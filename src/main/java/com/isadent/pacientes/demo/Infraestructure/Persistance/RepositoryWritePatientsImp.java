package com.isadent.pacientes.demo.Infraestructure.Persistance;

import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryWritePatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.CommandLine.EntityWritePatient;
import com.isadent.pacientes.demo.Infraestructure.Mappers.WritePacientesMapper;
import com.isadent.pacientes.demo.Infraestructure.Repository.CommandLine.WritePatientJpaRepository;
import org.springframework.stereotype.Component;

/**
 * Implementation of the RepositoryWritePatients interface.
 * This class provides methods for saving new patient information to the database.
 */
@Component
public class RepositoryWritePatientsImp implements RepositoryWritePatients {

    private final WritePacientesMapper writePacientesMapper;
    private final WritePatientJpaRepository writePatientJpaRepository;

    public RepositoryWritePatientsImp(WritePacientesMapper writePacientesMapper, WritePatientJpaRepository writePatientJpaRepository){
        this.writePatientJpaRepository = writePatientJpaRepository;
        this.writePacientesMapper = writePacientesMapper;
    }
    /**
     * Saves a new patient to the database.
     *
     * @param writePatients The WritePatients object containing the information of the patient to be saved.
     */
    @Override
    public void saveNewPatient(WritePatients writePatients) {
        EntityWritePatient newPatient = writePacientesMapper.toEntity(writePatients);
        writePatientJpaRepository.save(newPatient);

    }
}
