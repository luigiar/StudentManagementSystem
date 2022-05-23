package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;

import Entità.Studente;
import Gui.PanelAggiungiStudente;

import java.sql.*;
import dbSettings.Connessione;

public interface StudenteDAO {

	public void inserisciStudente(String nome, String cognome, String dataNascita, String genere) throws SQLException;
	
	public void aggiornaStudente(Studente studente) throws SQLException;
	
	public void eliminaStudente(int id) throws SQLException;
	
	public ArrayList<Studente> leggiStudenti() throws SQLException;
	
	public int getLastID(int id) throws SQLException;
	
	public void mostraStudentiIdonei(int idCorso,JTable table) throws SQLException;
	
	
}
