package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelDettagliStudente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDettagliStudente() {
		setLayout(null);
		setBounds(277, 28, 644, 542);
		
		JLabel lblNewLabel = new JLabel("Dettagli Studente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 69, 164, 162);
		add(lblNewLabel);

	}

}
