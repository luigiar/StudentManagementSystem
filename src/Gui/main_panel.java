package Gui;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import Controller.Controller;

import java.awt.SystemColor;

public class main_panel extends JPanel {
	Controller theController;
	private JLabel totalCourse_label; 
	private JLabel stdPresence_label;
	public main_panel(Controller c) {
		theController = c;
		setBackground(new Color(255, 215, 0));
		
		setBounds(0, 0, 673, 581);
		setLayout(null);
		
		JPanel front_panel = new JPanel();
		front_panel.setBounds(0, 48, 673, 62);
		front_panel.setBackground(new Color(255, 165, 0));
		add(front_panel);
		front_panel.setLayout(null);
		
		JLabel role_label = new JLabel("Ruolo : admin");
		role_label.setForeground(SystemColor.desktop);
		role_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		role_label.setBounds(10, 11, 147, 24);
		front_panel.add(role_label);
		
		JLabel front_label = new JLabel("Gestione per corsi di formazione");
		front_label.setForeground(new Color(0, 0, 0));
		front_label.setBounds(10, 11, 265, 26);
		front_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		add(front_label);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 490, 673, 80);
		panel.setBackground(new Color(255, 165, 0));
		add(panel);
		panel.setLayout(null);
		
		stdPresence_label = new JLabel("Studenti presenti :");
		stdPresence_label.setForeground(SystemColor.desktop);
		stdPresence_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		stdPresence_label.setBounds(10, 11, 147, 24);
		panel.add(stdPresence_label);
		
		totalCourse_label = new JLabel("Corsi presenti :");
		totalCourse_label.setForeground(Color.BLACK);
		totalCourse_label.setFont(new Font("Yu Gothic UI", Font.BOLD, 13));
		totalCourse_label.setBounds(516, 11, 147, 24);
		panel.add(totalCourse_label);
		
		showElementsMainPanel();

		Image imgHome = new ImageIcon(this.getClass().getResource("/homeImm.jpg")).getImage();
		JLabel homeImm_label = new JLabel("");
		homeImm_label.setIcon(new ImageIcon(imgHome));
		homeImm_label.setBounds(0, 111, 663, 379);
		add(homeImm_label);
	}
	
	public void showElementsMainPanel() {
		theController.showTotalStudentsNumber(stdPresence_label);
		theController.showTotalCourseNumber(totalCourse_label);
		
	}
	
}
