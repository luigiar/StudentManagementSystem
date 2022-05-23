package DAO;

import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public interface AdminDAO {

	public void registrationAdmin(String username, String password) throws SQLException;
	
	public boolean loginAdmin(String username, String password, boolean value) throws SQLException;
	
	public void isUsernameAvaiable(String username, JTextField user, JLabel message, JLabel messageAvaiable) throws SQLException;
}

