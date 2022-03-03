package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestisciRegistrazione extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JPasswordField passwordField;
	private Controller theController;
	private JLabel RegisterMessageLabel = new JLabel("");


	
	public GestisciRegistrazione(Controller c) {
		theController = c;
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setBounds(100, 100, 553, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 215, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 537, 41);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rgistrazione Admin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(199, 11, 167, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_Nome = new JLabel("Nome Utente:");
		lblNewLabel_Nome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_Nome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_Nome.setBounds(90, 95, 120, 14);
		contentPanel.add(lblNewLabel_Nome);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(120, 147, 90, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblConfermaPassword = new JLabel("Conferma Password:");
		lblConfermaPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfermaPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfermaPassword.setBounds(75, 184, 135, 14);
		contentPanel.add(lblConfermaPassword);
		
		JPanel panel_Username = new JPanel();
		panel_Username.setBackground(new Color(255, 255, 255));
		panel_Username.setBounds(212, 83, 143, 26);
		contentPanel.add(panel_Username);
		panel_Username.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("  Username")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("  Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setText("  Username");
		txtUsername.setBounds(10, 0, 125, 26);
		panel_Username.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_Password = new JPanel();
		panel_Password.setBackground(Color.WHITE);
		panel_Password.setBounds(212, 135, 143, 26);
		contentPanel.add(panel_Password);
		panel_Password.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwdPassword.addFocusListener(new FocusAdapter() {
		
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("  Password")) {
					pwdPassword.setEchoChar('*');
					pwdPassword.setText("");
				} else
					pwdPassword.selectAll();
			}

			
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().equals("")) {
					pwdPassword.setText("  Password");
					pwdPassword.setEchoChar((char) 0);
				}
			}
		});
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char) 0);
		pwdPassword.setText("  Password");
		pwdPassword.setBounds(10, 0, 125, 26);
		panel_Password.add(pwdPassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(212, 172, 143, 26);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("  Conferma")) {
					passwordField.setEchoChar('*');
					passwordField.setText("");
				} else
					passwordField.selectAll();
			}

			
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals("")) {
					passwordField.setText("  Conferma");
					passwordField.setEchoChar((char) 0);
				}
			}
		});
		passwordField.setEchoChar((char) 0);
		passwordField.setBorder(null);
		passwordField.setText("  Conferma");
		passwordField.setBounds(10, 0, 125, 26);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Salva");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	if (txtUsername.getText().equals("  Username") || pwdPassword.getText().equals("  Password") || passwordField.getText().equals("  Conferma")) {
					
					JOptionPane.showMessageDialog(null, "Per favore, completa tutti i campi", "Errore",
							JOptionPane.ERROR_MESSAGE);
		
				}
					
					if(!passwordField.getText().equals(pwdPassword.getText())) {
						
						JOptionPane.showMessageDialog(null, "La password non corrisponde!", "Errore",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
				c.registraAdmin(txtUsername.getText(), pwdPassword.getText());
				JOptionPane.showMessageDialog(null, "Registrazione effetuata!");
				 clearTextField();
				 GestisciRegistrazione.this.dispose();
				}
			}
		});
		
	
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(438, 282, 89, 23);
		contentPanel.add(btnNewButton);
		
		
	}
	
	public void clearTextField() {
		txtUsername.setText("");
		pwdPassword.setText("");
		passwordField.setText("");
	}
}
