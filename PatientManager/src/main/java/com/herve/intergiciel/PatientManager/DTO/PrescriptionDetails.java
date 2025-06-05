package com.herve.intergiciel.PatientManager.DTO;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class PrescriptionDetails {

    private Long patientId;
    private Long doctorId;
    private List<Long> medicaments;
    private List<Medicaments> medicamentDetails;
    private String instructions;
    private Date datePrescription;
    private Date dateModification;
}