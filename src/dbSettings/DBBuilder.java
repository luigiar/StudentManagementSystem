package dbSettings;

import java.sql.Connection;

public class DBBuilder {

	private Connection connessione;
	
	public DBBuilder(Connection connessione) { this.connessione = connessione; }
	
	public DBBuilder() { connessione = null; }
	
	private boolean connessioneEsistente() { return !(connessione == null); }
	
	
	
	
	
}
