package planning.model.dates;

import static planning.model.dates.Jour.DIMANCHE;
import static planning.model.dates.Jour.SAMEDI;
import java.util.ArrayList;

public class JourNonOuvre extends Jours {

    ArrayList<Jour> joursNonOuvres = new ArrayList<>();

    public JourNonOuvre() {
        super.jours = this.initJoursNonOuvres();
        this.afficherJoursNonOuvres();
    }

    public void afficherJoursNonOuvres() {
        System.out.println("Liste des jours non ouvrés");
        for (Jour joursNonOuvre : this.joursNonOuvres) {
            System.out.println(joursNonOuvre);
        }
    }

    public ArrayList<Jour> initJoursNonOuvres() {
        this.joursNonOuvres.add(SAMEDI);
        this.joursNonOuvres.add(DIMANCHE);
        return this.joursNonOuvres;
    }

    public ArrayList<Jour> getJours() {
        return jours;
    }

    public void setJours(ArrayList<Jour> jours) {
        this.jours = jours;
    }
}
