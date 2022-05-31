package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;

import Entità.Studente;
import Gui.PanelAggiungiStudente;

import java.sql.*;
import dbSettings.Connessione;

public interface StudenteDAO {

	public void inserisciStudente(String nome, String cognome, String dataNascita, String genere) throws SQLException;

	public void eliminaStudente(int id) throws SQLException;

	public ArrayList<Studente> leggiStudenti() throws SQLException;

	public int getLastID(int id) throws SQLException;

	public void mostraStudentiIdonei(int idCorso, JTable table) throws SQLException;

	public void updateAttendanceStudents(String idCorso, String idStudente, String idLezione, String presenza,
			JTable table) throws SQLException;

	public void showStudentEnrolledTable(String idCorso, String data_lezione, String idLezione, JTable table)
			throws SQLException;
	
	public void deteleCourseEnrollment(JTable table, String id, String idStudente) throws SQLException;
	
	public void getStudentEnrolment(String idStudente, JTable table) throws SQLException;
	
	public void addCourseToStudent(JTable table, String idStudente, String idCorso, String nomeCorso) throws SQLException;
	
	public void showTotalStudentsNumber(JLabel label) throws SQLException;
	
}
