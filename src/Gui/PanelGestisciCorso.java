package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PanelGestisciCorso extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelGestisciCorso() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		setBackground(new Color(255, 215, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		
		JLabel lblGestioneCorsi = new JLabel("Gestione Corsi");
		lblGestioneCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneCorsi.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneCorsi.setBounds(223, 11, 197, 28);
		panel.add(lblGestioneCorsi);
		
		table = new JTable();
		table.setBackground(new Color(255, 215, 0));
		table.setBounds(0, 273, 653, -216);
		add(table);
		
		JLabel lblNomeCorso = new JLabel("Nome Corso :");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNomeCorso.setBounds(20, 290, 101, 17);
		add(lblNomeCorso);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 318, 113, 20);
		add(textField);
		
		JLabel lblDescrizione = new JLabel("Descrizione :");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(20, 434, 101, 17);
		add(lblDescrizione);
		
		JLabel lblCorsoId = new JLabel(" Corso Id  :");
		lblCorsoId.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorsoId.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCorsoId.setBounds(249, 290, 101, 17);
		add(lblCorsoId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(249, 318, 120, 20);
		add(textField_2);
		
		JButton delete_button = new JButton("Elimina");
		delete_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		delete_button.setBackground(new Color(255, 51, 0));
		delete_button.setBounds(553, 518, 81, 29);
		add(delete_button);
		
		JButton update_button = new JButton("Aggiorna");
		update_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		update_button.setBackground(new Color(255, 51, 51));
		update_button.setBounds(462, 518, 81, 29);
		add(update_button);
		
		JButton clear_button = new JButton("Pulisci");
		clear_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		clear_button.setBackground(new Color(255, 255, 51));
		clear_button.setBounds(371, 518, 81, 29);
		add(clear_button);
		
		JLabel lblAreaTematica = new JLabel("Area Tematica :");
		lblAreaTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblAreaTematica.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAreaTematica.setBounds(20, 360, 109, 17);
		add(lblAreaTematica);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(20, 388, 139, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Seleziona Area", "Aggiungi Area", "Area Umanistica", "Area Linguistica", "Area Scientifica"}));
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().equals("Aggiungi Area")) {
						String itemAdd  = JOptionPane.showInputDialog(null,"Inserisci l'area tematica da aggiungere");
						if(itemAdd.equals("") || String.valueOf(itemAdd).isBlank()) {
						    JOptionPane.showMessageDialog(null, "Inserimento non eseguito!");
						}
						else 
							comboBox.addItem(itemAdd);							
						}
					}
		});
		
		JButton addArea_button = new JButton("Aggiungi");
		addArea_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		addArea_button.setBackground(new Color(102, 204, 51));
		addArea_button.setBounds(169, 387, 96, 21);
		add(addArea_button);
		
		JButton addArea_button_1 = new JButton("Rimuovi");
		addArea_button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		addArea_button_1.setBackground(new Color(255, 51, 0));
		addArea_button_1.setBounds(275, 387, 96, 21);
		add(addArea_button_1);
		
		JScrollPane scrollPane_descrizione = new JScrollPane();
		scrollPane_descrizione.setBounds(20, 462, 245, 85);
		add(scrollPane_descrizione);
		
		JTextArea textArea_descrizione = new JTextArea();
		textArea_descrizione.setLineWrap(true);
		scrollPane_descrizione.setViewportView(textArea_descrizione);

	}
}
