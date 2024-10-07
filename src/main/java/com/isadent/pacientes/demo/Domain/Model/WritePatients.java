package com.isadent.pacientes.demo.Domain.Model;

import lombok.Getter;

/**
 * Represents a patient record in the command side of the system.
 * This class is used to hold patient information when storing new patients in the database.
 */
@Getter
public class WritePatients {
    private final int id;
    private final String patientIdentification;
    private final String patientDirection;
    private final String patientName;

    public WritePatients(int id, String patientIdentification, String patientDirection, String patientName){

        this.id= id;
        this.patientIdentification=patientIdentification;
        this.patientDirection = patientDirection;
        this.patientName = patientName;
    }
}
