package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

public class PanelAggiungiStudente extends JPanel {
	private JTextField textField_nome;
	private JTextField textField_cognome;
	private JTextField txtDate;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public PanelAggiungiStudente() {
		setBackground(new Color(255,215,0));
		setLayout(null);
		setSize(673,581);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(10, 331, 101, 20);
		add(textField_nome);
		textField_nome.setColumns(10);
		
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
		
		textField_cognome = new JTextField();
		textField_cognome.setColumns(10);
		textField_cognome.setBounds(10, 404, 101, 20);
		add(textField_cognome);
		
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
		rdbtn_uomo.setActionCommand("Uomo");
		rdbtn_uomo.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtn_uomo.setBackground(new Color(255, 215, 0));
		rdbtn_uomo.setBounds(225, 403, 75, 23);
		add(rdbtn_uomo);
		
		JRadioButton rdbtn_donna = new JRadioButton("Donna");
		rdbtn_donna.setActionCommand("Donna");
		rdbtn_donna.setBackground(new Color(255, 215, 0));
		rdbtn_donna.setBounds(224, 429, 76, 21);
		add(rdbtn_donna);

		ButtonGroup Group = new ButtonGroup();
		Group.add(rdbtn_uomo);
		Group.add(rdbtn_donna);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 165, 0));
		topPanel.setBounds(0, 0, 673, 57);
		add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblRegister = new JLabel("Registrazione");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblRegister.setBounds(232, 11, 197, 28);
		topPanel.add(lblRegister);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 61, 632, 231);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(230, 230, 250));
		model = new DefaultTableModel();
		Object[] colonne = {"ID","Nome","Cognome","Genere","Data Nascita"};
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton insert_button = new JButton("Inserisci");
		insert_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_nome.getText().equals("") || textField_cognome.getText().equals("") || Group.isSelected(null) || txtDate.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Per favore, completa tutti i campi");
				}
				else 
				{
					riga[0] = "id prova";
					riga[1] = textField_nome.getText();
					riga[2] = textField_cognome.getText();
					riga[3] = Group.getSelection().getActionCommand();
					riga[4] = txtDate.getText();
					model.addRow(riga);
					
					riga[0] = "";
					textField_nome.setText("");
					textField_cognome.setText("");
					Group.clearSelection();
					txtDate.setText("");
					JOptionPane.showMessageDialog(null, "Inserimento effettuato");
				}
			
			}
		});
		insert_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		insert_button.setBackground(new Color(51, 153, 204));
		insert_button.setBounds(539, 518, 88, 30);
		add(insert_button);
		

		
		
	}
}
