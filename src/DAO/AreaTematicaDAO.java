package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entità.AreeTematiche;

public interface AreaTematicaDAO {
	
	public void aggiornaArea(String areaTematica, int id) throws SQLException;
	
	public void creaAreaTematica(String areaTematica) throws SQLException;
	
	public ArrayList<AreeTematiche> mostraAreeTematiche() throws SQLException;

}
