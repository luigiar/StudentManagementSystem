package dao_impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.StudenteDAO;
import Entità.Studente;

public class StudenteDAOImpl implements StudenteDAO {

	public void inserisciStudente(Studente studente) throws SQLException {
//		Connection conn = null;
//		Statement stmt = null;
//
//		String sql = "INSERT INTO studente VALUES(" + studente.getNome() + "," + studente.getCognome() + ","
//				+ studente.getDataNascita() + "," + studente.getGenere();
//
//		System.out.println("inserendo record nella tabella");
//		stmt = conn.createStatement();
//
//		stmt.executeQuery(sql);

	}

	public void aggiornaStudente(Studente s) throws SQLException {

	}

	public void eliminaStudente(Studente studente) throws SQLException {

	}

	public ArrayList leggiStudenti(ArrayList<Studente> s) throws SQLException {
		return null;
	}

}
