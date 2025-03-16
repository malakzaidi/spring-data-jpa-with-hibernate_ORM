package org.springdata.project1springboot.controllers;

import org.springdata.project1springboot.entities.Patient;
import org.springdata.project1springboot.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HospitalController {
    @RequestMapping("/patients")
    public class PatientController {

        @Autowired
        private PatientRepository patientRepository;

        @PostMapping
        public Patient addPatient(@RequestBody Patient patient) {
            return patientRepository.save(patient);
        }

        @GetMapping
        public List<Patient> getAllPatients() {
            return patientRepository.findAll();
        }
}
    }
