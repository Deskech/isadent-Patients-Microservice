package com.isadent.pacientes.demo.Domain.Repository;

import com.isadent.pacientes.demo.Domain.Model.WritePatients;
/**
 * Repository interface for writing patient records to the command side of the system.
 * Provides a method for saving new patient information.
 */
public interface RepositoryWritePatients {
    /**
     * Saves a new patient to the database.
     *
     * @param writePatients The WritePatients object containing the new patient's information.
     */
    void saveNewPatient(WritePatients writePatients);
}
