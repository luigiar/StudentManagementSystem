package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entità.Lezione;

public interface LezioneDAO {

	public ArrayList<Lezione> displayLezioniComboBox() throws SQLException;


}
