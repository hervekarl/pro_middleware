package com.herve.intergiciel.PatientManager.Repositories;

import com.herve.intergiciel.PatientManager.Modeles.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}