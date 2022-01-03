package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelGestisciCorso extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGestisciCorso() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JLabel lblNewLabel = new JLabel("Gestisci Corso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(163, 104, 130, 86);
		add(lblNewLabel);

	}

}
