package dao_impl;

import java.awt.SystemColor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.CorsoDAO;
import Entità.AreeTematiche;
import Entità.Corso;
import Gui.CourseTableModel;
import dbSettings.Connessione;

public class CorsoDAOImpl implements CorsoDAO {

	Connection conn = null;
	PreparedStatement inserisciCorsoStm, aggiornaCorsoStm, aggiornaDettagliCorsoStm, inserisciAreaStm, mostraAree,
			aggiornaArea, mostraData;
	Statement deleteCourseST = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void inserisciCorso(String nome, String descrizione, String massimoPartecipanti, String areaTematica,
			String data_inizio) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		System.out.println("connessione insert corso eseguita");
		try {
			String inserimentoSql = "INSERT INTO corso(nome,descrizione,max_partecipanti,aree_tematiche,data_inizio) VALUES (?, ?, ? ,?, ?)";
			// conversione valori
			int numeroMaxPartecipanti = Integer.parseInt(massimoPartecipanti);
			Date date = simpleDateFormat.parse(data_inizio);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());

			inserisciCorsoStm = conn.prepareStatement(inserimentoSql);
			System.out.println("inserendo corsi nella tabella");
			inserisciCorsoStm.setString(1, nome);
			inserisciCorsoStm.setString(2, descrizione);
			inserisciCorsoStm.setInt(3, numeroMaxPartecipanti);
			inserisciCorsoStm.setString(4, areaTematica);
			inserisciCorsoStm.setDate(5, dataSQL);
			inserisciCorsoStm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Inserimento effettuato", "Conferma", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Corsi Inseriti correttamente");

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Formato inserito non corretto", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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

			String selezionaCorsiSql = "SELECT id, nome, descrizione, max_partecipanti, aree_tematiche FROM corso order by id";
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
	public boolean aggiornaCorso(boolean isUpdated, int id, String nome, String maxPartecipanti, String descrizione,
			String dataInizio) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		String updateSql = "UPDATE corso SET nome = ?, max_partecipanti = ?, descrizione = ?, data_inizio = ? WHERE id = "
				+ id;

		try {
			int numeroPartecipantiMax = Integer.parseInt(maxPartecipanti);
			Date date = simpleDateFormat.parse(dataInizio);
			java.sql.Date dataSQL = new java.sql.Date(date.getTime());

			aggiornaCorsoStm = conn.prepareStatement(updateSql);
			System.out.println("Aggiornamento corso...");
			aggiornaCorsoStm.setString(1, nome);
			aggiornaCorsoStm.setInt(2, numeroPartecipantiMax);
			aggiornaCorsoStm.setString(3, descrizione);
			aggiornaCorsoStm.setDate(4, dataSQL);
			aggiornaCorsoStm.executeUpdate();

			SQLWarning warning = aggiornaCorsoStm.getWarnings();

			if (warning != null) {
				String errore = warning.toString();
				errore = errore.substring(errore.lastIndexOf(": ") + 1).strip();
				JOptionPane.showMessageDialog(null, errore, "Attenzione", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Aggiornamento Effettuato", "Conferma",
						JOptionPane.INFORMATION_MESSAGE);
				isUpdated = true;
			}
			return isUpdated;

		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Formato inserito non corretto", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// blocco per chiudere risorse
			try {
				if (aggiornaCorsoStm != null)
					conn.close();
				System.out.println("connessione chiusa correttamente");
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
		return isUpdated;
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

			String selezionaCorsiSql = "SELECT id, nome FROM corso order by id";
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
			JOptionPane.showMessageDialog(null, "Aggiornamento effettuato", "Conferma",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Formato inserito non corretto!", "Attenzione", JOptionPane.WARNING_MESSAGE);
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

	@Override
	public void mostraDettagliCorsi(JTable table) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		CallableStatement mostraDettagli;

		mostraDettagli = conn.prepareCall("{call get_details_course}");

		System.out.println("calcolando dettagli corsi...");
		ResultSet result = mostraDettagli.executeQuery();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		while (result.next()) {
			int id = result.getInt("id_corso");
			String nome = result.getString("nome_corso");
			int max_presenze = result.getInt("massimo_presenze");
			int min_presenze = result.getInt("minimo_presenze");
			float media_presenze = result.getFloat("media_presenze");
			String data = result.getString("data_lezione");

			model.addRow(new Object[] { id, nome, max_presenze, min_presenze, media_presenze, data });
		}

	}

	@Override
	public void getDataInizioCorso(String id, JTextField dataInizio) throws SQLException {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			PreparedStatement mostraData;
			int idCorso = Integer.parseInt(id);

			System.out.println("Mostrando data inizio... ");

			mostraData = con.prepareStatement("SELECT  data_inizio FROM corso where corso.id = " + idCorso);
			ResultSet risultato = mostraData.executeQuery();

			while (risultato.next()) {
				dataInizio.setText(risultato.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void showTotalCourseNumber(JLabel label) throws SQLException {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			PreparedStatement show;
			String mostraCorsi = "select count(*) from corso";
			show = con.prepareStatement(mostraCorsi);

			ResultSet risultato = show.executeQuery();
			while (risultato.next()) {
				label.setText("Corsi presenti : " + risultato.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void showNumberOfStudentEnrolled(JLabel label,String idCorso) throws SQLException {
		Connessione connessione = null;
		try {
			connessione = Connessione.getInstance();
			Connection con = connessione.getConnection();

			int id = Integer.parseInt(idCorso);
			PreparedStatement show;
			String mostraNumeroStudenti = "select count(studente_id) from registrazione where corso_id = " + id;
			show = con.prepareStatement(mostraNumeroStudenti);

			ResultSet risultato = show.executeQuery();
			while (risultato.next()) {
				label.setForeground(SystemColor.textHighlight);
				label.setText("Studenti iscritti : " + risultato.getInt(1));
				System.out.println("mostrando numero iscrizioni...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}