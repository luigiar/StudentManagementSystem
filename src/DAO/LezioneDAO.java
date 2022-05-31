package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Entità.Lezione;

public interface LezioneDAO {

	public ArrayList<Lezione> displayLezioniComboBox(int id) throws SQLException;


	public void insertLesson(String dataInizio, String idCorso, String titolo, String descrizione, String durata, String oraInizio) throws SQLException;
	
	public boolean checkLessonsNumber(int corsoID, boolean value, int numeroLezioni) throws SQLException;
	
	public ArrayList<Lezione> showElementsLesson(int lezioneID) throws SQLException;
	
	public void updateElemetsLesson(int lezioneID, String titolo, String descrizione, String durata, String oraInizio) throws SQLException;
	
	public void showNumberOfLessons(JLabel label, String idCorso) throws SQLException;
	
	public void getDetailLesson(String idCorso, JTextField numeroLezioni, JTextField presenzeObbligatorie) throws SQLException;
	
	
}
