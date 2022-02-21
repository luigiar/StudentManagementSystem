package Gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import Controller.Controller;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;

public class PanelAggiornaStudente extends JPanel {
	private final JSeparator separator = new JSeparator();
	private JTextField textField_corso;
	private JTextField textFieldPresenze;
	private JTextField textFieldAssenze;
	private JComboBox comboBoxCorsi;
	private Controller theController;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_nome;
	private JTextField textField_cognome;
	/**
	 * Create the panel.
	 */
	public PanelAggiornaStudente(Controller c) {
		theController = c;
		setBackground(new Color(255, 215, 0));
		setBounds(0, 56, 673, 525);
		setLayout(null);
		separator.setBounds(10, 428, 673, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(335, 2, 2, 428);
		add(separator_1);
		
		JButton btn_salva = new JButton("Salva");
		btn_salva.setBounds(293, 441, 89, 23);
		add(btn_salva);
		
		JLabel lbl_iscrizioneCorsi = new JLabel("Iscrizione ai corsi");
		lbl_iscrizioneCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_iscrizioneCorsi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_iscrizioneCorsi.setBounds(67, 11, 232, 23);
		add(lbl_iscrizioneCorsi);
		
		JLabel lbl_presenzeAssenze = new JLabel("Dettagli presenze/assenze :");
		lbl_presenzeAssenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_presenzeAssenze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_presenzeAssenze.setBounds(362, 11, 258, 23);
		add(lbl_presenzeAssenze);
		
		JLabel lbl_inserireCorso = new JLabel("Inserire il corso :");
		lbl_inserireCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_inserireCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_inserireCorso.setBounds(424, 45, 160, 28);
		add(lbl_inserireCorso);
		
		textField_corso = new JTextField();
		textField_corso.setBounds(424, 83, 131, 20);
		add(textField_corso);
		textField_corso.setColumns(10);
		
		JButton btn_seleziona = new JButton("Seleziona");
		btn_seleziona.setBackground(new Color(0, 139, 139));
		btn_seleziona.setBounds(449, 115, 89, 23);
		add(btn_seleziona);
		
		JLabel lbl_presenze = new JLabel("Presenze :");
		lbl_presenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lbl_presenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_presenze.setBounds(398, 156, 65, 14);
		add(lbl_presenze);
		
		JLabel lbl_assenze = new JLabel("Assenze :");
		lbl_assenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lbl_assenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_assenze.setBounds(518, 156, 59, 14);
		add(lbl_assenze);
		
		textFieldPresenze = new JTextField();
		textFieldPresenze.setBounds(408, 178, 43, 20);
		add(textFieldPresenze);
		textFieldPresenze.setColumns(10);
		
		textFieldAssenze = new JTextField();
		textFieldAssenze.setColumns(10);
		textFieldAssenze.setBounds(525, 178, 43, 20);
		add(textFieldAssenze);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aggiornamento presenze/assenze :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(362, 226, 275, 23);
		add(lblNewLabel_1_1);
		
		JRadioButton RadioButtonPresente = new JRadioButton("Presenze");
		RadioButtonPresente.setBackground(new Color(255, 215, 0));
		RadioButtonPresente.setBounds(398, 289, 80, 23);
		add(RadioButtonPresente);
		
		JRadioButton rdbtnAssente = new JRadioButton("Assenze");
		rdbtnAssente.setBackground(new Color(255, 215, 0));
		rdbtnAssente.setBounds(523, 289, 97, 23);
		add(rdbtnAssente);
		
		ButtonGroup group = new ButtonGroup();
		group.add(RadioButtonPresente);
		group.add(rdbtnAssente);
		
		JLabel lbl_iscriviStudente = new JLabel("Seleziona i corsi per lo studente :");
		lbl_iscriviStudente.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_iscriviStudente.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_iscriviStudente.setBounds(71, 93, 184, 28);
		add(lbl_iscriviStudente);
		
		comboBoxCorsi = new JComboBox();
		comboBoxCorsi.setBounds(57, 133, 131, 22);
		// mostra corsi nella comboBox
		c.mostraCorsiComboBox(comboBoxCorsi);
		add(comboBoxCorsi);
		
		JButton btn_aggiungiCorso = new JButton("Aggiungi");
		btn_aggiungiCorso.setToolTipText("Clicca per iscrivere lo studente al corso");
		btn_aggiungiCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_aggiungiCorso.setBackground(new Color(102, 204, 51));
		btn_aggiungiCorso.setBounds(213, 133, 96, 21);
		add(btn_aggiungiCorso);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(55, 195, 254, 186);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lbl_iscriviStudente_1 = new JLabel("Studente :");
		lbl_iscriviStudente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_iscriviStudente_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_iscriviStudente_1.setBounds(57, 34, 184, 28);
		add(lbl_iscriviStudente_1);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(61, 62, 43, 20);
		add(textField_id);
		textField_id.setColumns(10);
		
		textField_nome = new JTextField();
		textField_nome.setEditable(false);
		textField_nome.setColumns(10);
		textField_nome.setBounds(114, 62, 86, 20);
		add(textField_nome);
		
		textField_cognome = new JTextField();
		textField_cognome.setEditable(false);
		textField_cognome.setColumns(10);
		textField_cognome.setBounds(213, 62, 86, 20);
		add(textField_cognome);	
	}
	
	public void setStudentDetails(String id, String nome, String cognome) {
		textField_id.setText(id);		
		textField_nome.setText(nome);
		textField_cognome.setText(cognome);
	}
}
