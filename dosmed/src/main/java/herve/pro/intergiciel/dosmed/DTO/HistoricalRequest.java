package herve.pro.intergiciel.dosmed.DTO;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalRequest {

    private List<Allergy> allergy;
    private List<Antecedent> antecedent;
    private List<Maladie> malEncours;
    private List<Document> documents;
    private Patient patient;

    @Data
    public static class Allergy {
        private String substance;
        private String reaction;
        private String severity;
    }

    @Data
    public static class Antecedent {
        private String type;
        private String description;
        private String date; // Format ISO: "YYYY-MM-DD"
    }

    @Data
    public static class Maladie {
        private String diagnostic;
        private String traitement;
        private String depuis; // Format ISO
    }

    @Data
    public static class Document {
        private String type;
        private String fileName;
        private String uploadDate; // Format ISO
    }

    @Data
    public static class Patient {
        private String id;
        private String nom;
        private String prenom;
        private String dateNaissance;
        private String sexe;
    }
}
