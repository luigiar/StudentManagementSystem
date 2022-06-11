package Gui;


import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;



public class TestCellRenderer extends DefaultTableCellRenderer {


	@Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          setToolTipText(value.toString());
          return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          

      }
}
