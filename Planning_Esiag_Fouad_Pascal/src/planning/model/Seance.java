package planning.model;

public class Seance {

    private String descriptionSeance;
    private Formateur formateur; //unique formateur

    public Seance(String descriptionSeance) {
        this.descriptionSeance = descriptionSeance;
        // this.formateur = formateur;
    }

    public String getDescriptionSeance() {
        return descriptionSeance;
    }

    public void setDescriptionSeance(String descriptionSeance) {
        this.descriptionSeance = descriptionSeance;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

}
