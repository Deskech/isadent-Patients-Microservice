package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.CommandLine.EntityWritePatient;
/**
 * Mapper interface for converting WritePatients domain objects to EntityWritePatient entities.
 * This interface defines the mapping logic between the domain representation and the database entity.
 */
public interface WritePacientesMapper {
    /**
     * Converts a WritePatients domain object to an EntityWritePatient entity.
     *
     * @param writePatients The WritePatients object to be converted.
     * @return The corresponding EntityWritePatient entity.
     */
    EntityWritePatient toEntity(WritePatients writePatients);
}
