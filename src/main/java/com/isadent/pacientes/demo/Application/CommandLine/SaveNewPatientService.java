package com.isadent.pacientes.demo.Application.CommandLine;

import com.isadent.pacientes.demo.Domain.Events.NewPatientEvent;
import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryWritePatients;
import org.springframework.stereotype.Service;
/**
 * Service for saving new patient information.
 * This class handles the process of saving a new patient and publishing the corresponding event.
 */
@Service
public class SaveNewPatientService {

    private final RepositoryWritePatients repositoryWritePatients;
    private final NewPatientEvent newPatientEvent;

    public SaveNewPatientService(RepositoryWritePatients repositoryWritePatients, NewPatientEvent newPatientEvent) {
        this.repositoryWritePatients = repositoryWritePatients;
        this.newPatientEvent = newPatientEvent;
    }
    /**
     * Saves a new patient and publishes an event about the new patient.
     *
     * @param newPatient The WritePatients object containing the information of the patient to be saved.
     */
    public void saveNewPatient(WritePatients newPatient) {
        repositoryWritePatients.saveNewPatient(newPatient);
        newPatientEvent.publishNewPatient(newPatient);
    }
}
