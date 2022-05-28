package Gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entità.Studente;

public class StudenteTableModel extends AbstractTableModel {

	private List<Studente> studenti = new ArrayList<Studente>();
	private String[] colonne = { "ID", "Nome", "Cognome", "Data Nascita", "Genere" };

	public StudenteTableModel() {

	}

	public StudenteTableModel(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}

	public String getColumnName(int column) {
		return colonne[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonne.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int colonne) {
		switch (colonne) {
		case 0:
			return studenti.get(rowIndex).getId();
		case 1:
			return studenti.get(rowIndex).getNome();
		case 2:
			return studenti.get(rowIndex).getCognome();
		case 3:
			return studenti.get(rowIndex).getDataNascita();
		case 4:
			return studenti.get(rowIndex).getGenere();
		}
		return null;
	}

	public void add(Studente riga) {
		studenti.add(riga);
//		fireTableRowsInserted(getRowCount(), getColumnCount());
		this.fireTableStructureChanged();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 1:
			studenti.get(rowIndex).setNome(aValue.toString());
			break;
		case 2:
			studenti.get(rowIndex).setCognome(aValue.toString());
			break;
		case 3:
			studenti.get(rowIndex).setDataNascita(aValue.toString());
			break;
		case 4:
			studenti.get(rowIndex).setGenere(aValue.toString());
			break;
		}
//		fireTableCellUpdated(rowIndex, columnIndex);
		 this.fireTableStructureChanged();
	}

	public void remove(int riga) {
		studenti.remove(riga);
//		fireTableRowsDeleted(getRowCount(), getColumnCount());
		this.fireTableStructureChanged();
	}

}
