package no.zendera.FreightApplication.Repository;

import no.zendera.FreightApplication.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
