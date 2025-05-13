package com.herve.intergiciel.PatientManager.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herve.intergiciel.PatientManager.Modeles.InfoPatient;
import com.herve.intergiciel.PatientManager.Repositories.InfoPatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InfoPatientService {
    private InfoPatientRepository infoPatientRepository;

    public void create(InfoPatient infoPatient){
        this.infoPatientRepository.save(infoPatient);
    }

    public List<InfoPatient> search(){
        return this.infoPatientRepository.findAll();
    }

    public InfoPatient update( InfoPatient infoPatient) {
        if (infoPatientRepository.existsById(infoPatient.getIdPat())) {
            return infoPatientRepository.save(infoPatient);
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }

    public void delete( InfoPatient infoPatient) {
        if (infoPatientRepository.existsById(infoPatient.getIdPat())) {
            infoPatientRepository.deleteById(infoPatient.getIdPat());
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }
    
}
