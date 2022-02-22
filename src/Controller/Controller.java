package Controller;

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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.CorsoDAO;
import DAO.StudenteDAO;
import Entità.Corso;
import Entità.Studente;
import Gui.CourseTableModel;
import Gui.LoginFrame;
import Gui.MainFrame;
import Gui.StudenteTableModel;
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

	public void mostraCorsiComboBox(JComboBox comboBox, JTextField id, JTextField nome) {
		try {
			ArrayList<Corso> corsi = course.displayCorsiComboBox();
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (Corso c : corsi) {
				Integer codice = c.getCodiceCorso();
				String idCorso = String.valueOf(codice);
				String nomeCorso = c.getNome();
				modelComboBox.addElement(codice + " " + nomeCorso);
				if(comboBox.getSelectedItem() != null) {
				id.setText(idCorso);
				nome.setText(nomeCorso);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void addCourseToStudent(JComboBox comboBox,JTextField id) {
//		DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
//		Connessione connect = null;
//		try {
//			connect = Connessione.getInstance();
//
//			Connection conn = connect.getConnection();
//
//			PreparedStatement inserimentoCorso;
//
//			String inserimento = "INSERT INTO registrazione (studente_id, corso_id, nome_corso) VALUES (?, ?, ?)";
//			
//			int idStudent = Integer.parseInt(id.getText());
//
//			inserimentoCorso = conn.prepareStatement(inserimento);
//			inserimentoCorso.setInt(1, idStudent);
//			inserimentoCorso.setString(2, comboBox.getSelectedItem().toString());
//			inserimentoCorso.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
	
}
