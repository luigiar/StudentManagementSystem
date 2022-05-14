package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.AdminDAO;
import DAO.CorsoDAO;
import DAO.LezioneDAO;
import DAO.StudenteDAO;
import Entità.AreeTematiche;
import Entità.Corso;
import Entità.Lezione;
import Entità.Studente;
import Gui.CourseTableModel;
import Gui.LoginFrame;
import Gui.MainFrame;
import Gui.StudenteTableModel;
import dao_impl.AdminDAOImpl;
import dao_impl.CorsoDAOImpl;
import dao_impl.LezioneDAOImpl;
import dao_impl.StudenteDAOImpl;
import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {
	// Riferimenti al Login e Main Frame
	LoginFrame lf;
	MainFrame hm;
	StudenteDAO student = new StudenteDAOImpl();
	CorsoDAO course = new CorsoDAOImpl();
	AdminDAO admin = new AdminDAOImpl();
	LezioneDAO lesson = new LezioneDAOImpl();
	private CourseTableModel model;
	private StudenteTableModel modelStud;

	public static void main(String[] args) {

		// CREAZIONE DEL DATABASE E CONNESSIONE
		Connessione connessioneDB = null;
		Connection conn = null;
		DBBuilder builder = null;

		try {
			connessioneDB = Connessione.getInstance();
			conn = connessioneDB.getConnection();
			builder = new DBBuilder(conn);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		conn = connessioneDB.getConnection();

		// Start Controller
		Controller c = new Controller();
	}

	// launcher finestre
	public Controller() {
		lf = new LoginFrame(this);
		lf.setVisible(true);
	}

	public void showTotalStudentsNumber(JLabel label) {
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

	public void showTotalCourseNumber(JLabel label) {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			PreparedStatement show;
			String mostraCorsi = "select count(*) from corso";
			show = con.prepareStatement(mostraCorsi);

			ResultSet risultato = show.executeQuery();
			while (risultato.next()) {
				label.setText("Corsi presenti : " + risultato.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertStudent(String name, String surname, String date, String genere) {
		student = new StudenteDAOImpl();
		try {
			student.inserisciStudente(name, surname, date, genere);
			JOptionPane.showMessageDialog(null, "Inserimento effettuato", "Conferma", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayStudent(JTable table) {
		try {
			modelStud = new StudenteTableModel(student.leggiStudenti());
			table.setModel(modelStud);
			TableRowSorter myTableRowSorter = new TableRowSorter(modelStud);
			table.setRowSorter(myTableRowSorter);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudentToTableView(JTable table, JTextField nome, JTextField cognome, JTextFieldDateEditor data,
			ButtonGroup genere) {
		try {
			table.setModel(modelStud);
			int id = 0;
			id = student.getLastID(id);
			Studente s = new Studente(id, nome.getText(), cognome.getText(), data.getText().toString(),
					genere.getSelection().getActionCommand());
			modelStud.add(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteStudent(JTable table) {
		int row = table.getSelectedRow();
		String deleteCell = table.getValueAt(row, 0).toString();
		int theID = Integer.parseInt(deleteCell);

		try {
			student.eliminaStudente(theID);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		modelStud.remove(row);
	}

	public void insertCourse(String name, String description, String maxStudents, String themeArea, String date) {
		course = new CorsoDAOImpl();
		try {
			course.inserisciCorso(name, description, maxStudents, themeArea, date);
			JOptionPane.showMessageDialog(null, "Inserimento effettuato", "Conferma", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayCourse(JTable table) {
		try {
			model = new CourseTableModel(course.leggiCorsi());
			table.setModel(model);
			TableRowSorter myTableRowSorter = new TableRowSorter(model);
			table.setRowSorter(myTableRowSorter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCourseToTableView(JTable table, JTextField nome, JTextField maxPartecipanti, JComboBox areaTematica,
			JTextArea descrizione) {
		try {
			table.setModel(model);
			int id = 0;
			id = course.getLastID(id);
			int maxPart = Integer.parseInt(maxPartecipanti.getText());
			Corso c = new Corso(id, nome.getText(), descrizione.getText(), maxPart,
					areaTematica.getSelectedItem().toString());
			model.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(JTable table) {
		int row = table.getSelectedRow();
		String deleteCell = table.getValueAt(row, 0).toString();
		int theID = Integer.parseInt(deleteCell);
		try {
			course.eliminaCorso(theID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.remove(row);
	}

	public void updateDetailsCourse(String numeroLezioni, String presenzeObbligatorie, String id) {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			// Conversione valori
			int codiceCorso = Integer.parseInt(id);
			int lezioniTotali = Integer.parseInt(numeroLezioni);
			int presenzeNecessarie = Integer.parseInt(presenzeObbligatorie);

			course.aggiornaDettagliCorso(lezioniTotali, presenzeNecessarie, codiceCorso);
			JOptionPane.showMessageDialog(null, "Aggiornamento effettuato", "Conferma",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Dati inseriti non validi", "Attenzione", JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCourse(JTable table, String nome, String maxPartecipanti,
			String descrizione, String dataInizio ) {
		try {
			int rigaSelected = table.getSelectedRow();
			int theID = (int) model.getValueAt(rigaSelected, 0);
			course.aggiornaCorso(theID, nome, maxPartecipanti, descrizione,dataInizio);

			model.setValueAt(nome, rigaSelected, 1);
			model.setValueAt(maxPartecipanti, rigaSelected, 2);
			model.setValueAt(descrizione, rigaSelected, 4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void updateAreaTematica(String areaTematica,String idCorso) {
		int id = Integer.parseInt(idCorso);
		
		try {
			course.aggiornaArea(areaTematica, id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mostraCorsiComboBox(JComboBox comboBox) {
		try {
			ArrayList<Corso> corsi = course.displayCorsiComboBox();
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (Corso c : corsi) {
				String nomeCorso = c.getNome();
				Integer codice = c.getCodiceCorso();
				String codiceCorso = String.valueOf(codice);
				modelComboBox.addElement(codiceCorso + " " + nomeCorso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostraLezioniComboBox(JComboBox comboBox, String id) {
		try {
			int idCorso = Integer.parseInt(id);
			ArrayList<Lezione> lezioni = lesson.displayLezioniComboBox(idCorso);
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (Lezione l : lezioni) {
				int codiceLezione = l.getCodiceLezione();
				String dataInizio = l.getDataInizio();
				modelComboBox.addElement("Lezione " + codiceLezione + " : " + dataInizio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addCourseToStudent(JComboBox comboBox, String idStudente, String idCorso) {
		DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();

			Connection conn = connect.getConnection();

			PreparedStatement inserimentoCorso;

			String inserimentoSql = "INSERT INTO registrazione (studente_id, corso_id) VALUES (?, ?)";

			int theStudentID = Integer.parseInt(idStudente);
			int theCourseID = Integer.parseInt(idCorso);

			inserimentoCorso = conn.prepareStatement(inserimentoSql);
			inserimentoCorso.setInt(1, theStudentID);
			inserimentoCorso.setInt(2, theCourseID);
			JOptionPane.showMessageDialog(null, "Iscrizione effettuata");
			inserimentoCorso.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showTableDataStudent(String idStudente, JTable table) {
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		Connessione connect = null;
		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();
			int id = Integer.parseInt(idStudente);
			PreparedStatement mostraCorsi;
			String mostraSql = "SELECT DISTINCT registrazione.corso_id, corso.nome "
					+ "FROM corso, registrazione, studente " + "WHERE corso.id = registrazione.corso_id "
					+ "AND registrazione.studente_id = " + id;

			mostraCorsi = conn.prepareStatement(mostraSql);
			ResultSet risultato = mostraCorsi.executeQuery();
			while (risultato.next()) {
				int idCorso = risultato.getInt(1);
				String nomeCorso = risultato.getString(2);
				registrationStudent.addRow(new Object[] { idCorso, nomeCorso });
			}
		} catch (NumberFormatException ec) {
			JOptionPane.showMessageDialog(null, "Inserire un formato corretto", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// da fare procedura show con function nel database al posto di confrontare con java
//	public void showTableDataStudent(String idStudente, JTable table) {
//		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
//		Connessione connect = null;
//		try {
//			connect = Connessione.getInstance();
//			Connection conn = connect.getConnection();
//			int id = Integer.parseInt(idStudente);
//			
//			CallableStatement mostraCorsi;
//			mostraCorsi = conn.prepareCall("{call show_table_student_course(?)}");
//			mostraCorsi.setInt(1, id);
//			ResultSet risultato = mostraCorsi.executeQuery();
//			while (risultato.next()) {
//				int idCorso = risultato.getInt(1);
//				System.out.println(idCorso);
//				String nomeCorso = risultato.getString(2);
//				System.out.println(nomeCorso);
//				registrationStudent.addRow(new Object[] { idCorso, nomeCorso });
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public void addTableDataStudentToTableView(JTable table, String nomeCorso, String codiceCorso) {
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		registrationStudent.addRow(new Object[] { nomeCorso, codiceCorso });
	}

	public void registraAdmin(String username, String password) {
		try {
			admin.registrationAdmin(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAdminExists(String username, String password, boolean exist) {
		try {
			if (admin.loginAdmin(username, password, exist)) {
				exist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;

	}

	public void removeTableDataStudent(JTable table, String id, String idStudente) {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			CallableStatement rimuoviCorsoRegistrato;

			int idCorso = Integer.parseInt(id);
			int idStudent = Integer.parseInt(idStudente);
			rimuoviCorsoRegistrato = conn.prepareCall("{call delete_registered_course(?,?)}");
			rimuoviCorsoRegistrato.setInt(1, idCorso);
			rimuoviCorsoRegistrato.setInt(1, idStudent);
			rimuoviCorsoRegistrato.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		registrationStudent.removeRow(row);
	}

	public void showStudentEnrolledTable(String idCorso, String data_lezione, String idLezione, JTable table) {
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

	public void updateAttendanceStudents(String idCorso, String idStudente, String idLezione, String presenza,
			JTable table) {
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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showDetailLesson(String idCorso, JTextField numeroLezioni, JTextField presenzeObbligatorie) {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			int id = Integer.parseInt(idCorso);
			PreparedStatement insert = null;
			String mostraDettagli = "select numero_lezioni, presenze_obbligatorie from corso where corso.id = " + id;
			insert = conn.prepareStatement(mostraDettagli);

			ResultSet risultato = insert.executeQuery();
			while (risultato.next()) {
				int numLezioni = risultato.getInt(1);
				String lezioni = Integer.toString(numLezioni);
				numeroLezioni.setText(lezioni);

				int numPresenzeObbligatorie = risultato.getInt(2);
				String presenze = Integer.toString(numPresenzeObbligatorie);
				presenzeObbligatorie.setText(presenze);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertLesson(String dataInizio, String idCorso, String titolo, String descrizione, String durata,
			String oraInizio) {

		try {
			if (dataInizio.isBlank() || idCorso.isBlank() || titolo.isBlank() || durata.isBlank()
					|| oraInizio.isBlank()) {
				JOptionPane.showMessageDialog(null, "Completa prima tutti i campi!", "Attenzione",
						JOptionPane.WARNING_MESSAGE);
			} else {
				lesson.insertLesson(dataInizio, idCorso, titolo, descrizione, durata, oraInizio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkNumberLesson(String corsoID, boolean value, String numero_lezioni) {
		int id = Integer.parseInt(corsoID);
		int lezioniTotali = Integer.parseInt(numero_lezioni);
		try {
			if (lesson.checkLessonsNumber(id, value, lezioniTotali)) {
				value = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public void showNumberOfLessons(JLabel label, String idCorso) {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			int id = Integer.parseInt(idCorso);
			PreparedStatement show;
			String mostraNumeroLezioni = "select count(lezione_id) from lezione where corso_id = " + id;
			show = con.prepareStatement(mostraNumeroLezioni);

			ResultSet risultato = show.executeQuery();
			while (risultato.next()) {
				label.setText("Lezioni presenti : " + risultato.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertThematicArea(String areaTematica) {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();
			course.creaAreaTematica(areaTematica);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void mostraAreeComboBox(JComboBox comboBox) {
		try {
			ArrayList<AreeTematiche> aree = course.mostraAreeTematiche();
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (AreeTematiche a : aree) {
				String nomeArea = a.getNome();
				modelComboBox.addElement(nomeArea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getDataInizioCorso(String id, JTextField dataInizio) {
		Connessione connessione = null;
		try {
		connessione = Connessione.getInstance();
		Connection con = connessione.getConnection();
		
		PreparedStatement mostraData;
		int idCorso = Integer.parseInt(id);

			System.out.println("Mostrando data inizio... ");

			mostraData = con.prepareStatement("SELECT  data_inizio FROM corso where corso.id = " + idCorso);
			ResultSet risultato = mostraData.executeQuery();
			
			while (risultato.next()) {
				dataInizio.setText(risultato.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void isAvaiableUsername(String username, JTextField user, JLabel message) {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();
			
			admin.isUsernameAvaiable(username, user, message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
