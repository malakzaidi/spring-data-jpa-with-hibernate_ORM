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
	CommandLineRunner start (PatientRepository patientRepository) {
		return args -> {
			// Ajouter des patients
			Stream.of("Malak", "Douaa", "Sami")
					.forEach(nom -> {
						Patient patient = new Patient();
						patient.setNom(nom);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						patient.setScore(88);
						patientRepository.save(patient);
					});

			System.out.println("Liste des patients :");
			patientRepository.findAll().forEach(System.out::println);

			Long patientId = patientRepository.findAll().get(0).getId(); // Récupère l'ID du premier patient
			System.out.println("Patient avec l'ID " + patientId + " :");
			patientRepository.findById(patientId).ifPresent(System.out::println);

			patientRepository.findById(patientId).ifPresent(patient -> {
				patient.setMalade(true);
				patient.setScore(95);
				patientRepository.save(patient);
				System.out.println("Patient mis à jour : " + patient);
			});

			patientRepository.deleteById(patientId);
			System.out.println("Patient avec l'ID " + patientId + " supprimé.");

			System.out.println("Liste des patients après suppression :");
			patientRepository.findAll().forEach(System.out::println);
		};
	}

	}






