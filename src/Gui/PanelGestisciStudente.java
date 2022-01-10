package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class PanelGestisciStudente extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDate;
	private JTextField txtId;

	/**
	 * Create the panel.
	 */
	public PanelGestisciStudente() {
		setBackground(new Color(255, 215, 0));
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		
		JLabel lblGestioneStudenti = new JLabel("Gestione Studenti");
		lblGestioneStudenti.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneStudenti.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneStudenti.setBounds(223, 11, 197, 28);
		panel.add(lblGestioneStudenti);
		
		table = new JTable();
		table.setBackground(new Color(255, 215, 0));
		table.setBounds(10, 323, 653, -266);
		add(table);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNome.setBounds(10, 327, 50, 17);
		add(lblNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 345, 101, 20);
		add(textField);
		
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCognome.setBounds(10, 376, 75, 17);
		add(lblCognome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 395, 101, 20);
		add(textField_1);
		
		JLabel lblDataNascita = new JLabel("Data Nascita : ");
		lblDataNascita.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascita.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataNascita.setBounds(247, 327, 89, 17);
		add(lblDataNascita);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(247, 345, 119, 20);
		add(txtDate);
		
		JButton date_button = new JButton("New button");
		date_button.setBackground(new Color(255, 215, 0));
		date_button.setBounds(376, 344, 27, 23);
		add(date_button);
		date_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtDate.setText(new DatePicker(f).setPickedDate());
			}
	
		});
		
		JLabel lblGenere = new JLabel("Genere :");
		lblGenere.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenere.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblGenere.setBounds(20, 426, 75, 17);
		add(lblGenere);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Uomo");
		rdbtnNewRadioButton.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton.setBounds(20, 450, 65, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Donna");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 215, 0));
		rdbtnNewRadioButton_1.setBounds(20, 476, 68, 21);
		add(rdbtnNewRadioButton_1);
		
		JButton clear_button = new JButton("Pulisci");
		clear_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		clear_button.setBackground(new Color(255, 255, 51));
		clear_button.setBounds(337, 521, 89, 29);
		add(clear_button);
		
		JButton update_button = new JButton("Aggiorna");
		update_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		update_button.setBackground(new Color(255, 51, 51));
		update_button.setBounds(436, 521, 89, 29);
		add(update_button);
		
		JButton delete_button = new JButton("Elimina");
		delete_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		delete_button.setBackground(new Color(255, 51, 0));
		delete_button.setBounds(535, 521, 89, 29);
		add(delete_button);
		
		JLabel numberID = new JLabel("Studente Id :");
		numberID.setHorizontalAlignment(SwingConstants.LEFT);
		numberID.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		numberID.setBounds(247, 376, 101, 17);
		add(numberID);
		
		txtId = new JTextField();
		txtId.setBounds(247, 395, 119, 20);
		add(txtId);
		txtId.setColumns(10);

	}
}