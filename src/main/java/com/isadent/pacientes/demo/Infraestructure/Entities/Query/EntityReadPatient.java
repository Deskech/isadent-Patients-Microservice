package com.isadent.pacientes.demo.Infraestructure.Entities.Query;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * Entity class representing a patient in the query side database.
 * This class maps to the "pacientes" table and contains patient-related information.
 */
@Getter
@Setter
@Entity
@Table(name ="queryPacientes")
public class EntityReadPatient {
    @Id
    @Column(name = "id")
    private  int id;
    @Column(name = "cedula")
    private String patientIdentification;
    @Column(name = "direccion")
    private String patientDirection;
    @Column(name = "nombre")
    private String patientName;

}
