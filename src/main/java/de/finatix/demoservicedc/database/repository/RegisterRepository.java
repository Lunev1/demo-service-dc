package de.finatix.demoservicedc.database.repository;

import de.finatix.demoservicedc.database.model.Register;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<Register, Integer> {

}
