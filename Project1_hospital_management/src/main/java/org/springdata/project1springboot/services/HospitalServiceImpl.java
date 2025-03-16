package org.springdata.project1springboot.services;

import org.springdata.project1springboot.entities.Consultation;
import org.springdata.project1springboot.entities.Medecin;
import org.springdata.project1springboot.entities.Patient;
import org.springdata.project1springboot.entities.RendezVous;
import org.springdata.project1springboot.repositories.ConsultationRepository;
import org.springdata.project1springboot.repositories.MedecinRepository;
import org.springdata.project1springboot.repositories.PatientRepository;
import org.springdata.project1springboot.repositories.RendezVousRepository;

public class HospitalServiceImpl implements HospitalService {

        private PatientRepository patientRepository;
        private MedecinRepository medecinRepository;
        private RendezVousRepository rendezVousRepository;
        private ConsultationRepository consultationRepository;

        public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultatonRepository consultatonRepository) {
            this.patientRepository = patientRepository;
            this.medecinRepository = medecinRepository;
            this.rendezVousRepository = rendezVousRepository;
            this.consultationRepository = consultationRepository;
        }

        @Override
        public Patient savePatient(Patient patient) {
            return patientRepository.save(patient);
        }

        @Override
        public Medecin saveMedecin(Medecin medecin) {

            return medecinRepository.save(medecin);
        }

        @Override
        public RendezVous saveRDV(RendezVous rendezVous) {

            return rendezVousRepository.save(rendezVous);
        }

        @Override
        public Consultation saveConsultation(Consultation consultation) {

            return consultationRepository.save(consultation);
        }

        @Override
        public Medecin findByNom(String nom) {
            return medecinRepository.findByNom(nom);
        }


    }

