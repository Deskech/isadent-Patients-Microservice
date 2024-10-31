package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Implementation of the ReadPatientMapper interface.
 * This class provides the logic for converting data objects into ReadPatients domain objects.
 */
@Component
public class ReadPatientMapperImp implements ReadPatientMapper {
    /**
     * Converts a data to a ReadPatients domain object.
     *
     * @param data The data object to be converted.
     * @return A ReadPatients domain object containing the same data as the provided entity.
     */
    @Override
    public ReadPatients toDomain(Map<String, String> data) {

        return new ReadPatients(data.get("patientIdentification"),
                data.get("patientDirection"),
                data.get("patientName")
        );
    }
}
