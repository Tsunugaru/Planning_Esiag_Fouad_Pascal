package planning.model.dates;

/**
 *
 * @author Pascal
 */
public class Date {

    Mois mois;
    int numeroJour;
    int annee;
    Jour jour;

    public Date() {

    }

    public Date(int numeroJour, Mois mois, int annee) {
        this.mois = mois;
        this.numeroJour = numeroJour;
        this.annee = annee;
        this.jour = this.jourAssocie();
    }

    public Date(Mois mois, int annee) {
        this.annee = annee;
        this.mois = mois;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public int getNumeroJour() {
        return numeroJour;
    }

    public void setNumeroJour(int numeroJour) {
        this.numeroJour = numeroJour;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Jour jourAssocie() {
        int jour = this.getNumeroJour();
        int mois = associerMois(this.getMois());
        int annee = this.getAnnee();

        int c, a, m, j;

        c = (14 - mois) / 12;
        a = annee - c;
        m = mois + 12 * c - 2;
        j = (jour + a + a / 4 - a / 100 + a / 400 + (31 * m) / 12) % 7;
        return associerJour(j);
    }

    public int associerMois(Mois mois) {
        int unMois = 0;
        if (mois == Mois.JANVIER) {
            unMois = 1;
        } else if (mois == Mois.FEVRIER) {
            unMois = 2;

        } else if (mois == Mois.MARS) {
            unMois = 3;

        } else if (mois == Mois.AVRIL) {
            unMois = 4;

        } else if (mois == Mois.MAI) {
            unMois = 5;

        } else if (mois == Mois.JUIN) {
            unMois = 6;

        } else if (mois == Mois.JUILLET) {
            unMois = 7;

        } else if (mois == Mois.AOUT) {
            unMois = 8;

        } else if (mois == Mois.SEPTEMBRE) {
            unMois = 9;

        } else if (mois == Mois.OCTOBRE) {
            unMois = 10;

        } else if (mois == Mois.NOVEMBRE) {
            unMois = 11;

        } else if (mois == Mois.DECEMBRE) {
            unMois = 12;

        }
        return unMois;
    }

    public Mois associerMois(int unMois) {
        Mois mois = null;
        if (unMois == 1) {
            mois = Mois.JANVIER;
        } else if (unMois == 2) {
            mois = Mois.FEVRIER;

        } else if (unMois == 3) {
            mois = Mois.MARS;

        } else if (unMois == 4) {
            mois = Mois.AVRIL;

        } else if (unMois == 5) {
            mois = Mois.MAI;

        } else if (unMois == 6) {
            mois = Mois.JUIN;

        } else if (unMois == 7) {
            mois = Mois.JUILLET;

        } else if (unMois == 8) {
            mois = Mois.AOUT;

        } else if (unMois == 9) {
            mois = Mois.SEPTEMBRE;

        } else if (unMois == 10) {
            mois = Mois.OCTOBRE;

        } else if (unMois == 11) {
            mois = Mois.NOVEMBRE;

        } else if (unMois == 12) {
            mois = Mois.DECEMBRE;

        }
        return mois;
    }

    public Jour getJour() {
        return this.jour;
    }

    public Jour associerJour(int i) {
        Jour jour = null;
        if (i == 1) {
            jour = Jour.LUNDI;
        } else if (i == 2) {
            jour = Jour.MARDI;

        } else if (i == 3) {
            jour = Jour.MERCREDI;
        } else if (i == 4) {
            jour = Jour.JEUDI;

        } else if (i == 5) {
            jour = Jour.VENDREDI;
        } else if (i == 6) {
            jour = Jour.SAMEDI;
        } else if (i == 0) {
            jour = Jour.DIMANCHE;
        }
        return jour;
    }

    @Override
    public String toString() {
        return this.jour + " " + this.numeroJour + " " + this.mois + " " + this.annee;
    }
}
