package planning.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import planning.model.dates.Date;

public class ModeleCalendrier extends AbstractTableModel {

    private final ArrayList<Date> dates = new ArrayList<>();

    private final String[] entetes = {"Jour", "Numéro", "Mois", "Année"};

    public ModeleCalendrier() {
        super();

    }

    @Override
    public int getRowCount() {
        return dates.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dates.get(rowIndex).getJour();
            case 1:
                return dates.get(rowIndex).getNumeroJour();
            case 2:
                return dates.get(rowIndex).getMois();
            case 3:
                return dates.get(rowIndex).getAnnee();

            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addDate(Date date) {
        dates.add(date);
        fireTableRowsInserted(dates.size() - 1, dates.size() - 1);
    }

    public ArrayList<Date> getDates() {
        return this.dates;
    }
}
