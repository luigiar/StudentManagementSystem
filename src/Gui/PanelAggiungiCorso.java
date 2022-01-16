package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.MutableComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAggiungiCorso extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_maxPartecipanti;

	/**
	 * Create the panel.
	 */
	public PanelAggiungiCorso() {
		setBackground(new Color(255, 215, 0));
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		
		JLabel lblNewCourse = new JLabel("Nuovo Corso");
		lblNewCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewCourse.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewCourse.setBounds(232, 11, 197, 28);
		panel.add(lblNewCourse);
		
		table = new JTable();
		table.setBackground(new Color(255, 215, 0));
		table.setBounds(0, 302, 673, -245);
		add(table);
		
		JLabel lblNomeCorso = new JLabel("Nome Corso :");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNomeCorso.setBounds(20, 318, 101, 17);
		add(lblNomeCorso);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 345, 120, 20);
		add(textField);
		
		JLabel lblDescrizione = new JLabel("Descrizione :");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(20, 442, 101, 17);
		add(lblDescrizione);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 470, 341, 57);
		add(textPane);
		
		JButton insert_button = new JButton("Inserisci");
		insert_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		insert_button.setBackground(new Color(51, 153, 204));
		insert_button.setBounds(546, 521, 96, 29);
		add(insert_button);
		
		JButton clear_button = new JButton("Pulisci");
		clear_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		clear_button.setBackground(new Color(255, 255, 51));
		clear_button.setBounds(447, 521, 89, 29);
		add(clear_button);
		
		JLabel lblAreaTematica = new JLabel("Area Tematica :");
		lblAreaTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblAreaTematica.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAreaTematica.setBounds(235, 320, 109, 17);
		add(lblAreaTematica);
		
		JComboBox comboBox = new JComboBox();
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

		comboBox.setBackground(Color.WHITE);
		comboBox.setToolTipText("");

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Seleziona Area", "Aggiungi Area", "Area Umanistica", "Area Linguistica", "Area Scientifica"}));
		comboBox.setBounds(235, 344, 139, 21);
		add(comboBox);
		
		JButton addArea_button = new JButton("Aggiungi");
		addArea_button.setBackground(new Color(102, 204, 51));
		addArea_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));


		addArea_button.setBounds(384, 344, 96, 21);
		add(addArea_button);
		
		JLabel lblMaxPartecipanti = new JLabel("Max. Partecipanti");
		lblMaxPartecipanti.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxPartecipanti.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblMaxPartecipanti.setBounds(20, 376, 120, 17);
		add(lblMaxPartecipanti);
		
		textField_maxPartecipanti = new JTextField();
		textField_maxPartecipanti.setColumns(10);
		textField_maxPartecipanti.setBounds(20, 404, 120, 20);
		add(textField_maxPartecipanti);


	}
}
