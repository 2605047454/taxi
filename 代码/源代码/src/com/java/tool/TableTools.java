package com.java.tool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class TableTools {
	//static int mouseOnRowIndex= -1;
	//����table��ʾ
	public static void setTable(JTable table){
		//table.setRowSelectionAllowed(false);
		table.setShowHorizontalLines(false);
		table.setGridColor(Color.black);
		table.setFont(new Font("",Font.PLAIN,12));
		TableRowSorter<TableModel> tableRowSorter=new TableRowSorter<TableModel>(table.getModel()); // ���� 
		table.setRowSorter(tableRowSorter); // ִ���������� 
		//table.setShowVerticalLines(false);
		//�����п�
	}
	//�̶��п�
	public static void setFixColumnWidth(JTable table,int[] width){
		TableColumnModel tcm = table.getTableHeader().getColumnModel();
        for (int i = 0; i < tcm.getColumnCount(); i++) 
        {
            TableColumn tc = tcm.getColumn(i);
            tc.setPreferredWidth(width[i]);
            // tc.setMinWidth(100);
            tc.setMaxWidth(width[i]+10);
        }
	}
	//table���ݾ�����ʾ����ż��ɫ
	public static  void contentCenter(JTable table){
	        
		   try {
			    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
			     @Override
				public Component getTableCellRendererComponent(final JTable table,
			       Object value, boolean isSelected, boolean hasFocus,
			       int row, int column) {
			    //���ݾ�����ʾ
			    setHorizontalAlignment(SwingConstants.CENTER);
			    //��ż����ɫ
			      if (row % 2 == 0)
			       setBackground(Color.white); // ���������е�ɫ
			      else if (row % 2 == 1)
			       setBackground(new Color(206, 231, 253)); // ����ż���е�ɫ
			      //setBackground(new Color(127 ,255 ,212)); // ����ż���е�ɫ
			   /* //�����ͣ��ɫ�仯
			      table.addMouseMotionListener(new MouseMotionListener() {
					
			    	  @Override  
			    	    public void mouseDragged(MouseEvent e) {}  
			    	  
			    	    @Override  
			    	    public void mouseMoved(MouseEvent e) {  
			    	    
			    	        Point point = e.getPoint();  
			    	        int rowAtPoint = table.rowAtPoint(point);  
			    	        mouseOnRowIndex = rowAtPoint ;  
			    	        table.updateUI();  
			    	    }
				});
				     if(row == mouseOnRowIndex){  
			                setBackground(Color.YELLOW);  
			            }else{  
			                setBackground(null);  
			            }*/
				   
			      return super.getTableCellRendererComponent(table, value,
			        isSelected, hasFocus, row, column);
			     }
			     
			     
			    };
			    for (int i = 0; i < table.getColumnCount(); i++) {
			     table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
			    }
			   } catch (Exception ex) {
			    ex.printStackTrace();
			   }
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// ����table���ݾ���
		  // tcr.setHorizontalAlignment(JLabel.CENTER);
		   tcr.setHorizontalAlignment(SwingConstants.CENTER);// �����Ͼ�����һ��
		   table.setDefaultRenderer(Object.class, tcr);
	}
 
	//�Զ������п�
    public static void fitTableColumns(JTable myTable)
    {
         myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         JTableHeader header = myTable.getTableHeader();
         int rowCount = myTable.getRowCount();
         Enumeration columns = myTable.getColumnModel().getColumns();
         while(columns.hasMoreElements())
         {
             TableColumn column = (TableColumn)columns.nextElement();
             int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
             int width = (int)header.getDefaultRenderer().getTableCellRendererComponent
             (myTable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
             for(int row = 0; row < rowCount; row++)
             {
                 int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent
                 (myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth()+40;
                 width = Math.max(width+1, preferedWidth);
                
             }
             header.setResizingColumn(column); // ���к���Ҫ
             column.setWidth(width+myTable.getIntercellSpacing().width);
         }
    }
    
    
}
