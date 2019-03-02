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

import com.java.dao.CarInfDAO;
import com.java.entity.CarInfEntity;
import com.java.entity.DriverEntity;
import com.java.tool.TableToWord;
import com.java.tool.TableTools;

public class CarInfPanel extends JPanel{
	public static JTable table;
	QueryPanel querypanel;
	DriverEntity driver;
	Connection con;
	Statement sta;
	ResultSet rs;
	ResultSetMetaData rsmd;
	public static Vector<Vector<String>> data;
	Vector<String>	dataline;
	public static Vector<String> tableHead;
	ArrayList<CarInfEntity> list;
	public static DefaultTableModel tablemodel;
	public CarInfPanel(){
		
		querypanel = new QueryPanel();
		String[] dataString = CarInfEntity.title;
		tableHead = new Vector<String>();
		for(String temp:dataString){
			tableHead.add(temp);
		}
		
		data = new Vector<Vector<String>>();
		list = CarInfDAO.findAll();
		for(CarInfEntity temp : list){
			dataline = new Vector<String>();
			dataline.add(temp.getNumber());
			dataline.add(temp.getAddoilcount());
			dataline.add(temp.getRepaircount());
			data.add(dataline);
		}
		tablemodel = new DefaultTableModel(data,tableHead);
		table = new JTable(tablemodel){
			@Override
			public boolean isCellEditable(int row, int column) {			
				return false;	}
		};
		
		table.setToolTipText("�����ۺ���Ϣ��");
		//����table��ʾ
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
			add = createButton("image\\add.png","���");
			update = createButton("image\\edit.png","�༭");
			delete = createButton("image\\delete.png","ɾ��");
			check = createButton("image\\state.png","�鿴");
			query = createButton("image\\search.png","��ѯ");
			show = createButton("image\\show.png","��ʾ");
			save = createButton("image\\save.png","������");
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
		    button.setContentAreaFilled(false);// ���ð�ť͸��
		    button.setFont(new Font("����", Font.PLAIN, 12));// ��ť�ı���ʽ
		    button.setMargin(new Insets(0, 0, 0, 0));// ��ť������߿����
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
				if(JOptionPane.showConfirmDialog(this, "�Ƿ�Ҫ��������ݱ��", "��������", 2)==JOptionPane.YES_OPTION){
					//��table�е����ݱ���ΪWord
					long temp = System.currentTimeMillis();
					TableToWord.openWord("carDate\\�����ۺ���Ϣ��"+ temp +".doc", CarInfEntity.width,"�����ۺ���Ϣ��", CarInfEntity.title.length, CarInfEntity.title, data,0,0);
					try {
						String a ="carDate\\�����ۺ���Ϣ��"+ temp +".doc";
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
