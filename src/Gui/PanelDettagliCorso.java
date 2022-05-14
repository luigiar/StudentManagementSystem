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
import javax.swing.table.TableRowSorter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelDettagliCorso extends JPanel {
	private JTextField textField_NumLezioni;
	private JTextField textField_PresenzeObbligatorie;
	Image search = new ImageIcon(this.getClass().getResource("/searchImm.png")).getImage();
	private JTextField textField_cercaCorso;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableCellRenderer cellRender;
	private JLabel lblLezioniPresenti;
	private Controller theController;
	private JComboBox comboBoxCorsi;
	private boolean lessonCreable = false;

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
		scrollPane.setBounds(10, 241, 620, 227);
		add(scrollPane);

		table = new JTable();
		table.setBounds(10, 221, 612, -209);
		table.setBackground(new Color(230, 230, 250));
		table.getTableHeader().setReorderingAllowed(false);
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		Object[] colonne = { "Nome corso", "Max studenti a lezione", "Min studenti a lezione", "Riempimento medio",
				"Data inizio" };
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		TableRowSorter myRowSorter = new TableRowSorter(model);
		table.setRowSorter(myRowSorter);
		model.addRow(new Object[] { "Medicina", "60", "30", "25%", "2022-05-14" });
		model.addRow(new Object[] { "Areonautica", "50", "20", "30%", "2022-05-13" });
		model.addRow(new Object[] { "Parkour", "100", "80", "60%", "2022-05-12" });
		model.addRow(new Object[] { "Storia", "20", "10", "20%", "2022-05-11" });
		model.addRow(new Object[] { "Educazione Sessuale", "30", "25", "50%", "2022-05-09" });
		model.addRow(new Object[] { "Pullappare", "60", "40", "35%", "2022-05-07" });
		model.addRow(new Object[] { "Salto della corda", "100", "60", "80%", "2022-05-06" });
		scrollPane.setViewportView(table);

		JLabel lblSelezionaCorso = new JLabel("Seleziona corso :");
		lblSelezionaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelezionaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblSelezionaCorso.setBounds(10, 116, 112, 17);
		add(lblSelezionaCorso);

		comboBoxCorsi = new JComboBox();
		comboBoxCorsi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxCorsi.getSelectedIndex() != -1) {
					String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
					String codiceCorso = corsoSelected.replaceAll("[^0-9]", "");
					c.showDetailLesson(codiceCorso, textField_NumLezioni, textField_PresenzeObbligatorie);
					c.showNumberOfLessons(lblLezioniPresenti, codiceCorso);
				}
			}
		});
		comboBoxCorsi.setToolTipText("Scegli un corso");
		comboBoxCorsi.setBounds(132, 114, 145, 22);
		add(comboBoxCorsi);

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

		JButton button_GestisciLezione = new JButton();
		button_GestisciLezione.setToolTipText("Clicca per aggiungere una lezione");
		button_GestisciLezione.setText(" ...");
		button_GestisciLezione.setBounds(195, 156, 22, 17);
		button_GestisciLezione.setBackground(new Color(255, 165, 0));
		add(button_GestisciLezione);
		button_GestisciLezione.setLayout(null);
		button_GestisciLezione.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showJDialogLesson();
			}
		});

		lblLezioniPresenti = new JLabel("");
		lblLezioniPresenti.setHorizontalAlignment(SwingConstants.LEFT);
		lblLezioniPresenti.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblLezioniPresenti.setBounds(228, 158, 117, 17);
		add(lblLezioniPresenti);

		textField_cercaCorso = new JTextField();
		textField_cercaCorso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String cercaTesto = textField_cercaCorso.getText();
				myRowSorter.setRowFilter(new TableRowFilter(cercaTesto));
			}
		});
		textField_cercaCorso.setBounds(195, 201, 181, 22);
		add(textField_cercaCorso);
		textField_cercaCorso.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 0));
		separator.setBackground(new Color(255, 255, 0));
		separator.setBounds(0, 188, 673, 2);
		add(separator);

		JButton add_button = new JButton("Salva");
		add_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField_NumLezioni.getText().isBlank() || textField_PresenzeObbligatorie.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Completa prima tutti i campi!", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				} else {
					updateDetails();
					comboBoxCorsi.setSelectedIndex(-1);
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
		
				JLabel lblCercaCorso = new JLabel("Cerca Corso");
				add(lblCercaCorso);
				
						lblCercaCorso.setHorizontalAlignment(SwingConstants.LEFT);
						lblCercaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
						lblCercaCorso.setBounds(74, 200, 90, 30);
						
								JLabel lblSearch = new JLabel("");
								add(lblSearch);
								lblSearch.setBounds(26, 200, 42, 30);
								lblSearch.setIcon(new ImageIcon(search));

	}

	public void clearFields() {
		textField_NumLezioni.setText("");
		textField_PresenzeObbligatorie.setText("");
		lblLezioniPresenti.setText("");
		comboBoxCorsi.setSelectedIndex(-1);
	}

	public void showJDialogLesson() {
		if (comboBoxCorsi.getSelectedItem() != null) {
			String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
			String codiceCorso = corsoSelected.replaceAll("[^0-9]", "");
			GestisciLezioneJDialog lezione = new GestisciLezioneJDialog(theController, codiceCorso);
			lezione.setVisible(true);
			if (!lezione.isVisible()) {
				clearFields();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso!", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void updateDetails() {
		if (comboBoxCorsi.getSelectedItem() != null) {
			String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
			String codiceCorso = corsoSelected.replaceAll("[^0-9]", "");
			if (theController.checkNumberLesson(codiceCorso, lessonCreable, textField_NumLezioni.getText())) {
				theController.updateDetailsCourse(textField_NumLezioni.getText(),
						textField_PresenzeObbligatorie.getText(), codiceCorso);

			} else {
				JOptionPane.showMessageDialog(null,
						"Il numero delle lezioni inserito \nè inferiore di quelle già presenti.", "Attenzione",
						JOptionPane.WARNING_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso!", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void showElementsPanelDettagliCorso() {
		comboBoxCorsi.removeAllItems();
		theController.mostraCorsiComboBox(comboBoxCorsi);
		comboBoxCorsi.setSelectedIndex(-1);
		clearFields();
	}
}
