package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelAggiungiCorso extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAggiungiCorso() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JLabel lblNewLabel = new JLabel("Aggiungi Corso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(127, 104, 199, 110);
		add(lblNewLabel);

	}

}
