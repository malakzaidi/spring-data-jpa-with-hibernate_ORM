package org.springdata.project1springboot;

import org.springdata.project1springboot.entities.Consultation;
import org.springdata.project1springboot.repositories.ConsultationRepository;
import org.springdata.project1springboot.repositories.MedecinRepository;
import org.springdata.project1springboot.repositories.PatientRepository;
import org.springdata.project1springboot.repositories.RendezVousRepository;
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
	CommandLineRunner start (PatientRepository patientRepository , MedecinRepository medecinRepository,
							 ConsultationRepository consultationRepository , RendezVousRepository rendezVousRepository) {
		return args -> {
			// Ajouter des patients
			Stream.of("Micheal", "Samira", "Douaa" ,"Malak")
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
		Stream.of("Souad","Touria", "Yanis" ,"Aymane")
				.forEach(name -> {
					Medecin medecin = new Medecin();
					medecin.setNom(name);
					medecin.setSpecialite(Math.random()>0.5?"Dermatologue":"Cardio");
					medecin.setEmail(name + "@gmail.com");
					medecinRepository.saveMedecin(medecin);
				});

		Patient patient = patientRepository.findById(1L).orElse(null);
		Patient patient1 = patientRepository.findByNom("Aymane");

		Medecin medecin = service.findMedecinByNom("Yassine");

		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(new Date());
		rendezVous.setStatus(StatusRDV.PENDING);
		rendezVous.setMedecin(medecin);
		rendezVous.setPatient(patient);
		rendezVousRepository.saveRDV(rendezVous);


		RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
		Consultation consultation = new Consultation();
		consultation.setDateConsultation(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapport("this is the first rapport of the 1st consultation");
		consultationRepository.saveConsultation(consultation);
	}

	}






