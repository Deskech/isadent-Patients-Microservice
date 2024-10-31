package com.isadent.pacientes.demo.Domain.Events;

import reactor.core.publisher.Mono;

/**
 * Interface for listening to new patient events from the command side of the system.
 * This interface defines a method for handling events related to the creation of new patients.
 */
public interface ListenToNewPatientEvent<T> {
    /**
     * Listens for new patient events.
     *
     * @param newPaciente The event containing the information of the new patient.
     * @return listen to a new patient that has been stored y the command line database
     */

     Mono <Void>listenToNewPatient(T newPaciente);
}
