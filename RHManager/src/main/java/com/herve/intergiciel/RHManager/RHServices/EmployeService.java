package com.herve.intergiciel.RHManager.RHServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herve.intergiciel.RHManager.Modeles.Employe;
import com.herve.intergiciel.RHManager.RHRepository.EmployesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeService {
    
    private EmployesRepository employesRepository;

    public void create(Employe employe){
        this.employesRepository.save(employe);
    }

    public List<Employe> search(){
        return this.employesRepository.findAll();
    }

    public Employe update( Employe employe) {
        if (employesRepository.existsById(employe.getId())) {
            return employesRepository.save(employe);
        } else {
            throw new IllegalArgumentException("Employe not found");
        }
    }

    public void delete( Employe infoPatient) {
        if (employesRepository.existsById(infoPatient.getId())) {
            employesRepository.deleteById(infoPatient.getId());
        } else {
            throw new IllegalArgumentException("Employe not found");
        }
    }
    

}
