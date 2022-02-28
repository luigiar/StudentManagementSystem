package DAO;

import java.sql.SQLException;

public interface AdminDAO {

	public void registrationAdmin(String username, String password) throws SQLException;
}
