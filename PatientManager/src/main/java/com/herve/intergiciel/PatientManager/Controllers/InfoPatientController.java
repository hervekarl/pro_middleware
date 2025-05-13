package com.herve.intergiciel.PatientManager.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve.intergiciel.PatientManager.Modeles.InfoPatient;
import com.herve.intergiciel.PatientManager.Repositories.InfoPatientRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor

public class InfoPatientController {

    private final InfoPatientRepository infoPatientRepository;


    @PostMapping(path = "/create", consumes = "application/json")
    public InfoPatient create(@RequestBody InfoPatient infoPatient) {
        return infoPatientRepository.save(infoPatient);
    }

    @GetMapping(produces = "application/json")
    public List<InfoPatient> search() {
        return infoPatientRepository.findAll();
    }

    @PostMapping(path = "/update", consumes = "application/json")
    public InfoPatient update(@RequestBody InfoPatient infoPatient) {
        if (infoPatientRepository.existsById(infoPatient.getIdPat())) {
            return infoPatientRepository.save(infoPatient);
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }

    @PostMapping(path = "/delete/", consumes = "application/json")
    public void delete(@RequestBody InfoPatient infoPatient) {
        if (infoPatientRepository.existsById(infoPatient.getIdPat())) {
            infoPatientRepository.deleteById(infoPatient.getIdPat());
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }
    
}