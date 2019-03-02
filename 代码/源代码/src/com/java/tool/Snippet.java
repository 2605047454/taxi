package com.java.tool;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Snippet {
	//Òþ²Ø±í¸ñÁÐ  
	public static void hideTableColumn(JTable table, int column){  
		 TableColumn tc = table.getTableHeader().getColumnModel().getColumn(column);
	        tc.setMaxWidth(0);
	        tc.setPreferredWidth(0);
	        tc.setWidth(0);
	        tc.setMinWidth(0);
	        table.getTableHeader().getColumnModel().getColumn(column).setMaxWidth(0);
	        table.getTableHeader().getColumnModel().getColumn(column).setMinWidth(0);     
	}
}

