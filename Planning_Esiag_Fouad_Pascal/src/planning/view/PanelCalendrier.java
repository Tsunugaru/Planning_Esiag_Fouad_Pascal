package planning.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelCalendrier extends JPanel {

    JTable tableau;
    ModeleCalendrier modele;

    public PanelCalendrier() {
        super();
        this.modele = new ModeleCalendrier();
        tableau = new JTable(this.modele);
        this.add(new JScrollPane(this.tableau));
        this.setSize(400, 200);
    }

    public JTable getTableau() {
        return tableau;
    }

    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }

    public ModeleCalendrier getModele() {
        return modele;
    }

    public void setModele(ModeleCalendrier modele) {
        this.modele = modele;
    }
}
