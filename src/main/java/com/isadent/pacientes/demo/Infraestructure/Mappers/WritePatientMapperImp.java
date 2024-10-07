package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.CommandLine.EntityWritePatient;
import org.springframework.stereotype.Component;

/**
 * Implementation of the WritePacientesMapper interface.
 * This class provides the logic for converting WritePatients domain objects into EntityWritePatient entities.
 */
@Component
public class WritePatientMapperImp implements WritePacientesMapper {
    /**
     * Converts a WritePatients domain object to an EntityWritePatient entity.
     *
     * @param writePatients The WritePatients object to be converted.
     * @return A new EntityWritePatient entity containing the same data as the provided WritePatients object.
     */
    public EntityWritePatient toEntity(WritePatients writePatients) {

        return new EntityWritePatient(writePatients.getId(), writePatients.getPatientIdentification(), writePatients.getPatientDirection(), writePatients.getPatientName());
    }
}
