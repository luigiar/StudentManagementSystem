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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelAttendance extends JPanel {
	private JTable table;
	private JButton btn_mostraLezioni;
	private DefaultTableModel model;
	private Controller theController;
	private JTextField textField_codiceCorso;
	private JTextField textField_nomeCorso;
	private JComboBox comboBoxLezioni;
	private JComboBox comboBoxCorsi;
	private JButton btn_salva;
	DefaultComboBoxModel modelComboBox;
	String dataLezioneSelected, idLezioneSelected, idStudente, presenza;

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
		lbl_lezioni.setBounds(20, 161, 115, 22);
		add(lbl_lezioni);

		comboBoxLezioni = new JComboBox();
		comboBoxLezioni.setBounds(153, 162, 163, 22);
		add(comboBoxLezioni);
		modelComboBox = new DefaultComboBoxModel();
		comboBoxLezioni.setModel(modelComboBox);

		JLabel lbl_selezionaCorso = new JLabel("Seleziona un corso");
		lbl_selezionaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_selezionaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_selezionaCorso.setBounds(20, 97, 115, 23);
		add(lbl_selezionaCorso);

		textField_codiceCorso = new JTextField();
		textField_nomeCorso = new JTextField();
		textField_codiceCorso.setEditable(false);
		textField_nomeCorso.setEditable(false);
		Object[] campiCorso = { "Codice corso", textField_codiceCorso, "Nome corso", textField_nomeCorso };
		btn_mostraLezioni = new JButton("Mostra");
		btn_mostraLezioni.setToolTipText("visualizza le lezioni del corso");
		btn_mostraLezioni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBoxCorsi.getSelectedIndex() != -1) {
					String corsoID = comboBoxCorsi.getSelectedItem().toString();
					corsoID = corsoID.replaceAll("[^0-9]", "");
					textField_codiceCorso.setText(corsoID);

					String nomeCorso = comboBoxCorsi.getSelectedItem().toString();
					nomeCorso = nomeCorso.replaceAll("[0-9]", "");
					textField_nomeCorso.setText(nomeCorso);
					int input = JOptionPane.showConfirmDialog(null, campiCorso,
							"Visualizzare le lezioni per il corso? ", JOptionPane.OK_CANCEL_OPTION);
					if (input == JOptionPane.OK_OPTION) {
						mostraLezioni();
						JOptionPane.showMessageDialog(null, "Lezioni visualizzate");
					} else {
						JOptionPane.showMessageDialog(null, "Operazione annullata");
					}
				}

			}

		});
		btn_mostraLezioni.setBackground(new Color(0, 139, 139));
		btn_mostraLezioni.setBounds(281, 98, 75, 23);
		add(btn_mostraLezioni);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 217, 632, 231);
		add(scrollPane);

		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				switch (column) {
				case 0:
					return false;
				case 1:
					return false;
				case 2:
					return false;
				case 3:
					return false;
				case 4:
					return true;
				}
				return false;
			}
		};
		String[] colonne = { "ID", "Nome", "Cognome", "Data", "Presente" };
		model.setColumnIdentifiers(colonne);

		table = new JTable(model) {
			public Class getColumnClass(int colonne) {
				switch (colonne) {
				case 0:
					return int.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return Boolean.class;
				}
				return null;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = (DefaultTableModel) table.getModel();
				int column = table.columnAtPoint(e.getPoint());
				if (column == 4) {
					int row = table.getSelectedRow();
					idStudente = model.getValueAt(row, 0).toString();
					presenza = model.getValueAt(row, 4).toString();

					c.updateAttendanceStudents(textField_codiceCorso.getText(), idStudente, idLezioneSelected, presenza,
							table);
				}
			}
		});
		table.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(table);

		comboBoxCorsi = new JComboBox();
		comboBoxCorsi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				clearFields();
			}
		});
		comboBoxCorsi.setBounds(135, 98, 136, 22);
		add(comboBoxCorsi);
		c.mostraCorsiComboBox(comboBoxCorsi);
		comboBoxCorsi.setSelectedIndex(-1);

		JButton btn_aggiungiCorso = new JButton("Visualizza studenti");
		btn_aggiungiCorso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboBoxLezioni.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Selezionare prima una lezione!", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				} else {
					String lezioneSelected = comboBoxLezioni.getSelectedItem().toString();
					dataLezioneSelected = lezioneSelected.substring(lezioneSelected.lastIndexOf(": ") + 1).strip();
					idLezioneSelected = lezioneSelected
							.substring(lezioneSelected.indexOf("e ") + 1, lezioneSelected.indexOf(" :")).strip();
					mostraTabellaStudentiIscritti();
				}
			}
		});
		btn_aggiungiCorso.setToolTipText("Clicca per visualizzare gli studenti");
		btn_aggiungiCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_aggiungiCorso.setBackground(new Color(255, 165, 0));
		btn_aggiungiCorso.setBounds(326, 162, 136, 21);
		add(btn_aggiungiCorso);
	}

	public void mostraLezioni() {
		if (comboBoxLezioni.getItemCount() > -1) {
			modelComboBox.removeAllElements();
			theController.mostraLezioniComboBox(comboBoxLezioni, textField_codiceCorso.getText());
		}
	}

	public void mostraTabellaStudentiIscritti() {
		if (table.getRowCount() == 0) {
			theController.showStudentEnrolledTable(textField_codiceCorso.getText(), dataLezioneSelected,
					idLezioneSelected, table);
		} else {
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			theController.showStudentEnrolledTable(textField_codiceCorso.getText(), dataLezioneSelected,
					idLezioneSelected, table);
		}
	}

	public void clearFields() {
		if (comboBoxLezioni.getSelectedIndex() >= 0 || table.getRowCount() > 0 || comboBoxLezioni.getItemCount() > -1) {
			modelComboBox.removeAllElements();
			model.setRowCount(0);
		}

	}

}
