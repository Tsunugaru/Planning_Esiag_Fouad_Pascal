package planning.model;

class Formateur {

    private String email;
    private String telephone;
    private String initiales;
    private String nom;
    private String prenom;

    public Formateur(String email, String telephone, String initiales, String nom, String prenom) {
        this.email = email;
        this.telephone = telephone;
        this.initiales = initiales;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInitiales() {
        return initiales;
    }

    public void setInitiales(String initiales) {
        this.initiales = initiales;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
