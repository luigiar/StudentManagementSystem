package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.AdminDAO;
import DAO.AreaTematicaDAO;
import DAO.CorsoDAO;
import DAO.LezioneDAO;
import DAO.StudenteDAO;
import Entità.AreeTematiche;
import Entità.Corso;
import Entità.Lezione;
import Entità.Studente;
import Gui.CourseTableModel;
import Gui.LoginFrame;
import Gui.MainFrame;
import Gui.StudenteTableModel;
import dao_impl.AdminDAOImpl;
import dao_impl.AreaTematicaDAOImpl;
import dao_impl.CorsoDAOImpl;
import dao_impl.LezioneDAOImpl;
import dao_impl.StudenteDAOImpl;
import dbSettings.Connessione;
import dbSettings.DBBuilder;

public class Controller {

	private LoginFrame loginFrame;
	private MainFrame mainFrame;
	private StudenteDAO student = new StudenteDAOImpl();
	private CorsoDAO course = new CorsoDAOImpl();
	private AdminDAO admin = new AdminDAOImpl();
	private LezioneDAO lesson = new LezioneDAOImpl();
	private AreaTematicaDAO area = new AreaTematicaDAOImpl();
	private CourseTableModel modelCourse;
	private StudenteTableModel modelStudent;

	public static void main(String[] args) {

		// CREAZIONE DEL DATABASE E CONNESSIONE
		Connessione connessioneDB = null;
		Connection conn = null;
		DBBuilder builder = null;

		try {
			connessioneDB = Connessione.getInstance();
			conn = connessioneDB.getConnection();
			builder = new DBBuilder(conn);
		} catch (SQLException e) {

			e.printStackTrace();
		}
				
		
		// Creazione delle sequence
		builder.sequenceStudente(conn);
		builder.sequenceCorso(conn);
		builder.sequenceAdmin(conn);
		builder.sequenceAreeTematiche(conn);
		builder.sequenceLezioneID(conn);
		builder.sequencePartecipazioneCorsoID(conn);
		builder.sequencePartecipazioneLezioneID(conn);
		builder.sequencePartecipazioneStudenteID(conn);
		builder.sequenceLezioneCorsoID(conn);
		builder.sequenceRegistrazioneCorsoID(conn);
		builder.sequenceRegistrazioneID(conn);
		builder.sequenceRegistrazioneStudenteID(conn);
		
		//Creazione delle classi
		builder.tableStudente(conn);
		builder.tableCorso(conn);
		builder.tableAmministratore(conn);
		builder.tableLezione(conn);
		builder.tableAreeTematiche(conn);
		builder.tableAttendance(conn);
		builder.tableRegistrazione(conn);
		
		//Creazione trigger
		builder.triggerAfterLezioneInsert(conn);
		builder.triggerAfterRegistrazioneInsert(conn);
		builder.triggerBeforeAdminRegister(conn);
		builder.triggerBeforeIscrizioneStudente(conn);
		builder.triggerBeforeLezioneInsert(conn);
		builder.triggerBeforeUpdateDateCourse(conn);
		builder.triggerBeforeUpdateMaxPArtecipanti(conn);
		builder.triggerCheckDateFirstLesson(conn);
		builder.triggerDeleteRegistration(conn);
		
		//Creazione funzioni
		builder.functionCheckLogin(conn);
		builder.functionCheckNumberLesson(conn);
		builder.functionDeleteRegisteredCourse(conn);
		builder.functionGetDataTable(conn);
		builder.functionGetDetailsCourse(conn);
		builder.functionGetStudentiIdonei(conn);
		builder.functionInsertRegistration(conn);
		builder.functionShowTableStudentCourse(conn);
		builder.functionUpdatePresence(conn);
		
		
		// Start Controller
		Controller c = new Controller();


	}
		
	// launcher finestre
	public Controller() {
		loginFrame = new LoginFrame(this);
		loginFrame.setVisible(true);

	}

	public void showTotalStudentsNumber(JLabel label) {
		try {
			student.showTotalStudentsNumber(label);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showTotalCourseNumber(JLabel label) {
		try {
			course.showTotalCourseNumber(label);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertStudent(String name, String surname, String date, String genere) {
		student = new StudenteDAOImpl();
		try {
			student.inserisciStudente(name, surname, date, genere);
			JOptionPane.showMessageDialog(null, "Inserimento effettuato", "Conferma", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayStudent(JTable table) {
		try {
			modelStudent = new StudenteTableModel(student.leggiStudenti());
			table.setModel(modelStudent);
			TableRowSorter myTableRowSorter = new TableRowSorter(modelStudent);
			table.setRowSorter(myTableRowSorter);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudentToTableView(JTable table, JTextField nome, JTextField cognome, JTextFieldDateEditor data,
			ButtonGroup genere) {
		try {
			table.setModel(modelStudent);
			int id = 0;
			id = student.getLastID(id);
			Studente s = new Studente(id, nome.getText(), cognome.getText(), data.getText().toString(),
					genere.getSelection().getActionCommand());
			modelStudent.add(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteStudent(JTable table) {
		int row = table.convertRowIndexToModel(table.getSelectedRow());
		String deleteCell = table.getValueAt(row, 0).toString();
		int theID = Integer.parseInt(deleteCell);

		try {
			student.eliminaStudente(theID);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		modelStudent.remove(row);
	}

	public void insertCourse(String name, String description, String maxStudents, String themeArea, String date) {
		try {
			course.inserisciCorso(name, description, maxStudents, themeArea, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayCourse(JTable table) {
		try {
			modelCourse = new CourseTableModel(course.leggiCorsi());
			table.setModel(modelCourse);
			TableRowSorter myTableRowSorter = new TableRowSorter(modelCourse);
			table.setRowSorter(myTableRowSorter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCourseToTableView(JTable table, JTextField nome, JTextField maxPartecipanti, JComboBox areaTematica,
			JTextArea descrizione) {
		try {
			table.setModel(modelCourse);
			int id = 0;
			id = course.getLastID(id);
			int maxPart = Integer.parseInt(maxPartecipanti.getText());
			Corso c = new Corso(id, nome.getText(), descrizione.getText(), maxPart,
					areaTematica.getSelectedItem().toString());
			modelCourse.add(c);

		} catch (NumberFormatException error_format) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(JTable table) {
		CourseTableModel model = (CourseTableModel) table.getModel();
		int row = table.getSelectedRow();
		int rowModel = table.convertRowIndexToModel(row);
		String deleteCell = table.getValueAt(rowModel, 0).toString();
		int theID = Integer.parseInt(deleteCell);
		try {
			course.eliminaCorso(theID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.remove(rowModel);

	}

	public void updateDetailsCourse(String numeroLezioni, String presenzeObbligatorie, String id) {
		Connessione connect = null;

		try {
			connect = Connessione.getInstance();
			Connection conn = connect.getConnection();

			// Conversione valori
			int codiceCorso = Integer.parseInt(id);
			int lezioniTotali = Integer.parseInt(numeroLezioni);
			int presenzeNecessarie = Integer.parseInt(presenzeObbligatorie);

			course.aggiornaDettagliCorso(lezioniTotali, presenzeNecessarie, codiceCorso);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCourse(JTable table, String nome, String maxPartecipanti, String descrizione, String dataInizio) {
		try {
			boolean isUpdated = false;
			int rigaSelected = table.getSelectedRow();
			int theID = (int) modelCourse.getValueAt(rigaSelected, 0);
			if (course.aggiornaCorso(isUpdated, theID, nome, maxPartecipanti, descrizione, dataInizio)) {
				modelCourse.setValueAt(nome, rigaSelected, 1);
				modelCourse.setValueAt(maxPartecipanti, rigaSelected, 2);
				modelCourse.setValueAt(descrizione, rigaSelected, 4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateAreaTematica(String areaTematica, String idCorso) {
		int id = Integer.parseInt(idCorso);

		try {
			area.aggiornaArea(areaTematica, id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostraCorsiComboBox(JComboBox comboBox) {
		try {
			ArrayList<Corso> corsi = course.displayCorsiComboBox();
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (Corso c : corsi) {
				String nomeCorso = c.getNome();
				Integer codice = c.getCodiceCorso();
				String codiceCorso = String.valueOf(codice);
				modelComboBox.addElement(codiceCorso + " - " + nomeCorso);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mostraLezioniComboBox(JComboBox comboBox, String id) {
		try {
			int idCorso = Integer.parseInt(id);
			ArrayList<Lezione> lezioni = lesson.displayLezioniComboBox(idCorso);
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (Lezione l : lezioni) {
				int codiceLezione = l.getCodiceLezione();
				String dataInizio = l.getDataInizio();
				modelComboBox.addElement("Lezione ID " + codiceLezione + " : " + dataInizio);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addCourseToStudent(JTable table, String idStudente, String idCorso, String nomeCorso) {
		try {
			student.addCourseToStudent(table, idStudente, idCorso, nomeCorso);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getStudentEnrolment(String idStudente, JTable table) {
		try {
			student.getStudentEnrolment(idStudente, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registraAdmin(String username, String password) {
		try {
			admin.registrationAdmin(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAdminExists(String username, String password, boolean exist) {
		try {
			if (admin.loginAdmin(username, password, exist)) {
				exist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;

	}

	public void deteleCourseEnrollment(JTable table, String id, String idStudente) {
		try {
			student.deteleCourseEnrollment(table, id, idStudente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showStudentEnrolledTable(String idCorso, String data_lezione, String idLezione, JTable table) {
		try {
			student.showStudentEnrolledTable(idCorso, data_lezione, idLezione, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateAttendanceStudents(String idCorso, String idStudente, String idLezione, String presenza,
			JTable table) {
		try {
			student.updateAttendanceStudents(idCorso, idStudente, idLezione, presenza, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getDetailLesson(String idCorso, JTextField numeroLezioni, JTextField presenzeObbligatorie) {
		try {
			lesson.getDetailLesson(idCorso, numeroLezioni, presenzeObbligatorie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertLesson(String dataInizio, String idCorso, String titolo, String descrizione, String durata,
			String oraInizio) {
		try {
			if (dataInizio.isBlank() || idCorso.isBlank() || titolo.isBlank() || durata.isBlank()
					|| oraInizio.isBlank()) {
				JOptionPane.showMessageDialog(null, "Completa prima tutti i campi!", "Attenzione",
						JOptionPane.WARNING_MESSAGE);
			} else {
				lesson.insertLesson(dataInizio, idCorso, titolo, descrizione, durata, oraInizio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkNumberLesson(String corsoID, boolean value, String numero_lezioni) {
		int id = Integer.parseInt(corsoID);
		int lezioniTotali = Integer.parseInt(numero_lezioni);
		try {
			if (lesson.checkLessonsNumber(id, value, lezioniTotali)) {
				value = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public void showNumberOfLessons(JLabel label, String idCorso) {
		try {
			lesson.showNumberOfLessons(label, idCorso);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertThematicArea(String areaTematica) {
		try {
			area.creaAreaTematica(areaTematica);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void mostraAreeComboBox(JComboBox comboBox) {
		try {
			ArrayList<AreeTematiche> aree = area.mostraAreeTematiche();
			DefaultComboBoxModel modelComboBox = (DefaultComboBoxModel) comboBox.getModel();
			for (AreeTematiche a : aree) {
				String nomeArea = a.getNome();
				modelComboBox.addElement(nomeArea);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getDataInizioCorso(String id, JTextField dataInizio) {
		try {
			course.getDataInizioCorso(id, dataInizio);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void isAvaiableUsername(String username, JTextField user, JLabel message, JLabel messageAvaiable) {
		try {
			admin.isUsernameAvaiable(username, user, message, messageAvaiable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showCoursesDetails(JTable table) {
		try {
			course.mostraDettagliCorsi(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showStudentsAllowed(String idCorso, JTable table) {
		try {
			int id = Integer.parseInt(idCorso);
			student.mostraStudentiIdonei(id, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showLessonElements(String id, JTextField titolo, JTextArea descrizione, JTextField durata,
			JTextField oraInizio) {
		try {
			int idLezione = Integer.parseInt(id);

			ArrayList<Lezione> dettagliLezione = lesson.showElementsLesson(idLezione);
			for (Lezione l : dettagliLezione) {
				titolo.setText(l.getTitolo());
				descrizione.setText(l.getDescrizione());
				durata.setText(l.getDurata());
				oraInizio.setText(l.getOraInizio());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateElementsLesson(String id, String titolo, String descrizione, String durata, String oraInizio) {
		try {
			int idLezione = Integer.parseInt(id);

			lesson.updateElemetsLesson(idLezione, titolo, descrizione, durata, oraInizio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showNumberOfStudentEnrolled(JLabel label, String idCorso) {
		try {
			course.showNumberOfStudentEnrolled(label, idCorso);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
