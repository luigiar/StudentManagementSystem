package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class PanelAggiungiStudente extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDate;

	/**
	 * Create the panel.
	 */
	public PanelAggiungiStudente() {
		setBackground(new Color(255,215,0));
		setLayout(null);
		setSize(673,581);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Genere", "Data Nascita", "Cognome", "Nome", "StudenteID"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(new Color(255, 215, 0));
		table.setBounds(10, 289, 653, -230);
		add(table);
		
		textField = new JTextField();
		textField.setBounds(10, 331, 101, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNome.setBounds(10, 303, 50, 17);
		add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCognome.setBounds(10, 376, 88, 17);
		add(lblCognome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 404, 101, 20);
		add(textField_1);
		
		JLabel lblDataNascita = new JLabel("Data Nascita : ");
		lblDataNascita.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataNascita.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataNascita.setBounds(215, 303, 96, 17);
		add(lblDataNascita);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(215, 331, 101, 20);
		add(txtDate);
		
		JButton date_button = new JButton("New button");
		date_button.setBackground(new Color(255, 215, 0));
		
		date_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtDate.setText(new DatePicker(f).setPickedDate());
			}
	
		});
		date_button.setBounds(326,330,27,23);
		add(date_button);
		
		JLabel lblGenere = new JLabel("Genere :");
		lblGenere.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenere.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblGenere.setBounds(215, 376, 68, 17);
		add(lblGenere);
		
		JRadioButton rdbtn_uomo = new JRadioButton("Uomo");
		rdbtn_uomo.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_uomo.setBackground(new Color(255, 215, 0));
		rdbtn_uomo.setBounds(225, 403, 75, 23);
		add(rdbtn_uomo);
		
		JRadioButton rdbtn_donna = new JRadioButton("Donna");
		rdbtn_donna.setBackground(new Color(255, 215, 0));
		rdbtn_donna.setBounds(224, 429, 76, 21);
		add(rdbtn_donna);

		ButtonGroup Group = new ButtonGroup();
		Group.add(rdbtn_uomo);
		Group.add(rdbtn_donna);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblRegister = new JLabel("Registrazione");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblRegister.setBounds(232, 11, 197, 28);
		panel.add(lblRegister);
		
		JButton insert_button = new JButton("Inserisci");
		insert_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		insert_button.setBackground(new Color(51, 153, 204));
		insert_button.setBounds(539, 518, 96, 29);
		add(insert_button);
	}
}
