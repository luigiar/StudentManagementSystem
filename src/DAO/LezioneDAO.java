package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Entit�.Lezione;

public interface LezioneDAO {

	public ArrayList<Lezione> displayLezioniComboBox(int id) throws SQLException;


}
