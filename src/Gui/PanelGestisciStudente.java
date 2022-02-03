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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelGestisciStudente extends JPanel {
	private JTable table;
	private JTextField textFieldNome;
	private JTextField txtCogniome;
	private JTextField txtDate;
	private JTextField txtId;
	DefaultTableModel model;
	private PanelAggiornaStudente panelAggiornaStudente;
	DefaultTableCellRenderer cellRender;
	Image indietro = new ImageIcon(this.getClass().getResource("/Freccia_Icon.png")).getImage();

	/**
	 * Create the panel.
	 */
	public PanelGestisciStudente() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JPanel panel_gestisciStudente = new JPanel();
		panelAggiornaStudente = new PanelAggiornaStudente();
		JButton date_button = new JButton("New button");
		JButton delete_button = new JButton("Elimina");
		JButton update_button = new JButton("Aggiorna");
		
	//	add(panelAggiornaStudente);
	//	panelAggiornaStudente.setVisible(false);
		
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
		
		JLabel lblAggiornaStudente = new JLabel("Aggiorna Studente");
		lblAggiornaStudente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiornaStudente.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblAggiornaStudente.setBounds(223, 11, 197, 28);
		panel.add(lblAggiornaStudente);
		
		JPanel panel_indietro = new JPanel();
		panel_indietro.setBackground(new Color(245, 245, 245));
		panel_indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panelAggiornaStudente.setVisible(false);
				
				panel_gestisciStudente.setVisible(true);
				
				lblAggiornaStudente.setVisible(false);
				lblGestioneStudenti.setVisible(true);
				panel_indietro.setVisible(false);

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
				int rigaSelected = table.getSelectedRow();
				textFieldNome.setText((model.getValueAt(rigaSelected, 0)).toString());
				txtCogniome.setText((model.getValueAt(rigaSelected, 1)).toString());
				txtDate.setText((model.getValueAt(rigaSelected, 2)).toString());
				txtId.setText((model.getValueAt(rigaSelected, 3)).toString());
			}
		});
		table.setEnabled(false);
		table.setBackground(new Color(230, 230, 250));
		model = new DefaultTableModel() {
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Object[] colonne = {"ID","Nome","Cognome","Data Nascita","Genere"};
		Object[] riga = new Object[5];
		model.setColumnIdentifiers(colonne);
		
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNome.setBounds(33, 370, 50, 17);
		panel_gestisciStudente.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(33, 394, 101, 20);
		panel_gestisciStudente.add(textFieldNome);
		
		JLabel lblCognome = new JLabel("Cognome :");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCognome.setBounds(33, 438, 75, 17);
		panel_gestisciStudente.add(lblCognome);
		
		txtCogniome = new JTextField();
		txtCogniome.setColumns(10);
		txtCogniome.setBounds(33, 466, 101, 20);
		panel_gestisciStudente.add(txtCogniome);
		
		JLabel lblDataNascita = new JLabel("Data Nascita : ");
		lblDataNascita.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataNascita.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataNascita.setBounds(236, 370, 89, 17);
		panel_gestisciStudente.add(lblDataNascita);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(236, 394, 119, 20);
		panel_gestisciStudente.add(txtDate);
		
		
		date_button.setBackground(new Color(255, 215, 0));
		date_button.setBounds(365, 393, 27, 23);
		panel_gestisciStudente.add(date_button);
		date_button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame f = new JFrame();
				txtDate.setText(new DatePicker(f).setPickedDate());
			}
	
		});
		
		
		update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textFieldNome.getText().equals("admin") && txtCogniome.getText().equals("admin")
						&& txtDate.getText().equals("25-01-2022")&& txtId.getText().equals("abc123")) {
					
					add(panelAggiornaStudente);
					
				setAggiorna(panelAggiornaStudente);
				
				panel_gestisciStudente.setVisible(false);
				
				lblAggiornaStudente.setVisible(true);
				lblGestioneStudenti.setVisible(false);
				panel_indietro.setVisible(true);
				
				}
				else if(textFieldNome.getText().equals("") || txtCogniome.getText().equals("")
						|| txtDate.getText().equals("")|| txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, " Inserire tutti i campi ");
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Inserimento non valido ");
				}
				
			
			
				
				
			}
		});
		update_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		update_button.setBackground(new Color(255, 51, 51));
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
		txtId.setBounds(236, 466, 119, 20);
		panel_gestisciStudente.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertiscioi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				riga[0] = txtId.getText();
				riga[1] = textFieldNome.getText();
				riga[2] = txtCogniome.getText();
				riga[3] = txtDate.getText();
				model.addRow(riga);
				
				riga[0] = "";
				textFieldNome.setText("");
				txtCogniome.setText("");
				txtDate.setText("");
				txtId.setText("");
		}
	});
		btnNewButton.setBounds(434, 427, 89, 23);
		panel_gestisciStudente.add(btnNewButton);
		
	}
	
	public void setAggiorna(JPanel aggiornaPanel) {
		panelAggiornaStudente.setVisible(false);
		
		
		aggiornaPanel.setVisible(true);
		
}
	
}