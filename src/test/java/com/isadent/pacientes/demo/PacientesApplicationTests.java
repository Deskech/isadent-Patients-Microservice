package com.isadent.pacientes.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Application.Dtos.Patient;
import com.isadent.pacientes.demo.Application.Query.FindNewPatient;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Domain.Repository.RepositoryReadPatients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveHashOperations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PacientesApplicationTests {
    @Autowired
    FindNewPatient findNewPatient;

    @Autowired
    RepositoryReadPatients patients;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ReactiveHashOperations<String, String, String> redisOperations;


    @Test
    void contextLoads() {
    }

    @Test
    void searchPatientByName() {

        Patient patientName = new Patient();
        patientName.setPatientName("jose manuel");
        Mono<ReadPatients> readPatients = findNewPatient.findPatientByName(patientName);

        readPatients.subscribe(
                patients -> {
                    assertNotNull(patients);
                    System.out.println(patients.getPatientIdentification());
                    System.out.println(patients.getPatientName());
                    System.out.println(patients.getPatientDirection());
                    assertEquals("jose manuel", patients.getPatientName());
                },
                error -> System.err.println("Error: " + error.getMessage()),
                () -> System.out.println("Search completed")

        );
    }

    @Test
    void searchPatient() {


        Mono<ReadPatients> patientsMono = patients.findPatientByName("jose manuel");


        patientsMono.subscribe(
                readPatients -> {
                    assertNotNull(readPatients);
                    System.out.println("Patient Identification: " + readPatients.getPatientIdentification());
                    System.out.println("Patient name: " + readPatients.getPatientName());
                    System.out.println("Patient direction: " + readPatients.getPatientDirection());
                },
                error -> System.err.println("Error: " + error.getMessage()),
                () -> System.out.println("Search completed.")
        );


        ReadPatients result = patientsMono.block();
        assertNotNull(result, "The patient should not be null.");
        System.out.println("Blocking result: " + result.getPatientIdentification());
    }

    @Test
    void objectMapper() throws JsonProcessingException {

        ReadPatients readpatients = new ReadPatients("123333", "any direction", "patient");

        String objectString = objectMapper.writeValueAsString(readpatients);

        ReadPatients readPatient1 = objectMapper.readValue(objectString, ReadPatients.class);

        assertEquals("123333", readPatient1.getPatientIdentification());
        assertEquals("patient", readPatient1.getPatientName());
        assertEquals("any direction", readPatient1.getPatientDirection());

        System.out.println(objectString);
        System.out.println(readPatient1.getPatientName());
    }

    @Test
    void identification() {
        patients.findPatientByIdentification("1234")
                .subscribe(readPatients -> System.out.println("Patient Name: " + readPatients.getPatientIdentification()),
                        error -> System.err.println("Error: " + error.getMessage()));

    }

    @Test
    void reactiveRedis() {
        redisOperations.entries("patientIdentification:" + "1234")
                .subscribe(
                        value -> System.out.println("Found patient key: " + value),
                        error -> System.err.println("Error retrieving patient: " + error.getMessage()),
                        () -> System.out.println("No patient found with identification: 1234")
                );

    }


}
