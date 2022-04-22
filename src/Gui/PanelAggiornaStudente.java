package Gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAggiornaStudente extends JPanel {
	private final JSeparator separator = new JSeparator();
	private JTextField textField_corsoClicked;
	private JTextField textFieldPresenze;
	private JTextField textFieldAssenze;
	private JComboBox comboBoxCorsi;
	private JComboBox comboBoxLezioni;
	private Controller theController;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_nome;
	private JTextField textField_cognome;
	private JTextField textField_codiceCorso;
	private JTextField textField_nomeCorso;
	private JTextField textField_idCorso;
	private JTextField textField_nameCourse;
	DefaultComboBoxModel modelComboBox;

	/**
	 * Create the panel.
	 */
	public PanelAggiornaStudente(Controller c) {
		theController = c;
		setBackground(new Color(255, 215, 0));
		setBounds(0, 56, 673, 525);
		setLayout(null);
		separator.setBounds(0, 480, 673, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(342, 2, 2, 480);
		add(separator_1);

		JLabel lbl_iscrizioneCorsi = new JLabel("Iscrizione ai corsi");
		lbl_iscrizioneCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_iscrizioneCorsi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_iscrizioneCorsi.setBounds(67, 11, 232, 23);
		add(lbl_iscrizioneCorsi);

		JLabel lbl_presenzeAssenze = new JLabel("Dettagli presenze/assenze :");
		lbl_presenzeAssenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_presenzeAssenze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_presenzeAssenze.setBounds(362, 11, 258, 23);
		add(lbl_presenzeAssenze);

		JLabel lbl_corsoClicked = new JLabel("Corso selezionato dalla tabella :");
		lbl_corsoClicked.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_corsoClicked.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_corsoClicked.setBounds(398, 45, 179, 28);
		add(lbl_corsoClicked);

		textField_corsoClicked = new JTextField();
		textField_corsoClicked.setEditable(false);
		textField_corsoClicked.setBounds(424, 84, 131, 20);
		add(textField_corsoClicked);
		textField_corsoClicked.setColumns(10);

		JButton btn_seleziona = new JButton("Mostra");
		btn_seleziona.setBackground(new Color(0, 139, 139));
		btn_seleziona.setBounds(442, 154, 97, 23);
		add(btn_seleziona);

		JLabel lbl_presenze = new JLabel("Presenze :");
		lbl_presenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lbl_presenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_presenze.setBounds(398, 184, 65, 14);
		add(lbl_presenze);

		JLabel lbl_assenze = new JLabel("Assenze :");
		lbl_assenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		lbl_assenze.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_assenze.setBounds(525, 184, 59, 14);
		add(lbl_assenze);

		textFieldPresenze = new JTextField();
		textFieldPresenze.setEditable(false);
		textFieldPresenze.setBounds(409, 209, 43, 20);
		add(textFieldPresenze);
		textFieldPresenze.setColumns(10);

		textFieldAssenze = new JTextField();
		textFieldAssenze.setEditable(false);
		textFieldAssenze.setColumns(10);
		textFieldAssenze.setBounds(534, 209, 43, 20);
		add(textFieldAssenze);

		JLabel lblNewLabel_1_1 = new JLabel("Aggiornamento presenze/assenze :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(362, 240, 275, 23);
		add(lblNewLabel_1_1);

		JRadioButton RadioButtonPresente = new JRadioButton("Presente");
		RadioButtonPresente.setBackground(new Color(255, 215, 0));
		RadioButtonPresente.setBounds(525, 322, 80, 23);
		add(RadioButtonPresente);

		JRadioButton rdbtnAssente = new JRadioButton("Assente");
		rdbtnAssente.setBackground(new Color(255, 215, 0));
		rdbtnAssente.setBounds(523, 289, 97, 23);
		add(rdbtnAssente);

		ButtonGroup group = new ButtonGroup();
		group.add(RadioButtonPresente);
		group.add(rdbtnAssente);

		JLabel lbl_iscriviStudente = new JLabel("Seleziona i corsi per lo studente :");
		lbl_iscriviStudente.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_iscriviStudente.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_iscriviStudente.setBounds(55, 103, 189, 23);
		add(lbl_iscriviStudente);

		comboBoxCorsi = new JComboBox();
		comboBoxCorsi.setBounds(67, 133, 136, 22);
		textField_codiceCorso = new JTextField();
		textField_nomeCorso = new JTextField();
		textField_codiceCorso.setEditable(false);
		textField_nomeCorso.setEditable(false);
		// mostra corsi nella comboBox
		c.mostraCorsiComboBox(comboBoxCorsi);
		add(comboBoxCorsi);

		JButton btn_aggiungiCorso = new JButton("Iscrivi");
		Object[] campiCorso = { "Codice corso", textField_codiceCorso, "Nome corso", textField_nomeCorso };
		btn_aggiungiCorso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String corsoID = comboBoxCorsi.getSelectedItem().toString();
				corsoID = corsoID.replaceAll("[^0-9]", "");
				textField_codiceCorso.setText(corsoID);

				String nomeCorso = comboBoxCorsi.getSelectedItem().toString();
				nomeCorso = nomeCorso.replaceAll("[0-9]", "");
				textField_nomeCorso.setText(nomeCorso);
				int input = JOptionPane.showConfirmDialog(null, campiCorso, "Iscrivere lo studente al corso seguente? ",
						JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					c.addCourseToStudent(comboBoxCorsi, textField_id.getText(), corsoID);
					c.addTableDataStudentToTableView(table, textField_codiceCorso.getText(),
							textField_nomeCorso.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Iscrizione Annullata");
				}
			}
		});
		btn_aggiungiCorso.setToolTipText("Clicca per iscrivere lo studente al corso");
		btn_aggiungiCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_aggiungiCorso.setBackground(new Color(102, 204, 51));
		btn_aggiungiCorso.setBounds(213, 133, 96, 21);
		add(btn_aggiungiCorso);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(55, 195, 254, 186);
		add(scrollPane);

		table = new JTable();
		DefaultTableModel registrationStudent = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setModel(registrationStudent);
		String[] colonne = { "Corso ID", "Nome corso" };
		registrationStudent.setColumnIdentifiers(colonne);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rigaSelected = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				textField_idCorso.setText((model.getValueAt(rigaSelected, 0)).toString());
				textField_nameCourse.setText((model.getValueAt(rigaSelected, 1)).toString());
				textField_corsoClicked.setText((model.getValueAt(rigaSelected, 1)).toString());
				mostraLezioni();
			}
		});
		table.setBackground(new Color(230, 230, 250));

		scrollPane.setViewportView(table);
		JLabel lbl_iscriviStudente_1 = new JLabel("Studente :");
		lbl_iscriviStudente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_iscriviStudente_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_iscriviStudente_1.setBounds(57, 28, 89, 23);
		add(lbl_iscriviStudente_1);

		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(57, 72, 43, 20);
		add(textField_id);
		textField_id.setColumns(10);

		textField_nome = new JTextField();
		textField_nome.setEditable(false);
		textField_nome.setColumns(10);
		textField_nome.setBounds(117, 73, 86, 20);
		add(textField_nome);

		textField_cognome = new JTextField();
		textField_cognome.setEditable(false);
		textField_cognome.setColumns(10);
		textField_cognome.setBounds(213, 73, 86, 20);
		add(textField_cognome);

		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 53, 46, 14);
		add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNome.setBounds(117, 53, 86, 14);
		add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblCognome.setBounds(213, 53, 86, 14);
		add(lblCognome);

		textField_idCorso = new JTextField();
		textField_idCorso.setEditable(false);
		textField_idCorso.setColumns(10);
		textField_idCorso.setBounds(55, 416, 52, 20);
		add(textField_idCorso);

		textField_nameCourse = new JTextField();
		textField_nameCourse.setEditable(false);
		textField_nameCourse.setColumns(10);
		textField_nameCourse.setBounds(117, 416, 86, 20);
		add(textField_nameCourse);

		JButton deleteCourse_button = new JButton("Elimina");
		deleteCourse_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_idCorso.getText().isBlank() && !textField_nameCourse.getText().isBlank()) {
					c.removeTableDataStudent(table, textField_idCorso.getText());
					JOptionPane.showMessageDialog(null, "Icrizione al corso rimossa", "Conferma",
							JOptionPane.INFORMATION_MESSAGE);
					clearTextField();
				}
			}
		});
		deleteCourse_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		deleteCourse_button.setBackground(new Color(255, 127, 80));
		deleteCourse_button.setBounds(213, 415, 73, 21);
		add(deleteCourse_button);

		JLabel lbl_iscriviStudente_2 = new JLabel("Seleziona dalla tabella un'iscrizione da annullare");
		lbl_iscriviStudente_2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_iscriviStudente_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_iscriviStudente_2.setBounds(55, 382, 258, 23);
		add(lbl_iscriviStudente_2);

		JLabel lbl_mostraAssenzePresenze = new JLabel("Clicca per mostrare assenze/presenze");
		lbl_mostraAssenzePresenze.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_mostraAssenzePresenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_mostraAssenzePresenze.setBounds(398, 115, 197, 28);
		add(lbl_mostraAssenzePresenze);

		JLabel lbl_corsiIscritti = new JLabel("Corsi iscritti :");
		lbl_corsiIscritti.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_corsiIscritti.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_corsiIscritti.setBounds(55, 170, 179, 28);
		add(lbl_corsiIscritti);

		comboBoxLezioni = new JComboBox();
		comboBoxLezioni.setBounds(383, 303, 136, 22);
		modelComboBox = new DefaultComboBoxModel();
		comboBoxLezioni.setModel(modelComboBox);
		add(comboBoxLezioni);

		JButton btn_salvaPresenza = new JButton("Salva");
		btn_salvaPresenza.setToolTipText("Clicca per salvare");
		btn_salvaPresenza.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		btn_salvaPresenza.setBackground(new Color(102, 204, 51));
		btn_salvaPresenza.setBounds(383, 349, 96, 21);
		add(btn_salvaPresenza);

		JLabel lbl_lezioni = new JLabel("Seleziona una lezione");
		lbl_lezioni.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_lezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lbl_lezioni.setBounds(383, 274, 115, 28);
		add(lbl_lezioni);

	}

	public void setStudentDetails(String id, String nome, String cognome) {
		textField_id.setText(id);
		textField_nome.setText(nome);
		textField_cognome.setText(cognome);
		showTableData();
	}

	public void showTableData() {
		if (table.getRowCount() == 0)
			theController.showTableDataStudent(textField_id.getText(), table);
	}

	public void clearTableData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		clearTextField();
	}

	public void clearTextField() {
		textField_idCorso.setText("");
		textField_nameCourse.setText("");
		textField_corsoClicked.setText("");
		modelComboBox.removeAllElements();
	}

	public void mostraLezioni() {
		if (comboBoxLezioni.getItemCount() == 0) {
			theController.mostraLezioniComboBox(comboBoxLezioni, textField_idCorso.getText());
		}else
			modelComboBox.removeAllElements();
	}
}
