package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.TextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {

	private Image img = new ImageIcon(LoginFrame.class.getResource("/Login (3).jpg")).getImage();
	
	private JPanel LoginPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	private JLabel loginMessageLabel = new JLabel("");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setBounds(100, 100, 613, 400);
		LoginPane = new JPanel();
		LoginPane.setBackground(Color.WHITE);
		LoginPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(LoginPane);
		setLocationRelativeTo(null);
		LoginPane.setLayout(null);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBounds(0, 0, 600, 38);
		TopPanel.setBorder(new LineBorder(new Color(255, 165, 0)));
		TopPanel.setBackground(new Color(255, 165, 0));
		LoginPane.add(TopPanel);
		TopPanel.setLayout(null);
		
		JLabel TitleTopLabel = new JLabel("Gestione di corsi di fomazione");
		TitleTopLabel.setForeground(Color.WHITE);
		TitleTopLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		TitleTopLabel.setBounds(21, 11, 199, 14);
		TopPanel.add(TitleTopLabel);
		
		JLabel MessaggioAccessoLabel = new JLabel("Accedi per proseguire");
		MessaggioAccessoLabel.setBounds(201, 73, 196, 28);
		MessaggioAccessoLabel.setBackground(new Color(0, 0, 0));
		MessaggioAccessoLabel.setForeground(new Color(0, 0, 0));
		MessaggioAccessoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MessaggioAccessoLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		LoginPane.add(MessaggioAccessoLabel);
		
		JPanel username_panel = new JPanel();
		username_panel.setBackground(Color.WHITE);
		username_panel.setBounds(201, 134, 211, 43);
		LoginPane.add(username_panel);
		username_panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 11, 166, 20);
		username_panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel password_panel = new JPanel();
		password_panel.setBackground(Color.WHITE);
		password_panel.setBounds(201, 199, 211, 38);
		LoginPane.add(password_panel);
		password_panel.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				}
				else
					pwdPassword.selectAll();
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(10, 11, 167, 20);
		password_panel.add(pwdPassword);
		
		JPanel login_panel = new JPanel();
		login_panel.setForeground(new Color(102, 0, 0));
		login_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("admin") && pwdPassword.getText().equals("admin")) {
					MainFrame mainFrame = new MainFrame();
					mainFrame.setVisible(true);
					LoginFrame.this.dispose();
					loginMessageLabel.setText("");
					JOptionPane.showMessageDialog(null, "Login eseguito");
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
						pwdPassword.getText().equals("") || pwdPassword.getText().equals("Password")) {
					loginMessageLabel.setText("Per favore, tutti i campi sono richiesti!");
				}
				else {
					loginMessageLabel.setText("Username e password non corrispondono!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				login_panel.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login_panel.setBackground(Color.ORANGE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				login_panel.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				login_panel.setBackground(new Color(30, 60, 60));
			}
		});
		login_panel.setBackground(new Color(255, 165, 0));
		login_panel.setBounds(201, 276, 211, 43);
		LoginPane.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel login_label = new JLabel("LOGIN");
		login_label.setForeground(Color.WHITE);
		login_label.setHorizontalAlignment(SwingConstants.CENTER);
		login_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		login_label.setBounds(55, 11, 101, 21);
		login_panel.add(login_label);
		loginMessageLabel.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		loginMessageLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		loginMessageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		loginMessageLabel.setForeground(new Color(255, 0, 0));
		loginMessageLabel.setBounds(185, 248, 294, 14);
		LoginPane.add(loginMessageLabel);
		
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 35, 600, 326);
		background_label.setIcon(new ImageIcon(img));
		LoginPane.add(background_label);
	}
}
