package com.java.selectbuttonpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.addpanel.DriverCorJFrame2;
import com.java.dao.DriverDAO;
import com.java.entity.DriverEntity;
import com.java.tool.TableTools;

public class SelectPersonPanel extends JFrame{
	ControlPanel controlPanel = new ControlPanel();
	TablePanel tablePanel;
	JTextField text;
	JTextField id_p_text;
	public static Vector<Vector<String>> data;
	public static Vector<String>	dataline;
	public static Vector<String> tableHead;
	public ArrayList<DriverEntity> list;
	public static JTable table;
	//Integer id_p;
	public SelectPersonPanel(JTextField id_p_text,JTextField text){
		this.setTitle("选择人员");
		this.text =text;
		this.id_p_text = id_p_text;
		tablePanel = new TablePanel();
		this.setLayout(new BorderLayout());
		add(controlPanel,BorderLayout.NORTH);
		add(tablePanel,BorderLayout.CENTER);
		//pack();
		setSize(600, 400);
		setVisible(true);
	}
	class ControlPanel extends JPanel implements ActionListener{
		JButton add;
		JButton select;
		JButton delete;
		public ControlPanel(){
			setLayout(new FlowLayout(FlowLayout.LEFT));
			add = createButton("image\\add2.png","添加");
			select = createButton("image\\select.png","选择");
			delete = createButton("image\\delete.png","删除");
			
			add.addActionListener(this);
			select.addActionListener(this);
			delete.addActionListener(this);
			add(add);
			add(select);
			add(delete);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==add){
				new DriverCorJFrame2();
			}
			if(e.getSource()==delete){
				if(JOptionPane.showConfirmDialog(this, "确定要删除吗", "删除信息", 2)==JOptionPane.YES_OPTION){
				int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				DriverDAO.delete(key);
				//更新表格内容
				list = DriverDAO.findAll();
				SelectCarPanel.data.clear();
				for(DriverEntity temp : list){
					dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId_p()));
					dataline.add(temp.getName());
					dataline.add(temp.getSex());
					dataline.add(temp.getNation());
					dataline.add(temp.getJiguan());
					dataline.add(temp.getIdcard());
					dataline.add(temp.getXueli());
					dataline.add(temp.getSchool());
					dataline.add(temp.getTel());
					dataline.add(temp.getMail());
					dataline.add(temp.getAddress());
					dataline.add(temp.getState());

					//data.add(dataline);
					SelectCarPanel.data.add(dataline);
				}
				SelectCarPanel.table.updateUI();
			}
			}
			if(e.getSource()==select){
				int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				DriverEntity driver = DriverDAO.findByID(key);
				//new DriverUpdateJFrame(driver);
			}
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
			/*JButton button = new JButton(name);
			button.setFont(new Font("粗体", Font.PLAIN, 12));// 按钮文本样式
			button.setMargin(new Insets(0, 0, 0, 0));
			button.setBorderPainted(false);
			ImageIcon image = new ImageIcon(imagePath); 
			image.setImage(image.getImage().getScaledInstance(22,22,Image.SCALE_DEFAULT));
	        button.setIcon(image);
			button.setSize(40, 100);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setVerticalTextPosition(SwingConstants.BOTTOM);
			button.setBorderPainted(false);*/
			//button.setBackground(new Color(191,239,255));
			//button.setBackground(new Color(191,239,255));
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
					  // button.setBackground(new Color(191,239,255));
				   }
				   
				   @Override
				public void mouseEntered(MouseEvent e) {
					   button.setBorderPainted(true);
					   //button.setBackground(new Color(191,230,250));
				   }
				   
				   @Override
				public void mouseClicked(MouseEvent e) {
				    // TODO Auto-generated method stub
				    
				   }
				  });
	        return button;
		}
	}
	private class TablePanel extends JPanel{
		DriverEntity driver;
		Connection con;
		Statement sta;
		ResultSet rs;
		ResultSetMetaData rsmd;
		DefaultTableModel tablemodel;
		public TablePanel(){
			String[] dataString = DriverEntity.title;
			tableHead = new Vector<String>();
			for(String temp:dataString){
				tableHead.add(temp);
			}
			
			data = new Vector<Vector<String>>();
			list = DriverDAO.findAll();
			for(DriverEntity temp : list){
				dataline = new Vector<String>();
				dataline.add(Integer.toString(temp.getId_p()));
				dataline.add(temp.getName());
				dataline.add(temp.getSex());
				dataline.add(temp.getNation());
				dataline.add(temp.getJiguan());
				dataline.add(temp.getIdcard());
				dataline.add(temp.getXueli());
				dataline.add(temp.getSchool());
				dataline.add(temp.getTel());
				dataline.add(temp.getMail());
				dataline.add(temp.getAddress());
				dataline.add(temp.getState());

				data.add(dataline);
			}
			tablemodel = new DefaultTableModel(data,tableHead);
			table = new JTable(tablemodel){
				@Override
				public boolean isCellEditable(int row, int column) {			
					return false;	}
	};;
			
			table.setToolTipText("人员信息表");
			//设置table显示
			TableTools.setTable(table);
			TableTools.fitTableColumns(table);
			TableTools.contentCenter(table);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			table.addMouseListener(new MouseAdapter(){
			    
			    @Override
				public void mouseClicked(MouseEvent e) {
			     
			       if(e.getClickCount()==2){//点击几次，这里是双击事件
			    	   //Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			    	   text.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			    	   id_p_text.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());;	
			    	   closeJFrame();
			       }
			    }
			   });
			JScrollPane js = new JScrollPane(table);
			js.getViewport().setBackground(Color.WHITE);
			setLayout(new BorderLayout());
			add(js,BorderLayout.CENTER);
		}
	}
	 public void closeJFrame(){
	    	this.dispose();
	    }
}
