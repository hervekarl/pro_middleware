package com.herve.intergiciel.PatientManager.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve.intergiciel.PatientManager.Exceptions.PatientErrorExceptions;
import com.herve.intergiciel.PatientManager.Modeles.InfoPatient;
import com.herve.intergiciel.PatientManager.Repositories.InfoPatientRepository;
import com.herve.intergiciel.PatientManager.Services.InfoPatientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor

public class InfoPatientController {

    private final InfoPatientService infoPatientService;



    @PostMapping(path = "/create", consumes = "application/json")
    public ResponseEntity<InfoPatient> create(@RequestBody InfoPatient infoPatient) {
        return ResponseEntity.ok(infoPatientService.create(infoPatient));
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<InfoPatient>> search() {
        List<InfoPatient> patients=infoPatientService.search();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchPatientById(@PathVariable Long id){
        return ResponseEntity.ok(infoPatientService.serchPatientById(id));
    }

    @PutMapping(path = "/update/{id}", consumes = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody InfoPatient infoPatient) {

         if (!id.equals(infoPatient.getIdPat())) {
            return ResponseEntity.badRequest().body("ID dans URL ne correspond pas au corps de la requête");
        }
        try {
            return ResponseEntity.ok(infoPatientService.updatePatient(id, infoPatient));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de la mise à jour: " + e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete/{id}", consumes = "application/json")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        infoPatientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}