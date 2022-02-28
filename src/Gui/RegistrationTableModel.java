package Gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entità.Corso;

public class RegistrationTableModel extends AbstractTableModel {
	
	private String[] colonne = {"Corso ID", "Nome corso"};
	private List<Object> righe = new ArrayList<Object>();
	
	public RegistrationTableModel() {
		
	}
	
	public RegistrationTableModel(ArrayList<Object> righe) {
		this.righe = righe;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return righe.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colonne.length;
	}

//	@Override
//	public Object getValueAt(int rowIndex, int columnIndex) {
//		switch (columnIndex) {
//		case 0:
//			return righe.get(rowIndex).getCodiceCorso();
//		case 1:
//			return righe.get(rowIndex).getNome();
//		}
//		return null;
//	}

	@Override
	public String getColumnName(int column) {
		return colonne[column];
	}
	
	public void addRow(String riga) {
		this.righe.add(riga);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
