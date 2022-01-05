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
		table.setBounds(10, 358, 653, -279);
		add(table);
		
		textField = new JTextField();
		textField.setBounds(82, 410, 101, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNewLabel.setBounds(22, 411, 50, 17);
		add(lblNewLabel);
		
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCognome.setBounds(193, 413, 109, 17);
		add(lblCognome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(291, 412, 101, 20);
		add(textField_1);
		
		JLabel lblDataNascita = new JLabel("Data Nascita : ");
		lblDataNascita.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascita.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataNascita.setBounds(10, 475, 109, 17);
		add(lblDataNascita);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(129, 474, 101, 20);
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
		date_button.setBounds(240,473,27,23);
		add(date_button);
		
		JLabel lblGenere = new JLabel("Genere :");
		lblGenere.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenere.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblGenere.setBounds(283, 475, 109, 17);
		add(lblGenere);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Uomo");
		rdbtnNewRadioButton.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton.setBounds(381, 473, 75, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Donna");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton_1.setBounds(463, 474, 68, 21);
		add(rdbtnNewRadioButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Registrazione");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(232, 11, 197, 28);
		panel.add(lblNewLabel_1);
	}
}
