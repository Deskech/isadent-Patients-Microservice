package com.isadent.pacientes.demo.Domain.Events;

/**
 * Interface for listening to new patient events from the command side of the system.
 * This interface defines a method for handling events related to the creation of new patients.
 */
public interface ListenToNewPacienteEvent<T> {
    /**
     * Listens for new patient events.
     *
     * @param newPaciente The event containing the information of the new patient.
     */
    void listenToNewPatient(T newPaciente);
}
