package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GestisciLezioneJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	Image rightArrow = new ImageIcon(this.getClass().getResource("/rightArrow.png")).getImage();
	Image leftArrow = new ImageIcon(this.getClass().getResource("/leftArrow.png")).getImage();

	
	/**
	 * Create the dialog.
	 */
	public GestisciLezioneJDialog() {
		setTitle("Aggiungi delle lezioni");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 439, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 215, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_GestioneLezioni = new JPanel();
		panel_GestioneLezioni.setLayout(null);
		panel_GestioneLezioni.setBackground(new Color(255, 165, 0));
		panel_GestioneLezioni.setBounds(0, 0, 423, 57);
		contentPanel.add(panel_GestioneLezioni);
		
		JLabel lblGestioneLezioni = new JLabel("Gestione Lezioni");
		lblGestioneLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestioneLezioni.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblGestioneLezioni.setBounds(109, 11, 197, 28);
		panel_GestioneLezioni.add(lblGestioneLezioni);
		
		JLabel lblLezionenumero = new JLabel("Lezione #Numero : ");
		lblLezionenumero.setHorizontalAlignment(SwingConstants.LEFT);
		lblLezionenumero.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblLezionenumero.setBounds(10, 68, 128, 17);
		contentPanel.add(lblLezionenumero);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 67, 86, 20);
		contentPanel.add(textField);
		
		JLabel lblDurataLezione = new JLabel("Durata Lezione :");
		lblDurataLezione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurataLezione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDurataLezione.setBounds(10, 111, 128, 17);
		contentPanel.add(lblDurataLezione);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 110, 86, 20);
		contentPanel.add(textField_1);
		
		JLabel lblDescrizione = new JLabel("Descrizione : ");
		lblDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescrizione.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDescrizione.setBounds(10, 153, 108, 17);
		contentPanel.add(lblDescrizione);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(128, 145, 184, 57);
		contentPanel.add(textPane);
		
		JLabel lblDataInizio = new JLabel("Data Inizio : ");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(10, 235, 93, 17);
		contentPanel.add(lblDataInizio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(148, 234, 86, 20);
		contentPanel.add(textField_2);
		
		JLabel lblOraInizio = new JLabel("Ora inizio :");
		lblOraInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblOraInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblOraInizio.setBounds(10, 279, 108, 17);
		contentPanel.add(lblOraInizio);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(148, 278, 86, 20);
		contentPanel.add(textField_3);
		
		JLabel lblPresenze = new JLabel("Presenze :");
		lblPresenze.setHorizontalAlignment(SwingConstants.LEFT);
		lblPresenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblPresenze.setBounds(10, 319, 108, 17);
		contentPanel.add(lblPresenze);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(148, 318, 86, 20);
		contentPanel.add(textField_4);
		
		JLabel lblAssenze = new JLabel("Assenze :");
		lblAssenze.setHorizontalAlignment(SwingConstants.LEFT);
		lblAssenze.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAssenze.setBounds(10, 357, 108, 17);
		contentPanel.add(lblAssenze);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(148, 356, 86, 20);
		contentPanel.add(textField_5);
		
		
		JButton btnNewButton = new JButton("Salva");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(324, 415, 89, 23);
		contentPanel.add(btnNewButton);
		
		JPanel panel_RightArrow = new JPanel();
		panel_RightArrow.setBackground(new Color(255, 215, 0));
		panel_RightArrow.setBounds(203, 403, 45, 36);
		contentPanel.add(panel_RightArrow);
		panel_RightArrow.setLayout(null);
		panel_RightArrow.addMouseListener(new PanelButtonMouseAdapter(panel_RightArrow));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 45, 36);
		panel_RightArrow.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(rightArrow));
		
		JPanel panel_LeftArrow = new JPanel();
		panel_LeftArrow.setBackground(new Color(255, 215, 0));
		panel_LeftArrow.setBounds(148, 403, 45, 35);
		contentPanel.add(panel_LeftArrow);
		panel_LeftArrow.addMouseListener(new PanelButtonMouseAdapter(panel_LeftArrow));
		panel_LeftArrow.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 0, 36, 35);
		panel_LeftArrow.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(leftArrow));
		

		
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
			panel.setBackground(new Color(255, 215, 0));
			super.mouseExited(e);
		
		}
		
	}
}
