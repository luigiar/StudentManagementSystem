package dao_impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

			System.out.println("eliminando studente...");
			deleteStudentST = conn.createStatement();

			deleteStudentST.executeUpdate(eliminazioneSql);
			System.out.println("studente eliminato!");

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

	@Override
	public void updateAttendanceStudents(String idCorso, String idStudente, String idLezione, String presenza,
			JTable table) throws SQLException {
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();
			CallableStatement aggiornaPresenza;

			int codiceCorso = Integer.parseInt(idCorso);
			int codiceStudente = Integer.parseInt(idStudente);
			int codiceLezione = Integer.parseInt(idLezione);
			boolean presence = Boolean.parseBoolean(presenza);
			aggiornaPresenza = conn.prepareCall("{call update_presence(?,?,?,?)}");
			aggiornaPresenza.setInt(1, codiceCorso);
			aggiornaPresenza.setInt(2, codiceStudente);
			aggiornaPresenza.setInt(3, codiceLezione);
			aggiornaPresenza.setBoolean(4, presence);
			aggiornaPresenza.executeUpdate();
			System.out.println("presenza aggiornata");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showStudentEnrolledTable(String idCorso, String data_lezione, String idLezione, JTable table)
			throws SQLException {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();
			CallableStatement mostraStudentiIscritti;

			// conversione string in date
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = (Date) simpleDateFormat.parse(data_lezione);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());
			int id = Integer.parseInt(idCorso);
			int id_lesson = Integer.parseInt(idLezione);

			mostraStudentiIscritti = conn.prepareCall("{call get_data_table(?,?,?)}");
			mostraStudentiIscritti.setInt(1, id);
			mostraStudentiIscritti.setDate(2, dataSQL);
			mostraStudentiIscritti.setInt(3, id_lesson);
			ResultSet result = mostraStudentiIscritti.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			while (result.next()) {
				int idStudente = result.getInt("idStudente");
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String data = result.getString("data_lezione");
				boolean presenza = result.getBoolean("presenza");
				model.addRow(new Object[] { idStudente, nome, cognome, data, presenza });
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deteleCourseEnrollment(JTable table, String id, String idStudente) throws SQLException {
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			CallableStatement rimuoviCorsoRegistrato;

			int idCorso = Integer.parseInt(id);
			int idStudent = Integer.parseInt(idStudente);
			rimuoviCorsoRegistrato = conn.prepareCall("{call delete_registered_course(?,?)}");
			rimuoviCorsoRegistrato.setInt(1, idCorso);
			rimuoviCorsoRegistrato.setInt(2, idStudent);
			rimuoviCorsoRegistrato.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		registrationStudent.removeRow(row);
		
	}

	@Override
	public void getStudentEnrolment(String idStudente, JTable table) throws SQLException {
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();
			int id = Integer.parseInt(idStudente);

			CallableStatement mostraCorsi;
			mostraCorsi = conn.prepareCall("{call show_table_student_course(?)}");
			mostraCorsi.setInt(1, id);
			ResultSet risultato = mostraCorsi.executeQuery();
			while (risultato.next()) {
				int idCorso = risultato.getInt(1);
				String nomeCorso = risultato.getString(2);
				registrationStudent.addRow(new Object[] { idCorso, nomeCorso });
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addCourseToStudent(JTable table, String idStudente, String idCorso, String nomeCorso)
			throws SQLException {
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();

			Connection conn = connect.getConnection();
			CallableStatement inserimentoCorso;

			int theStudentID = Integer.parseInt(idStudente);
			int theCourseID = Integer.parseInt(idCorso);

			inserimentoCorso = conn.prepareCall("{call insert_registration(?,?)}");

			inserimentoCorso.setInt(1, theCourseID);
			inserimentoCorso.setInt(2, theStudentID);
			inserimentoCorso.executeUpdate();

			SQLWarning warning = inserimentoCorso.getWarnings();

			if (warning != null) {
				String errore = warning.toString();
				errore = errore.substring(errore.lastIndexOf(": ") + 1).strip();
				JOptionPane.showMessageDialog(null, errore, "Attenzione", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Iscrizione Effettuata", "Conferma",
						JOptionPane.INFORMATION_MESSAGE);
				DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
				registrationStudent.addRow(new Object[] { idCorso, nomeCorso, "0%" });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void showTotalStudentsNumber(JLabel label) throws SQLException {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			PreparedStatement show;
			String mostraStudenti = "select count(*) from studente";
			show = con.prepareStatement(mostraStudenti);

			ResultSet risultato = show.executeQuery();
			while (risultato.next()) {
				label.setText("Studenti presenti : " + risultato.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
