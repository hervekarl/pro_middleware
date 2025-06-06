package herve.pro.intergiciel.dosmed.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import herve.pro.intergiciel.dosmed.DTO.HistoricalRequest.Patient;

@FeignClient(name = "service-patient", url = "${patient.service.url}")
public interface PatientServiceClient {
    
    @GetMapping("/patients/{id}")
    Patient getPatientById(@PathVariable("id") Long id);
    
    @PostMapping("/patients")
    Patient createPatient(@RequestBody Patient patient);
    
    // Ajoutez d'autres méthodes selon vos besoins
}

