package com.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.java.entity.DriverOverEntity;
import com.java.tool.TableTools;

public class InfPanel extends JTabbedPane{
	ResultSetMetaData rsmd;
	public static JTable table;
	public static Vector<Vector<String>> data;
	Vector<String>	dataline;
	public static Vector<String> tableHead;
	ArrayList<DriverOverEntity> list;
	public static DefaultTableModel tablemodel;
	DriverOverPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	public InfPanel(){
	  JPanel combop = new JPanel();
	   p1 = new DriverOverPanel();
	   p2 = new JPanel();
	   p3 = new JPanel();
	   p4 = new JPanel();

	  add(p1,"驾照到期信息");
	  add(p2,"请假到期信息");
	  add(p3,"请假上限信息");
	  add(p4,"维修到期信息");
	}
	class DriverOverPanel extends JPanel{
		public DriverOverPanel(){
			String[] dataString = DriverOverEntity.title;
			tableHead = new Vector<String>();
			for(String temp:dataString){
				tableHead.add(temp);
			}
			
			data = new Vector<Vector<String>>();
			//list = TimeOut.findDriverTimeOut();
			/*for(DriverOverEntity temp : list){
				dataline = new Vector<String>();
				dataline.add(temp.getName());
				dataline.add(temp.getOvertime().toString());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				dataline.add(sdf.format(new Date()));
				dataline.add(Integer.toString(temp.getGetday()));
				dataline.add(Integer.toString(temp.getOverday()));
				data.add(dataline);
			}*/
			tablemodel = new DefaultTableModel(data,tableHead);
			table = new JTable(tablemodel){
				@Override
				public boolean isCellEditable(int row, int column) {			
					return false;	}
			};
			
			table.setToolTipText("违章记录表");
			//设置table显示
			TableTools.setTable(table);
			TableTools.fitTableColumns(table);
			TableTools.contentCenter(table);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JScrollPane js = new JScrollPane(table);
			//table.setSize(200, 200);
			js.getViewport().setBackground(Color.WHITE);
			js.setPreferredSize(new Dimension(800,200));
			//js.setMaximumSize(new Dimension(1000,200));
			//setLayout(new BorderLayout());
			//add(querypanel,BorderLayout.NORTH);
			//add(js,BorderLayout.CENTER);
			this.setLayout(new FlowLayout(FlowLayout.LEFT));
			this.add(js);
		}
	}
}
