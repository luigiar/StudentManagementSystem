package dao_impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.StudenteDAO;
import Entità.Studente;
import dbSettings.Connessione;

public class StudenteDAOImpl implements StudenteDAO {

	private PreparedStatement inserisciStudenteStmt;
	Connection conn = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Statement deleteStudentST;

	public void inserisciStudente(String nome, String cognome, String dataNascita, String genere) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		try {
			String inserimentoSQL = "INSERT INTO studente(nome,cognome,data_nascita, genere) VALUES(?, ?, ?, ?)";
			// Convertendo data.util in data.sql
			Date date = simpleDateFormat.parse(dataNascita);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());
			System.out.println("inserendo record nella tabella");

			inserisciStudenteStmt = conn.prepareStatement(inserimentoSQL);
			inserisciStudenteStmt.setString(1, nome);
			inserisciStudenteStmt.setString(2, cognome);
			inserisciStudenteStmt.setDate(3, (java.sql.Date) dataSQL);
			inserisciStudenteStmt.setString(4, genere);
			inserisciStudenteStmt.executeUpdate();
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

	public void eliminaStudente(int id) throws SQLException {

		Connessione connection = Connessione.getInstance();
		conn = connection.getConnection();
		System.out.println("connessione delete eseguita");

		try {
			String eliminazioneSql = "DELETE FROM studente WHERE id = " + id;

			System.out.println("eliminando corsi...");
			deleteStudentST = conn.createStatement();

			deleteStudentST.executeUpdate(eliminazioneSql);
			System.out.println("corso eliminato!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (deleteStudentST != null)
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

	public ArrayList<Studente> leggiStudenti() throws SQLException {
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		Statement mostraStudentiST = null;
		try {
			System.out.println("Mostrando elementi tabella studenti... ");
			mostraStudentiST = conn.createStatement();

			String selezionaStudentiSQL = "SELECT * FROM studente order by id";
			ResultSet result = mostraStudentiST.executeQuery(selezionaStudentiSQL);

			while (result.next()) {
				Studente s = new Studente();
				s.setId(result.getInt(1));
				s.setNome(result.getString(2));
				s.setCognome(result.getString(3));
				s.setDataNascita(result.getString(4));
				s.setGenere(result.getString(5));
				studenti.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (mostraStudentiST != null)
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
		return studenti;

	}

	@Override
	public int getLastID(int id) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		Statement mostraID = null;

		try {
			mostraID = conn.createStatement();

			String mostraIDSql = "SELECT MAX(id) AS LastID FROM studente";
			ResultSet risultato = mostraID.executeQuery(mostraIDSql);
			while (risultato.next()) {
				id = risultato.getInt(1);
			}
		} catch (SQLException e) {

		}
		try {
			if (mostraID != null)
				conn.close();
		} catch (SQLException se) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return id;
	}

	@Override
	public void aggiornaStudente(Studente studente) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostraStudentiIdonei(int idCorso,JTable table) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		CallableStatement mostraStudenti;

		mostraStudenti = conn.prepareCall("{call get_studenti_idonei(?)}");
		mostraStudenti.setInt(1, idCorso);
		System.out.println("calcolando studenti idonei...");
		ResultSet result = mostraStudenti.executeQuery();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		while (result.next()) {
			int id = result.getInt("id_studente");
			String nome = result.getString("nome");
			String cognome = result.getString("cognome");
			int presenze = result.getInt("presenze");

			
			model.addRow(new Object[] {id,nome,cognome, presenze});
		}
		
	}

}
