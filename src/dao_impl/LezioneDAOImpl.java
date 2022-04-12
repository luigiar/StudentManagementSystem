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
	public ArrayList<Lezione> displayLezioniComboBox(int id) throws SQLException {
		ArrayList<Lezione> lezioni = new ArrayList<Lezione>();
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();

		try {
			mostraLezioni = conn
					.prepareStatement("SELECT numero_lezione, data_inizio FROM lezione WHERE corso_id = " + id);
			ResultSet risultato = mostraLezioni.executeQuery();
			while (risultato.next()) {

				Lezione lezione = new Lezione();
				lezione.setNumeroLezione(risultato.getInt(1));
				lezione.setDataInizio(risultato.getString(2));

				lezioni.add(lezione);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lezioni;

	}

}
