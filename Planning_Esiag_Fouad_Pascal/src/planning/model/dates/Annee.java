package planning.model.dates;

import java.util.ArrayList;
import java.util.Observable;

public class Annee extends Observable {

    private int annee;
    ArrayList<Mois> listeMois = new ArrayList<>();
    private int nbJours;
    ArrayList<Integer> listeNbJours = new ArrayList<>();

    public ArrayList<Date> semaine = new ArrayList<>();
    public String jour = new String();
    public String mois = new String();
    public int numjour;

    public Annee(int annee) {
        this.annee = annee;
        nbJours = 0;

        initMois();
    }

    public void initMois() {
        listeGetMois();//ajouter les mois a l'année

        listeDesJours();//ajouter les jour au mois
        afficherMois();
        afficherJours();
        for (int i = 0; i < this.listeMois.size(); i++) {
            if (this.listeMois.get(i) == Mois.JANVIER || this.listeMois.get(i) == Mois.MARS || this.listeMois.get(i) == Mois.MAI || this.listeMois.get(i) == Mois.JUILLET
                    || this.listeMois.get(i) == Mois.AOUT || this.listeMois.get(i) == Mois.OCTOBRE || this.listeMois.get(i) == Mois.DECEMBRE) {
                this.nbJours = 31;
            } else if (this.listeMois.get(i) == Mois.AVRIL || this.listeMois.get(i) == Mois.JUIN || this.listeMois.get(i) == Mois.SEPTEMBRE || this.listeMois.get(i) == Mois.NOVEMBRE) {
                this.nbJours = 30;
            } else if (this.listeMois.get(i) == Mois.FEVRIER) {
                //test année bissextile
                if (((annee % 100 != 0) && (annee % 4 == 0))) {
                    this.nbJours = 29;
                } else {
                    this.nbJours = 28;
                }

            }
            //ajout du mois avec son nombre de jours dans la map

        }

    }

    public ArrayList<Mois> getListeMois() {
        return this.listeMois;
    }

    public void setListeMois(ArrayList<Mois> listeMois) {
        this.listeMois = listeMois;
    }

    public String affichagesemaine(int mois, int semaine) {
        /**
         * le premier int i permet de selectionner le mois dans l'array list Le
         * second selectionne la semaine dans le mois precedemment selectionner
         */
        return null;

    }

    public ArrayList<Integer> getListeNbJours() {
        return this.listeNbJours;
    }

    public void setListeNbJours(ArrayList<Integer> listeNbJours) {
        this.listeNbJours = listeNbJours;
    }

    // 
    public ArrayList<Integer> listeDesJours() {
        for (int i = 0; i < this.listeMois.size(); i++) {
            if (this.listeMois.get(i) == Mois.JANVIER || this.listeMois.get(i) == Mois.MARS || this.listeMois.get(i) == Mois.MAI || this.listeMois.get(i) == Mois.JUILLET
                    || this.listeMois.get(i) == Mois.AOUT || this.listeMois.get(i) == Mois.OCTOBRE || this.listeMois.get(i) == Mois.DECEMBRE) {
                this.nbJours = 31;
                this.listeNbJours.add(this.nbJours);

            } else if (this.listeMois.get(i) == Mois.AVRIL || this.listeMois.get(i) == Mois.JUIN || this.listeMois.get(i) == Mois.SEPTEMBRE || this.listeMois.get(i) == Mois.NOVEMBRE) {
                this.nbJours = 30;
                this.listeNbJours.add(this.nbJours);

            } else if (this.listeMois.get(i) == Mois.FEVRIER) {
                //test année bissextile
                if (((annee % 100 != 0) && (annee % 4 == 0))) {
                    this.nbJours = 29;
                } else {
                    this.nbJours = 28;
                }
                this.listeNbJours.add(this.nbJours);

            }
        }

        return this.listeNbJours;
    }

    public ArrayList<Mois> listeGetMois() {
        Mois[] mois = new Mois[]{Mois.JANVIER, Mois.FEVRIER, Mois.MARS, Mois.AVRIL, Mois.MAI, Mois.JUIN, Mois.JUILLET, Mois.AOUT, Mois.SEPTEMBRE, Mois.OCTOBRE, Mois.NOVEMBRE, Mois.DECEMBRE};
        for (int i = 0; i < mois.length; i++) {
            this.listeMois.add(mois[i]);
        }

        return this.listeMois;
    }

    public void afficherMois() {
        for (int i = 0; i < this.listeMois.size(); i++) {
            System.out.println(this.listeMois.get(i));
        }
    }

    public void afficherJours() {
        for (int i = 0; i < this.listeNbJours.size(); i++) {
            System.out.println(this.listeNbJours.get(i));
        }
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
//retourne tous les mois de l'année

    public ArrayList<Mois> getMois() {
        return this.listeMois;
    }

    public void setMois(ArrayList<Mois> mois) {
        this.listeMois = mois;
    }

    public int getNbJours() {
        return this.nbJours;
    }

    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    //renvoie le nombre de jours du mois
    public int joursMois(Mois mois) {
        int nbJours = 0;
        for (int i = 0; i < this.listeMois.size(); i++) {
            if (this.listeMois.get(i) == mois) {
                nbJours = this.listeNbJours.get(i);
                break;
            }

        }
        //System.out.println("Le mois " + mois + " de l'année " + this.annee + " comporte " + nbJours + " jours");
        return nbJours;
    }
//nombre total de jours dans l'année

    public int nbJoursTotal() {
        int nbJoursTotal = 0;
        for (int i = 0; i < this.listeNbJours.size(); i++) {
            nbJoursTotal = this.listeNbJours.get(i) + nbJoursTotal;
        }
        System.out.println("L'année " + this.annee + " comporte " + nbJoursTotal + " jours");

        return nbJoursTotal;
    }

    public void a() {

        for (int v = 0; v <= semaine.size(); v++) {
            jour = semaine.get(v).getJour().name();
            System.out.println(jour);
        }

    }

    public String b(int i) {
        mois = semaine.get(i).getMois().name();
        System.out.println(mois);
        return mois;

    }

    public int c(int i) {
        numjour = semaine.get(i).getNumeroJour();
        System.out.println(numjour);
        return numjour;

    }

    public void test(int i) {

        System.out.println("on rentre dans le test");
        System.out.println(semaine.get(i).getNumeroJour());
    }

}
