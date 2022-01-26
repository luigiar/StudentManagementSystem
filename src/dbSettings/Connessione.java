package dbSettings;
import java.sql.*;

public class Connessione {
	private static Connessione instance;
	private Connection connection = null;
	private String USERNAME = "postgres";
	private String PASSWORD = "fasterbunny";
	private String IP = "localhost";
	private String PORT = "5432";
	private String URL = "jdbc:postgresql://"+IP+":"+PORT+"/DBProject";

	private Connessione() throws SQLException {
		// Carica il drive ed ottiene una connessione
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connessione Effettuata ");
		} catch (ClassNotFoundException e) {
			System.out.println("Creazione del Database fallita");
		}

	}

	public Connection getConnection() { return connection; }

	public static Connessione getInstance() throws SQLException {
		if(instance == null) 
		{
			instance = new Connessione();
		}
		else
			if(instance.getConnection().isClosed())
			{
				instance = new Connessione();
			}
		return instance;
	}




}

