package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CercaCorso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomeCorso;
	private JTextField textFieldCorsoID;
	private JTextField textFieldAreaTematica;
	private JTextField textFieldDataInizio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CercaCorso dialog = new CercaCorso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CercaCorso() {
		setTitle("Cerca un corso");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 215, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_CercaCorso = new JPanel();
		panel_CercaCorso.setLayout(null);
		panel_CercaCorso.setBackground(new Color(255, 165, 0));
		panel_CercaCorso.setBounds(0, 0, 434, 57);
		contentPanel.add(panel_CercaCorso);
		
		JLabel lblCercaCorso = new JLabel("Cerca Corso");
		lblCercaCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCercaCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCercaCorso.setBounds(109, 11, 197, 28);
		panel_CercaCorso.add(lblCercaCorso);
		
		JLabel lblNomeCorso = new JLabel("Nome Corso :");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCorso.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblNomeCorso.setBounds(10, 87, 97, 17);
		contentPanel.add(lblNomeCorso);
		
		textFieldNomeCorso = new JTextField();
		textFieldNomeCorso.setColumns(10);
		textFieldNomeCorso.setBounds(117, 86, 86, 20);
		contentPanel.add(textFieldNomeCorso);
		
		JLabel lblCorsoId = new JLabel("Corso id :");
		lblCorsoId.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorsoId.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblCorsoId.setBounds(10, 138, 97, 17);
		contentPanel.add(lblCorsoId);
		
		textFieldCorsoID = new JTextField();
		textFieldCorsoID.setColumns(10);
		textFieldCorsoID.setBounds(117, 137, 86, 20);
		contentPanel.add(textFieldCorsoID);
		
		JLabel lblAreaTematica = new JLabel("Area Tematica :");
		lblAreaTematica.setHorizontalAlignment(SwingConstants.LEFT);
		lblAreaTematica.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblAreaTematica.setBounds(10, 187, 108, 17);
		contentPanel.add(lblAreaTematica);
		
		textFieldAreaTematica = new JTextField();
		textFieldAreaTematica.setColumns(10);
		textFieldAreaTematica.setBounds(117, 186, 86, 20);
		contentPanel.add(textFieldAreaTematica);
		
		JLabel lblDataInizio = new JLabel("Data Inizio : ");
		lblDataInizio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInizio.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblDataInizio.setBounds(10, 237, 93, 17);
		contentPanel.add(lblDataInizio);
		
		textFieldDataInizio = new JTextField();
		textFieldDataInizio.setColumns(10);
		textFieldDataInizio.setBounds(117, 236, 86, 20);
		contentPanel.add(textFieldDataInizio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 215, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CercaCorso.this.dispose();
					}
				});
				okButton.setBackground(new Color(255, 165, 0));
				okButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						CercaCorso.this.dispose();
					}
				});
				cancelButton.setBackground(new Color(255, 165, 0));
				cancelButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
