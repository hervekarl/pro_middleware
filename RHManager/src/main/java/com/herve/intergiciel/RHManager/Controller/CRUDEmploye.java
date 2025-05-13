package com.herve.intergiciel.RHManager.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herve.intergiciel.RHManager.Modeles.Employe;
import com.herve.intergiciel.RHManager.RHRepository.EmployesRepository;

@RestController
@RequestMapping("/rh")
public class CRUDEmploye {

    private final EmployesRepository employesRepository;

    public CRUDEmploye(EmployesRepository employesRepository) {
        this.employesRepository = employesRepository;
    }

   
    // @PostMapping(path = "employes/create", consumes = "application/json")
    // public Employe create(@RequestBody Employe employe) {
    //     return employesRepository.save(employe);
    // }
    
    // @GetMapping(path = "/employes", produces  = "application/json")
    // public List<Employe> getAllEmployes() {
    //     return employesRepository.findAll();
    // }

    @PostMapping(path = "employe/create", consumes = "application/json")
    public Employe create(@RequestBody Employe infoPatient) {
        return employesRepository.save(infoPatient);
    }

    @GetMapping(path = "employe", produces = "application/json")
    public List<Employe> search() {
        return employesRepository.findAll();
    }

    @GetMapping(path = "/employes/{id}", produces = "application/json")
    public Employe getEmployeById(Long id) {
        return employesRepository.findById(id).orElse(null);
    }

    public Employe updateEmploye(Long id, @RequestBody Employe employe) {
        if (employesRepository.existsById(id)) {
            employe.setId(id);
            return employesRepository.save(employe);
        }
        return null;
    }
    public void deleteEmploye(Long id) {
        if (employesRepository.existsById(id)) {
            employesRepository.deleteById(id);
        }
    }

}
