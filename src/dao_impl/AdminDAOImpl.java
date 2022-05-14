package dao_impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

import javax.swing.JOptionPane;

import DAO.AdminDAO;
import dbSettings.Connessione;

public class AdminDAOImpl implements AdminDAO {
	Connection conn = null;
	private PreparedStatement inserisciAdmin;
	boolean login = false;

	@Override
	public void registrationAdmin(String username, String password) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		String inserimentoSql = "INSERT INTO amministratore(username, password) VALUES (?,?)";

		inserisciAdmin = conn.prepareStatement(inserimentoSql);
		inserisciAdmin.setString(1, username);
		inserisciAdmin.setString(2, password);
		inserisciAdmin.executeUpdate();
		
		SQLWarning warning = inserisciAdmin.getWarnings();

		if (warning != null) {
			String errore = warning.toString();
			errore = errore.substring(errore.lastIndexOf(": ") + 1).strip();
			JOptionPane.showMessageDialog(null, errore, "Attenzione", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Registrazione effettuata!", "Conferma",
					JOptionPane.INFORMATION_MESSAGE);
		}
		// blocco per chiudere risorse
		try {
			if (inserisciAdmin != null)
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

	@Override
	public boolean loginAdmin(String username, String password, boolean value) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();
		
		CallableStatement myStatement = null;
		ResultSet result = null;
		
		myStatement = conn.prepareCall("{call check_login(?, ?)}");
		myStatement.setString(1,username);
		myStatement.setString(2, password);
		
		result = myStatement.executeQuery();
		while(result.next()) {
			 value = result.getBoolean(1);
		}

		return value;

	}
	
	

}
