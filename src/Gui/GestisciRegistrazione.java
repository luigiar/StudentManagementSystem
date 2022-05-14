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
	private String password = null;
	private String conferma_pwd = null;

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

		JLabel lblNewLabel = new JLabel("Registrazione Admin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel.setBounds(185, 11, 167, 19);
		panel.add(lblNewLabel);

		JPanel panel_Username = new JPanel();
		panel_Username.setBackground(new Color(255, 255, 255));
		panel_Username.setBounds(181, 103, 143, 26);
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
		panel_Password.setBounds(181, 166, 143, 26);
		contentPanel.add(panel_Password);
		panel_Password.setLayout(null);

		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pwdPassword.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				password = String.valueOf(pwdPassword.getPassword());
				if (password.equals("  Password")) {
					pwdPassword.setEchoChar('*');
					pwdPassword.setText("");
				} else
					pwdPassword.selectAll();
			}

			public void focusLost(FocusEvent e) {
				password = String.valueOf(pwdPassword.getPassword());
				if (password.equals("")) {
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
		panel_1.setBounds(181, 229, 143, 26);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.addFocusListener(new FocusAdapter() {

			public void focusGained(FocusEvent e) {
				conferma_pwd = String.valueOf(passwordField.getPassword());
				if (conferma_pwd.equals("  Password")) {
					passwordField.setEchoChar('*');
					passwordField.setText("");
				} else
					passwordField.selectAll();
			}

			public void focusLost(FocusEvent e) {
				conferma_pwd = String.valueOf(passwordField.getPassword());
				if (conferma_pwd.equals("")) {
					passwordField.setText("  Password");
					passwordField.setEchoChar((char) 0);
				}
			}
		});
		passwordField.setEchoChar((char) 0);
		passwordField.setBorder(null);
		passwordField.setText("  Password");
		passwordField.setBounds(10, 0, 125, 26);
		panel_1.add(passwordField);

		JButton btnNewButton = new JButton("Salva");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password = String.valueOf(pwdPassword.getPassword());
				conferma_pwd = String.valueOf(passwordField.getPassword());
				if (txtUsername.getText().equals("  Username") || txtUsername.getText().equals("")
						|| password.equals("  Password") || password.equals("") || conferma_pwd.equals("  Password")
						|| conferma_pwd.equals("")) {
		
					JOptionPane.showMessageDialog(null, "Per favore, completa tutti i campi", "Errore",
							JOptionPane.ERROR_MESSAGE);
				}else
				if (!conferma_pwd.equals(password)) {
					JOptionPane.showMessageDialog(null, "La password non corrisponde!", "Errore",
							JOptionPane.ERROR_MESSAGE);
				} else {
					c.registraAdmin(txtUsername.getText(), password);
				}
			}
		});

		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(438, 282, 89, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblRegistratiPerAccedere = new JLabel("Registra i dati per accedere all'applicazione");
		lblRegistratiPerAccedere.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratiPerAccedere.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		lblRegistratiPerAccedere.setBounds(10, 52, 258, 26);
		contentPanel.add(lblRegistratiPerAccedere);

	}

	public void clearTextField() {
		txtUsername.setText("");
		pwdPassword.setText("");
		passwordField.setText("");
	}
}
