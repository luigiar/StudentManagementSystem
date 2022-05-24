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
import javax.swing.JTextArea;

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
	private JTextField textField_titoloLezione;
	private JTextField textField_durataLezione;
	private JTextField textField_oraInizio;
	private JTextArea textArea_descrizione;

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
		lbl_lezioni.setBounds(10, 153, 115, 22);
		add(lbl_lezioni);

		comboBoxLezioni = new JComboBox();
		comboBoxLezioni.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				model.setRowCount(0);
				if (comboBoxLezioni.getSelectedItem() != null) {
					String lezioneSelected = comboBoxLezioni.getSelectedItem().toString();
					idLezioneSelected = lezioneSelected
							.substring(lezioneSelected.indexOf("D ") + 1, lezioneSelected.indexOf(" :")).strip();
					c.showLessonElements(idLezioneSelected, textField_titoloLezione, textArea_descrizione,
							textField_durataLezione, textField_oraInizio);
				}
			}
		});
		comboBoxLezioni.setBounds(145, 154, 163, 22);
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
		btn_mostraLezioni.setBounds(325, 98, 75, 23);
		add(btn_mostraLezioni);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 197, 632, 210);
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
		comboBoxCorsi.setBounds(135, 98, 163, 22);
		add(comboBoxCorsi);
		table.getTableHeader().setReorderingAllowed(false);

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
							.substring(lezioneSelected.indexOf("D ") + 1, lezioneSelected.indexOf(" :")).strip();
					mostraTabellaStudentiIscritti();
				}
			}
		});
		btn_aggiungiCorso.setToolTipText("Clicca per visualizzare gli studenti");
		btn_aggiungiCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_aggiungiCorso.setBackground(new Color(255, 165, 0));
		btn_aggiungiCorso.setBounds(325, 154, 136, 21);
		add(btn_aggiungiCorso);

		JLabel label_dettagliLezione = new JLabel("Dettagli della lezione selezionata");
		label_dettagliLezione.setHorizontalAlignment(SwingConstants.LEFT);
		label_dettagliLezione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		label_dettagliLezione.setBounds(10, 411, 236, 23);
		add(label_dettagliLezione);

		JLabel lblTitoloLezione = new JLabel("Titolo :");
		lblTitoloLezione.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitoloLezione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblTitoloLezione.setBounds(20, 445, 67, 17);
		add(lblTitoloLezione);

		textField_titoloLezione = new JTextField();
		textField_titoloLezione.setColumns(10);
		textField_titoloLezione.setBounds(95, 445, 151, 20);
		add(textField_titoloLezione);

		JLabel lblDurataLezione = new JLabel("Durata Lezione :");
		lblDurataLezione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurataLezione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDurataLezione.setBounds(346, 445, 115, 17);
		add(lblDurataLezione);

		textField_durataLezione = new JTextField();
		textField_durataLezione.setColumns(10);
		textField_durataLezione.setBounds(471, 444, 86, 20);
		add(textField_durataLezione);

		JLabel lblDescrizione = new JLabel("Descrizione : ");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(20, 489, 79, 17);
		add(lblDescrizione);

		JLabel lblOraInizio = new JLabel("Ora inizio :");
		lblOraInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblOraInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOraInizio.setBounds(346, 491, 93, 17);
		add(lblOraInizio);

		textField_oraInizio = new JTextField();
		textField_oraInizio.setToolTipText("hh:mm");
		textField_oraInizio.setColumns(10);
		textField_oraInizio.setBounds(471, 488, 86, 20);
		add(textField_oraInizio);

		JScrollPane scrollPane_descrizione = new JScrollPane();
		scrollPane_descrizione.setBounds(105, 482, 170, 57);
		add(scrollPane_descrizione);

		textArea_descrizione = new JTextArea();
		textArea_descrizione.setLineWrap(true);
		scrollPane_descrizione.setViewportView(textArea_descrizione);

		JLabel lblDuration = new JLabel("h.");
		lblDuration.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuration.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDuration.setBounds(567, 445, 55, 17);
		add(lblDuration);
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
			textField_titoloLezione.setText("");
			textArea_descrizione.setText("");
			textField_durataLezione.setText("");
			textField_oraInizio.setText("");
		}

	}

	public void showElementsPanelAttendance() {
		comboBoxCorsi.removeAllItems();
		theController.mostraCorsiComboBox(comboBoxCorsi);
		comboBoxCorsi.setSelectedIndex(-1);
	}
}
