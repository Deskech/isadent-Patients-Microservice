package com.isadent.pacientes.demo.Infraestructure.Persistance;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Mappers.ReadPatientMapper;
import com.isadent.pacientes.demo.Infraestructure.Mappers.ReadPatientMapperImp;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * Implementation of the RepositoryReadPatients interface.
 * This class provides methods for retrieving patient information from the database.
 */
@Component
public class RepositoryReadPatientsImp implements RepositoryReadPatients {

    private final ReadPatientMapper readPatientMapper;
    private final ReactiveHashOperations<String, String, String> redisOperations;


    public RepositoryReadPatientsImp(ReadPatientMapperImp readPatientMapper,
                                     ReactiveHashOperations<String, String, String> redisOperations
    ) {
        this.readPatientMapper = readPatientMapper;
        this.redisOperations = redisOperations;

    }

    /**
     * Finds a patient by their identification number.
     *
     * @param identification The identification number of the patient to find.
     * @return A ReadPatients object representing the found patient, or null if not found.
     */
    @Override
    public Mono<ReadPatients> findPatientByIdentification(String identification) {

        String patientIndex = "patientIdentification:" + identification;

        return redisOperations.entries(patientIndex)
                .filter(entry -> "patientKey".equals(entry.getKey()))
                .singleOrEmpty()
                .flatMap(entry -> {
                    String patientKey = entry.getValue();

                    if (patientKey == null) {
                        return Mono.error(new RuntimeException("Patient not found with id: " + identification));
                    }

                    return redisOperations.entries(patientKey)
                            .collectMap(Map.Entry::getKey, Map.Entry::getValue);

                })
                .map(readPatientMapper::toDomain)
                .switchIfEmpty(Mono.error(new RuntimeException("Patient Not Found: " + identification)));


    }

    /**
     * Finds a patient by their name.
     *
     * @param patientName The name of the patient to find.
     * @return A ReadPatients object representing the found patient, or null if not found.
     */
    @Override
    public Mono<ReadPatients> findPatientByName(String patientName) {
        String patientKey = "patient:" + patientName;

        return redisOperations.entries(patientKey)
                .collectMap(Map.Entry::getKey, Map.Entry::getValue)
                .map(readPatientMapper::toDomain)
                .switchIfEmpty(Mono.error(new RuntimeException("Patient not found: " + patientName)))
                .onErrorReturn(new ReadPatients("N/A", "N/A", "Patient not found"));

    }
}
