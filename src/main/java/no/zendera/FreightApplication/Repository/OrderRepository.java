package no.zendera.FreightApplication.Repository;

import no.zendera.FreightApplication.Model.Customer;
import no.zendera.FreightApplication.Model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);
}
