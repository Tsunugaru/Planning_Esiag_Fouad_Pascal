
package planning.model.dates;

import java.util.ArrayList;
import static planning.model.dates.Jour.* ;

public class JourOuvre extends Jours {

    ArrayList<Jour> joursOuvres = new ArrayList<>();

    public JourOuvre() {
        super.jours = this.initJourOuvres();
        this.afficherJoursOuvres();
    }

    public void afficherJoursOuvres() {
        System.out.println("Liste des jours ouvrés");
        for (Jour joursOuvre : this.joursOuvres) {
            System.out.println(joursOuvre);
        }
    }

    public ArrayList<Jour> initJourOuvres() {
        this.joursOuvres.add(LUNDI);
        this.joursOuvres.add(MARDI);
        this.joursOuvres.add(MERCREDI);
        this.joursOuvres.add(JEUDI);
        this.joursOuvres.add(VENDREDI);
        return this.joursOuvres;
    }

    public ArrayList<Jour> getJours() {
        return jours;
    }

    public void setJours(ArrayList<Jour> jours) {
        this.jours = jours;
    }

}
