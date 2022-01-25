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
import javax.swing.SwingUtilities;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final JLabel logo_label = new JLabel("");
	JPanel side_panel = new JPanel();
	

	private final JPanel student_panel = new JPanel();
	JPanel studenti_panel = new JPanel();
	private final JPanel course_panel = new JPanel();
	private final JLabel welcome_label = new JLabel("Benvenuto");
	JPanel addStudent_panel = new JPanel();
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
	private PanelAggiungiCorso panelAggiungiCorso;
	private PanelGestisciCorso panelGestisciCorso;
	private PanelDettagliCorso panelDettagliCorso;
	private final JPanel corsi_panel = new JPanel();
	private final JLabel corsi_label = new JLabel("Corsi");



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
		setResizable(false);
		setTitle("Home");
		
		customDesign();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 970, 620);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		panelHome = new main_panel();
		panelHome.setBounds(0, 0, 648, 554);
		panelAggiungiStudente = new PanelAggiungiStudente();
		panelAggiungiStudente.setBounds(0, 0, 648, 554);
		panelGestisciStudente = new PanelGestisciStudente();
		panelGestisciStudente.setBounds(0, 0, 648, 554);
		panelAggiungiCorso = new PanelAggiungiCorso();
		panelGestisciCorso = new PanelGestisciCorso();
		panelDettagliCorso = new PanelDettagliCorso();
		side_panel.setAutoscrolls(true);
		side_panel.setBorder(null);
		side_panel.setBackground(new Color(255, 165, 0));
		
		
		side_panel.setBounds(0, 0, 258, 576);
		contentPane.add(side_panel);
		side_panel.setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		student_panel.setBackground(new Color(255, 165, 0));
		
		
		student_panel.setBounds(0, 223, 258, 92);
		
		side_panel.add(student_panel);
		student_panel.setLayout(null);
		
		addStudent_panel.setBackground(new Color(255, 215, 0));
		addStudent_panel.addMouseListener(new PanelButtonMouseAdapter(addStudent_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelAggiungiStudente);
				nascondisubMenu();
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
				nascondisubMenu();
			}
		});
		manageStudent_panel.setBackground(new Color(255, 215, 0));
		manageStudent_panel.setBounds(0, 47, 258, 45);
		student_panel.add(manageStudent_panel);
		manageStudent_panel.setLayout(null);
		
		JLabel manageStudent_label = new JLabel("Gestisci Studente");
		manageStudent_label.setHorizontalAlignment(SwingConstants.CENTER);
		manageStudent_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		manageStudent_label.setBounds(64, 11, 124, 23);
		manageStudent_panel.add(manageStudent_label);
		course_panel.setBounds(0,270,258,137);
		
		side_panel.add(course_panel);
		course_panel.setLayout(null);
		
		addCourse_panel.addMouseListener(new PanelButtonMouseAdapter(addCourse_panel) {
			public void mouseClicked(MouseEvent e) {
				menuSelected(panelAggiungiCorso);
				nascondisubMenu();
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
				nascondisubMenu();
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
				nascondisubMenu();
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
		welcome_label.setForeground(new Color(240, 248, 255));
		welcome_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_label.setBounds(0, 114, 72, 29);
		
		side_panel.add(welcome_label);
		
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
		signOut_panel.setBounds(0, 535, 258, 48);
		
		side_panel.add(signOut_panel);
		signOut_label.setHorizontalAlignment(SwingConstants.CENTER);
		signOut_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		signOut_label.setBounds(64, 11, 119, 25);
		
		signOut_panel.add(signOut_label);
		logo_label.setBounds(70, 11, 110, 104);
		side_panel.add(logo_label);
		logo_label.setIcon(new ImageIcon(img));
		
		
		studenti_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrasubMenu(student_panel);
				corsi_panel.setBounds(0,310,258,48);
				if(!student_panel.isVisible())
				corsi_panel.setBounds(0,225,258,47);
			}
		});
		studenti_panel.setBackground(new Color(255, 215, 0));
		studenti_panel.setForeground(new Color(255, 255, 255));
		studenti_panel.setBounds(0, 179, 258, 48);
		side_panel.add(studenti_panel);
		studenti_panel.setLayout(null);
		studenti_panel.addMouseListener(new PanelButtonMouseAdapter(studenti_panel));
		
		JLabel studenti_label = new JLabel("Studenti");
		studenti_label.setHorizontalAlignment(SwingConstants.LEFT);
		studenti_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		studenti_label.setBounds(10, 11, 178, 25);
		studenti_panel.add(studenti_label);
		corsi_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrasubMenu(course_panel);
			}
		});
		corsi_panel.setLayout(null);
		corsi_panel.setBackground(new Color(255, 215, 0));
		corsi_panel.setBounds(0,225,258,47);
		corsi_panel.addMouseListener(new PanelButtonMouseAdapter(corsi_panel));
		
		side_panel.add(corsi_panel);
		corsi_panel.setLayout(null);
		corsi_label.setHorizontalAlignment(SwingConstants.LEFT);
		corsi_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		corsi_label.setBounds(10, 11, 106, 26);
		

		corsi_panel.add(corsi_label);
		
	
		
		
		mainContent_panel.setBounds(284, 11, 648, 554);
		contentPane.add(mainContent_panel);
		mainContent_panel.setLayout(null);
		
		mainContent_panel.add(panelHome);
		mainContent_panel.add(panelAggiungiStudente);
		mainContent_panel.add(panelGestisciStudente);
		mainContent_panel.add(panelAggiungiCorso);
		mainContent_panel.add(panelGestisciCorso);
		mainContent_panel.add(panelDettagliCorso);
		
		menuSelected(panelHome);
		
		
		
	}
	
	public void menuSelected(JPanel selectedPanel) {
		panelHome.setVisible(false);
		panelAggiungiCorso.setVisible(false);
		panelGestisciCorso.setVisible(false);
		panelDettagliCorso.setVisible(false);
		panelAggiungiStudente.setVisible(false);
		panelGestisciStudente.setVisible(false);

		
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
	

	private void customDesign() {
		student_panel.setVisible(false);
		course_panel.setVisible(false);
	}
	
	private void nascondisubMenu() {
		if(student_panel.isVisible()) {
			student_panel.setVisible(false);
			corsi_panel.setBounds(0,225,258,47);
			
		}
		if(course_panel.isVisible()) {
			course_panel.setVisible(false);
		}
	}
	
	private void mostrasubMenu(JPanel submenu) {
		if(!submenu.isVisible()) {
			nascondisubMenu();
			submenu.setVisible(true);
		}
		else
			submenu.setVisible(false);
	}
}