package com.isadent.pacientes.demo.Infraestructure.Mappers;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
import org.springframework.stereotype.Component;
/**
 * Implementation of the ReadPatientMapper interface.
 * This class provides the logic for converting EntityReadPatient objects into ReadPatients domain objects.
 */
@Component
public class ReadPatientMapperImp implements ReadPatientMapper {
    /**
     * Converts an EntityReadPatient to a ReadPatients domain object.
     *
     * @param entityReadPatient The EntityReadPatient object to be converted.
     * @return A ReadPatients domain object containing the same data as the provided entity.
     */
    @Override
    public ReadPatients toDomain(EntityReadPatient entityReadPatient) {
        return new ReadPatients(entityReadPatient.getId(), entityReadPatient.getPatientIdentification(),
                entityReadPatient.getPatientDirection(), entityReadPatient.getPatientName());
    }
}
