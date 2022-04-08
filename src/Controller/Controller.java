package Controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.AdminDAO;
import DAO.CorsoDAO;
import DAO.StudenteDAO;
import Entità.Corso;
import Entità.Studente;
import Gui.CourseTableModel;
import Gui.LoginFrame;
import Gui.MainFrame;
import Gui.StudenteTableModel;
import dao_impl.AdminDAOImpl;
import dao_impl.CorsoDAOImpl;
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

// funzione che mostra numero di studenti totali presenti nel db
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
				label.setText("Studenti presenti : " +risultato.getInt(1));
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
				label.setText("Corsi presenti : " +risultato.getInt(1));
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

	public void insertCourse(String name, String description, String maxStudents, String themeArea) {
		course = new CorsoDAOImpl();
		try {
			course.inserisciCorso(name, description, maxStudents, themeArea);
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

	public void updateCourse(JTable table, String nome, String maxPartecipanti, String areaTematica,
			String descrizione) {
		try {
			int rigaSelected = table.getSelectedRow();
			int theID = (int) model.getValueAt(rigaSelected, 0);
			course.aggiornaCorso(theID, nome, maxPartecipanti, areaTematica, descrizione);

			model.setValueAt(nome, rigaSelected, 1);
			model.setValueAt(maxPartecipanti, rigaSelected, 2);
			model.setValueAt(areaTematica, rigaSelected, 3);
			model.setValueAt(descrizione, rigaSelected, 4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void refreshTableCourse(JTable table) {
		table.setModel(model);
	}

	public void refreshTableStudent(JTable table) {
		table.setModel(modelStud);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

// da fare procedura show con function nel database
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

	public void removeTableDataStudent(JTable table, String id) {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			CallableStatement rimuoviCorsoRegistrato;

			int idCorso = Integer.parseInt(id);
			rimuoviCorsoRegistrato = conn.prepareCall("{call delete_registered_course(?)}");
			rimuoviCorsoRegistrato.setInt(1, idCorso);
			rimuoviCorsoRegistrato.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel registrationStudent = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		registrationStudent.removeRow(row);
	}
	
	
}
