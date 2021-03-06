package planning.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import planning.model.PlanningModel;

/**
 *
 * @author Pascal
 */
public class EmploiDuTemps extends javax.swing.JPanel implements Observer {

    private final PlanningModel planningModel;
    public final ModeleTableau modeleTableau;

    public EmploiDuTemps(PlanningModel planningModel) {
        this.planningModel = planningModel;
        modeleTableau = new ModeleTableau();
        planningModel.addObserver(EmploiDuTemps.this);
        initComponents();
    }

    private EmploiDuTemps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable o, Object o1) {
        modeleTableau.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableauPlanning = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Emploi du Temps", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 13), new java.awt.Color(51, 51, 255))); // NOI18N

        tableauPlanning.setModel(modeleTableau);
        tableauPlanning.setMaximumSize(new java.awt.Dimension(15, 15));
        jScrollPane1.setViewportView(tableauPlanning);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableauPlanning;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        new EmploiDuTemps().setVisible(true);
    }

    public class ModeleTableau extends AbstractTableModel {

        private final String[] entetes = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

        private final Object[][] donnees;

        public ModeleTableau() {
            super();
            donnees = new  Object[][] {
                {"", "", "", "", "", "", ""},
                {"", "", "", "", "", "", ""}
            };
        }
        
        @Override
        public int getRowCount() {
            return donnees.length ;
        }

        @Override
        public int getColumnCount() {
            return entetes.length ;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return entetes[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            /**
             * ici j'ai penser a mettre le nom d'un module pour l'identifier
             * dans le planning dans la table
             *
             */
            return donnees[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return !((column == 5) || (column == 6));
        }
    }
}
