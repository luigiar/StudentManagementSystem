package dao_impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.LezioneDAO;
import Entità.Lezione;
import Gui.GestisciLezioneJDialog;
import dbSettings.Connessione;

public class LezioneDAOImpl implements LezioneDAO {
	PreparedStatement mostraLezioni, inserisciLezione, mostraDettagliLezione, updateDettagliLezione;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

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
			java.sql.Time timeDurata = new java.sql.Time(sdf.parse(durata).getTime());
			java.sql.Time timeValue = new java.sql.Time(sdf.parse(oraInizio).getTime());

			inserisciLezione = conn.prepareStatement(sqlInsert);
			inserisciLezione.setDate(1, (java.sql.Date) dataSQL);
			inserisciLezione.setInt(2, id);
			inserisciLezione.setString(3, titolo);
			inserisciLezione.setString(4, descrizione);
			inserisciLezione.setTime(5, timeDurata);
			inserisciLezione.setTime(6, timeValue);
			inserisciLezione.executeUpdate();

			SQLWarning warning = inserisciLezione.getWarnings();

			if (warning != null) {
				String errore = warning.toString();
				errore = errore.substring(errore.lastIndexOf(": ") + 1).strip();
				JOptionPane.showMessageDialog(null, errore, "Attenzione", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Lezione aggiunta correttamente", "Conferma",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (DateTimeParseException exceptionTime) {
			JOptionPane.showMessageDialog(null, "Inserisci un formato corretto per l'ora", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException exceptionDurata) {
			JOptionPane.showMessageDialog(null, "Durata della lezione inserita non corretta", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkLessonsNumber(int corsoID, boolean value, int numeroLezioni) throws SQLException {
		Connessione connect = Connessione.getInstance();
		Connection conn = connect.getConnection();

		CallableStatement myStatement = null;
		ResultSet result = null;

		myStatement = conn.prepareCall("{call check_number_lesson(?,?)}");
		myStatement.setInt(1, corsoID);
		myStatement.setInt(2, numeroLezioni);

		result = myStatement.executeQuery();
		while (result.next()) {
			value = result.getBoolean(1);
		}

		return value;

	}

	@Override
	public ArrayList<Lezione> showElementsLesson(int lezioneID) throws SQLException {
		Connessione connect = Connessione.getInstance();
		Connection conn = connect.getConnection();
		ArrayList<Lezione> lezioni = new ArrayList<Lezione>();

		String mostraSql = "select titolo, descrizione, durata, ora_inizio from lezione where lezione_id = "
				+ lezioneID;
		mostraDettagliLezione = conn.prepareStatement(mostraSql);

		ResultSet risultato = mostraDettagliLezione.executeQuery();
		while (risultato.next()) {
			Lezione lezione = new Lezione();
			lezione.setTitolo(risultato.getString(1));
			lezione.setDescrizione(risultato.getString(2));
			Time durataTime = risultato.getTime(3);
			String durata = String.valueOf(durataTime);
			lezione.setDurata(durata);
			Time timeOraInizio = risultato.getTime(4);
			String oraInizio = String.valueOf(timeOraInizio);
			lezione.setOraInizio(oraInizio);
			lezioni.add(lezione);
		}
		return lezioni;
	}

	@Override
	public void updateElemetsLesson(int lezioneID, String titolo, String descrizione, String durata, String oraInizio)
			throws SQLException {
		Connessione connect = Connessione.getInstance();
		Connection conn = connect.getConnection();

		String aggiornaSql = "update lezione set titolo = ?, descrizione = ?, durata = ?, ora_inizio = ? where lezione_id = "
				+ lezioneID;

		try {
			java.sql.Time timeDurata = new java.sql.Time(sdf.parse(durata).getTime());
			java.sql.Time timeValue = new java.sql.Time(sdf.parse(oraInizio).getTime());

			updateDettagliLezione = conn.prepareStatement(aggiornaSql);
			updateDettagliLezione.setString(1, titolo);
			updateDettagliLezione.setString(2, descrizione);
			updateDettagliLezione.setTime(3, timeDurata);
			updateDettagliLezione.setTime(4, timeValue);
			System.out.println("aggiornando dettagli lezione...");
			updateDettagliLezione.executeUpdate();
			System.out.println("lezione aggiornata");

			JOptionPane.showMessageDialog(null, "Lezione aggiornata correttamente");
			
		} catch (DateTimeParseException exceptionTime) {
			JOptionPane.showMessageDialog(null, "Inserisci un formato corretto per l'ora", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException exceptionDurata) {
			JOptionPane.showMessageDialog(null, "Durata della lezione inserita non corretta", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(null, "Inserisci un formato corretto", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
