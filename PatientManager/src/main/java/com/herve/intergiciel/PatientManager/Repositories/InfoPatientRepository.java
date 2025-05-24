package com.herve.intergiciel.PatientManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herve.intergiciel.PatientManager.Modeles.InfoPatient;

public interface InfoPatientRepository extends JpaRepository<InfoPatient, Long>{

    

}
