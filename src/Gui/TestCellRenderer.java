package Gui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.MouseInfo;


public class TestCellRenderer extends DefaultTableCellRenderer {
	private JPanel panel;
	private int x;
	private int y;
	
	  public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	@Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		x = MouseInfo.getPointerInfo().getLocation().x;
		y = MouseInfo.getPointerInfo().getLocation().y;
		 System.out.println(MouseInfo.getPointerInfo().getLocation());
          setToolTipText(value.toString());
          return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          

      }
}
