package no.zendera.FreightApplication.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class FreightOrder {
    @NotNull
    private long customerId;
    List<Order> freightOrders;
}
