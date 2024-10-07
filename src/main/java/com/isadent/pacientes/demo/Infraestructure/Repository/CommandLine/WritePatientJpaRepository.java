package com.isadent.pacientes.demo.Infraestructure.Repository.CommandLine;


import com.isadent.pacientes.demo.Infraestructure.Entities.CommandLine.EntityWritePatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Saves a new patient in the command line database
 */
@Repository
public interface WritePatientJpaRepository extends JpaRepository<EntityWritePatient,Integer> {


}
