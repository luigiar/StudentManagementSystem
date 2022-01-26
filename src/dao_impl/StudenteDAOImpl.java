package dao_impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.StudenteDAO;
import Entità.Studente;


public class StudenteDAOImpl implements StudenteDAO {

	private Connection connection;
	private PreparedStatement inserisciStudenteP,tabellaStudente;


	public void StudenteDAOImp(Connection connection) throws SQLException {
		this.connection = connection;
		inserisciStudenteP = connection.prepareStatement("INSERT INTO studente VALUES (?, nextval(?))");
	}
//	private void createTableStudente() {
//		try {
//			String sqlC =
//					"Create Table studente" +
//							"(id BIGSERIAL CONSTRAINT v PRIMARY KEY," +
//							"nome VARCHAR(15)," +
//							"cognome VARCHAR(15)" +
//							"dataNascita DATE," +
//							"genere VARCHAR(15)";
//
//			tabellaStudente.executeUpdate(sqlC);
//		} catch (SQLException e) {
//			System.out.println("non posso creare tabella studente");
//			e.printStackTrace();
//			System.exit(1);
//		}
//
//	}

	@Override
	public void inserisciStudente(Studente studente) throws SQLException {
		inserisciStudenteP.setString(2, studente.getNome());
		inserisciStudenteP.setString(3, studente.getCognome());
		inserisciStudenteP.setString(4, studente.getDataNascita());
		inserisciStudenteP.setString(5, studente.getGenere());
	}

	public void aggiornaStudente(Studente s) throws SQLException {

	}

	public void eliminaStudente(Studente studente) throws SQLException {

	}

	private ArrayList<Studente> leggiStudenti() {
		return null;

	}

}
