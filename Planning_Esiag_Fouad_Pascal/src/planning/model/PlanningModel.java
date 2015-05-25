package planning.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class PlanningModel extends Observable implements Serializable {
    
    File file;
    ArrayList<Formation> formations = new ArrayList<>();
    ArrayList<Formation> recuperation = new ArrayList<>();
    
    public PlanningModel(ArrayList<Formation> formations) {
        this.formations = formations;
    }
    
    public PlanningModel() {
    }

    public ArrayList<Formation> getFormations() {
        return formations;
    }

    public void setFormations(ArrayList<Formation> formations) {
        this.formations = formations;
        setChanged();
        notifyObservers(this);
    }

    public void serialiser(File file) throws FileNotFoundException, IOException {
        //File file = new File("PlanningModel");
        FileOutputStream fis = new FileOutputStream(file);
        ObjectOutputStream ecr = new ObjectOutputStream(fis);
        ecr.writeObject(this);
        ecr.close();

    }

    public void deserialiser(File file) throws FileNotFoundException, IOException, ClassNotFoundException {

        PlanningModel sauvegarde = new PlanningModel(recuperation);
        FileInputStream fil = new FileInputStream(file);
        ObjectInputStream fal = new ObjectInputStream(fil);
        sauvegarde = (PlanningModel) fal.readObject();
    }

    public void deserialiser() throws FileNotFoundException, IOException, ClassNotFoundException {
        //String PATH="C
        File file = new File("Sauvegarde planning");
        PlanningModel sauvegarde = new PlanningModel(recuperation);
        FileInputStream fil = new FileInputStream(file);
        ObjectInputStream fal = new ObjectInputStream(fil);
        sauvegarde = (PlanningModel) fal.readObject();
    }

    public void serialiser() throws FileNotFoundException, IOException {
        File file = new File("Planning");
        FileOutputStream fis = new FileOutputStream(file);
        ObjectOutputStream ecr = new ObjectOutputStream(fis);
        ecr.writeObject(this);
        ecr.close();
    }

}
