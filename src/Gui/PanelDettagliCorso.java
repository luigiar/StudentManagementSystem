package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelDettagliCorso extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDettagliCorso() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JLabel lblNewLabel = new JLabel("Dettagli Corsi");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(141, 105, 143, 85);
		add(lblNewLabel);

	}

}
