package Gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import Controller.Controller;

public class PanelDettagliCorso extends JPanel {
	private JTextField textField_NumLezioni;
	private JTextField textField_PresenzeObbligatorie;
	Image search = new ImageIcon(this.getClass().getResource("/searchImm.png")).getImage();
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRender;
	private Controller theController;

	/**
	 * Create the panel.
	 */
	public PanelDettagliCorso(Controller c) {
		theController = c;
		setLayout(null);
		setBounds(0, 0, 673, 581);
		setBackground(new Color(255, 215, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);

		JLabel lblDettagliCorso = new JLabel("Dettagli Corso");
		lblDettagliCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDettagliCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDettagliCorso.setBounds(223, 11, 197, 28);
		panel.add(lblDettagliCorso);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 241, 632, 226);
		add(scrollPane);

		table = new JTable();
		table.setBounds(10, 221, 612, -209);
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		Object[] colonne = { "Nome corso", "Data inizio", "Num lezioni", "Ore totali", "Max studenti a lezione",
				"Min studenti a lezione", "Riempimento medio" };
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		scrollPane.setViewportView(table);

		// set della grandezza delle colonne
		cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);

		JLabel lblSelezionaCorso = new JLabel("Seleziona corso :");
		lblSelezionaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelezionaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblSelezionaCorso.setBounds(10, 116, 112, 17);
		add(lblSelezionaCorso);

		JComboBox comboBoxCorsi = new JComboBox();
		comboBoxCorsi.setToolTipText("Scegli un corso");
		comboBoxCorsi.setBounds(132, 114, 145, 22);
		add(comboBoxCorsi);
		c.mostraCorsiComboBox(comboBoxCorsi);

		JLabel lblNumeroLezioni = new JLabel("Numero lezioni :");
		lblNumeroLezioni.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroLezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNumeroLezioni.setBounds(10, 156, 112, 17);
		add(lblNumeroLezioni);

		textField_NumLezioni = new JTextField();
		textField_NumLezioni.setBounds(132, 155, 53, 20);
		add(textField_NumLezioni);
		textField_NumLezioni.setColumns(10);

		JLabel lblPresenzeObbligatorie = new JLabel("Presenze obbligatorie :");
		lblPresenzeObbligatorie.setHorizontalAlignment(SwingConstants.LEFT);
		lblPresenzeObbligatorie.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPresenzeObbligatorie.setBounds(338, 116, 145, 17);
		add(lblPresenzeObbligatorie);

		textField_PresenzeObbligatorie = new JTextField();
		textField_PresenzeObbligatorie.setBounds(493, 115, 53, 20);
		add(textField_PresenzeObbligatorie);
		textField_PresenzeObbligatorie.setColumns(10);

		JPanel panel_cercaCorso = new JPanel();
		panel_cercaCorso.setBounds(0, 201, 112, 29);
		panel_cercaCorso.setBackground(new Color(255, 165, 0));
		add(panel_cercaCorso);
		panel_cercaCorso.setLayout(null);
		panel_cercaCorso.addMouseListener(new PanelButtonMouseAdapter(panel_cercaCorso));

		JLabel lblCercaCorso = new JLabel("Cerca Corso");

		lblCercaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCercaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCercaCorso.setBounds(10, 0, 72, 30);
		panel_cercaCorso.add(lblCercaCorso);

		JLabel lblSearch = new JLabel("");
		lblSearch.setBounds(80, 0, 49, 30);
		lblSearch.setIcon(new ImageIcon(search));
		panel_cercaCorso.add(lblSearch);

		JPanel panel_GestisciLezione = new JPanel();
		panel_GestisciLezione.setBounds(195, 156, 23, 17);
		panel_GestisciLezione.setBackground(new Color(255, 165, 0));
		add(panel_GestisciLezione);
		panel_GestisciLezione.setLayout(null);
		panel_GestisciLezione.addMouseListener(new PanelButtonMouseAdapter(panel_GestisciLezione));
		panel_GestisciLezione.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				GestisciLezioneJDialog lezione = new GestisciLezioneJDialog();
				lezione.setVisible(true);
			}

		});

		JLabel lblAggiungiLezioni = new JLabel("...");
		lblAggiungiLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiLezioni.setBounds(-28, 0, 81, 14);
		panel_GestisciLezione.add(lblAggiungiLezioni);

		textField = new JTextField();
		textField.setBounds(132, 201, 96, 22);
		add(textField);
		textField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 0));
		separator.setBackground(new Color(255, 255, 0));
		separator.setBounds(0, 188, 673, 2);
		add(separator);

		JButton add_button = new JButton("Aggiungi");
		add_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_NumLezioni.getText().isBlank() || textField_PresenzeObbligatorie.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Completa prima tutti i campi!", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
					String codiceCorso = corsoSelected.replaceAll("[^0-9]", "");

					c.updateDetailsCourse(textField_NumLezioni.getText(), textField_PresenzeObbligatorie.getText(),
							codiceCorso);
					
					clearFields();
				}
			}
		});
		add_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		add_button.setBackground(new Color(102, 204, 51));
		add_button.setBounds(534, 156, 96, 21);
		add(add_button);
		
		JLabel lbl_introPanel = new JLabel("Imposta i dettagli di ogni corso, gestisci le lezioni");
		lbl_introPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_introPanel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lbl_introPanel.setBounds(10, 68, 312, 23);
		add(lbl_introPanel);

	}
	
	public void clearFields() {
		textField_NumLezioni.setText("");
		textField_PresenzeObbligatorie.setText("");
	}
}
