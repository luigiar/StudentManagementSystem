package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.StudenteDAO;
import Entità.Studente;
import dbSettings.Connessione;

public class StudenteDAOImpl implements StudenteDAO {

	private PreparedStatement inserisciStudenteStmt;
	Connection conn = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public void inserisciStudente(String nome, String cognome, String dataNascita, String genere) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		try {
			String inserimentoSQL = "INSERT INTO studente VALUES(?, ?, ?, ?)";
			// Convertendo data.util in data.sql
			Date date = simpleDateFormat.parse(dataNascita);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());
			System.out.println("inserendo record nella tabella");

			inserisciStudenteStmt = conn.prepareStatement(inserimentoSQL);
			inserisciStudenteStmt.setString(1, nome);
			inserisciStudenteStmt.setString(2, cognome);
			inserisciStudenteStmt.setDate(3, (java.sql.Date) dataSQL);
			inserisciStudenteStmt.setString(4, genere);
			inserisciStudenteStmt.execute();
			System.out.println("Dati Inseriti correttamente");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (inserisciStudenteStmt != null)
					conn.close();
			} catch (SQLException se) {
				// non fa nulla
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
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
