package herve.pro.intergiciel.dosmed.Modeles;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import herve.pro.intergiciel.dosmed.CONVERTIR.AllergyListConverter;
import herve.pro.intergiciel.dosmed.CONVERTIR.AntecedentListConverter;
import herve.pro.intergiciel.dosmed.CONVERTIR.DocumentListConverter;
import herve.pro.intergiciel.dosmed.CONVERTIR.JsonConverter;
import herve.pro.intergiciel.dosmed.CONVERTIR.MaladieListConverter;
import herve.pro.intergiciel.dosmed.CONVERTIR.PatientConverter;
import herve.pro.intergiciel.dosmed.DTO.HistoricalRequest;

@Entity
@Table(name = "dossier_patient")
@Data
public class Historical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "JSON")
    @Convert(converter = AllergyListConverter.class)
    private List<HistoricalRequest.Allergy> allergy;

    @Column(columnDefinition = "JSON")
    @Convert(converter = AntecedentListConverter.class)
    private List<HistoricalRequest.Antecedent> antecedent;

    @Column(columnDefinition = "JSON")
    @Convert(converter = MaladieListConverter.class)
    private List<HistoricalRequest.Maladie> malEncours;

    @Column(columnDefinition = "JSON")
    @Convert(converter = DocumentListConverter.class)
    private List<HistoricalRequest.Document> documents;

    @Column(columnDefinition = "JSON", unique = true)
    @NonNull
    @Convert(converter = PatientConverter.class)
    private HistoricalRequest.Patient patient;

}
