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
	private JLabel lblLezioniPresenti;
	private Controller theController;
	private JComboBox comboBoxCorsi;
	private JLabel lblMostraStudentiIdonei;
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

		lblMostraStudentiIdonei = new JLabel("Visualizza studenti idonei per : ");
		lblMostraStudentiIdonei.setHorizontalAlignment(SwingConstants.LEFT);
		lblMostraStudentiIdonei.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblMostraStudentiIdonei.setBounds(10, 514, 312, 17);
		add(lblMostraStudentiIdonei);

		JLabel lblDettagliCorso = new JLabel("Dettagli Corso");
		lblDettagliCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDettagliCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDettagliCorso.setBounds(223, 11, 197, 28);
		panel.add(lblDettagliCorso);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 241, 630, 227);
		add(scrollPane);

		TestCellRenderer cell = new TestCellRenderer();
		table = new JTable();
		table.setDefaultRenderer(Object.class, cell);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.convertRowIndexToModel(table.getSelectedRow());
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				lblMostraStudentiIdonei.setText("Visualizza studenti idonei per : "
						+ model.getValueAt(row, 0).toString() + " - " + model.getValueAt(row, 1));
				lblMostraStudentiIdonei.setToolTipText(model.getValueAt(row, 1).toString());
			}
		});
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
		Object[] colonne = { "ID", "Nome corso", "Max studenti a lezione", "Min studenti a lezione", "Media presenze",
				"Data inizio" };
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		TableRowSorter myRowSorter = new TableRowSorter(model);
		table.setRowSorter(myRowSorter);
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
					String codiceCorso = corsoSelected.substring(0,corsoSelected.indexOf(" -"));
					c.getDetailLesson(codiceCorso, textField_NumLezioni, textField_PresenzeObbligatorie);
					c.showNumberOfLessons(lblLezioniPresenti, codiceCorso);
				}
			}
		});
		comboBoxCorsi.setToolTipText("Scegli un corso");
		comboBoxCorsi.setBounds(132, 114, 181, 22);
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
					int numeroPresenze = Integer.parseInt(textField_PresenzeObbligatorie.getText());
					int numeroLezioni = Integer.parseInt(textField_NumLezioni.getText());
					if (numeroPresenze > numeroLezioni) {
						JOptionPane.showMessageDialog(null,
								"Numero presenze obbligatorie è maggiore\n del numero di lezioni!", "Attenzione",
								JOptionPane.WARNING_MESSAGE);
					} else {
						updateDetails();

					}
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

		JButton add_button_1 = new JButton("Mostra");
		add_button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!lblMostraStudentiIdonei.getText().equals("Visualizza studenti idonei per : ")) {
					String corsoSelezionato = lblMostraStudentiIdonei.getText();
					String codiceCorso = corsoSelezionato.substring(corsoSelezionato.lastIndexOf(":") +1,corsoSelezionato.indexOf(" -")).strip();

					StudentiIdoneiJDialog studenti = new StudentiIdoneiJDialog(c, codiceCorso);
					studenti.setVisible(true);

					if (!studenti.isVisible()) {
						lblMostraStudentiIdonei.setText("Visualizza studenti idonei per : ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso dalla tabella!",
							"Attenzione", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		add_button_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		add_button_1.setBackground(new Color(65, 105, 225));
		add_button_1.setBounds(337, 512, 96, 21);
		add(add_button_1);

		JLabel lblselezionaUnCorso = new JLabel(">>Seleziona un corso dalla tabella");
		lblselezionaUnCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblselezionaUnCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblselezionaUnCorso.setBounds(10, 473, 251, 17);
		add(lblselezionaUnCorso);

	}

	public void clearFields() {
		textField_NumLezioni.setText("");
		textField_PresenzeObbligatorie.setText("");
		lblLezioniPresenti.setText("");
		comboBoxCorsi.setSelectedIndex(-1);
		model.setRowCount(0);
		table.clearSelection();
		lblMostraStudentiIdonei.setText("Visualizza studenti idonei per : ");
		lblMostraStudentiIdonei.setToolTipText(null);
	}

	public void showJDialogLesson() {
		if (comboBoxCorsi.getSelectedItem() != null) {
			String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
			String codiceCorso = corsoSelected.substring(0,corsoSelected.indexOf(" -"));
			GestisciLezioneJDialog lezione = new GestisciLezioneJDialog(theController, codiceCorso,table);
			lezione.setVisible(true);
			if (!lezione.isVisible()) {
				theController.showNumberOfLessons(lblLezioniPresenti, codiceCorso);
				mostraTabellaCorsi();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso!", "Attenzione",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void updateDetails() {
		if (comboBoxCorsi.getSelectedItem() != null) {
			String corsoSelected = comboBoxCorsi.getSelectedItem().toString();
			String codiceCorso = corsoSelected.substring(0,corsoSelected.indexOf(" -"));
			if (theController.checkNumberLesson(codiceCorso, lessonCreable, textField_NumLezioni.getText())) {
				theController.updateDetailsCourse(textField_NumLezioni.getText(),
						textField_PresenzeObbligatorie.getText(), codiceCorso);

				comboBoxCorsi.setSelectedIndex(-1);
				textField_NumLezioni.setText("");
				textField_PresenzeObbligatorie.setText("");
				lblLezioniPresenti.setText("");

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
		textField_NumLezioni.setText("");
		textField_PresenzeObbligatorie.setText("");
		lblLezioniPresenti.setText("");
		mostraTabellaCorsi();
	}

	public void setGrandezzaColonneTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
	}
	
	public void mostraTabellaCorsi() {
		if (table.getRowCount() == 0) {
			theController.showCoursesDetails(table);
		} else {
			model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			theController.showCoursesDetails(table);
		}
		setGrandezzaColonneTable();
	}
}
