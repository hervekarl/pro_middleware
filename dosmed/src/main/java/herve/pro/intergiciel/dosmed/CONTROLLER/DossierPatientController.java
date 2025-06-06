package herve.pro.intergiciel.dosmed.CONTROLLER;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import herve.pro.intergiciel.dosmed.feignClient.PatientServiceClient;

@RestController
@RequestMapping("/api/dossiers")
public class DossierPatientController {
    
    private final PatientServiceClient patientServiceClient;
    
    public DossierPatientController(PatientServiceClient patientServiceClient) {
        this.patientServiceClient = patientServiceClient;
    }
    
    
    // Autres méthodes
}