package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import dbSettings.Connessione;

public class StudenteDAO {
	
	private Connection connection = null;
	private Statement st = null;

//	connessione al database

	public void inserisciStudente(String nome, String cognome, String gender, String dataN) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO studente(\r\n"
					+ "	\"StudenteID\", nome, cognome, \"dataNascita\", genere)\r\n"
					+ "	VALUES (\"NCOX1\",\"Antonio\", \"Carminio\", \"11-08-2001\", \"Uomo\");");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
