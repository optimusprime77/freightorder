package no.zendera.FreightApplication.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private long freightOrderId;
    @ManyToOne(cascade=CascadeType.ALL)
    private Customer customer;
    @NotNull
    private String source;
    @NotNull
    private String destination;
    private float freight;
}
