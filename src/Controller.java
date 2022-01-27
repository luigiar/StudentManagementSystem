import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {

	public static void main(String[] args) {
		Controller c = new Controller();

		// CREAZIONE DEL DATABASE E CONNESSIONE
		Connessione connessioneDB = null;
		Connection conn = null;
		DBBuilder builder = null;

		try {
			connessioneDB = Connessione.getInstance();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		conn = connessioneDB.getConnection();

	}

}
