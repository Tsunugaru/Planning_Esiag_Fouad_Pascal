package planning.model;

import planning.model.dates.Annee;
import java.awt.Color;
import java.util.ArrayList;


public class Formation {

    private int nbLimite = 3;
    private Annee annee;
    private String nom;
    private ArrayList<Module> modules = new ArrayList<>();

    public Formation(String nom, Annee annee) {
        this.nom = nom;
        this.annee = annee;
        initModules();
        afficherFormation();
    }

    public boolean verifNbSeances(Module module) {
        boolean b = false;
        if ((module.getSeances().getNbSeances()) > (this.nbLimite)) {
            b = false;
        } else {
            b = true;
        }

        return b;
    }

    public void afficherFormation() {
        System.out.println(this.getNom() + " " + this.getAnnee().getAnnee());
        System.out.println("Liste des Modules: ");
        for (int i = 0; i < this.modules.size(); i++) {
            System.out.println(this.modules.get(i).getNom());
        }
        System.out.println("Durée totale: " + this.dureeTotale() + " heures");
    }

    public void initModules() {
        ArrayList<Seance> seanceModule = new ArrayList<Seance>();

        seanceModule.add(new Seance("Cours 1"));
        seanceModule.add(new Seance("Cours 2"));
        seanceModule.add(new Seance("Cours 3"));
        seanceModule.add(new Seance("Cours 4"));

        Seances seances = new Seances(seanceModule);

        ArrayList<Seance> seanceModule2 = new ArrayList<Seance>();
        seanceModule2.add(new Seance("Cours vv1"));
        seanceModule2.add(new Seance("Cours vv2"));
        seanceModule2.add(new Seance("Cours vv3"));
        Seances seances2 = new Seances(seanceModule2);

        ArrayList<Seance> seanceModule3 = new ArrayList<Seance>();
        seanceModule3.add(new Seance("Cours ss1"));
        seanceModule3.add(new Seance("Cours scsc2"));
        Seances seances3 = new Seances(seanceModule3);

        ArrayList<Seance> seanceModule4 = new ArrayList<Seance>();
        seanceModule4.add(new Seance("Cours scscsc"));

        Seances seances4 = new Seances(seanceModule4);

        this.ajouterModule(this.modules, new Module("JAVA", "J", Color.green, 20, seances));
        this.ajouterModule(this.modules, new Module("UML", "U", Color.green, 10, seances2));
        this.ajouterModule(this.modules, new Module("Programmation linéaire", "PL", Color.green, 200, seances3));
        this.ajouterModule(this.modules, new Module("Anglais", "A", Color.green, 10, seances4));

    }

    public void ajouterModule(ArrayList<Module> modules, Module m) {
        if (verifNbSeances(m) == true) {
            this.modules.add(m);
        } else {
            System.out.println("Erreur! Le module " + m.getNom() + " ne peut être ajouté");
        }
    }

    public void ajouterModule(Module m) {
        if (verifNbSeances(m) == true) {
            this.modules.add(m);
        } else {
            System.out.println("Erreur! Le module " + m.getNom() + " ne peut être ajouté");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public int dureeTotale() {
        int dureeTotale = 0;
        for (int i = 0; i < this.modules.size(); i++) {
            dureeTotale = dureeTotale + this.modules.get(i).getDuree();
        }
        return dureeTotale;
    }

    public Annee getAnnee() {
        return annee;
    }

    public void setAnnee(Annee annee) {
        this.annee = annee;
    }
}
