package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.dao.ChargeDAO;
import com.java.entity.ChargeEntity;
import com.java.tool.TableToWord;
import com.java.tool.TableTools;

public class ChargeInfPanel extends JPanel{
	public static JTable table;
	QueryPanel querypanel;
	Connection con;
	Statement sta;
	ResultSet rs;
	ResultSetMetaData rsmd;
	public static Vector<Vector<String>> data;
	Vector<String>	dataline;
	public static Vector<String> tableHead;
	ArrayList<ChargeEntity> list;
	public static DefaultTableModel tablemodel;
	public ChargeInfPanel(){
		
		querypanel = new QueryPanel();
		String[] dataString = ChargeEntity.title;
		tableHead = new Vector<String>();
		for(String temp:dataString){
			tableHead.add(temp);
		}
		
		data = new Vector<Vector<String>>();
		list = ChargeDAO.findAll();
		for(ChargeEntity temp : list){
			dataline = new Vector<String>();
			dataline.add(Integer.toString(temp.getId_ch()));
			dataline.add(temp.getName());
			dataline.add(temp.getNumber());
			dataline.add(temp.getBoss());
			dataline.add(temp.getMile());
			dataline.add(temp.getCharge());
			data.add(dataline);
		}
		tablemodel = new DefaultTableModel(data,tableHead);
		table = new JTable(tablemodel){
			@Override
			public boolean isCellEditable(int row, int column) {			
				return false;	}
		};
		
		table.setToolTipText("出车信息表");
		//设置table显示
		TableTools.setTable(table);
		TableTools.fitTableColumns(table);
		TableTools.contentCenter(table);
		JScrollPane js = new JScrollPane(table);
		js.getViewport().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		add(querypanel,BorderLayout.NORTH);
		add(js,BorderLayout.CENTER);
	}
	
	private class QueryPanel extends JToolBar implements ActionListener{
		private JToolBar querybar;
		private JButton add;
		private JButton update;
		private JButton delete;
		private JButton check;
		private JButton query;
		private JButton show;
		private JButton save;
		public QueryPanel(){
			add = createButton("image\\add.png","添加");
			update = createButton("image\\edit.png","编辑");
			delete = createButton("image\\delete.png","删除");
			check = createButton("image\\state.png","查看");
			query = createButton("image\\search.png","查询");
			show = createButton("image\\show.png","显示");
			save = createButton("image\\save.png","保存表格");
			setLayout(new FlowLayout(FlowLayout.LEFT));
			add.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
			save.addActionListener(this);
			//add(add);
			//add(update);
			//add(delete);
			//this.addSeparator();
			//add(check);
			add(query);
			add(show);
			add(save);
			//add(querybar);
		}
		public JButton createButton(String imagePath,String name){
		    final JButton button = new JButton(name);
		    button.setContentAreaFilled(false);// 设置按钮透明
		    button.setFont(new Font("粗体", Font.PLAIN, 12));// 按钮文本样式
		    button.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		    ImageIcon image = new ImageIcon(imagePath); 
			image.setImage(image.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
	        button.setIcon(image);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setBorderPainted(false);
			button.addMouseListener(new MouseListener() {
				   
				   @Override
				public void mouseReleased(MouseEvent e) {
				    // TODO Auto-generated method stub
				    
				   }
				   
				   @Override
				public void mousePressed(MouseEvent e) {
				    // TODO Auto-generated method stub
				    
				   }
				   
				   @Override
				public void mouseExited(MouseEvent e) {
					   button.setBorderPainted(false);
					   button.setBackground(new Color(191,239,255));
				   }
				   
				   @Override
				public void mouseEntered(MouseEvent e) {
					   button.setBorderPainted(true);
					   button.setBackground(new Color(191,230,250));
				   }
				   
				   @Override
				public void mouseClicked(MouseEvent e) {
				    // TODO Auto-generated method stub
				    
				   }
				  });
	        return button;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==add){
			}
			if(e.getSource()==save){
				if(JOptionPane.showConfirmDialog(this, "是否要保存此数据表格", "保存数据", 2)==JOptionPane.YES_OPTION){
					//将table中的内容保存为Word
					long temp = System.currentTimeMillis();
					TableToWord.openWord("carDate\\出车信息表"+ temp +".doc", ChargeEntity.width,"出车信息表", ChargeEntity.title.length, ChargeEntity.title, data,0,0);
					try {
						String a ="carDate\\出车信息表"+ temp +".doc";
						Runtime.getRuntime().exec("cmd /c \""+a+"\"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
