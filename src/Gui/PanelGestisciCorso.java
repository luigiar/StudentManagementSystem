package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGestisciCorso extends JPanel {
	private JTextField textField_nomeCorso;
	private JTextField textField_corsoID;
	DefaultTableModel model;
	private JTable table;
	private JTextField textFieldPartecipanti;
	private JTextArea textArea_descrizione;
	private JComboBox comboBox_areaTematica;
	DefaultTableCellRenderer cellRender;



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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 68, 632, 215);
		add(scrollPane);
		
		TestCellRenderer cell = new TestCellRenderer();	
		table = new JTable(model) {
		@Override
		public Point getToolTipLocation(MouseEvent event) {
			return new Point(scrollPane.getMousePosition().x,scrollPane.getMousePosition().y);
		
			}
		};
		table.setDefaultRenderer(Object.class, cell);
		table.setBounds(10, 221, 612, -209);
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		Object[] colonne = {"Corso ID","Nome Corso", "Area tematica","Max. Partecipanti","Descrizione"};
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		// set della grandezza delle colonne
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rigaSelected = table.getSelectedRow();
				textField_corsoID.setText((model.getValueAt(rigaSelected, 0)).toString());
				textField_nomeCorso.setText((model.getValueAt(rigaSelected, 1)).toString());
				comboBox_areaTematica.setSelectedItem(model.getValueAt(rigaSelected, 2));
				textFieldPartecipanti.setText((model.getValueAt(rigaSelected, 3)).toString());
				textArea_descrizione.setText((model.getValueAt(rigaSelected, 4)).toString());
				
			}
		});
		
		
		JLabel lblNomeCorso = new JLabel("Nome Corso :");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNomeCorso.setBounds(20, 290, 101, 17);
		add(lblNomeCorso);
		
		textField_nomeCorso = new JTextField();
		textField_nomeCorso.setColumns(10);
		textField_nomeCorso.setBounds(20, 318, 113, 20);
		add(textField_nomeCorso);
		
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
		
		textField_corsoID = new JTextField();
		textField_corsoID.setColumns(10);
		textField_corsoID.setBounds(249, 318, 120, 20);
		add(textField_corsoID);
		
		JButton delete_button = new JButton("Elimina");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rigaPressed = table.getSelectedRow();
				if(rigaPressed >= 0) {
					int input = JOptionPane.showConfirmDialog(null, "Vuoi procedere?", "Seleziona un'opzione", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if(input == JOptionPane.YES_OPTION) {
						model.removeRow(rigaPressed);
						JOptionPane.showMessageDialog(null, "Corso eliminato correttamente", "Conferma", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Eliminazione non eseguita","Conferma", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso","Attenzione",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		delete_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		delete_button.setBackground(new Color(255, 51, 0));
		delete_button.setBounds(553, 518, 81, 29);
		add(delete_button);
		
		JButton update_button = new JButton("Aggiorna");
		update_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rigaPressed = table.getSelectedRow();
				if(rigaPressed >= 0) {
					if(textField_corsoID.getText().isBlank() || textField_nomeCorso.getText().isBlank() || comboBox_areaTematica.getSelectedItem().equals("---Seleziona Area") || comboBox_areaTematica.getSelectedItem().equals("Aggiungi Area") || textFieldPartecipanti.getText().isBlank() || textArea_descrizione.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Aggiornamento non valido!","Errore", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						model.setValueAt(textField_corsoID.getText(), rigaPressed, 0);
						model.setValueAt(textField_nomeCorso.getText(), rigaPressed, 1);
						model.setValueAt(comboBox_areaTematica.getSelectedItem(), rigaPressed, 2);
						model.setValueAt(textFieldPartecipanti.getText(), rigaPressed, 3);
						model.setValueAt(textArea_descrizione.getText(), rigaPressed, 4);
						JOptionPane.showMessageDialog(null, "Aggiornamento effettuato","Conferma",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso","Attenzione",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		update_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		update_button.setBackground(new Color(255, 51, 51));
		update_button.setBounds(462, 518, 81, 29);
		add(update_button);
		
		JButton clear_button = new JButton("Pulisci");
		// Prova per verificare funzionamento di Aggiorna
		clear_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				riga[0] = "test ID";
				riga[1] = textField_nomeCorso.getText();
				riga[2] = comboBox_areaTematica.getSelectedItem();
				riga[3] = textFieldPartecipanti.getText();
				riga[4] = textArea_descrizione.getText(); 
				model.addRow(riga);
				
				riga[0] = "";
				textField_nomeCorso.setText("");
				comboBox_areaTematica.setSelectedIndex(0);
				textFieldPartecipanti.setText("");
				textArea_descrizione.setText("");
				
			}
		});
		clear_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		clear_button.setBackground(new Color(255, 255, 51));
		clear_button.setBounds(371, 518, 81, 29);
		add(clear_button);
		
		JLabel lblAreaTematica = new JLabel("Area Tematica :");
		lblAreaTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblAreaTematica.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAreaTematica.setBounds(20, 360, 109, 17);
		add(lblAreaTematica);
		
		comboBox_areaTematica = new JComboBox();
		comboBox_areaTematica.setToolTipText("Seleziona un'area tematica per il corso");
		comboBox_areaTematica.setBackground(Color.WHITE);
		comboBox_areaTematica.setBounds(20, 388, 139, 21);
		comboBox_areaTematica.setModel(new DefaultComboBoxModel(new String[] {"---Seleziona Area", "Aggiungi Area", "Area Umanistica", "Area Linguistica", "Area Scientifica"}));
		add(comboBox_areaTematica);
		comboBox_areaTematica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(comboBox_areaTematica.getSelectedItem().equals("Aggiungi Area")) {
						String itemAdd  = JOptionPane.showInputDialog(null,"Inserisci l'area tematica da aggiungere");
						if(itemAdd.equals("") || String.valueOf(itemAdd).isBlank()) {
						    JOptionPane.showMessageDialog(null, "Inserimento non eseguito!","Attenzione",JOptionPane.WARNING_MESSAGE);
						}
						else 
							comboBox_areaTematica.addItem(itemAdd);							
						}
					}
		});
		
		JButton addArea_button = new JButton("Aggiungi");
		addArea_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rigaPressed = table.getSelectedRow();
				if(rigaPressed >= 0) {
					if(comboBox_areaTematica.getSelectedItem().toString().equals("---Seleziona Area") || comboBox_areaTematica.getSelectedItem().toString().equals("Aggiungi Area")) {
						JOptionPane.showMessageDialog(null, "Inserimento non valido!","Errore", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String valoreCorrente = model.getValueAt(rigaPressed,2).toString();
						model.setValueAt(comboBox_areaTematica.getSelectedItem(), rigaPressed, 2);
						String valoreAggiunto = model.getValueAt(rigaPressed, 2).toString();
						valoreCorrente = valoreCorrente.concat(valoreAggiunto.indent(2)); 
						model.setValueAt(valoreCorrente, rigaPressed, 2);
						JOptionPane.showMessageDialog(null, "Area tematica aggiunta con successo","Conferma",JOptionPane.INFORMATION_MESSAGE);
						comboBox_areaTematica.setSelectedIndex(0);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso","Attenzione",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		addArea_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		addArea_button.setBackground(new Color(102, 204, 51));
		addArea_button.setBounds(169, 387, 96, 21);
		add(addArea_button);
		
		JButton editArea_button = new JButton("Modifica");
		editArea_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rigaPressed = table.getSelectedRow();
				if(rigaPressed >= 0) {
					String input = JOptionPane.showInputDialog(null, "Modifica l'area per questo corso",table.getValueAt(rigaPressed, 2));
					if(!input.isBlank()) {
					table.setValueAt(input, rigaPressed, 2);
					JOptionPane.showMessageDialog(null, "Modifica effettuata","Conferma",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Per favore, aggiungi un'area tematica al corso","Attenzione",JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso","Attenzione",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		editArea_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		editArea_button.setBackground(new Color(255, 127, 80));
		editArea_button.setBounds(275, 387, 96, 21);
		add(editArea_button);
		
		JScrollPane scrollPane_descrizione = new JScrollPane();
		scrollPane_descrizione.setBounds(20, 462, 245, 85);
		add(scrollPane_descrizione);
		
		textArea_descrizione = new JTextArea();
		textArea_descrizione.setLineWrap(true);
		scrollPane_descrizione.setViewportView(textArea_descrizione);
		
		JLabel lblMaxPartecipanti = new JLabel("Max. Partecipanti");
		lblMaxPartecipanti.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxPartecipanti.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblMaxPartecipanti.setBounds(462, 292, 120, 17);
		add(lblMaxPartecipanti);
		
		textFieldPartecipanti = new JTextField();
		textFieldPartecipanti.setColumns(10);
		textFieldPartecipanti.setBounds(462, 318, 120, 20);
		add(textFieldPartecipanti);
		

			
		

	}
}
