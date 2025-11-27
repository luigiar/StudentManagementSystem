package dbSettings;

import java.sql.*;

import org.postgresql.util.PSQLException;

public class Connessione {
	private static Connessione instance; // 1.dichiarazione di una var di tipo della classe stessa, statico e privato
	private Connection connection = null;
	private String username = "miousername";
	private String password = "miapassord";
	private String ip = "localhost";
	private String port = "miaporta";
	private String url = "jdbc:postgresql://" + ip + ":" + port + "/postgres";

	private Connessione() throws SQLException {
		// Carica il drive ed ottiene una connessione dal db 
		try {
			Class.forName("org.postgresql.Driver");
			
			String url1 = "jdbc:postgresql://" + ip + ":" + port + "/db_project";
			connection = DriverManager.getConnection(url1, username, password);
			System.out.println("Connessione Effettuata db_project");

		} catch (ClassNotFoundException e) {
			System.out.println("Connessione del Database fallita, errore ");
		} catch (PSQLException ex) {
			System.out.println("Database non esiste");
			// connessione al db default
			connection = DriverManager.getConnection(url, username, password);
			DBBuilder db = new DBBuilder();
			db.creationDatabase(connection);

			String url1 = "jdbc:postgresql://" + ip + ":" + port + "/test";
			connection = DriverManager.getConnection(url1, username, password);
			System.out.println("Connessione Effettuata db_project");

		}
	}

	// restituita l'istanza si può fare la return della connection
	public Connection getConnection() { // 2. costruttore che non accetta parametri e privato
		return connection;
	}

	public static Connessione getInstance() throws SQLException { // 3. definire metodo principale getInstance, statico
																	// e ritorna oggetto tipo intance
		if (instance == null) {
			// creazione oggetto Connessione, se non esiste
			instance = new Connessione();
		} else
		// se esiste verifica se è stata chiusa
		if (instance.getConnection().isClosed()) {
			// se lo è, se ne può creare un'altra
			instance = new Connessione();
		}
		return instance;
	}

}
