package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.addpanel.DriverCorJFrame;
import com.java.dao.DriverDAO;
import com.java.entity.DriverEntity;
import com.java.tool.Snippet;
import com.java.tool.TableToWord;
import com.java.tool.TableTools;
import com.java.updatepanel.DriverUpdateJFrame;
import com.java.updatepanel.DriverUpdateJFrame2;

public class DriverPanel extends JPanel{
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
	ArrayList<DriverEntity> list;
	public static DefaultTableModel tablemodel;
	private int queryNumber;
	private String queryKey = "姓名";
	//Vector meta;
	public DriverPanel(){
		querypanel = new QueryPanel();
		String[] dataString = DriverEntity.title;
		tableHead = new Vector<String>();
		for(String temp:dataString){
			tableHead.add(temp);
		}
		
		data = new Vector<Vector<String>>();
		list = DriverDAO.findAll();
		queryNumber = list.size();
		
		for(DriverEntity temp : list){
			dataline = new Vector<String>();
			dataline.add(Integer.toString(temp.getId_p()));
			dataline.add(temp.getName());
			//dataline.add(temp.getDepart_name());
			//dataline.add(temp.getZhiwu_name());
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
			/*dataline.add(temp.getEntertime().toString());
			dataline.add(temp.getState());
			dataline.add(temp.getProfessional());
			dataline.add(temp.getDriverid());
			dataline.add(temp.getGettime().toString());
			dataline.add(temp.getEffecttime());
			dataline.add(temp.getAllowtype());
			dataline.add(temp.getOvertime().toString());
			dataline.add(temp.getIn_driverid());
			dataline.add(temp.getIn_gettime().toString());
			dataline.add(temp.getIn_effecttime());
			dataline.add(temp.getIn_allowtype());
			dataline.add(temp.getIn_overtime().toString());*/
			data.add(dataline);
		}
		tablemodel = new DefaultTableModel(data,tableHead);
		table = new JTable(tablemodel){
			@Override
			public boolean isCellEditable(int row, int column) {			
				return false;	}
};
		
		table.setToolTipText("人员信息");
		//Table双击事件
				table.addMouseListener(new MouseAdapter(){
					    
					    @Override
						public void mouseClicked(MouseEvent e) {
					     
					       if(e.getClickCount()==2){//点击几次，这里是双击事件
					    		int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
								DriverEntity driver = DriverDAO.findByID(key);
								new DriverUpdateJFrame2(driver);
					       }
					    }
					   });
		//设置table显示
		TableTools.setTable(table);
		//TableTools.fitTableColumns(table);
		TableTools.contentCenter(table);
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		
		Snippet.hideTableColumn(table, 0);
		querypanel = new QueryPanel();
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
		private String[] queryitem;
		private JComboBox<String> jcb;
		private JTextField text;
		private JLabel querylabel;
		private JButton save;
		public QueryPanel(){
			add = createButton("image\\add.png","添加");
			update = createButton("image\\edit.png","编辑");
			delete = createButton("image\\delete.png","删除");
			check = createButton("image\\state.png","查看");
			query = createButton("image\\search.png","查询");
			show = createButton("image\\show.png","显示");
			save = createButton("image\\save.png","保存表格");
			queryitem = new String[]{"姓名","性别","状�??"};
			jcb = new JComboBox<String>(queryitem);
			querylabel = new JLabel("      查询条目:"+queryNumber);
			querylabel.setForeground(Color.red);
			text = new JTextField("");
			text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
			text.setBackground(null);
			jcb.setPreferredSize(new Dimension(100,22));
			text.setPreferredSize(new Dimension(80,22));
			setLayout(new FlowLayout(FlowLayout.LEFT));
			add.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
			jcb.addActionListener(this);
			query.addActionListener(this);
			show.addActionListener(this);
			save.addActionListener(this);
			if(Manage.user.getType().equals("管理�?"))
			{
			add(add);
			add(update);
			add(delete);
			}else if(Manage.user.getType().equals("�?般用�?")){
				add(add);
			}
			this.addSeparator();
			//add(check);
			add(jcb);
			add(text);
			add(query);
			add(show);
			add(save);
			add(querylabel);
			//add(querybar);
		}
		public JButton createButton(String imagePath,String name){
		    final JButton button = new JButton(name);
		    button.setContentAreaFilled(false);// 设置按钮透明
		    button.setFont(new Font("粗体", Font.PLAIN, 12));// 按钮文本样式
		    button.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距�??
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
				new DriverCorJFrame();
			}
			if(e.getSource()==delete){
				try{
				if(JOptionPane.showConfirmDialog(this, "确定要删除吗", "删除信息", 2)==JOptionPane.YES_OPTION){
				int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				DriverDAO.delete(key);
				//更新表格内容
				list = DriverDAO.findAll();
				DriverPanel.data.clear();
				for(DriverEntity temp : list){
					dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId_p()));
					dataline.add(temp.getName());
					//dataline.add(temp.getDepart_name());
					//dataline.add(temp.getZhiwu_name());
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
					/*dataline.add(temp.getEntertime().toString());
					dataline.add(temp.getState());
					dataline.add(temp.getProfessional());
					dataline.add(temp.getDriverid());
					dataline.add(temp.getGettime().toString());
					dataline.add(temp.getEffecttime());
					dataline.add(temp.getAllowtype());
					dataline.add(temp.getOvertime().toString());
					dataline.add(temp.getIn_driverid());
					dataline.add(temp.getIn_gettime().toString());
					dataline.add(temp.getIn_effecttime());
					dataline.add(temp.getIn_allowtype());
					dataline.add(temp.getIn_overtime().toString());*/
					DriverPanel.data.add(dataline);
				}
				DriverPanel.table.updateUI();
				queryNumber = list.size();
				querylabel.setText("      查询条目:"+queryNumber);
				text.setText("");
				}
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(this, "请�?�择编辑条目");
				}
			}
			if(e.getSource()==update){
				try{
				int key = Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
				DriverEntity driver = DriverDAO.findByID(key);
				new DriverUpdateJFrame(driver);
				}catch(ArrayIndexOutOfBoundsException e1){
					JOptionPane.showMessageDialog(this, "请�?�择编辑条目");
				}
				
			}
			if(e.getSource()==jcb){
				 queryKey = (String) jcb.getSelectedItem(); 
			}
			if(e.getSource()==query){
				ArrayList<DriverEntity> list = new ArrayList<DriverEntity>();
				if(text.getText().equals("")){
					list = DriverDAO.findAll();
				}else{
				if(queryKey.endsWith("姓名")){
					list = DriverDAO.findByName(text.getText());
				}else if(queryKey.endsWith("性别")){
					
					list = DriverDAO.findByZhiWu(text.getText());
				}else if(queryKey=="状�??"){
					list = DriverDAO.findByState(text.getText(),"全部");
				}
				}
				queryNumber = list.size();
				querylabel.setText("      查询条目:"+queryNumber);
				DriverPanel.data.clear();
				for(DriverEntity temp : list){
					Vector<String> dataline = new Vector<String>();
					dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId_p()));
					dataline.add(temp.getName());
					//dataline.add(temp.getDepart_name());
					//dataline.add(temp.getZhiwu_name());
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
					/*dataline.add(temp.getEntertime().toString());
					dataline.add(temp.getState());
					dataline.add(temp.getProfessional());
					dataline.add(temp.getDriverid());
					dataline.add(temp.getGettime().toString());
					dataline.add(temp.getEffecttime());
					dataline.add(temp.getAllowtype());
					dataline.add(temp.getOvertime().toString());
					dataline.add(temp.getIn_driverid());
					dataline.add(temp.getIn_gettime().toString());
					dataline.add(temp.getIn_effecttime());
					dataline.add(temp.getIn_allowtype());
					dataline.add(temp.getIn_overtime().toString());*/
					DriverPanel.data.add(dataline);
				}
				DriverPanel.table.updateUI();
			}
			if(e.getSource()==show){
				//更新表格内容
				list = DriverDAO.findAll();
				DriverPanel.data.clear();
				for(DriverEntity temp : list){
					dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId_p()));
					dataline.add(temp.getName());
					//dataline.add(temp.getDepart_name());
					//dataline.add(temp.getZhiwu_name());
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
					/*dataline.add(temp.getEntertime().toString());
					dataline.add(temp.getState());
					dataline.add(temp.getProfessional());
					dataline.add(temp.getDriverid());
					dataline.add(temp.getGettime().toString());
					dataline.add(temp.getEffecttime());
					dataline.add(temp.getAllowtype());
					dataline.add(temp.getOvertime().toString());
					dataline.add(temp.getIn_driverid());
					dataline.add(temp.getIn_gettime().toString());
					dataline.add(temp.getIn_effecttime());
					dataline.add(temp.getIn_allowtype());
					dataline.add(temp.getIn_overtime().toString());*/
					DriverPanel.data.add(dataline);
				}
				DriverPanel.table.updateUI();
				queryNumber = list.size();
				querylabel.setText("      查询条目:"+queryNumber);
				text.setText("");
			}
			if(e.getSource()==save){
				if(JOptionPane.showConfirmDialog(this, "是否要保存此数据表格", "保存数据", 2)==JOptionPane.YES_OPTION){
					//将table中的内容保存为Word
					long temp = System.currentTimeMillis();
					TableToWord.openWord("carDate\\人员信息"+  temp +".doc", DriverEntity.width,"人员信息", DriverEntity.title.length, DriverEntity.title, data,-2,1);
					try {
						String a ="carDate\\人员信息"+ temp +".doc";
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
