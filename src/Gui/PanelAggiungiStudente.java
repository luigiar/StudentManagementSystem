package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelAggiungiStudente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAggiungiStudente() {
		setLayout(null);
		setBounds(277, 28, 644, 542);
		
		JLabel lblNewLabel = new JLabel("AggiungiStudente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(113, 105, 255, 69);
		add(lblNewLabel);

	}
}
