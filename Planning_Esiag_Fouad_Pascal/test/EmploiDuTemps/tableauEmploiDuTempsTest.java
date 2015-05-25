package EmploiDuTemps;


import static java.awt.Color.blue;
import static java.awt.Color.red;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import planning.model.Formation;
import planning.model.Module;
import planning.model.PlanningModel;
import planning.model.Seance;
import planning.model.Seances;
import planning.model.dates.Annee;
import planning.view.EmploiDuTemps;


/**
 *
 * @author Fouad777
 */
public class tableauEmploiDuTempsTest {

    ArrayList<Formation> formations = new ArrayList<>();
    ArrayList<Formation> recuperation = new ArrayList<>();
    PlanningModel planning = new PlanningModel(formations);
    PlanningModel sauvegarde = new PlanningModel(recuperation);

    Annee t = new Annee(2015);
    EmploiDuTemps EmploiDuTemps = new EmploiDuTemps(planning);
    Annee bis = new Annee(2012);
    private ArrayList<Seance> listeSeances;
    Seances sc = new Seances(listeSeances);
    Seances sc2 = new Seances(listeSeances);
    Module test = new Module("Math", "MTH", red, 24, sc);
    Module test2 = new Module("Java","IHM",blue,42,sc2);
    Formation formation = new Formation("ESIAG", t);
    private ArrayList<Module> modules = new ArrayList<Module>();

    @Test
    // Teste n°1 si le tableau de EmploiDuTemps a une colonne par jour de la semaine et  deux lignes par semaine
    public void tabconf() {
        assertEquals(7, EmploiDuTemps.modeleTableau.getColumnCount(), 1);
        assertEquals(2, EmploiDuTemps.modeleTableau.getRowCount(), 1);

    }

    // Teste n°2 une fois l'année choisie les jours sont crées automatiquement
    @Test
    public void jourannée() {
        assertEquals(365, t.nbJoursTotal());

    }

    // Test n°3 Prise en compte des années bisextiles
    @Test
    public void bisextile() {
        assertEquals(366, bis.nbJoursTotal());
    }
    //Test n°4 Pouvoir marqué les jours non ouvré
    @Test
    public void cellNotEditable(){
       assertFalse(EmploiDuTemps.modeleTableau.isCellEditable(0, 5));
       assertFalse(EmploiDuTemps.modeleTableau.isCellEditable(0, 6));
             
   }
    // Test n°7 Teste si chaque module a une couleur, un nom et une abbréviation distinct des autres
    @Test
    public void TestConstructeurModule() {
        assertEquals("Math", test.getNom());
        assertEquals("MTH", test.getAbreviation());
        assertEquals(red, test.getCouleur());
        assertEquals(24, test.getDuree(), 0);
        assertEquals(sc, test.getSeances());

    }

    // Test n°8 Ces données sont modifiable pour chaque module
    @Test
    public void modiffModule() {
        /**
         * String Java = new String(); String Jav = new String(); Color blue;
         * int nbsc = 12;*
         */
        test.setNom("Java");
        test.setAbreviation("Jav");
        test.setCouleur(blue);
        test.setDuree(12);
        assertEquals("Java", test.getNom());
        assertEquals("Jav", test.getAbreviation());
        assertEquals(blue, test.getCouleur());
        assertEquals(12, test.getDuree(), 0);
    }
    // Test n°9 Les modules ont un nom couleur et appréviation distinct des autres
    @Test
    public void DiffModule(){
    assertFalse(test.getNom().equals(test2.getNom()));
    assertFalse(test.getAbreviation().equals(test2.getAbreviation()));
    assertFalse(test.getCouleur()==test2.getCouleur());
}
    // Test n°10 sauve le planning sauve ces données
    @Test
    public void serialiser() throws IOException, FileNotFoundException, ClassNotFoundException {
        File file = new File("testunit");
        planning.serialiser(file);
        assertTrue(file.exists());
    }

    @Test
    public void deserialiser() throws IOException, FileNotFoundException, ClassNotFoundException {
        File file = new File("testUnitaire");
        planning.setFormations(formations);
        planning.serialiser(file);
        sauvegarde.deserialiser(file);
        Assert.assertEquals(planning.getFormations(), sauvegarde.getFormations());
    }
    
    //  Test  n°11 la durée en heure est affichée pour chaque module
    @Test
    public void nbheureModule() {
        test.setDuree(28);
        assertEquals(28, test.getDuree(), 1);
    }

    // Test n°12 la durée total de la formation en nombre de jourés et d'heures est affiché
    /**@Test
    public void nbheureFormation() {

        formation.ajouterModule(modules, test);
        assertEquals(24, formation.dureeTotale(), 1);
    }**/
    
    

 








}
