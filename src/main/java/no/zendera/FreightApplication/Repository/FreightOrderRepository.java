package no.zendera.FreightApplication.Repository;

import no.zendera.FreightApplication.Model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightOrderRepository extends CrudRepository<Order, Long> {

}
