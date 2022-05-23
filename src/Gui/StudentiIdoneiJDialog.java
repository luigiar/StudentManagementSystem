package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;

public class StudentiIdoneiJDialog extends JDialog {
	private JTable table;
	private DefaultTableModel model;
	private Controller theController;
	private JLabel lblMessageElencoStudenti;
	private JLabel lblMessage;

	public StudentiIdoneiJDialog(Controller c, String corsoID) {
		theController = c;
		setTitle("Finestra studenti idonei");
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(new Color(255, 215, 0));
		setBounds(100, 100, 450, 378);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JPanel panel_GestioneLezioni = new JPanel();
			panel_GestioneLezioni.setLayout(null);
			panel_GestioneLezioni.setBackground(new Color(255, 165, 0));
			panel_GestioneLezioni.setBounds(0, 0, 434, 57);
			getContentPane().add(panel_GestioneLezioni);
			{
				JLabel lblStudentiIdonei = new JLabel("Studenti Idonei");
				lblStudentiIdonei.setHorizontalAlignment(SwingConstants.CENTER);
				lblStudentiIdonei.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
				lblStudentiIdonei.setBounds(124, 11, 197, 28);
				panel_GestioneLezioni.add(lblStudentiIdonei);
			}
		}

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(99, 95, 325, 227);
		getContentPane().add(scrollPane);
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable();
		table.setBackground(new Color(230, 230, 250));
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		Object[] colonne = { "ID", "Nome", "Cognome", "Presenze" };
		TableRowSorter myRowSorter = new TableRowSorter(model);
		table.setRowSorter(myRowSorter);
		table.setModel(model);
		model.setColumnIdentifiers(colonne);
		theController.showStudentsAllowed(corsoID, table);

		lblMessage = new JLabel("Nessuno studente idoneo!");
		lblMessage.setForeground(Color.RED);
		lblMessage.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessage.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMessage.setBounds(10, 68, 197, 16);
		getContentPane().add(lblMessage);
		lblMessage.setVisible(false);

		lblMessageElencoStudenti = new JLabel("Elenco degli studenti idonei :");
		lblMessageElencoStudenti.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessageElencoStudenti.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMessageElencoStudenti.setBounds(10, 68, 197, 16);
		getContentPane().add(lblMessageElencoStudenti);
		setLabelJDialog();
	}

	public void setLabelJDialog() {
		if (table.getRowCount() == 0) {
			lblMessage.setVisible(true);
			lblMessageElencoStudenti.setVisible(false);
		}
	}
}
