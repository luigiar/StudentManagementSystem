package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Entità.AreeTematiche;
import Entità.Corso;
import Entità.Studente;
import Gui.CourseTableModel;

public interface CorsoDAO {

	public void inserisciCorso(String nome, String descrizione, String massimoPartecipanti, String areaTematica, String data_inizio) throws SQLException;
	
	public ArrayList<Corso> leggiCorsi() throws SQLException;
	
	public int getLastID(int id) throws SQLException;
	
	public void eliminaCorso(int id) throws SQLException;
	
	public boolean aggiornaCorso(boolean isUpdate,int id, String nome, String massimoPartecipanti ,String descrizione, String dataInizio) throws SQLException;
	
	public ArrayList<Corso> displayCorsiComboBox() throws SQLException;
	
	public void aggiornaDettagliCorso(int numeroLezioni, int presenzeObbligatorie,int idCorso) throws SQLException;
	
	public void mostraDettagliCorsi(JTable table) throws SQLException;
	
	public void getDataInizioCorso(String id, JTextField dataInizio) throws SQLException;
	
	public void showTotalCourseNumber(JLabel label) throws SQLException;
		
}
