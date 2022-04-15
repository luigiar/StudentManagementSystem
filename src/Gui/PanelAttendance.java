package Gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAttendance extends JPanel {
	private JTable table;
	private JButton btn_mostraLezioni;
	private DefaultTableModel model;
	private ButtonGroup btn;
	private Controller theController; 
	private JTextField textField_codiceCorso;
	private JTextField textField_nomeCorso;
	
	public PanelAttendance(Controller c) {
		theController = c;
		setLayout(null);
		setBounds(0, 0, 673, 581);
		setBackground(new Color(255, 215, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);

		JLabel lbl_introPanel = new JLabel(
				"Imposta come stato \"assente/presente\" agli studenti per ogni lezione di un corso");
		lbl_introPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_introPanel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lbl_introPanel.setBounds(10, 64, 494, 23);
		add(lbl_introPanel);

		JLabel lblGestionePresenzeassenze = new JLabel("Gestione assenze / presenze");
		lblGestionePresenzeassenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionePresenzeassenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestionePresenzeassenze.setBounds(232, 11, 197, 35);
		panel.add(lblGestionePresenzeassenze);

		JLabel lbl_lezioni = new JLabel("Seleziona una lezione");
		lbl_lezioni.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_lezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_lezioni.setBounds(385, 98, 115, 22);
		add(lbl_lezioni);

		JComboBox comboBoxLezioni = new JComboBox();
		comboBoxLezioni.setBounds(506, 98, 136, 22);
		add(comboBoxLezioni);

		JLabel lbl_selezionaCorso = new JLabel("Seleziona un corso");
		lbl_selezionaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_selezionaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_selezionaCorso.setBounds(10, 98, 115, 23);
		add(lbl_selezionaCorso);

		JComboBox comboBoxCorsi = new JComboBox();
		comboBoxCorsi.setBounds(135, 99, 136, 22);
		add(comboBoxCorsi);
		c.mostraCorsiComboBox(comboBoxCorsi);
		
		textField_codiceCorso = new JTextField();
		textField_nomeCorso = new JTextField();
		textField_codiceCorso.setEditable(false);
		textField_nomeCorso.setEditable(false);
		Object[] campiCorso = { "Codice corso", textField_codiceCorso, "Nome corso", textField_nomeCorso };
		btn_mostraLezioni = new JButton("Mostra");
		btn_mostraLezioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String corsoID = comboBoxCorsi.getSelectedItem().toString();
				corsoID = corsoID.replaceAll("[^0-9]", "");
				textField_codiceCorso.setText(corsoID);

				String nomeCorso = comboBoxCorsi.getSelectedItem().toString();
				nomeCorso = nomeCorso.replaceAll("[0-9]", "");
				textField_nomeCorso.setText(nomeCorso);
				int input = JOptionPane.showConfirmDialog(null, campiCorso, "Visualizzare le lezioni per il corso? ",
						JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					c.mostraLezioniComboBox(comboBoxLezioni, textField_codiceCorso.getText());
					JOptionPane.showMessageDialog(null, "Lezioni visualizzate");
				} else {
					JOptionPane.showMessageDialog(null, "Operazione annullata");
				}
			}
		});
		btn_mostraLezioni.setBackground(new Color(0, 139, 139));
		btn_mostraLezioni.setBounds(281, 98, 75, 23);
		add(btn_mostraLezioni);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 159, 632, 231);
		add(scrollPane);
		
		model = new DefaultTableModel();
		String[] colonne = { "Nome", "Cognome", "Data", "Presente" };
		model.setColumnIdentifiers(colonne);
		
		table = new JTable(model) {
			public Class getColumnClass(int colonne) {
				switch (colonne) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return Boolean.class;
				}
				return null;
			}
		};
		table.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(table);
		
		JButton btn_aggiungiCorso = new JButton("Visualizza studenti");
		btn_aggiungiCorso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String lezioneSelected = comboBoxLezioni.getSelectedItem().toString();
				lezioneSelected = lezioneSelected.substring(lezioneSelected.lastIndexOf(": ") + 1).strip();
				c.showStudentEnrolledTable(textField_codiceCorso.getText(),lezioneSelected,table);
				}
		});
		btn_aggiungiCorso.setToolTipText("Clicca per visualizzare gli studenti");
		btn_aggiungiCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_aggiungiCorso.setBackground(new Color(255, 165, 0));
		btn_aggiungiCorso.setBounds(10, 132, 136, 21);
		add(btn_aggiungiCorso);
	}
}
