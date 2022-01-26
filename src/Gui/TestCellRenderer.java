package Gui;


import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;



public class TestCellRenderer extends DefaultTableCellRenderer {
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
          setToolTipText(value.toString());
          return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          

      }
}
