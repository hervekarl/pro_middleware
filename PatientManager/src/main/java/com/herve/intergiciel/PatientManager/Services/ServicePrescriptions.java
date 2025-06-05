package com.herve.intergiciel.PatientManager.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.herve.intergiciel.PatientManager.DTO.DtoPrescription;
import com.herve.intergiciel.PatientManager.DTO.Medicaments;
import com.herve.intergiciel.PatientManager.DTO.PrescriptionDetails;
import com.herve.intergiciel.PatientManager.Exceptions.PatientErrorExceptions;
import com.herve.intergiciel.PatientManager.Modeles.Patient;
import com.herve.intergiciel.PatientManager.Modeles.Prescriptions;
import com.herve.intergiciel.PatientManager.Repositories.MedicamentClient;
import com.herve.intergiciel.PatientManager.Repositories.PatientRepository;
import com.herve.intergiciel.PatientManager.Repositories.PrescriptRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicePrescriptions {
    private final PrescriptRepository prescriptRepository;
    private final MedicamentClient medicamentClient;
    private final PatientRepository patientRepository;
    
    public Prescriptions savePrescription(DtoPrescription dtoPrescription) {
        if (dtoPrescription.getPatientId() == null || dtoPrescription.getDoctorId() == null || dtoPrescription.getMedicaments() == null || (dtoPrescription.getMedicaments()).isEmpty()) {
            throw new IllegalArgumentException("Patient ID, doctor ID and medicaments list cannot be null or empty");
        }

        Patient patient = patientRepository.findById(dtoPrescription.getPatientId())
                .orElseThrow(() -> new PatientErrorExceptions("Patient not found with ID: " + dtoPrescription.getPatientId()));

        if (!medicamentClient.verifyMedicamentAvailability(dtoPrescription.getMedicaments())) {
            throw new PatientErrorExceptions("One or more medicaments are not available");
        }

        Prescriptions prescription = new Prescriptions();
        prescription.setPatientId(patient);
        prescription.setDoctorId(dtoPrescription.getDoctorId());
        prescription.setMedicaments(dtoPrescription.getMedicaments());
        prescription.setInstructions(dtoPrescription.getInstructions());

        return prescriptRepository.save(prescription);
    }

    public void deletePrescription(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Prescription ID cannot be null");
        }
        prescriptRepository.deleteById(id);
    }

    public List<Prescriptions> getAllPrescriptions() {
        return prescriptRepository.findAll();
    }

    public PrescriptionDetails getPrescriptionById(Long id) {
    // 1. Vérification que l'ID n'est pas null
    if (id == null) {
        throw new IllegalArgumentException("Prescription ID cannot be null");
    }

    // 2. Récupération de la prescription depuis la base de données
    // C'est ici que 'prescription' est obtenu via le repository
    Prescriptions prescription = prescriptRepository.findById(id)
            .orElseThrow(() -> new PatientErrorExceptions("Prescription not found with ID: " + id));

    // 3. Récupération des détails des médicaments
    List<Medicaments> medicamentDetails = prescription.getMedicaments().stream()
            .map(medicamentId -> medicamentClient.getMedicamentById(medicamentId))
            .collect(Collectors.toList());

    // 4. Construction de l'objet de retour
    PrescriptionDetails details = new PrescriptionDetails();
    details.setPatientId(prescription.getPatientId().getIdPat()); // patient vient de l'entité Prescriptions
    details.setDoctorId(prescription.getDoctorId());
    details.setMedicaments(prescription.getMedicaments());
    details.setMedicamentDetails(medicamentDetails);
    details.setInstructions(prescription.getInstructions());
    details.setDatePrescription(prescription.getDatePrescription());
    details.setDateModification(prescription.getDateModification());

    return details;
}
}