package org.springdata.project1springboot.repositories;


import com.jpa.orm_data.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}