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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import java.awt.Point;

import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class PanelAggiungiCorso extends JPanel {
	private JTextField textField_nomeCorso;
	private JTextField textField_maxPartecipanti;
	private JTable table;
	private JComboBox comboBox;
	private JTextArea textArea_descrizione;
	DefaultTableCellRenderer cellRender;
	private Controller theController;
	CourseTableModel modelCourse;
	private JLabel lblDataInizio;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public PanelAggiungiCorso(Controller c) {
		theController = c;
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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 68, 632, 213);
		add(scrollPane);

		TestCellRenderer cell = new TestCellRenderer();

		table = new JTable();
		table.setDefaultRenderer(Object.class, cell);
		table.setBackground(new Color(230, 230, 250));
		table.setBounds(10, 221, 612, -209);
		table.getTableHeader().setReorderingAllowed(false);

		scrollPane.setViewportView(table);

		JLabel lblNomeCorso = new JLabel("Nome Corso :");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNomeCorso.setBounds(20, 318, 101, 17);
		add(lblNomeCorso);

		textField_nomeCorso = new JTextField();
		textField_nomeCorso.setColumns(10);
		textField_nomeCorso.setBounds(20, 345, 120, 20);
		add(textField_nomeCorso);

		JLabel lblDescrizione = new JLabel("Descrizione :");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(20, 442, 101, 17);
		add(lblDescrizione);

		JScrollPane scrollPane_descrizione = new JScrollPane();
		scrollPane_descrizione.setBounds(20, 470, 252, 66);
		add(scrollPane_descrizione);

		textArea_descrizione = new JTextArea();
		scrollPane_descrizione.setViewportView(textArea_descrizione);
		textArea_descrizione.setLineWrap(true);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(235, 404, 128, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEditable(false);
		add(dateChooser);
		
		JButton insert_button = new JButton("Inserisci");
		insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_nomeCorso.getText().isBlank() || comboBox.getSelectedItem().equals("---Seleziona Area")
						|| textField_maxPartecipanti.getText().isBlank() || textArea_descrizione.getText().isBlank()
						|| comboBox.getSelectedItem().equals("Aggiungi Area")
						|| editor.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Per favore, completa tutti i campi!", "Errore",
							JOptionPane.ERROR_MESSAGE);
				} else {

					c.insertCourse(textField_nomeCorso.getText(), textArea_descrizione.getText(),
							textField_maxPartecipanti.getText(), comboBox.getSelectedItem().toString(), editor.getText());

					c.addCourseToTableView(table, textField_nomeCorso, textField_maxPartecipanti, comboBox,
							textArea_descrizione);
					setGrandezzaColonneTable();
					clearTextField();

				}

			}
		});
		insert_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		insert_button.setBackground(new Color(51, 153, 204));
		insert_button.setBounds(546, 521, 96, 29);
		add(insert_button);

		JLabel lblAreaTematica = new JLabel("Area Tematica :");
		lblAreaTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblAreaTematica.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAreaTematica.setBounds(235, 320, 109, 17);
		add(lblAreaTematica);

		comboBox = new JComboBox();
		comboBox.setToolTipText("Seleziona un'area tematica per il corso");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---Seleziona Area", "Aggiungi Area"}));
		comboBox.setBounds(235, 344, 139, 21);
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Aggiungi Area")) {
					String itemAdd = JOptionPane.showInputDialog(null, "Inserisci l'area tematica da aggiungere");
					if (itemAdd == null) {
						JOptionPane.showMessageDialog(null, "Inserimento non eseguito!", "Attenzione",
								JOptionPane.WARNING_MESSAGE);

					} else if (itemAdd.equals("") || String.valueOf(itemAdd).isBlank()) {
						JOptionPane.showMessageDialog(null, "Inserimento non eseguito!", "Attenzione",
								JOptionPane.WARNING_MESSAGE);
					} else
						comboBox.addItem(itemAdd);

				}
			}
		});


		JButton addArea_button = new JButton("Aggiungi");
		addArea_button.setToolTipText("Seleziona un corso e aggiungi un'area");
		addArea_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					int rigaPressed = table.convertRowIndexToModel(row);
					if (comboBox.getSelectedItem().toString().equals("---Seleziona Area")
							|| comboBox.getSelectedItem().toString().equals("Aggiungi Area")) {
						JOptionPane.showMessageDialog(null, "Inserimento non valido!", "Errore",
								JOptionPane.ERROR_MESSAGE);
					} else {
						CourseTableModel model = (CourseTableModel) table.getModel();
						String valoreCorrente = model.getValueAt(rigaPressed, 3).toString();
						String idCorsoClicked = model.getValueAt(rigaPressed, 0).toString();
						model.setValueAt(comboBox.getSelectedItem(), rigaPressed, 3);
						String valoreAggiunto = model.getValueAt(rigaPressed, 3).toString();
						valoreCorrente = valoreCorrente.concat(valoreAggiunto.indent(2));
						model.setValueAt(valoreCorrente, rigaPressed, 3);
						c.updateAreaTematica(valoreCorrente, idCorsoClicked);
						setGrandezzaColonneTable();
						
						JOptionPane.showMessageDialog(null, "Area tematica aggiunta con successo", "Conferma",
								JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedIndex(0);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima un corso", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
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
		
		
		lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(235, 378, 120, 17);
		add(lblDataInizio);

	}

	public void clearTextField() {
		if (!textField_nomeCorso.getText().isBlank() || !textField_maxPartecipanti.getText().isBlank()
				|| !textArea_descrizione.getText().isBlank() || !dateChooser.equals(null)) {

			textField_nomeCorso.setText("");
			textField_maxPartecipanti.setText("");
			textArea_descrizione.setText("");
			dateChooser.setCalendar(null);
		}
		table.clearSelection();
	}

	public void setGrandezzaColonneTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
	}
	
	public void showElementsPanelAggiungiCorso() {
		theController.displayCourse(table);
		setGrandezzaColonneTable();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---Seleziona Area", "Aggiungi Area"}));
		theController.mostraAreeComboBox(comboBox);
	}
}
