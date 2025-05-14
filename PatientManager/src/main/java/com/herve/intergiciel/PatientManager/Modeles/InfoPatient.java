package com.herve.intergiciel.PatientManager.Modeles;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "info_patient")
public class InfoPatient {

    // definition des types de valeur que contiendra le genre
    public enum Genre{HOMME, FEMME, AUTRE, homme, femme, autre, Homme, Femme, H, F, h, f}
    // definition des types de valeur que contiendra le groupe sanguin
    public enum GroupeSanguin { A, B, AB, O }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPat;

    @NotNull(message = "Ce champ est obligatoire")
    private String name;
    
    private String prenom;

    @Pattern(regexp = "^[+0][0-9]*$", message = "Le téléphone doit commencer par + ou 0")
    private String tel;

    private String addr;
   
    @NotNull(message = "Ce champ est obligatoire")
    private Genre sexe;

    @Column(name = "date_naissance")
    private String dateN;

    @Email(message = "Email invalide ou est deja utilisé")
    @Column(unique = true)
    private String email;

    private GroupeSanguin groupeSanguin;


}
