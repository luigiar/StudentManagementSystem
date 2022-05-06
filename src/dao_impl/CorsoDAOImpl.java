package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.CorsoDAO;
import Entità.Corso;
import dbSettings.Connessione;

public class CorsoDAOImpl implements CorsoDAO {

	Connection conn = null;
	PreparedStatement inserisciCorsoStm, aggiornaCorsoStm, aggiornaDettagliCorsoStm;
	Statement deleteCourseST = null;

	@Override
	public void inserisciCorso(String nome, String descrizione, String massimoPartecipanti, String areaTematica)
			throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		System.out.println("connessione insert corso eseguita");
		try {
			String inserimentoSql = "INSERT INTO corso(nome,descrizione,max_partecipanti,aree_tematiche) VALUES (?, ?, ? ,?)";
			// conversione valori
			int numeroMaxPartecipanti = Integer.parseInt(massimoPartecipanti);

			inserisciCorsoStm = conn.prepareStatement(inserimentoSql);
			System.out.println("inserendo corsi nella tabella");
			inserisciCorsoStm.setString(1, nome);
			inserisciCorsoStm.setString(2, descrizione);
			inserisciCorsoStm.setInt(3, numeroMaxPartecipanti);
			inserisciCorsoStm.setString(4, areaTematica);
			inserisciCorsoStm.executeUpdate();
			System.out.println("Corsi Inseriti correttamente");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (inserisciCorsoStm != null)
					conn.close();
			} catch (SQLException se) {
				// non fa nulla
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<Corso> leggiCorsi() throws SQLException {
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		Statement mostraCorsi = null;

		try {
			System.out.println("Mostrando elementi tabella corsi... ");
			mostraCorsi = conn.createStatement();

			String selezionaCorsiSql = "SELECT id,nome,descrizione,max_partecipanti,aree_tematiche FROM corso";
			ResultSet risultato = mostraCorsi.executeQuery(selezionaCorsiSql);

			while (risultato.next()) {
				Corso c = new Corso();
				c.setCodiceCorso(risultato.getInt(1));
				c.setNome(risultato.getString(2));
				c.setDescrizione(risultato.getString(3));
				c.setMaxPartecipanti(risultato.getInt(4));
				c.setAreeTematiche(risultato.getString(5));
				corsi.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (mostraCorsi != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return corsi;
	}

	@Override
	public int getLastID(int id) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		Statement mostraID = null;
		try {
			mostraID = conn.createStatement();
			String mostraIDSql = "SELECT MAX(id) AS LastID FROM corso";
			ResultSet risultato = mostraID.executeQuery(mostraIDSql);
			while (risultato.next()) {
				id = risultato.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (mostraID != null)
				conn.close();
		} catch (SQLException se) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return id;
	}

	@Override
	public void eliminaCorso(int id) throws SQLException {

		Connessione connection = Connessione.getInstance();
		conn = connection.getConnection();
		System.out.println("connessione delete eseguita");

		try {
			String eliminazioneSql = "DELETE FROM corso WHERE id = " + id;

			System.out.println("eliminando corsi...");
			deleteCourseST = conn.createStatement();

			deleteCourseST.executeUpdate(eliminazioneSql);
			System.out.println("corso eliminato!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (inserisciCorsoStm != null)
					conn.close();
			} catch (SQLException se) {
				// non fa nulla
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	@Override
	public void aggiornaCorso(int id, String nome, String maxPartecipanti, String areeTematiche, String descrizione)
			throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		String updateSql = "UPDATE corso SET nome = ?, max_partecipanti = ?, aree_tematiche = ?, descrizione = ? WHERE id = "
				+ id;

		try {
			int numeroPartecipantiMax = Integer.parseInt(maxPartecipanti);
			aggiornaCorsoStm = conn.prepareStatement(updateSql);
			System.out.println("Aggiornamento corso...");
			aggiornaCorsoStm.setString(1, nome);
			aggiornaCorsoStm.setInt(2, numeroPartecipantiMax);
			aggiornaCorsoStm.setString(3, areeTematiche);
			aggiornaCorsoStm.setString(4, descrizione);

			aggiornaCorsoStm.executeUpdate();
			System.out.println("Corso aggiornato correttamente");
			aggiornaCorsoStm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (inserisciCorsoStm != null)
					conn.close();
			} catch (SQLException se) {
				// non fa nulla
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Corso> displayCorsiComboBox() throws SQLException {
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();

		Statement mostraCorsi = null;

		try {
			System.out.println("Mostrando elementi comboBox corsi... ");
			mostraCorsi = conn.createStatement();

			String selezionaCorsiSql = "SELECT id, nome FROM corso";
			ResultSet risultato = mostraCorsi.executeQuery(selezionaCorsiSql);

			while (risultato.next()) {
				Corso c = new Corso();
				c.setCodiceCorso(risultato.getInt(1));
				c.setNome(risultato.getString(2));

				corsi.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (mostraCorsi != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return corsi;
	}

	@Override
	public void aggiornaDettagliCorso(int numeroLezioni, int presenzeObbligatorie, int idCorso) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		try {
			String inserimentoDettagliSql = "update corso set numero_lezioni = ?, presenze_obbligatorie = ?"
					+ "where corso.id = " + idCorso;

			aggiornaDettagliCorsoStm = conn.prepareStatement(inserimentoDettagliSql);
			System.out.println("aggiornando tabella corso");
			aggiornaDettagliCorsoStm.setInt(1, numeroLezioni);
			aggiornaDettagliCorsoStm.setInt(2, presenzeObbligatorie);
			aggiornaDettagliCorsoStm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (aggiornaDettagliCorsoStm != null)
					conn.close();
			} catch (SQLException se) {
				// non fa nulla
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}
	}
}
