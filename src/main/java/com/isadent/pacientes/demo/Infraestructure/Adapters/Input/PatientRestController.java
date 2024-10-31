package com.isadent.pacientes.demo.Infraestructure.Adapters.Input;

import com.isadent.pacientes.demo.Application.CommandLine.SaveNewPatientService;
import com.isadent.pacientes.demo.Application.Dtos.Patient;
import com.isadent.pacientes.demo.Application.Query.FindNewPatient;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Domain.Model.WritePatients;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * REST controller for managing patient-related operations.
 * Provides endpoints for saving new patients and retrieving existing patient information.
 */

@RestController
public class PatientRestController {
    private final SaveNewPatientService saveNewPatientService;
    private final FindNewPatient findNewPatient;

    public PatientRestController(SaveNewPatientService saveNewPatientService, FindNewPatient findNewPatient){
        this.findNewPatient = findNewPatient;
        this.saveNewPatientService = saveNewPatientService;
    }
    /**
     * Endpoint to save a new patient.
     *
     * @param writePatients The patient information to be saved.
     */
    @CrossOrigin
    @PostMapping("/patients/create")
    public void newPaciente(@RequestBody WritePatients writePatients){
        saveNewPatientService.saveNewPatient(writePatients);
    }
    /**
     * Endpoint to find a patient by their identification number.
     *
     * @param patient The identification number of the patient.
     * @return The patient information if found.
     */
    @CrossOrigin
    @PostMapping("/patients/search-by-identification")
    public Mono<ReadPatients> searchByIdentification(@RequestBody Patient patient){
        return findNewPatient.findPatientByIdentification(patient);
    }
    /**
     * Endpoint to find a patient by their name.
     *
     * @param patientName The Patient object containing the name of the patient.
     * @return The patient information if found.
     */
    @CrossOrigin
    @PostMapping("/patients/search-by-name")
    public Mono<ReadPatients> searchByName(@RequestBody Patient patientName){
        return findNewPatient.findPatientByName(patientName);
    }

}
