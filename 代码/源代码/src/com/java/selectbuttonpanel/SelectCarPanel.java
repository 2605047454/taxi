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

import com.java.addpanel.CarCorJFrame1;
import com.java.dao.CarDAO;
import com.java.entity.CarEntity;
import com.java.tool.TableTools;

public class SelectCarPanel extends JFrame{
	ControlPanel controlPanel = new ControlPanel();
	TablePanel tablePanel;
	JTextField text;
	JTextField id_p_text;
	public static Vector<Vector<String>> data;
	public static Vector<String>	dataline;
	public static Vector<String> tableHead;
	public ArrayList<CarEntity> list;
	
	DefaultTableModel tablemodel;
	public static JTable table;
	//Integer id_p;
	public SelectCarPanel(JTextField id_p_text,JTextField text){
		this.text =text;
		this.id_p_text = id_p_text;
		tablePanel = new TablePanel();
		this.setLayout(new BorderLayout());
		add(controlPanel,BorderLayout.NORTH);
		add(tablePanel,BorderLayout.CENTER);
		pack();
		//setSize(600, 400);
		setVisible(true);
	}

	class ControlPanel extends JPanel implements ActionListener{
		JButton add;
		JButton select;
		JButton delete;
		public ControlPanel(){
			setLayout(new FlowLayout(FlowLayout.LEFT));
			add = createButton("image\\add2.png","���");
			select = createButton("image\\select.png","ѡ��");
			delete = createButton("image\\delete.png","ɾ��");
			
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
				new CarCorJFrame1();
			}
			if(e.getSource()==delete){
				if(JOptionPane.showConfirmDialog(this, "ȷ��Ҫɾ����", "ɾ����Ϣ", 2)==JOptionPane.YES_OPTION){
				int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				CarDAO.delete(key);
				//���±������
				list = CarDAO.findAll();
				SelectCarPanel.data.clear();
				for(CarEntity temp : list){
					dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId()));
					dataline.add(temp.getNumber());
					dataline.add(temp.getXinghao());
					dataline.add(temp.getType());
					dataline.add(temp.getF_number());
					dataline.add(temp.getJ_number());
					dataline.add(temp.getSelltime().toString());
					dataline.add(temp.getState());
					dataline.add(temp.getInf());
					//data.add(dataline);
					SelectCarPanel.data.add(dataline);
				}
				SelectCarPanel.table.updateUI();
			}
			}
			if(e.getSource()==select){
				/*int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				DriverEntity driver = DriverDAO.findByID(key);
				new DriverUpdateJFrame(driver);*/
			}
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
				    
				   }
				   
				   @Override
				public void mousePressed(MouseEvent e) {
				    
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
				   }
				  });
	        return button;
		}
	}
	private class TablePanel extends JPanel{
		
		CarEntity car;
		Connection con;
		Statement sta;
		ResultSet rs;
		ResultSetMetaData rsmd;
		
		public TablePanel(){
			String[] dataString = CarEntity.title;
			tableHead = new Vector<String>();
			for(String temp:dataString){
				tableHead.add(temp);
			}
			
			data = new Vector<Vector<String>>();
			list = CarDAO.findAll();
			for(CarEntity temp : list){
				dataline = new Vector<String>();
				dataline.add(Integer.toString(temp.getId()));
				dataline.add(temp.getNumber());
				dataline.add(temp.getXinghao());
				dataline.add(temp.getType());
				dataline.add(temp.getF_number());
				dataline.add(temp.getJ_number());
				dataline.add(temp.getSelltime().toString());
				dataline.add(temp.getState());
				dataline.add(temp.getInf());
				data.add(dataline);
			}
			tablemodel = new DefaultTableModel(data,tableHead);
			table = new JTable(tablemodel){
				@Override
				public boolean isCellEditable(int row, int column) {			
							return false;	}
			};
			table.setToolTipText("������Ϣ��");
			//����table��ʾ
			TableTools.setTable(table);
			TableTools.fitTableColumns(table);
			TableTools.contentCenter(table);

			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
			table.addMouseListener(new MouseAdapter(){
			    
			    @Override
				public void mouseClicked(MouseEvent e) {
			     
			       if(e.getClickCount()==2){//������Σ�������˫���¼�
			    	   //Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			    	   //��ʾ��
			    	   text.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
			    	   //���ر���
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
