import java.sql.Connection;
import java.sql.SQLException;

import dbSettings.Connessione;

public class Controller {

	public static void main(String[] args) {

		// CREAZIONE DEL DATABASE E CONNESSIONE
		Connessione connessioneDB = null;
		Connection connection = null;
		
		try {
			connessioneDB = Connessione.getInstance();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		connection = connessioneDB.getConnection();
		
		
	}
	
	
}
