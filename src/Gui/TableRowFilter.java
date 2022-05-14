package Gui;

import javax.swing.RowFilter;

public class TableRowFilter extends RowFilter {

	private String searchText;

	TableRowFilter(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public boolean include(Entry entry) {
		for (int i = entry.getValueCount() - 1; i >= 0; i--) {
			if (entry.getStringValue(i).toLowerCase().indexOf(searchText.toLowerCase()) >= 0) {
				return entry.getStringValue(i).toLowerCase().indexOf(searchText.toLowerCase()) >= 0;
			}
		}
		return false;
	}

}
