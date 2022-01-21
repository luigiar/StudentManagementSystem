package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class PanelDettagliCorso extends JPanel {
	private JTextField textField_OreTotali;
	private JTextField textField_NumLezioni;
	private JTextField textField_OreObbligatorie;
	Image search = new ImageIcon(this.getClass().getResource("/searchImm.png")).getImage();
	private JTextField textField_DataInizio;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelDettagliCorso() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		setBackground(new Color(255, 215, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 673, 57);
		add(panel);
		
		JLabel lblDettagliCorso = new JLabel("Dettagli Corso");
		lblDettagliCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblDettagliCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDettagliCorso.setBounds(223, 11, 197, 28);
		panel.add(lblDettagliCorso);
		
		JLabel lblSelezionaCorso = new JLabel("Seleziona Corso :");
		lblSelezionaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelezionaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblSelezionaCorso.setBounds(10, 82, 112, 17);
		add(lblSelezionaCorso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(132, 80, 116, 22);
		add(comboBox);
		
		JLabel lblOreTotali = new JLabel("Ore Totali :");
		lblOreTotali.setHorizontalAlignment(SwingConstants.LEFT);
		lblOreTotali.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOreTotali.setBounds(346, 134, 76, 17);
		add(lblOreTotali);
		
		textField_OreTotali = new JTextField();
		textField_OreTotali.setBackground(Color.WHITE);
		textField_OreTotali.setBounds(435, 133, 116, 20);
		add(textField_OreTotali);
		textField_OreTotali.setColumns(10);
		
		JLabel lblNumeroLezioni = new JLabel("Numero Lezioni :");
		lblNumeroLezioni.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroLezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNumeroLezioni.setBounds(10, 134, 112, 17);
		add(lblNumeroLezioni);
		
		textField_NumLezioni = new JTextField();
		textField_NumLezioni.setBounds(132, 133, 116, 20);
		add(textField_NumLezioni);
		textField_NumLezioni.setColumns(10);
		
		JLabel lblOreObbligatorie = new JLabel("Ore Obbligatorie :");
		lblOreObbligatorie.setHorizontalAlignment(SwingConstants.LEFT);
		lblOreObbligatorie.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOreObbligatorie.setBounds(10, 197, 112, 17);
		add(lblOreObbligatorie);
		
		textField_OreObbligatorie = new JTextField();
		textField_OreObbligatorie.setBounds(132, 196, 116, 20);
		add(textField_OreObbligatorie);
		textField_OreObbligatorie.setColumns(10);
		
		JPanel panel_cercaCorso = new JPanel();
		panel_cercaCorso.setBounds(0, 281, 122, 30);
		panel_cercaCorso.setBackground(new Color(255, 165, 0));
		add(panel_cercaCorso);
		panel_cercaCorso.setLayout(null);
		panel_cercaCorso.addMouseListener(new PanelButtonMouseAdapter(panel_cercaCorso));
		
		JLabel lblCercaCorso = new JLabel("Cerca Corso");

		lblCercaCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCercaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCercaCorso.setBounds(10, 0, 72, 30);
		panel_cercaCorso.add(lblCercaCorso);
		
		JLabel lblSearch = new JLabel("");
		lblSearch.setBounds(80, 0, 49, 30);
		lblSearch.setIcon(new ImageIcon(search));
		panel_cercaCorso.add(lblSearch);
		
		
		JPanel panel_GestisciLezione = new JPanel();
		panel_GestisciLezione.setBounds(258, 134, 23, 17);
		panel_GestisciLezione.setBackground(new Color(255, 165, 0));
		add(panel_GestisciLezione);
		panel_GestisciLezione.setLayout(null);
		panel_GestisciLezione.addMouseListener(new PanelButtonMouseAdapter(panel_GestisciLezione));
		panel_GestisciLezione.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				GestisciLezioneJDialog lezione = new GestisciLezioneJDialog();
				lezione.setVisible(true);
			}
			
		});
		
		JLabel lblAggiungiLezioni = new JLabel("...");
		lblAggiungiLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiLezioni.setBounds(-28, 0, 81, 14);
		panel_GestisciLezione.add(lblAggiungiLezioni);
		
		
		JLabel lblDataInizio = new JLabel("Data Inizio :");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(346, 84, 84, 17);
		add(lblDataInizio);
		
		textField_DataInizio = new JTextField();
		textField_DataInizio.setColumns(10);
		textField_DataInizio.setBounds(435, 81, 116, 20);
		add(textField_DataInizio);
		
		textField = new JTextField();
		textField.setBounds(132, 289, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 0));
		separator.setBackground(new Color(255, 255, 0));
		separator.setBounds(0, 242, 673, 2);
		add(separator);

	}
private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
			super.mousePressed(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
			super.mouseReleased(e);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
			super.mouseEntered(e);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 165, 0));
			super.mouseExited(e);
		
		}
		
	}
}


		
		