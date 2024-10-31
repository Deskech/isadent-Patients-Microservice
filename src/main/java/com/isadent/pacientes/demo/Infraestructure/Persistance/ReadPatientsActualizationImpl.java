package com.isadent.pacientes.demo.Infraestructure.Persistance;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Repository.Query.ReadPatientActualization;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ReadPatientsActualizationImpl implements ReadPatientActualization {
    private final ReactiveHashOperations<String, String, String> redisOperations;

    public ReadPatientsActualizationImpl(ReactiveHashOperations<String, String, String> redisOperations) {
        this.redisOperations = redisOperations;
    }

    @Override
    public Mono<Void> saveNewPatient(ReadPatients readPatients) {
        String patientKey = "patient:" + readPatients.getPatientName();
        String patientIndex = "patientIdentification:" + readPatients.getPatientIdentification();

        //we save the necessary elements in the redis database (Query line)
        return redisOperations.put(patientKey, "patientName", readPatients.getPatientName())
                .then(redisOperations.put(patientKey, "patientIdentification", readPatients.getPatientIdentification()))
                .then(redisOperations.put(patientKey, "patientDirection", readPatients.getPatientDirection()))
                .then(redisOperations.put(patientIndex, "patientKey", patientKey))
                .then();
    }
}
