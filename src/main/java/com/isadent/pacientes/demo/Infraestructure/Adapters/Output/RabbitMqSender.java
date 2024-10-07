package com.isadent.pacientes.demo.Infraestructure.Adapters.Output;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Domain.Events.NewPacienteEvent;
import com.isadent.pacientes.demo.Domain.Model.WritePatients;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * This component sends the New Patients events to the Bill microservice
 */
@Component
public class RabbitMqSender implements NewPacienteEvent {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    public RabbitMqSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper){
                this.rabbitTemplate= rabbitTemplate;
                this.objectMapper = objectMapper;
        }

    /**
     * Sends the New Patients information to the Bill microservice
     * @param writePatients The WritePatients object containing the new patient's information.
     */
    @SneakyThrows
    @Override
    public void publishNewPatient(WritePatients writePatients) {
        String patientString = objectMapper.writeValueAsString(writePatients);
        rabbitTemplate.convertAndSend("newPaciente","", patientString);
        System.out.println(patientString);
    }
}
