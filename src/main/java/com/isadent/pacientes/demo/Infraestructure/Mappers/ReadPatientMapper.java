package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;

import java.util.Map;

/**
 * Mapper interface for converting data objects to ReadPatients domain objects.
 */
public interface ReadPatientMapper {
    /**
     * Converts a data object comming from redis database to a ReadPatients domain object.
     *
     * @param data object to be converted.
     * @return The corresponding ReadPatients domain object.
     */
    ReadPatients toDomain(Map<String, String> data);


}
