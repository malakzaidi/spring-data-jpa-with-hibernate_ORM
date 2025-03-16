package org.springdata.project1springboot.services;

import org.springdata.project1springboot.entities.Consultation;
import org.springdata.project1springboot.entities.Medecin;
import org.springdata.project1springboot.entities.Patient;
import org.springdata.project1springboot.entities.RendezVous;

public interface HospitalService {
        Patient savePatient(Patient patient);
        Medecin saveMedecin(Medecin medecin);
        RendezVous saveRDV(RendezVous rendezVous);
        Consultation saveConsultation(Consultation consultation);

    }

