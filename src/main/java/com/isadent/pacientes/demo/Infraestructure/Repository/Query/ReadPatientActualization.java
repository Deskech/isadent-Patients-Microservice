package com.isadent.pacientes.demo.Infraestructure.Repository.Query;

import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Saves the New Patients events from the Command line database to the Query Line database.
 */
@Repository
public interface ReadPatientActualization extends JpaRepository<EntityReadPatient,Integer> {
}
