package org.springdata.project1springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springdata.project1springboot.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}