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
        saveNewPatientService.saveNewPaciente(writePatients);
    }
    /**
     * Endpoint to find a patient by their identification number.
     *
     * @param patientIdentification The identification number of the patient.
     * @return The patient information if found.
     */
    @CrossOrigin
    @PostMapping("/patients/search-by-identification")
    public ReadPatients findPacienteByCedula(@RequestBody String patientIdentification){
        return findNewPatient.findPacienteByCedula(patientIdentification);
    }
    /**
     * Endpoint to find a patient by their name.
     *
     * @param patientName The Patient object containing the name of the patient.
     * @return The patient information if found.
     */
    @CrossOrigin
    @PostMapping("/patients/search-by-name")
    public ReadPatients findPacienteByNombre(@RequestBody Patient patientName){
        return findNewPatient.findPacienteByNombre(patientName);
    }

}
