package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.LezioneDAO;
import Entità.Lezione;
import dbSettings.Connessione;

public class LezioneDAOImpl implements LezioneDAO {
	PreparedStatement mostraLezioni, inserisciLezione;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public ArrayList<Lezione> displayLezioniComboBox(int id) throws SQLException {
		ArrayList<Lezione> lezioni = new ArrayList<Lezione>();
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();

		try {
			mostraLezioni = conn.prepareStatement("SELECT lezione_id, data_inizio FROM lezione WHERE corso_id = " + id);
			ResultSet risultato = mostraLezioni.executeQuery();
			while (risultato.next()) {

				Lezione lezione = new Lezione();
				lezione.setCodiceLezione(risultato.getInt(1));
				lezione.setDataInizio(risultato.getString(2));

				lezioni.add(lezione);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lezioni;

	}

	@Override
	public void insertLesson(String dataInizio, String idCorso, String titolo, String descrizione, String durata,
			String oraInizio) throws SQLException {
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();

		try {
			String sqlInsert = "insert into lezione(data_inizio, corso_id, titolo, descrizione, durata, ora_inizio) values(?, ?, ?, ?, ?, ?)";

			Date date = simpleDateFormat.parse(dataInizio);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());
			int id = Integer.parseInt(idCorso);

			inserisciLezione = conn.prepareStatement(sqlInsert);
			inserisciLezione.setDate(1, (java.sql.Date) dataSQL);
			inserisciLezione.setInt(2, id);
			inserisciLezione.setString(3, titolo);
			inserisciLezione.setString(4, descrizione);
			inserisciLezione.setString(5, durata);
			inserisciLezione.setString(6, oraInizio);
			inserisciLezione.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
