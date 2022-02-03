package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entità.Corso;

public interface CorsoDAO {

	public void inserisciCorso(String nome, String descrizione, String massimoPartecipanti, String areaTematica) throws SQLException;
	
	public ArrayList<Corso> leggiCorsi() throws SQLException;
	
	public int getLastID(int id) throws SQLException;
	
}
