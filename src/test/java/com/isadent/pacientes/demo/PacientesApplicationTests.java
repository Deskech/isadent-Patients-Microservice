package com.isadent.pacientes.demo;

import com.isadent.pacientes.demo.Application.Dtos.Patient;
import com.isadent.pacientes.demo.Application.Query.FindNewPatient;
import com.isadent.pacientes.demo.Domain.Model.ReadPatients;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PacientesApplicationTests {
	@Autowired
	FindNewPatient findNewPatient;
	@Test
	void contextLoads() {
	}

	@Test
	void searchPatientByName(){
		Patient patientName = new Patient();
		patientName.setPatientName("jose manuel");
		ReadPatients readPatients =  findNewPatient.findPatientByName(patientName);
		System.out.println(readPatients.toString());
	}
}
