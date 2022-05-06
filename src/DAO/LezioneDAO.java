package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entità.Lezione;

public interface LezioneDAO {

	public ArrayList<Lezione> displayLezioniComboBox(int id) throws SQLException;


	public void insertLesson(String dataInizio, String idCorso, String titolo, String descrizione, String durata, String oraInizio) throws SQLException;
	
	public boolean checkLessonsNumber(int corsoID, boolean value, int numeroLezioni) throws SQLException;
}
