package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.StudenteDAO;
import Entità.Studente;

public class StudenteDAOImpl implements StudenteDAO {


	public void inserisciStudente(Studente studente) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			String sqlcommand = "INSERT INTO studente VALUES(?, ?, ?, ?)";

			System.out.println("inserendo record nella tabella");
			
			stmt = conn.prepareStatement(sqlcommand);
			stmt.setString(1, studente.getNome());
			stmt.setString(2, studente.getCognome());
			stmt.setString(3, studente.getDataNascita());
			stmt.setString(4, studente.getGenere());
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void aggiornaStudente(Studente s) throws SQLException {

	}

	public void eliminaStudente(Studente studente) throws SQLException {

	}

	public ArrayList<Studente> leggiStudenti() throws SQLException {
		ArrayList<Studente> result = new ArrayList<Studente>();
		Connection conn = null;
		Statement st = null;
		try {
			st = conn.createStatement();

			String sql = "SELECT * FROM STUDENTE";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Studente s = new Studente();
				s.setNome(rs.getString(1));
				s.setCognome(rs.getString(2));
				s.setDataNascita(rs.getString(3));
				s.setGenere(rs.getString(4));
				result.add(s);
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;

	}

}
