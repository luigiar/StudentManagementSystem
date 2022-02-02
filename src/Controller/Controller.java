package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DAO.StudenteDAO;
import Entità.Studente;
import Gui.LoginFrame;
import Gui.MainFrame;
import dao_impl.StudenteDAOImpl;
import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {
	// Riferimenti al Login e Main Frame
	LoginFrame lf;
	MainFrame hm;
	StudenteDAO student = new StudenteDAOImpl();
	JTable table = new JTable();

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

	public void displayStudent(JTable table) throws SQLException {
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

	}

	public void addStudentToTableView(JTable table, JTextField nome, JTextField cognome, JTextField data,
			ButtonGroup genere) throws SQLException {
		int id = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] colonne = { "ID", "Nome", "Cognome", "Data Nascita", "Genere" };
		model.setColumnIdentifiers(colonne);
		Object[] riga = new Object[5];

		riga[0] = student.getLastID(id);
		riga[1] = nome.getText();
		riga[2] = cognome.getText();
		riga[3] = data.getText();
		riga[4] = genere.getSelection().getActionCommand();

		model.addRow(riga);

	}

}
