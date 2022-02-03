package Gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class PanelAggiornaStudente extends JPanel {
	private final JSeparator separator = new JSeparator();
	private JTextField textField;
	private JTextField textFieldPresenze;
	private JTextField textFieldAssenze;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelAggiornaStudente() {
		setBackground(new Color(255, 215, 0));
		setBounds(0, 56, 673, 525);
		setLayout(null);
		separator.setBounds(10, 428, 673, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(335, 2, 2, 428);
		add(separator_1);
		
		JButton btnNewButton = new JButton("Salva");
		btnNewButton.setBounds(293, 441, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Aggiorna partecipazione corsi :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(47, 11, 232, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dettagli presenze/assenze :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(362, 11, 258, 23);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Inserire il corso :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(417, 59, 160, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(424, 84, 150, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Seleziona");
		btnNewButton_1.setBounds(449, 115, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Presenze :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(398, 156, 65, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Assenze :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(518, 156, 59, 14);
		add(lblNewLabel_4);
		
		textFieldPresenze = new JTextField();
		textFieldPresenze.setBounds(408, 178, 43, 20);
		add(textFieldPresenze);
		textFieldPresenze.setColumns(10);
		
		textFieldAssenze = new JTextField();
		textFieldAssenze.setColumns(10);
		textFieldAssenze.setBounds(525, 178, 43, 20);
		add(textFieldAssenze);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aggiornamento presenze/assenze :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(362, 226, 275, 23);
		add(lblNewLabel_1_1);
		
		JRadioButton RadioButtonPresente = new JRadioButton("Presenze");
		RadioButtonPresente.setBackground(new Color(255, 215, 0));
		RadioButtonPresente.setBounds(398, 289, 80, 23);
		add(RadioButtonPresente);
		
		JRadioButton rdbtnAssente = new JRadioButton("Assenze");
		rdbtnAssente.setBackground(new Color(255, 215, 0));
		rdbtnAssente.setBounds(523, 289, 97, 23);
		add(rdbtnAssente);
		
		ButtonGroup group = new ButtonGroup();
		group.add(RadioButtonPresente);
		group.add(rdbtnAssente);
		
		JLabel lblNewLabel_5 = new JLabel("Aggiungi corso :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(47, 59, 94, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Elimina corso :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(57, 87, 84, 14);
		add(lblNewLabel_6);
		
		table = new JTable();
		table.setBounds(72, 142, 214, 142);
		add(table);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 56, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 84, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}
}
