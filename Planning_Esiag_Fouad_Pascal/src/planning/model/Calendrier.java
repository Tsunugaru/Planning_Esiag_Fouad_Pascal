package planning.model;

import planning.model.dates.Annee;
import planning.model.dates.Date;
import planning.view.ModeleCalendrier;

/**
 *
 * @author Pascal
 */
public class Calendrier {

    Date date;

    public Calendrier(Date date) {
        this.date = date;
    }

    public void listeDates(ModeleCalendrier m, int semaine) {
        Annee annee = new Annee(this.date.getAnnee());
        int debut = 0;
        int nbJours = 7;
        //int nbJours = annee.joursMois(this.date.getMois());
        if (semaine == 1) {
            nbJours = 7;
            debut = 1;
        } else if (semaine == 2) {
            nbJours = 14;
            debut = 7;
        } else if (semaine == 3) {
            nbJours = 21;
            debut = 14;
        } else if (semaine == 4) {
            nbJours = 28;
            debut = 21;
        }
        for (int i = debut; i <= nbJours; i++) {
            this.date.setNumeroJour(i);
            System.out.println(this.date.jourAssocie() + " " + i + " " + this.date.getMois() + " " + this.date.getAnnee());
            m.addDate(new Date(i, this.date.getMois(), this.date.getAnnee()));
        }
    }

    public void listeAnnee() {
        Annee annee = new Annee(this.date.getAnnee());
        //annee.initMois();
        for (int i = 0; i < annee.getListeMois().size(); i++) {
            int k = annee.getListeNbJours().get(i); //Nombre de jours dans chaque case (mois)
            for (int m = 1; m <= k; m++) {
                this.date.setNumeroJour(m);
                this.date.setMois(annee.getListeMois().get(i));
                System.out.println(this.date.jourAssocie() + " " + m + " " + annee.getListeMois().get(i) + " " + this.date.getAnnee());

            }

        }
    }

}
