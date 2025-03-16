package org.springdata.project1springboot.repositories;


import com.jpa.orm_data.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}