package com.isadent.pacientes.demo.Domain.Events;

import com.isadent.pacientes.demo.Domain.Model.WritePatients;
/**
 * Interface for publishing events when a new patient is created.
 * This is used to notify the query side to update its values.
 */
public interface NewPacienteEvent {
    /**
     * Publishes an event for a new patient.
     *
     * @param writePatients The WritePatients object containing the new patient's information.
     */
    void publishNewPatient(WritePatients writePatients);
}
