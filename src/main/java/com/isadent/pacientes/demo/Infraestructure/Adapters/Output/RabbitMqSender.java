package com.isadent.pacientes.demo.Infraestructure.Adapters.Output;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Domain.Events.NewPatientEvent;
import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * This component sends the New Patients events to the Bill microservice
 */
@Component
public class RabbitMqSender implements NewPatientEvent {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RabbitMqSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    /**
     * Sends the New Patients information to the Bill microservice
     *
     * @param writePatients The WritePatients object containing the new patient's information.
     */
    @SneakyThrows
    @Override
    public void publishNewPatient(WritePatients writePatients) {
        try {
            String patientString = objectMapper.writeValueAsString(writePatients);
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType("application/json");
            Message message = new Message(patientString.getBytes(), messageProperties);
            rabbitTemplate.send("newPaciente", "", message);

            System.out.println(message);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
