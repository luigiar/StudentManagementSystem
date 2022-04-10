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

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GestisciLezioneJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLezioneNum;
	private JTextField textFieldDurataLezione;
	private JTextField textField_DataInizio;
	private JTextField textField_OraInizio;
	private JTextField textField_Presenze;
	private JTextField textField_Assenze;
	private JTextField textField;
	
	/**
	 * Create the dialog.
	 */
	public GestisciLezioneJDialog() {
		setTitle("Aggiungi delle lezioni");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 439, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 215, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_GestioneLezioni = new JPanel();
		panel_GestioneLezioni.setLayout(null);
		panel_GestioneLezioni.setBackground(new Color(255, 165, 0));
		panel_GestioneLezioni.setBounds(0, 0, 423, 57);
		contentPanel.add(panel_GestioneLezioni);
		
		JLabel lblGestioneLezioni = new JLabel("Gestione Lezioni");
		lblGestioneLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneLezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneLezioni.setBounds(109, 11, 197, 28);
		panel_GestioneLezioni.add(lblGestioneLezioni);
		
		JLabel lblLezionenumero = new JLabel("Titolo :");
		lblLezionenumero.setHorizontalAlignment(SwingConstants.LEFT);
		lblLezionenumero.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblLezionenumero.setBounds(10, 68, 128, 17);
		contentPanel.add(lblLezionenumero);
		
		textFieldLezioneNum = new JTextField();
		textFieldLezioneNum.setColumns(10);
		textFieldLezioneNum.setBounds(148, 67, 86, 20);
		contentPanel.add(textFieldLezioneNum);
		
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
		
		JTextArea textArea_descrizione = new JTextArea();
		textArea_descrizione.setBounds(148, 150, 151, 73);
		scrollPane_descrizione.setViewportView(textArea_descrizione);
		textArea_descrizione.setLineWrap(true);
		
		
		JLabel lblDataInizio = new JLabel("Data Inizio : ");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(10, 235, 93, 17);
		contentPanel.add(lblDataInizio);
		
		textField_DataInizio = new JTextField();
		textField_DataInizio.setColumns(10);
		textField_DataInizio.setBounds(148, 234, 86, 20);
		contentPanel.add(textField_DataInizio);
		
		JLabel lblOraInizio = new JLabel("Ora inizio :");
		lblOraInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblOraInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOraInizio.setBounds(10, 279, 93, 17);
		contentPanel.add(lblOraInizio);
		
		textField_OraInizio = new JTextField();
		textField_OraInizio.setColumns(10);
		textField_OraInizio.setBounds(148, 278, 86, 20);
		contentPanel.add(textField_OraInizio);
		
		JLabel lblPresenze = new JLabel("Presenze :");
		lblPresenze.setHorizontalAlignment(SwingConstants.LEFT);
		lblPresenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPresenze.setBounds(10, 319, 108, 17);
		contentPanel.add(lblPresenze);
		
		textField_Presenze = new JTextField();
		textField_Presenze.setColumns(10);
		textField_Presenze.setBounds(148, 318, 86, 20);
		contentPanel.add(textField_Presenze);
		
		JLabel lblAssenze = new JLabel("Assenze :");
		lblAssenze.setHorizontalAlignment(SwingConstants.LEFT);
		lblAssenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAssenze.setBounds(10, 357, 108, 17);
		contentPanel.add(lblAssenze);
		
		textField_Assenze = new JTextField();
		textField_Assenze.setColumns(10);
		textField_Assenze.setBounds(148, 356, 86, 20);
		contentPanel.add(textField_Assenze);
		
		
		JButton btnNewButton = new JButton("Salva");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(102, 204, 51));
		btnNewButton.setBounds(324, 415, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblNumeroLez = new JLabel("Numero lez.");
		lblNumeroLez.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroLez.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNumeroLez.setBounds(244, 68, 73, 17);
		contentPanel.add(lblNumeroLez);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(324, 68, 31, 20);
		contentPanel.add(textField);
	
	

		
	}
}
