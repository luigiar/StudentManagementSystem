package dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.AdminDAO;
import dbSettings.Connessione;

public class AdminDAOImpl implements AdminDAO {
	Connection conn = null;
	private PreparedStatement inserisciAdmin;

	@Override
	public void registrationAdmin(String username, String password) throws SQLException {
		Connessione connect = Connessione.getInstance();
		conn = connect.getConnection();

		String inserimentoSql = "INSERT INTO admin(username, password) VALUES (?,?)";

		inserisciAdmin = conn.prepareStatement(inserimentoSql);
		inserisciAdmin.setString(1, username);
		inserisciAdmin.setString(2, password);
		inserisciAdmin.executeUpdate();
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

}
