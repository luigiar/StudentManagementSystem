package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entità.Studente;
import Gui.PanelAggiungiStudente;

import java.sql.*;
import dbSettings.Connessione;

public interface StudenteDAO {

	public void inserisciStudente(Studente studente) throws SQLException;
	
	public void aggiornaStudente(Studente studente) throws SQLException;
	
	public void eliminaStudente(Studente studente) throws SQLException;
	
	public ArrayList<Studente> leggiStudenti() throws SQLException;
	
	
}
