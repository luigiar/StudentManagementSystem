package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LezioneDAO;
import Entità.Lezione;
import dbSettings.Connessione;

public class LezioneDAOImpl implements LezioneDAO {
	PreparedStatement mostraLezioni;
	@Override
	public ArrayList<Lezione> displayLezioniComboBox() throws SQLException {
		ArrayList<Lezione> lezioni = new ArrayList<Lezione>();
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();
		
	
		String mostraSql = "SELECT numero_lezione, data_inizio FROM lezione";
		mostraLezioni = conn.prepareStatement(mostraSql);
		ResultSet risultato = mostraLezioni.executeQuery(mostraSql);
		while(risultato.next()) {
			
		Lezione lezione = new Lezione();
		lezione.setDataInizio(risultato.getString(1));
	     //scegliere cosa mostrare nella combo box
		//lezione.setNumeroLezione(risultato.getInt(2);
			
			lezioni.add(lezione);
		}
		
		
		return lezioni;
		
	}

}
