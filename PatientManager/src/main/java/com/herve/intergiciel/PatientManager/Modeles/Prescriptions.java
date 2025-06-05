package com.herve.intergiciel.PatientManager.Modeles;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "prescriptions")
public class Prescriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patientId;

    private Long doctorId;

    @ElementCollection
    private List<Long> medicaments;

    private String instructions;

    @CreationTimestamp
    @Column(updatable = false, name = "date_prescription")
    private Date datePrescription;

    @UpdateTimestamp
    @Column(name = "date_modification")
    private Date dateModification;

}
