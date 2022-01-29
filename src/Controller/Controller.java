package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import DAO.StudenteDAO;
import Entità.Studente;
import Gui.LoginFrame;
import Gui.MainFrame;
import dao_impl.StudenteDAOImpl;
import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {
	//Riferimenti al Login e Main Frame
	LoginFrame lf;
	MainFrame hm;


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
	
	

	public Controller() {
		lf = new LoginFrame(this);
		hm = new MainFrame(this);
		lf.setVisible(true);
	}
	
	

}
