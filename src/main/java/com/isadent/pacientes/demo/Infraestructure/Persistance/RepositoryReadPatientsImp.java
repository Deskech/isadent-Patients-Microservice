package com.isadent.pacientes.demo.Infraestructure.Persistance;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
import com.isadent.pacientes.demo.Infraestructure.Mappers.ReadPatientMapperImp;
import com.isadent.pacientes.demo.Infraestructure.Repository.Query.ReadPatientJpaRepository;
import org.springframework.stereotype.Component;
/**
 * Implementation of the RepositoryReadPatients interface.
 * This class provides methods for retrieving patient information from the database.
 */
@Component
public class RepositoryReadPatientsImp implements RepositoryReadPatients {

    private final ReadPatientMapperImp readPacienteMapper;
    private final ReadPatientJpaRepository readPatientJpaRepository;
    public RepositoryReadPatientsImp(ReadPatientMapperImp readPacienteMapperImp, ReadPatientJpaRepository readPatientJpaRepository){
        this.readPacienteMapper= readPacienteMapperImp;
        this.readPatientJpaRepository = readPatientJpaRepository;
    }
    /**
     * Finds a patient by their identification number.
     *
     * @param identification The identification number of the patient to find.
     * @return A ReadPatients object representing the found patient, or null if not found.
     */
    @Override
    public ReadPatients findPatientByIdentification(String identification) {
       EntityReadPatient patient=  readPatientJpaRepository.findPatientByPatientIdentification(identification);
        return readPacienteMapper.toDomain(patient);
    }
    /**
     * Finds a patient by their name.
     *
     * @param patientName The name of the patient to find.
     * @return A ReadPatients object representing the found patient, or null if not found.
     */
    @Override
    public ReadPatients findPatientByName(String patientName) {
       EntityReadPatient patient =  readPatientJpaRepository.findPacienteByNombre(patientName);
        return readPacienteMapper.toDomain(patient);
    }
}
