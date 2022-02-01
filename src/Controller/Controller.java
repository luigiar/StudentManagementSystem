package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.swing.table.DefaultTableModel;

import DAO.StudenteDAO;
import Entità.Studente;
import Gui.LoginFrame;
import Gui.MainFrame;
import Gui.PanelAggiungiStudente;
import dao_impl.StudenteDAOImpl;
import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {
	// Riferimenti al Login e Main Frame
	LoginFrame lf;
	MainFrame hm;
	StudenteDAO student = new StudenteDAOImpl();


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
	
	public void displayStudent() throws SQLException  {
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] riga = new Object[5];
		Object[] colonne = { "ID", "Nome", "Cognome", "Data Nascita", "Genere" };
		model.setColumnIdentifiers(colonne);
		ArrayList<Studente> studenti = student.leggiStudenti();

		for(int i = 0;i<studenti.size();i++) {
			riga[0] = studenti.get(i).getId(); 
			riga[1] = studenti.get(i).getNome();
			riga[2] = studenti.get(i).getCognome();
			riga[3] = studenti.get(i).getDataNascita();
			riga[4] = studenti.get(i).getGenere();
			
			model.addRow(riga);
		}
		
	}

}
