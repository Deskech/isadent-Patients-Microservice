package com.isadent.pacientes.demo.Infraestructure.Repository.Query;

import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import reactor.core.publisher.Mono;

/**
 * Saves the New Patients events from the Command line database to the Query Line database.
 */

public interface ReadPatientActualization {

    Mono<Void> saveNewPatient(ReadPatients readPatients);
}
