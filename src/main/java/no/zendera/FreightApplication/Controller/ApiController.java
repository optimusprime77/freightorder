package no.zendera.FreightApplication.Controller;

import com.zaxxer.hikari.HikariDataSource;
import no.zendera.FreightApplication.Config.ApplicationConfig;
import no.zendera.FreightApplication.Config.DatabaseConfig;
import no.zendera.FreightApplication.Model.Customer;
import no.zendera.FreightApplication.Model.FreightOrder;
import no.zendera.FreightApplication.Model.Order;
import no.zendera.FreightApplication.Model.Response;
import no.zendera.FreightApplication.Repository.CustomerRepository;
import no.zendera.FreightApplication.Repository.FreightOrderRepository;
import no.zendera.FreightApplication.Repository.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    ApplicationConfig appConfig;

    @Autowired
    DatabaseConfig dataBaseConfig;

    @Lazy
    @Autowired
    HikariDataSource hikariDataSource;

    @Autowired
    FreightOrderRepository freightOrderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping(value = "/createFreightOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity onPostCustomerInfo(@RequestBody FreightOrder freightOrder) throws SQLException {

        Connection connection = this.dataBaseConfig.getConnection();
        try {
            for (Order order : freightOrder.getFreightOrders()) {
                Customer customer = customerRepository.findById(freightOrder.getCustomerId()).get();
                order.setCustomer(customer);
                freightOrderRepository.save(order);
            }
        }
        catch (RuntimeException e)
        {
            return new ResponseEntity<>("Invalid Data.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping(value = "/getFreightOrderInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> onGetCustomerInfo(@RequestHeader("customerId") String customerId) throws SQLException {
        try {
            Connection connection = this.dataBaseConfig.getConnection();
            Customer customer = customerRepository.findById(Long.parseLong(customerId)).get();
            List<Order> orders = orderRepository.findByCustomer(customer);
            return orders;
        }
        catch (RuntimeException e)
        {
            logger.info("Request processing failed");
            logger.info(e.getMessage());
            return new ArrayList<Order>(); //Return Empty Request
        }
    }
}