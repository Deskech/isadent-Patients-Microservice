package com.isadent.pacientes.demo.Infraestructure.Adapters.Input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isadent.pacientes.demo.Domain.Events.ListenToNewPacienteEvent;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import com.isadent.pacientes.demo.Infraestructure.Entities.Query.EntityReadPatient;
import com.isadent.pacientes.demo.Infraestructure.Repository.Query.ReadPatientActualization;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * RabbitMQ listener that listens for new patient events from the command side of the system.
 * When a new patient event is received, it processes the event and saves the patient information
 * to the query side for further updates.
 */
@Component
public class RabbitMqListener implements ListenToNewPacienteEvent<String> {

   private final ReadPatientActualization readPatientActualization;
    private final ObjectMapper objectMapper;
    public RabbitMqListener(ReadPatientActualization readPatientActualization, ObjectMapper objectMapper){
        this.readPatientActualization = readPatientActualization;
        this.objectMapper= objectMapper;
    }
    /**
     * Listens for new patient events on the "pacientesQueue".
     * Converts the event message from JSON to a ReadPatients object and saves the patient to the query side.
     *
     * @param event The JSON string representing the new patient event.
     */
    @SneakyThrows
@RabbitListener(queues = "pacientesQueue")
public void listenToNewPatient(String event){
        // since we receive a string we map it back to class
        ReadPatients readPatients = objectMapper.readValue(event, ReadPatients.class);
        // we set up our jpa Entity to store it in the query side
    EntityReadPatient newPaciente = new EntityReadPatient();
    newPaciente.setId(readPatients.getId());
    newPaciente.setPatientIdentification(readPatients.getPatientIdentification());
    newPaciente.setPatientName(readPatients.getPatientName());
    newPaciente.setPatientDirection(readPatients.getPatientDirection());
    // update the patient's record in the query side
    readPatientActualization.save(newPaciente);
}

}
