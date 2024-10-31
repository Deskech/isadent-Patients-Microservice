package com.isadent.pacientes.demo.Infraestructure.Adapters.Input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Domain.Events.ListenToNewPatientEvent;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Repository.Query.ReadPatientActualization;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * RabbitMQ listener that listens for new patient events from the command side of the system.
 * When a new patient event is received, it processes the event and saves the patient information
 * to the query side for further updates.
 */
@Component
public class RabbitMqListener implements ListenToNewPatientEvent<String> {


    private final ObjectMapper objectMapper;
    private final ReadPatientActualization readPatientActualization;

    public RabbitMqListener(ObjectMapper objectMapper, ReadPatientActualization readPatientActualization

    ) {

        this.objectMapper = objectMapper;
        this.readPatientActualization = readPatientActualization;

    }

    /**
     * Listens for new patient events on the "pacientesQueue".
     * Converts the event message from JSON to a ReadPatients object and saves the patient to the query side.
     *
     * @param event The JSON string representing the new patient event.
     * @return saves the patients object in the redis database
     */
    @SneakyThrows
    @RabbitListener(queues = "pacientesQueue")
    public Mono<Void> listenToNewPatient(String event) {

        // since we receive a string we map it back to class
        ReadPatients readPatients = objectMapper.readValue(event, ReadPatients.class);

        //we save the necessary elements in the redis database (Query line)
        return readPatientActualization.saveNewPatient(readPatients);

    }

}
