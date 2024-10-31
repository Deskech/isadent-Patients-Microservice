package com.isadent.pacientes.demo.Domain.Repository;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import reactor.core.publisher.Mono;

@SuppressWarnings(value = "all")
/**
 * Repository interface for reading patient records from the query side of the system.
 * Provides methods for finding patients by their identification number or name.
 */
public interface RepositoryReadPatients {
    /**
     * Finds a patient by their identification number.
     *
     * @param patientIdentification The identification number of the patient.
     * @return A ReadPatients object containing the patient's information.
     */
   Mono<ReadPatients> findPatientByIdentification(String patientIdentification);
    /**
     * Finds a patient by their name.
     *
     * @param patientName The name of the patient.
     * @return A ReadPatients object containing the patient's information.
     */
    Mono<ReadPatients> findPatientByName(String patientName);
}
