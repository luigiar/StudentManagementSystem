package Gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entità.Corso;

public class CourseTableModel extends AbstractTableModel {
	
	private List<Corso> corsi = new ArrayList<Corso>();
	private String[] colonne = { "Corso ID", "Nome Corso", "Max Partecipanti", "Area Tematica", "Descrizione" };
	
	
	public CourseTableModel() {
		
	}
	public CourseTableModel(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}
	
	@Override
	public String getColumnName(int column) {
		return colonne[column];
	}

	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return corsi.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonne.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int colonne) {
		switch(colonne) {
		case 0:
			return corsi.get(rowIndex).getCodiceCorso();
		case 1:
			return corsi.get(rowIndex).getNome();
		case 2:
			return corsi.get(rowIndex).getMaxPartecipanti();
		case 3:
			return corsi.get(rowIndex).getAreeTematiche();
		case 4:
			return corsi.get(rowIndex).getDescrizione();
		}
		return null;
	}

	public void add(Corso riga) {
		corsi.add(riga);
//		fireTableRowsInserted(corsi.size() - 1, corsi.size() - 1);
		fireTableDataChanged();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
