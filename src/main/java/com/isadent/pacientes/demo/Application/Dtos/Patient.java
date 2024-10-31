package com.isadent.pacientes.demo.Application.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Dto containing the patient's name
 */
@Getter
@Setter
public class Patient implements Serializable {
    private String patientName;
    private String patientIdentification;

    public Patient(){}
}
