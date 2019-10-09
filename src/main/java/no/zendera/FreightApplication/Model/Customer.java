package no.zendera.FreightApplication.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter @ToString
@Entity(name = "CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue
    private long customerId;
    @NotNull
    private String customerFirstName;
    private String customerLastName;
    @NotNull
    private boolean elevated;
    @NotNull @Column(unique = true)
    private long primaryPhone;
}