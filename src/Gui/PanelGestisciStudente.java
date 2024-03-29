package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class PanelGestisciStudente extends JPanel {
	private Controller theController;
	private JTable table;
	private JTextField textFieldNome;
	private JTextField txtCognome;
	private JTextField txtDate;
	private JTextField txtId;
	private DefaultTableModel model;
	private PanelDettagliStudente panelDettagliStudente;
	private JLabel lblGestioneStudenti;
	private JLabel lblAggiornaStudente;
	private JPanel panel_indietro;
	private JPanel panel_gestisciStudente;
	DefaultTableCellRenderer cellRender;
	Image indietro = new ImageIcon(this.getClass().getResource("/Freccia_Icon.png")).getImage();

	/**
	 * Create the panel.
	 */
	public PanelGestisciStudente(Controller c) {

		theController = c;
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 673, 581);

		panel_gestisciStudente = new JPanel();
		panelDettagliStudente = new PanelDettagliStudente(c);
		JButton update_button = new JButton("Dettagli");
		update_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldNome.getText().isBlank() && !txtCognome.getText().isBlank() && !txtDate.getText().isBlank()
						&& !txtId.getText().isBlank()) {
				panelDettagliStudente.showElementsPanelDettagliStudente();
				panelDettagliStudente.setStudentDetails(txtId.getText(), textFieldNome.getText(), txtCognome.getText());
				}
			}
		});
		JButton delete_button = new JButton("Elimina");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					int rigaPressedModel = table.convertRowIndexToModel(row);
					int input = JOptionPane.showConfirmDialog(null, "Vuoi procedere?", "Seleziona un'opzione",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (input == JOptionPane.YES_OPTION) {
						c.deleteStudent(table);
						clearFields();
						JOptionPane.showMessageDialog(null, "Studente eliminato correttamente", "Conferma",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Eliminazione non eseguita", "Conferma",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Per favore, seleziona prima uno studente", "Attenzione",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);

		lblGestioneStudenti = new JLabel("Gestione Studenti");
		lblGestioneStudenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneStudenti.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneStudenti.setBounds(223, 11, 197, 28);
		panel.add(lblGestioneStudenti);

		lblAggiornaStudente = new JLabel("Dettagli Studente");
		lblAggiornaStudente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiornaStudente.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblAggiornaStudente.setBounds(223, 11, 197, 28);
		panel.add(lblAggiornaStudente);

		panel_indietro = new JPanel();
		panel_indietro.setBackground(new Color(245, 245, 245));
		panel_indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelDettagliStudente.setVisible(false);
				panel_gestisciStudente.setVisible(true);
				lblAggiornaStudente.setVisible(false);
				lblGestioneStudenti.setVisible(true);
				panel_indietro.setVisible(false);
				panelDettagliStudente.clearTableData();
				panelDettagliStudente.clearTextField();

			}
		});
		panel_indietro.setBounds(39, 18, 74, 19);
		panel.add(panel_indietro);
		panel_indietro.setLayout(null);
		panel_indietro.setVisible(false);

		JLabel lblNewLabel = new JLabel("Indietro");
		lblNewLabel.setBounds(20, 3, 56, 14);
		panel_indietro.add(lblNewLabel);

		JLabel lblFreccia = new JLabel("");
		lblFreccia.setBounds(0, 3, 18, 14);
		lblFreccia.setIcon(new ImageIcon(indietro));
		panel_indietro.add(lblFreccia);

		panel_gestisciStudente.setBackground(new Color(255, 215, 0));
		panel_gestisciStudente.setBounds(0, 56, 673, 525);
		panel_gestisciStudente.setLayout(null);
		add(panel_gestisciStudente);

		lblAggiornaStudente.setVisible(false);
		panel_gestisciStudente.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 61, 632, 231);
		panel_gestisciStudente.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rigaSelected = table.convertRowIndexToModel(table.getSelectedRow());
				StudenteTableModel model = (StudenteTableModel) table.getModel();
				txtId.setText((model.getValueAt(rigaSelected, 0)).toString());
				textFieldNome.setText((model.getValueAt(rigaSelected, 1)).toString());
				txtCognome.setText((model.getValueAt(rigaSelected, 2)).toString());
				txtDate.setText((model.getValueAt(rigaSelected, 3)).toString());

			}
		});
		table.setBackground(new Color(230, 230, 250));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNome.setBounds(33, 370, 50, 17);
		panel_gestisciStudente.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(33, 394, 101, 20);
		panel_gestisciStudente.add(textFieldNome);

		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCognome.setBounds(33, 438, 75, 17);
		panel_gestisciStudente.add(lblCognome);

		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(33, 466, 101, 20);
		panel_gestisciStudente.add(txtCognome);

		JLabel lblDataNascita = new JLabel("Data Nascita : ");
		lblDataNascita.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascita.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataNascita.setBounds(236, 370, 89, 17);
		panel_gestisciStudente.add(lblDataNascita);

		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(236, 394, 119, 20);
		panel_gestisciStudente.add(txtDate);

		update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldNome.getText().isBlank() || txtCognome.getText().isBlank() || txtDate.getText().isBlank()
						|| txtId.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Selezionare studente dalla tabella!", "Attenzione!",
							JOptionPane.WARNING_MESSAGE);

				} else {
					panel_gestisciStudente.setVisible(false);
					lblAggiornaStudente.setVisible(true);
					lblGestioneStudenti.setVisible(false);
					panel_indietro.setVisible(true);

					add(panelDettagliStudente);
					setAggiorna(panelDettagliStudente);
					table.clearSelection();
					clearFields();
				}
			}
		});
		update_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		update_button.setBackground(new Color(50, 205, 50));
		update_button.setBounds(434, 461, 89, 29);
		panel_gestisciStudente.add(update_button);

		delete_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		delete_button.setBackground(new Color(255, 51, 0));
		delete_button.setBounds(533, 461, 89, 29);
		panel_gestisciStudente.add(delete_button);

		JLabel numberID = new JLabel("Studente Id :");
		numberID.setHorizontalAlignment(SwingConstants.LEFT);
		numberID.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		numberID.setBounds(236, 438, 101, 17);
		panel_gestisciStudente.add(numberID);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(236, 466, 119, 20);
		panel_gestisciStudente.add(txtId);
		txtId.setColumns(10);

	}

	public void setAggiorna(JPanel aggiornaPanel) {
		panelDettagliStudente.setVisible(false);
		aggiornaPanel.setVisible(true);
		}

	public void setGrandezzaColonneTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(cellRender);
	}

	public void clearFields() {
		if (!txtId.getText().isBlank() || !textFieldNome.getText().isBlank() || !txtCognome.getText().isBlank()
				|| !txtDate.getText().isBlank()) {
			txtId.setText("");
			textFieldNome.setText("");
			txtCognome.setText("");
			txtDate.setText("");
			table.clearSelection();
		}
	}

	public void showElementsPanelGestisciStudente() {
		theController.displayStudent(table);
	}
	
	public void resetDettagli() {
		if(panelDettagliStudente.isVisible()) {
			panelDettagliStudente.setVisible(false);
			panel_gestisciStudente.setVisible(true);
			lblAggiornaStudente.setVisible(false);
			lblGestioneStudenti.setVisible(true);
			panel_indietro.setVisible(false);
		}

	}

}