package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class GestisciLezioneJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_titolo;
	private JTextField textFieldDurataLezione;
	private JTextField textField_oraInizio;
	private JTextArea textArea_descrizione;
	private JDateChooser dateChooser;
	private Controller theController;
	
	/**
	 * Create the dialog.
	 */
	public GestisciLezioneJDialog(Controller c, String corsoID) {
		theController = c;
		setTitle("Aggiungi delle lezioni");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 425, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 215, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_GestioneLezioni = new JPanel();
		panel_GestioneLezioni.setLayout(null);
		panel_GestioneLezioni.setBackground(new Color(255, 165, 0));
		panel_GestioneLezioni.setBounds(0, 0, 409, 57);
		contentPanel.add(panel_GestioneLezioni);
		
		JLabel lblGestioneLezioni = new JLabel("Gestione Lezioni");
		lblGestioneLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneLezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneLezioni.setBounds(109, 11, 197, 28);
		panel_GestioneLezioni.add(lblGestioneLezioni);
		
		JLabel lblTitolo = new JLabel("Titolo :");
		lblTitolo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitolo.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTitolo.setBounds(10, 68, 128, 17);
		contentPanel.add(lblTitolo);
		
		textField_titolo = new JTextField();
		textField_titolo.setColumns(10);
		textField_titolo.setBounds(148, 67, 151, 20);
		contentPanel.add(textField_titolo);
		
		JLabel lblDurataLezione = new JLabel("Durata Lezione :");
		lblDurataLezione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurataLezione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDurataLezione.setBounds(10, 111, 128, 17);
		contentPanel.add(lblDurataLezione);
		
		textFieldDurataLezione = new JTextField();
		textFieldDurataLezione.setColumns(10);
		textFieldDurataLezione.setBounds(148, 110, 86, 20);
		contentPanel.add(textFieldDurataLezione);
		
		JLabel lblDescrizione = new JLabel("Descrizione : ");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(10, 153, 108, 17);
		contentPanel.add(lblDescrizione);
		
		
		JScrollPane scrollPane_descrizione = new JScrollPane();
		contentPanel.add(scrollPane_descrizione);
		scrollPane_descrizione.setBounds(148, 150, 151, 73);
		
		textArea_descrizione = new JTextArea();
		textArea_descrizione.setBounds(148, 150, 151, 73);
		scrollPane_descrizione.setViewportView(textArea_descrizione);
		textArea_descrizione.setLineWrap(true);
		
		
		JLabel lblDataInizio = new JLabel("Data Inizio : ");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(10, 235, 93, 17);
		contentPanel.add(lblDataInizio);
		
		JLabel lblOraInizio = new JLabel("Ora inizio :");
		lblOraInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblOraInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOraInizio.setBounds(10, 279, 93, 17);
		contentPanel.add(lblOraInizio);
		
		textField_oraInizio = new JTextField();
		textField_oraInizio.setToolTipText("hh:mm");
		textField_oraInizio.setColumns(10);
		textField_oraInizio.setBounds(148, 278, 86, 20);
		contentPanel.add(textField_oraInizio);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 232, 128, 20);
		contentPanel.add(dateChooser);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEditable(false);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			c.insertLesson(editor.getText(),corsoID,textField_titolo.getText(), textArea_descrizione.getText(), textFieldDurataLezione.getText(),textField_oraInizio.getText());
			}
		});
		btnSalva.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnSalva.setBackground(new Color(102, 204, 51));
		btnSalva.setBounds(305, 313, 89, 23);
		contentPanel.add(btnSalva);
		
		JLabel lblDuration = new JLabel("h.");
		lblDuration.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuration.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDuration.setBounds(244, 113, 55, 17);
		contentPanel.add(lblDuration);
		
		}
}
