package dao_impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.StudenteDAO;
import Entità.Studente;

public class StudenteDAOPostgresImpl implements StudenteDAO {
	
	
	private Connection connection;
	private PreparedStatement inserisciStudenteP;
	
	
	public void StudenteDAOPostgresImp(Connection connection) throws SQLException {
			this.connection = connection;
			inserisciStudenteP = connection.prepareStatement("INSERT INTO studente VALUES (?, nextval(?))");
	
	}


	@Override
	public void inserisciStudente(Studente studente) throws SQLException {
		inserisciStudenteP.setString(0, studente.getId());
		inserisciStudenteP.setString(1, studente.getNome());
		inserisciStudenteP.setString(2, studente.getCognome());
		inserisciStudenteP.setString(3, studente.getDataNascita());
		inserisciStudenteP.setString(4, studente.getGenere());
	}
}
