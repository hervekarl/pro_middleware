package com.herve.intergiciel.PatientManager.DTO;

import java.util.List;

import lombok.Data;

@Data
public class DtoPrescription {

    private Long patientId;
    private Long doctorId;
    private List<Long> medicaments;
    private String instructions;

}

