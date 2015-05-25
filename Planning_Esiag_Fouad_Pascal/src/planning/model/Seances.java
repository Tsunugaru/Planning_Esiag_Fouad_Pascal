package planning.model;

import java.util.ArrayList;

public class Seances {

    private int m; //nombre de séances
    private int n; //rang de la séance
    private ArrayList<Seance> listeSeances;

    public Seances(ArrayList<Seance> listeSeances) {
        this.listeSeances = listeSeances;

    }

    public int getNbSeances() {
        this.m = this.listeSeances.size();
        return this.m;
    }

    public int getRang(Seance seance) {
        for (int i = 0; i < this.listeSeances.size(); i++) {
            if (this.listeSeances.get(i) == seance) {
                this.n = i;
                break;
            }
        }

        return this.n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ArrayList<Seance> getListeSeances() {
        return this.listeSeances;
    }

    public void setListeSeances(ArrayList<Seance> listeSeances) {
        this.listeSeances = listeSeances;
    }
}
