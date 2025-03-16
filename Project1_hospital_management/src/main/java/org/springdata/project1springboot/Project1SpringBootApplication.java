package org.springdata.project1springboot;

import org.springdata.project1springboot.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springdata.project1springboot.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Project1SpringBootApplication {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Project1SpringBootApplication.class, args);
	}


	@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		return args -> {
			Stream.of("Mohammed","Saad", "Walid")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom(nom);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						patient.setScore(88);
						service.savePatient(patient);
					});



		};

	}

}




