package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entità.Corso;
import Entità.Studente;

public interface CorsoDAO {

	public void inserisciCorso(String nome, String descrizione, String massimoPartecipanti, String areaTematica) throws SQLException;
	
	public ArrayList<Corso> leggiCorsi() throws SQLException;
	
	public int getLastID(int id) throws SQLException;
	
	public void eliminaCorso(int id) throws SQLException;
	
	public void aggiornaCorso(int id, String nome, String massimoPartecipanti, String areaTematica ,String descrizione) throws SQLException;
	
	public ArrayList<Corso> displayCorsiComboBox() throws SQLException;
	
	public void aggiornaDettagliCorso(int numeroLezioni, int presenzeObbligatorie,int idCorso) throws SQLException;
	
}
