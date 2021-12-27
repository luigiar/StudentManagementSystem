package ConnectionDB;
import java.sql.*;

public class Connessione {

	public static void main(String[] args) {
	
	try	{
		// caricamento driver
		
		Class.forName("org.postgresql.Driver");
		
		// creazione del url 
		
		String url = "jdbc:postgresql://localhost:5432/esempio";
		
		// creazione oggetto connection(url,nome db,password)
		
		Connection conn = DriverManager.getConnection(url,"postgres","fasterbunny");
		
		System.out.println("Connessione al DB . . . \n");
		
		System.out.println("Connesso al database!");
		
		Statement st = conn.createStatement();
		
		System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %n", "matricola", "email", "nome", "cognome");
		ResultSet resultSet = st.executeQuery("SELECT * FROM studente");
	
		while(resultSet.next()) {
		System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %n",resultSet.getString("matricola"), resultSet.getString("email"), resultSet.getString("nome"), resultSet.getString("cognome"));
		}
		conn.close();
	}		
	catch (ClassNotFoundException e) {
		System.out.println("Driver non trovati");
		System.out.println(e);
	}
	
	catch (SQLException e) {
		System.out.println("Connessione fallita\n");
		System.out.println(e);
	}

	
		
		
		
		
		
		
	}
}
