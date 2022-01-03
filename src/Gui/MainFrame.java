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
import java.awt.event.MouseMotionAdapter;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JLabel lblX = new JLabel("X");
	JLabel menu_label = new JLabel("");
	JLabel right_label = new JLabel("");
	JPanel side_panel = new JPanel();
	JButton std_btn = new JButton("Studenti");
	
	private final JLabel logo_label = new JLabel("");
	private final JPanel student_panel = new JPanel();
	private static boolean StudentButtonPressed = false;
	private final JButton course_button = new JButton("Corsi");
	private final JPanel course_panel = new JPanel();
	private static boolean courseButtonPressed = false;
	private final JLabel welcome_label = new JLabel("Benvenuto");
	JPanel addStudent_panel = new JPanel();
	JPanel detailsStudent_panel = new JPanel();
	JPanel manageStudent_panel = new JPanel();
	private final JPanel addCourse_panel = new JPanel();
	private final JLabel addCourse_label = new JLabel("Aggiungi Corso");
	private final JPanel manageCourse_panel = new JPanel();
	private final JLabel manageCourse_label = new JLabel("Gestisci Corso");
	private final JPanel detailsCourse_panel = new JPanel();
	private final JLabel detailsCourse_label = new JLabel("Dettagli Corso");
	private final JPanel home_panel = new JPanel();
	private final JPanel signOut_panel = new JPanel();
	private final JLabel home_label = new JLabel("Home");
	private final JLabel signOut_label = new JLabel("Esci");
	private final JPanel mainContent_panel = new JPanel();
	
	private main_panel panelHome;
	private PanelAggiungiStudente panelAggiungiStudente;
	private PanelGestisciStudente panelGestisciStudente;
	private PanelDettagliStudente panelDettagliStudente;
	private PanelAggiungiCorso panelAggiungiCorso;
	private PanelGestisciCorso panelGestisciCorso;
	private PanelDettagliCorso panelDettagliCorso;



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



	public MainFrame() {
		setTitle("Home");
//		nonActive();
		studentButtonOff();
		courseButtonOff();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 627);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		panelHome = new main_panel();
		panelAggiungiStudente = new PanelAggiungiStudente();
		panelGestisciStudente = new PanelGestisciStudente();
		panelDettagliStudente = new PanelDettagliStudente();
		panelAggiungiCorso = new PanelAggiungiCorso();
		panelGestisciCorso = new PanelGestisciCorso();
		panelDettagliCorso = new PanelDettagliCorso();
		
		right_label.setBounds(261, 0, 717, 627);
		contentPane.add(right_label);
		side_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		side_panel.setBackground(Color.WHITE);
		
		
		side_panel.setBounds(0, 0, 258, 627);
		contentPane.add(side_panel);
		side_panel.setLayout(null);
		logo_label.setBounds(60, 26, 110, 91);
		
		side_panel.add(logo_label);
		
		Image img = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		logo_label.setIcon(new ImageIcon(img));
		
		Image img2= new ImageIcon(this.getClass().getResource("/menuicon.png")).getImage();
		menu_label.setIcon(new ImageIcon(img2));
		
		menu_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				active();
			}
		});
		
		
		student_panel.setBounds(0, 223, 258, 137);
		
		side_panel.add(student_panel);
		student_panel.setLayout(null);
		
		addStudent_panel.setBackground(new Color(255, 215, 0));
		addStudent_panel.addMouseListener(new PanelButtonMouseAdapter(addStudent_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelAggiungiStudente);
			}
		});
		addStudent_panel.setBounds(0, 0, 258, 47);
		student_panel.add(addStudent_panel);
		addStudent_panel.setLayout(null);
		
		JLabel addStudent_label = new JLabel("Aggiungi Studente");
		addStudent_label.setHorizontalAlignment(SwingConstants.CENTER);
		addStudent_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		addStudent_label.setBounds(75, 11, 119, 25);
		addStudent_panel.add(addStudent_label);
		
		manageStudent_panel.addMouseListener(new PanelButtonMouseAdapter(manageStudent_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelGestisciStudente);
			}
		});
		manageStudent_panel.setBackground(new Color(255, 215, 0));
		manageStudent_panel.setBounds(0, 45, 258, 45);
		student_panel.add(manageStudent_panel);
		manageStudent_panel.setLayout(null);
		
		JLabel manageStudent_label = new JLabel("Gestisci Studente");
		manageStudent_label.setHorizontalAlignment(SwingConstants.CENTER);
		manageStudent_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		manageStudent_label.setBounds(64, 11, 124, 23);
		manageStudent_panel.add(manageStudent_label);
		
		detailsStudent_panel.addMouseListener(new PanelButtonMouseAdapter(detailsStudent_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelDettagliStudente);
			}
		});
		detailsStudent_panel.setBackground(new Color(255, 215, 0));
		detailsStudent_panel.setBounds(0, 90, 258, 47);
		student_panel.add(detailsStudent_panel);
		detailsStudent_panel.setLayout(null);
		
		JLabel detailsStudent_label = new JLabel("Dettagli Studente");
		detailsStudent_label.setBackground(Color.WHITE);
		detailsStudent_label.setHorizontalAlignment(SwingConstants.CENTER);
		detailsStudent_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		detailsStudent_label.setBounds(77, 11, 106, 25);
		detailsStudent_panel.add(detailsStudent_label);
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
		course_button.setBounds(0, 359, 258, 41);
		
		side_panel.add(course_button);
		course_panel.setBounds(0, 401, 258, 137);
		
		side_panel.add(course_panel);
		course_panel.setLayout(null);
		
		addCourse_panel.addMouseListener(new PanelButtonMouseAdapter(addCourse_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelAggiungiCorso);
			}
		});
		addCourse_panel.setBackground(new Color(255, 215, 0));
		addCourse_panel.setLayout(null);
		addCourse_panel.setBounds(0, 0, 258, 47);
		
		course_panel.add(addCourse_panel);
		addCourse_label.setHorizontalAlignment(SwingConstants.CENTER);
		addCourse_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		addCourse_label.setBounds(75, 11, 119, 25);
		addCourse_panel.add(addCourse_label);
		
		manageCourse_panel.addMouseListener(new PanelButtonMouseAdapter(manageCourse_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelGestisciCorso);
			}
		});
		manageCourse_panel.setBackground(new Color(255, 215, 0));
		manageCourse_panel.setLayout(null);
		manageCourse_panel.setBounds(0, 47, 258, 45);
		
		course_panel.add(manageCourse_panel);
		manageCourse_label.setHorizontalAlignment(SwingConstants.CENTER);
		manageCourse_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		manageCourse_label.setBounds(64, 11, 124, 23);
		manageCourse_panel.add(manageCourse_label);
		
		detailsCourse_panel.addMouseListener(new PanelButtonMouseAdapter(detailsCourse_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelDettagliCorso);
			}
		});
		detailsCourse_panel.setBackground(new Color(255, 215, 0));
		detailsCourse_panel.setLayout(null);
		detailsCourse_panel.setBounds(0, 90, 258, 47);
		
		course_panel.add(detailsCourse_panel);
		detailsCourse_label.setHorizontalAlignment(SwingConstants.CENTER);
		detailsCourse_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		detailsCourse_label.setBounds(77, 11, 106, 25);
		
		detailsCourse_panel.add(detailsCourse_label);
		welcome_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_label.setBounds(0, 114, 72, 29);
		
		side_panel.add(welcome_label);
		std_btn.setBounds(0, 181, 258, 42);
		side_panel.add(std_btn);
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
		
		home_panel.addMouseListener(new PanelButtonMouseAdapter(home_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelHome);
			}
		});
		home_panel.setBackground(new Color(255, 215, 0));
		home_panel.setBounds(0, 140, 258, 41);
		
		side_panel.add(home_panel);
		home_panel.setLayout(null);
		home_label.setHorizontalAlignment(SwingConstants.CENTER);
		home_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		home_label.setBounds(65, 11, 119, 25);
		
		home_panel.add(home_label);
		
		signOut_panel.addMouseListener(new PanelButtonMouseAdapter(signOut_panel) {
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire dall'applicazione?") == 0) {
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				MainFrame.this.dispose();
				}
			}
		});
		signOut_panel.setLayout(null);
		signOut_panel.setBackground(new Color(255, 215, 0));
		signOut_panel.setBounds(0, 549, 258, 50);
		
		side_panel.add(signOut_panel);
		signOut_label.setHorizontalAlignment(SwingConstants.CENTER);
		signOut_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		signOut_label.setBounds(66, 11, 119, 25);
		
		signOut_panel.add(signOut_label);
		menu_label.setBounds(0, 11, 50, 42);
		side_panel.add(menu_label);
		
	
		
		
		mainContent_panel.setBounds(284, 24, 673, 581);
		contentPane.add(mainContent_panel);
		mainContent_panel.setLayout(null);
		
		mainContent_panel.add(panelHome);
		mainContent_panel.add(panelAggiungiStudente);
		mainContent_panel.add(panelGestisciStudente);
		mainContent_panel.add(panelDettagliStudente);
		mainContent_panel.add(panelAggiungiCorso);
		mainContent_panel.add(panelGestisciCorso);
		mainContent_panel.add(panelDettagliCorso);
		
		menuSelected(panelHome);
		lblX.setBounds(944, 0, 34, 26);
		contentPane.add(lblX);
		
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
		
		
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		
		
	}
	
	public void menuSelected(JPanel selectedPanel) {
		panelHome.setVisible(false);
		panelAggiungiCorso.setVisible(false);
		panelGestisciCorso.setVisible(false);
		panelDettagliCorso.setVisible(false);
		panelAggiungiStudente.setVisible(false);
		panelGestisciStudente.setVisible(false);
		panelDettagliStudente.setVisible(false);
		
		selectedPanel.setVisible(true);
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
	
//	public void nonActive() 
//	{
//	side_panel.setVisible(false);
//	side_panel.setEnabled(false);
//	
//	
//	std_btn.setVisible(false);
//	std_btn.setEnabled(false);
//	
//	menu_label.setVisible(true);
//	menu_label.setEnabled(true);
//	}
	
//	public void active() 
//
//	{
//	side_panel.setVisible(true);
//	side_panel.setEnabled(true);
//	
//	right_label.setVisible(true);
//	right_label.setEnabled(true);
//	
//	std_btn.setVisible(true);
//	std_btn.setEnabled(true);
//	
//	
//	menu_label.setVisible(false);
//	menu_label.setEnabled(false);
//	}

	public void studentButtonOff()
	{
		student_panel.setVisible(false);
		student_panel.setEnabled(false);
	}
	
	public void studentButtonOn()
	{
		student_panel.setVisible(true);
		student_panel.setEnabled(true);
		
		addStudent_panel.setVisible(true);
		addStudent_panel.setEnabled(true);
		
		manageStudent_panel.setVisible(true);
		manageStudent_panel.setEnabled(true);
		
		detailsStudent_panel.setVisible(true);
		detailsStudent_panel.setEnabled(true);
	}
	
	public void courseButtonOff()
	{
		course_panel.setVisible(false);
		course_panel.setEnabled(false);
	}
	public void courseButtonOn()
	{
		course_panel.setVisible(true);
		course_panel.setEnabled(true);
		
		addCourse_panel.setVisible(true);
		addCourse_panel.setEnabled(true);
		
		manageCourse_panel.setVisible(true);
		manageCourse_panel.setEnabled(true);
		
		detailsCourse_panel.setVisible(true);
		detailsCourse_panel.setEnabled(true);
	}
}