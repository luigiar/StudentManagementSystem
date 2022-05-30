package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.AreaTematicaDAO;
import Entità.AreeTematiche;
import dbSettings.Connessione;

public class AreaTematicaDAOImpl implements AreaTematicaDAO {

	Connection conn = null;
	PreparedStatement inserisciAreaStm, aggiornaArea, mostraAree;

	@Override
	public void aggiornaArea(String areaTematica, int id) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		String updateSql = "UPDATE corso SET aree_tematiche = ? where corso.id = " + id;

		try {

			aggiornaArea = conn.prepareStatement(updateSql);
			System.out.println("Aggiornamento area tematica...");
			aggiornaArea.setString(1, areaTematica);

			aggiornaArea.executeUpdate();
			System.out.println("Area aggiornata correttamente");
			aggiornaArea.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (aggiornaArea != null)
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
	public void creaAreaTematica(String areaTematica) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		System.out.println("connessione insertArea corso eseguita");
		try {
			String inserimentoSql = "INSERT INTO aree_tematiche(nome_area) values (?)";

			inserisciAreaStm = conn.prepareStatement(inserimentoSql);
			System.out.println("inserendo area nella tabella");
			inserisciAreaStm.setString(1, areaTematica);
			inserisciAreaStm.executeUpdate();
			System.out.println("Area aggiunta correttamente");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (inserisciAreaStm != null)
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
	public ArrayList<AreeTematiche> mostraAreeTematiche() throws SQLException {
		ArrayList<AreeTematiche> aree = new ArrayList<AreeTematiche>();
		Connessione connection = Connessione.getInstance();
		Connection conn = connection.getConnection();

		try {
			System.out.println("Mostrando elementi comboBox aree... ");

			mostraAree = conn.prepareStatement("SELECT  nome_area FROM aree_tematiche");
			ResultSet risultato = mostraAree.executeQuery();

			while (risultato.next()) {
				AreeTematiche a = new AreeTematiche();
				a.setNome(risultato.getString(1));

				aree.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (mostraAree != null)
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

		return aree;
	}
}