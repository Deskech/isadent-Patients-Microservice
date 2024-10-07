package com.isadent.pacientes.demo.Infraestructure.Repository.Query;

import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Retrieves the patient's information
 */
@Repository
public interface ReadPatientJpaRepository extends JpaRepository<EntityReadPatient, Integer> {
    /**
     *
     * @param patientIdentification patient's identification number
     * @return patient's information found or null
     */
    @Query("select p from EntityReadPatient p where p.patientIdentification= :patientIdentification")
    EntityReadPatient findPatientByPatientIdentification(@Param("patientIdentification") String patientIdentification);

    /**
     *
     * @param patientName patient's name
     * @return patient's information found or null
     */
    @Query("select p from EntityReadPatient p where p.patientName= :patientName")
    EntityReadPatient findPacienteByNombre(@Param("patientName") String patientName);


}
