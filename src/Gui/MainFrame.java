package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JLabel right_label = new JLabel("");
	JLabel menu_label = new JLabel("");
	JPanel side_panel = new JPanel();
	JButton std_btn = new JButton("Studenti");
	JLabel lblX = new JLabel("X");
	
	private final JLabel logo_label = new JLabel("");
	private final JPanel student_panel = new JPanel();
	private final JButton addStudent_button = new JButton("Aggiungi Studente");
	private final JButton ManageStudent_button = new JButton("Gestisci Studente");
	private final JButton DashboardStudent_button = new JButton("Dettagli Studente");
	private static boolean StudentButtonPressed = false;
	private final JButton course_button = new JButton("Corsi");
	private final JPanel course_panel = new JPanel();
	private final JButton addCourse_button = new JButton("Aggiungi Corso");
	private final JButton manageCourse_button = new JButton("Gestisci Corso");
	private final JButton dashboardCourse_button = new JButton("Dettagli Corso");
	private static boolean courseButtonPressed = false;
	private final JButton btnNewButton = new JButton("Esci");
	private final JLabel welcome_label = new JLabel("Benvenuto");
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	

	public MainFrame() {
		setTitle("Home");
		nonActive();
		studentButtonOff();
		courseButtonOff();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 581);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		right_label.setBounds(259, 0, 686, 581);
		contentPane.add(right_label);
		
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Sei sicuro di voler uscire dall'applicazione?", "Conferma", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					MainFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		
		
		menu_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				active();
			}
		});
		
	
		menu_label.setBounds(10, 0, 50, 42);
		contentPane.add(menu_label);
		std_btn.setHorizontalAlignment(SwingConstants.LEFT);
		std_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!StudentButtonPressed) {
					studentButtonOn();
				}
				else {
					studentButtonOff();
				}
				StudentButtonPressed = !StudentButtonPressed;
				
			}
		});
		
		std_btn.setForeground(Color.BLACK);
		std_btn.setBackground(Color.ORANGE);
		std_btn.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		
		
		std_btn.setBounds(0, 144, 258, 42);
		contentPane.add(std_btn);
		side_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		side_panel.setBackground(Color.WHITE);
		
		
		side_panel.setBounds(0, 0, 258, 542);
		contentPane.add(side_panel);
		side_panel.setLayout(null);
		logo_label.setBounds(68, 11, 110, 91);
		
		side_panel.add(logo_label);
		
		Image img = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		logo_label.setIcon(new ImageIcon(img));
		
		student_panel.setBounds(0, 188, 258, 137);
		
		side_panel.add(student_panel);
		student_panel.setLayout(null);
		addStudent_button.setBackground(Color.ORANGE);
		addStudent_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		addStudent_button.setBounds(0, 0, 258, 47);
		
		student_panel.add(addStudent_button);
		ManageStudent_button.setBackground(Color.ORANGE);
		ManageStudent_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		ManageStudent_button.setBounds(0, 44, 258, 47);
		
		student_panel.add(ManageStudent_button);
		DashboardStudent_button.setBackground(Color.ORANGE);
		DashboardStudent_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		DashboardStudent_button.setBounds(0, 92, 258, 45);
		
		student_panel.add(DashboardStudent_button);
		course_button.setForeground(Color.BLACK);
		course_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!courseButtonPressed)
				{
					courseButtonOn();
				}
				else {
					courseButtonOff();
				}
				courseButtonPressed = !courseButtonPressed;
			}
		});
		course_button.setBackground(Color.ORANGE);
		course_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		course_button.setHorizontalAlignment(SwingConstants.LEFT);
		course_button.setBounds(0, 326, 258, 41);
		
		side_panel.add(course_button);
		course_panel.setBounds(0, 367, 258, 115);
		
		side_panel.add(course_panel);
		course_panel.setLayout(null);
		addCourse_button.setBackground(Color.ORANGE);
		addCourse_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		addCourse_button.setBounds(0, 0, 258, 40);
		
		course_panel.add(addCourse_button);
		manageCourse_button.setBackground(Color.ORANGE);
		manageCourse_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		manageCourse_button.setBounds(0, 37, 258, 40);
		
		course_panel.add(manageCourse_button);
		dashboardCourse_button.setBackground(Color.ORANGE);
		dashboardCourse_button.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		dashboardCourse_button.setBounds(0, 75, 258, 41);
		
		course_panel.add(dashboardCourse_button);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		btnNewButton.setBounds(0, 501, 258, 41);
		
		side_panel.add(btnNewButton);
		welcome_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_label.setBounds(0, 109, 220, 33);
		
		side_panel.add(welcome_label);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/menuicon.png")).getImage();
		menu_label.setIcon(new ImageIcon(img2));
		
		
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBounds(911, 0, 34, 26);
		contentPane.add(lblX);
		
		
	
	}
	
	public void nonActive() 
	{
	side_panel.setVisible(false);
	side_panel.setEnabled(false);
	
	
	std_btn.setVisible(false);
	std_btn.setEnabled(false);
	
	menu_label.setVisible(true);
	menu_label.setEnabled(true);
	}
	
	public void active() 

	{
	side_panel.setVisible(true);
	side_panel.setEnabled(true);
	
	right_label.setVisible(true);
	right_label.setEnabled(true);
	
	std_btn.setVisible(true);
	std_btn.setEnabled(true);
	
	
	menu_label.setVisible(false);
	menu_label.setEnabled(false);
	}

	public void studentButtonOff()
	{
		student_panel.setVisible(false);
		student_panel.setEnabled(false);
		
		addStudent_button.setVisible(false);
		addStudent_button.setEnabled(false);
		
		ManageStudent_button.setVisible(false);
		ManageStudent_button.setEnabled(false);
		
		DashboardStudent_button.setVisible(false);
		DashboardStudent_button.setEnabled(false);
	}
	
	public void studentButtonOn()
	{
		student_panel.setVisible(true);
		student_panel.setEnabled(true);
		
		addStudent_button.setVisible(true);
		addStudent_button.setEnabled(true);
		
		ManageStudent_button.setVisible(true);
		ManageStudent_button.setEnabled(true);
		
		DashboardStudent_button.setVisible(true);
		DashboardStudent_button.setEnabled(true);
	}
	
	public void courseButtonOff()
	{
		course_panel.setVisible(false);
		course_panel.setEnabled(false);
		
		addCourse_button.setVisible(false);
		addCourse_button.setEnabled(false);
		
		manageCourse_button.setVisible(false);
		manageCourse_button.setEnabled(false);
		
		dashboardCourse_button.setVisible(false);
		dashboardCourse_button.setEnabled(false);
	}
	public void courseButtonOn()
	{
		course_panel.setVisible(true);
		course_panel.setEnabled(true);
		
		addCourse_button.setVisible(true);
		addCourse_button.setEnabled(true);
		
		manageCourse_button.setVisible(true);
		manageCourse_button.setEnabled(true);
		
		dashboardCourse_button.setVisible(true);
		dashboardCourse_button.setEnabled(true);
	}
}
