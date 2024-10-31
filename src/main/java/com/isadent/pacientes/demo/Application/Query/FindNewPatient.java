package com.isadent.pacientes.demo.Application.Query;

import com.isadent.pacientes.demo.Application.Dtos.Patient;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryReadPatients;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * This case of use finds the patient's information
 */
@Service
public class FindNewPatient {

    private final RepositoryReadPatients repositoryReadPatients;

    public FindNewPatient(RepositoryReadPatients repositoryReadPatients) {
        this.repositoryReadPatients = repositoryReadPatients;
    }

    /**
     * Finds a patient by their identification number.
     *
     * @param patientIdentification The identification number of the patient to be found.
     * @return The ReadPatients object containing the patient's information, or null if not found.
     */
    public Mono<ReadPatients> findPatientByIdentification(Patient patientIdentification) {
        String identification = patientIdentification.getPatientIdentification();
        return repositoryReadPatients.findPatientByIdentification(identification);
    }

    /**
     * Finds a patient by their name.
     *
     * @param patientName The Patient object containing the name of the patient to be found.
     * @return The ReadPatients object containing the patient's information, or null if not found.
     */

    public Mono<ReadPatients> findPatientByName(Patient patientName) {
        String name = patientName.getPatientName().toLowerCase();
        return repositoryReadPatients.findPatientByName(name);
    }
}
