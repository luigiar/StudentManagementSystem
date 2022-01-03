package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class main_panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public main_panel() {
		
		setBounds(0, 0, 673, 581);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUESTA \u00C8 LA HOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(173, 43, 246, 187);
		add(lblNewLabel);

	}

}
