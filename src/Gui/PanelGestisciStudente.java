package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelGestisciStudente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGestisciStudente() {
		setLayout(null);
		setBounds(0, 0, 673, 581);
		
		JLabel lblNewLabel = new JLabel("Gestisci Studente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(149, 98, 173, 101);
		add(lblNewLabel);

	}

}
