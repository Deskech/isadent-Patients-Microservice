package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
/**
 * Mapper interface for converting EntityReadPatient objects to ReadPatients domain objects.
 */
public interface ReadPatientMapper {
    /**
     * Converts an EntityReadPatient to a ReadPatients domain object.
     *
     * @param entityReadPatient The EntityReadPatient object to be converted.
     * @return The corresponding ReadPatients domain object.
     */
    ReadPatients toDomain(EntityReadPatient entityReadPatient);

}
