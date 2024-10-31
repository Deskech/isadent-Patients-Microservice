package com.isadent.pacientes.demo.Domain.Model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@SuppressWarnings(value = "all")
/**
 * Represents a patient record retrieved from the query side.
 * This class is used to hold patient information that is read from the database.
 */
@Setter
@Getter
public class ReadPatients implements Serializable {

    private String patientIdentification;
    private String patientDirection;
    private String patientName;

    public ReadPatients(String patientIdentification, String patientDirection, String patientName) {

        this.patientIdentification = patientIdentification;
        this.patientDirection = patientDirection;
        this.patientName = patientName;
    }
}
