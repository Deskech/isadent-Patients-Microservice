package com.isadent.pacientes.demo.Infraestructure.Entities.CommandLine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * Entity class representing a patient in the database.
 * This class maps to the "pacientes" table and contains patient-related information.
 */
@Entity
@Getter
@Setter
@Table(name = "pacientes")
public class EntityWritePatient {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cedula")
    private String patientIdentification;
    @Column(name = "direccion")
    private String patientDirection;
    @Column(name = "nombre")
    private String patientName;

    public EntityWritePatient(){}

    public EntityWritePatient(int id, String patientIdentification, String patientDirection, String patientName){
        this.id= id;
        this.patientIdentification= patientIdentification;
        this.patientDirection=patientDirection;
        this.patientName = patientName;
    }

}
