package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Entità.Studente;

import java.sql.*;
import dbSettings.Connessione;

public interface StudenteDAO {

	void inserisciStudente(Studente studente) throws SQLException;
	
	void aggiornaStudente(Studente studente) throws SQLException;
	
	void eliminaStudente(Studente studente) throws SQLException;
	

}
