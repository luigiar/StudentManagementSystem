package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.CorsoDAO;
import DAO.StudenteDAO;
import Entità.Corso;
import Entità.Studente;
import Gui.CourseTableModel;
import Gui.LoginFrame;
import Gui.MainFrame;
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
			ArrayList<Studente> studenti = student.leggiStudenti();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] colonne = { "ID", "Nome", "Cognome", "Data Nascita", "Genere" };
			model.setColumnIdentifiers(colonne);
			Object[] riga;
			for (int i = 0; i < studenti.size(); i++) {
				riga = new Object[5];
				riga[0] = studenti.get(i).getId();
				riga[1] = studenti.get(i).getNome();
				riga[2] = studenti.get(i).getCognome();
				riga[3] = studenti.get(i).getDataNascita();
				riga[4] = studenti.get(i).getGenere();
				model.addRow(riga);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addStudentToTableView(JTable table, JTextField nome, JTextField cognome, JDateChooser data,
			ButtonGroup genere) {
		int id = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] riga = new Object[5];
		String date = ((JTextField)data.getDateEditor().getUiComponent()).getText();

		try {
			riga[0] = student.getLastID(id);
			riga[1] = nome.getText();
			riga[2] = cognome.getText();
			riga[3] = date;
			riga[4] = genere.getSelection().getActionCommand();

			model.addRow(riga);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	public void addCourseToTableView(JTable table,JTextField nome, JTextField maxPartecipanti, JComboBox areaTematica,
			JTextArea descrizione) {
		try {
			table.setModel(model);
			int id = 0;
			id = course.getLastID(id);
			int maxPart = Integer.parseInt(maxPartecipanti.getText());
			Corso c = new Corso(id,nome.getText(),descrizione.getText(),maxPart,areaTematica.getSelectedItem().toString());
			model.add(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(JTable table) {
		int row = table.getSelectedRow();
		String deleteCell = table.getValueAt(row, 0).toString();
		int theID = Integer.parseInt(deleteCell);
		System.out.println(theID);
		try {
			course.eliminaCorso(theID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCourse(JTable table, String nome, String descrizione, String maxPartecipanti,String areaTematica) {
		CourseTableModel model = (CourseTableModel) table.getModel();
		try {
			int rigaSelected = table.getSelectedRow();
			int theID = (int) model.getValueAt(rigaSelected, 0);
			System.out.println(theID);
			course.aggiornaCorso(theID, nome, descrizione, maxPartecipanti, areaTematica);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
