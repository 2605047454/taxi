package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.java.dao.CarDAO;
import com.java.dao.DriverDAO;
import com.java.entity.CarEntity;
import com.java.entity.DriverEntity;
import com.java.updatepanel.CarUpdateJFrame;
import com.java.updatepanel.DriverUpdateJFrame2;

public class CarStatePanel extends JPanel{
	private JLabel j1;
	private JButton b1;
	private ImageIcon i1;
	private JSplitPane topPanel;
	private JSplitPane bottomPanel;
	private JSplitPane verPanel;
	private ArrayList<CarEntity> carList;
	private ArrayList<DriverEntity> driverList;
	private JScrollPane js;
	private String type;
	private String state;
	public static Car rightCar;
	public static Driver rightDriver;
	public CarStatePanel(){
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		//初始化type 和 state
		type = "全部";
		state = "全部";
		//添加滚动条
		 js = new JScrollPane();
		//初始化车辆列表
		carList = new ArrayList<CarEntity>();
		carList = createCarList();
		
		//初始化驾驶员列表
		driverList = new ArrayList<DriverEntity>();
		//driverList = createDriverList();
		driverList = DriverDAO.findByState("全部","全部");
		
		
		//设置车辆右侧面板
		rightCar = new Car();
		for(CarEntity car:carList){
			rightCar.addLable(createLabel(car));
		}
		//设置人员右侧面板
		rightDriver = new Driver();
			for(DriverEntity driver:driverList){
				rightDriver.addLable(createLabel2(driver));
			}
		
			
		
		//设置水平分割线-上侧车辆
				topPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
				
				topPanel.setDividerSize(5);
				topPanel.setDividerLocation(450);
				//topPanel.setResizeWeight(0.4);
				topPanel.setLeftComponent(new CarInf());
				JScrollPane js = new JScrollPane();
				js.setSize(20,200);
				rightCar.setPreferredSize(new Dimension(js.getWidth() - 50, js.getHeight()+10));
				//rightCar.setPreferredSize(new Dimension(10,400));
				js.add(rightCar);
				//js.add(rightCar);
				//js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				//js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				//js.getHorizontalScrollBar().setAutoscrolls(false);
				//js.getVerticalScrollBar().setAutoscrolls(true);
				js.setViewportView(rightCar);
				
				topPanel.setRightComponent(js);
				rightCar.revalidate(); 
				topPanel.setVisible(true);
		//设置水平分割线-下侧人员
				bottomPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
				
				bottomPanel.setDividerSize(5);
				//bottomPanel.setResizeWeight(0.4);
				bottomPanel.setLeftComponent(new DriverInf());
				 JScrollPane js2 = new JScrollPane();
				 //js2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				 //js2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				 js.setSize(20,200);
				 rightDriver.setPreferredSize(new Dimension(js.getWidth() - 50, js.getHeight()*2));
				 js2.add(rightDriver);
				 js2.setViewportView(rightDriver);
				bottomPanel.setRightComponent(js2);
				bottomPanel.setDividerLocation(450);
				bottomPanel.setVisible(true);
			
		//设置垂直分割线
				verPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				verPanel.setDividerSize(10);
				verPanel.setOneTouchExpandable(true);
				verPanel.setResizeWeight(0.44);
				verPanel.setLeftComponent(topPanel);
				verPanel.setRightComponent(bottomPanel);
				verPanel.setVisible(true);
				add(verPanel,BorderLayout.CENTER);
				add(new InfPanel(),BorderLayout.SOUTH);
		this.setVisible(true);
	}
	private class CarInf extends JPanel implements ActionListener{
		private JTextField text;
		private JLabel label1;
		
		private JLabel lc1;
		private JLabel lc2;
		private JLabel lc3;
		
		private JLabel label2;
		private JRadioButton jb1;
		private JRadioButton jb2;
		private JRadioButton jb3;
		private JRadioButton jb4;
		private JRadioButton jb6;
		private JRadioButton jb7;
		private JRadioButton jb8;
		private ButtonGroup group1;
		private ButtonGroup group2;
		public CarInf(){
			GridBagLayout layout = new GridBagLayout();
		    this.setLayout(layout);
		   
			label1 = new JLabel("车辆类型 ",SwingConstants.CENTER);
			label1.setFont(new Font("Dialog",Font.BOLD,14));
			label1.setBorder(BorderFactory.createBevelBorder(0));
			ImageIcon image = new ImageIcon("image\\car\\捷达-可用.png"); 
			image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
			lc1 = new JLabel("捷达",image,SwingConstants.LEADING);
			image = new ImageIcon("image\\car\\桑塔纳-可用.png"); 
			image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
			lc2 = new JLabel("桑塔纳",image,SwingConstants.LEADING);
			image = new ImageIcon("image\\car\\奥迪-可用.png"); 
			image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
			lc3 = new JLabel("奥迪",image,SwingConstants.LEADING);
			
			
			label2 = new JLabel("车辆状态",SwingConstants.CENTER);
			label2.setFont(new Font("Dialog",Font.BOLD,14));
			label2.setBorder(BorderFactory.createBevelBorder(0));
			//设置第二个标签
			//label2.setSize(new Dimension(10,20));
			//设置第三个标签
			//添加点选框
			jb1 = new JRadioButton("全部",true);
			jb2 = new JRadioButton("捷达");
			jb3 = new JRadioButton("桑塔纳");
			jb4 = new JRadioButton("奥迪");
			jb6 = new JRadioButton("全部",true);
			jb7 = new JRadioButton("可用");
			jb8 = new JRadioButton("维修");
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);
			jb6.addActionListener(this);
			jb7.addActionListener(this);
			jb8.addActionListener(this);
			group1 = new ButtonGroup();
			group2 = new ButtonGroup();
			group1.add(jb1);
			group1.add(jb2);
			group1.add(jb3);
			group1.add(jb4);
			group2.add(jb6);
			group2.add(jb7);
			group2.add(jb8);
			add(label1);
			add(lc1);
			add(lc2);
			add(lc3);
			add(jb1);
			add(jb2);
			add(jb3);
			add(jb4);
			add(label2);
			add(jb6);
			add(jb7);
			add(jb8);
			GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints，
	        //是用来控制添加进的组件的显示位置
	        s.fill = GridBagConstraints.BOTH;
	        //该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况
	        //NONE：不调整组件大小。
	        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
	        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
	        //BOTH：使组件完全填满其显示区域。
	        s.gridx = 0;
	        s.gridy = 0;
	        s.gridwidth = 5;
	        s.insets = new Insets(0,0,5,0);
	       // s.gridwidth=0;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
	        //s.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
	        //s.weighty=0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
	        layout.setConstraints(label1, s);//设置组件			
			
	        s.gridx = 0;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        s.insets = new Insets(0,0,5,0);
	        layout.setConstraints(lc1, s);
	        s.gridx = 2;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(lc2, s);
	        s.gridx = 4;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(lc3, s);
	       /* s.gridx = 3;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(lc4, s);*/

	        
	        s.gridx = 0;
	        s.gridy = 2;
	        s.gridwidth =1;
	        layout.setConstraints(jb1, s);
	        s.gridx = 1;
	        s.gridy = 2;
	        s.gridwidth =1;
	        layout.setConstraints(jb2, s);
	        s.gridx = 2;
	        s.gridy = 2;
	        s.gridwidth =1;
	        layout.setConstraints(jb3, s);
	        s.gridx = 3;
	        s.gridy = 2;
	        s.gridwidth =1;
	        layout.setConstraints(jb4, s);
	        /*s.gridx = 4;
	        s.gridy = 2;
	        s.gridwidth =1;
	        layout.setConstraints(jb5, s);*/
	        
	        s.gridx = 0;
	        s.gridy = 7;
	        s.gridwidth =5;
	        s.insets = new Insets(5,0,5,0);
	        layout.setConstraints(label2, s);
	        
	        s.gridx = 0;
	        s.gridy = 8;
	        s.gridwidth =1;
	        s.insets = new Insets(0,0,0,0);
	        layout.setConstraints(jb6, s);
	        s.gridx = 1;
	        s.gridy = 8;
	        s.gridwidth =1;
	        layout.setConstraints(jb7, s);
	        s.gridx = 2;
	        s.gridy = 8;
	        s.gridwidth =1;
	        layout.setConstraints(jb8, s);
	       /* s.gridx = 3;
	        s.gridy = 8;
	        s.gridwidth =1;
	        layout.setConstraints(jb9, s);
	        s.gridx = 4;
	        s.gridy = 8;
	        s.gridwidth =1;
	        layout.setConstraints(jb10, s);*/
		}
		//给按钮添加监听
		@Override
		public void actionPerformed(ActionEvent e) {
			//String type = "";
			//String state = "";
			Enumeration<AbstractButton> radioBtns=group1.getElements();  
			while (radioBtns.hasMoreElements()) {  
			    AbstractButton btn = radioBtns.nextElement();  
			    if(btn.isSelected()){  
			    	type=btn.getText();  
			        break;  
			    }
			}
			radioBtns=group2.getElements();  
			while (radioBtns.hasMoreElements()) {  
			    AbstractButton btn = radioBtns.nextElement();  
			    if(btn.isSelected()){  
			    	state=btn.getText();  
			        break;  
			    }
			}
			carList = CarDAO.findByStateAndType(type, state);
			rightCar.removeAll();
			for(CarEntity car:carList){
				rightCar.addLable(createLabel(car));
			}
			rightCar.validate();
			rightCar.repaint();
		}
	}
	private class DriverInf extends JPanel implements ActionListener{
		private JTextField text;
		private JLabel label1;
		private JLabel dl1;
		private JLabel dl3;
		private JRadioButton jb1;
		private JRadioButton jb2;
		private JRadioButton jb4;
		private ButtonGroup group1;
		private ButtonGroup group2;
		public DriverInf(){
			
			GridBagLayout layout = new GridBagLayout();
		    this.setLayout(layout);
			label1 = new JLabel("人员信息 ",SwingConstants.CENTER);
			label1.setFont(new Font("Dialog",Font.BOLD,14));
			label1.setBorder(BorderFactory.createBevelBorder(0));
			ImageIcon image = new ImageIcon("image\\driver\\人员-正常.png"); 
			image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
			dl1 = new JLabel("正常",image,SwingConstants.LEADING);
			
			image = new ImageIcon("image\\driver\\人员-请假.png"); 
			image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
			dl3 = new JLabel("请假",image,SwingConstants.LEADING);
			
			
		
			//添加点选框
			jb1 = new JRadioButton("全部",true);
			jb2 = new JRadioButton("正常");
			jb4 = new JRadioButton("请假");
			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb4.addActionListener(this);
			group1 = new ButtonGroup();
			group2 = new ButtonGroup();
			group1.add(jb1);
			group1.add(jb2);
			group1.add(jb4);
			add(label1);
			add(dl1);
			add(dl3);
			add(jb1);
			add(jb2);
			add(jb4);
			
			//根据部门自动添加单选按钮
			/*fendui1 = new JRadioButton("全部",true);
			fendui1.addActionListener(this);
			group2.add(fendui1);
			add(fendui1);
			HashSet<String> set = new HashSet<String>();
			set = DepartDAO.findDepartName();
			departButton = new JRadioButton[set.size()];
			int number=0;
			Iterator<String> it=set.iterator();
		       while(it.hasNext())
		       {
		    	   departButton[number] = new JRadioButton(it.next());
		    	   departButton[number].addActionListener(this);
		    	   group2.add(departButton[number]);
		    	   add(departButton[number]);
		    	   number++;
		       }*/
			
			//设置组件
			GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints，
			s.fill = GridBagConstraints.BOTH;
	        s.gridx = 0;
	        s.gridy = 0;
	        s.gridwidth = 5;
	        s.insets = new Insets(0,0,5,0);
	        layout.setConstraints(label1, s);	
	        s.gridx = 1;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        s.insets = new Insets(0,0,0,0);
	        layout.setConstraints(dl1, s);
	        /*s.gridx = 1;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(dl2, s);*/
	        s.gridx = 2;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(dl3, s);
	       /* s.gridx = 3;
	        s.gridy = 1;
	        s.gridwidth = 1;
	        layout.setConstraints(dl4, s);*/
	        
	        s.gridx = 0;
	        s.gridy = 2;
	        s.gridwidth = 1;
	        layout.setConstraints(jb1, s);
	        s.gridx = 2;
	        s.gridy = 2;
	        s.gridwidth = 1;
	        layout.setConstraints(jb2, s);
	        /*s.gridx = 2;
	        s.gridy = 2;
	        s.gridwidth = 1;
	        layout.setConstraints(jb3, s);*/
	        s.gridx = 4;
	        s.gridy = 2;
	        s.gridwidth = 1;
	        layout.setConstraints(jb4, s);
	        /*s.gridx = 4;
	        s.gridy = 2;
	        s.gridwidth = 1;
	        layout.setConstraints(jb5, s);*/
	        /*
	        //添加分队的单选按钮
	        s.gridx = 0;
	        s.gridy = 4;
	        s.gridwidth = 1;
	        layout.setConstraints(fendui1, s);
	        for(int i=0;i<departButton.length;i++)
	        {
	        s.gridx = i+1;
	        s.gridy = 4 + (i/4);
	        s.gridwidth = 1;
	        layout.setConstraints(departButton[i], s);
	        }*/
	        
	        /*s.gridx = 0;
	        s.gridy = 3;
	        s.gridwidth = 0;
	        s.gridheight = 0;
	        layout.setConstraints(b, s);*/
		}
			//给按钮添加监听
		@Override
		public void actionPerformed(ActionEvent e) {
			//String type = "";
			String state = "";
			String fendui = "";
			Enumeration<AbstractButton> radioBtns=group1.getElements();  
			Enumeration<AbstractButton> radioBtns2=group2.getElements();  
			while (radioBtns.hasMoreElements()) {  
			    AbstractButton btn = radioBtns.nextElement();  
			    if(btn.isSelected()){  
			    	state=btn.getText();  
			        break;  
			    }
			}
			while (radioBtns2.hasMoreElements()) {  
			    AbstractButton btn = radioBtns2.nextElement();  
			    if(btn.isSelected()){  
			    	fendui=btn.getText();  
			        break;  
			    }
			}
			driverList = DriverDAO.findByState(state,"全部");
			rightDriver.removeAll();
			for(DriverEntity driver:driverList){
				rightDriver.addLable(createLabel2(driver));
			}
			rightDriver.validate();
			rightDriver.repaint();			
		}
	}
	
	public class Car extends JPanel{
		public Car(){
			setBackground(Color.WHITE);
			setLayout(new FlowLayout(0,30,10));
			setVisible(true);
		}
		public void addLable(JLabel label){
			this.add(label);
		}
	}
	public class Driver extends JPanel{
		public Driver(){
			setBackground(Color.WHITE);
			setLayout(new FlowLayout(0,40,30));
			setVisible(true);
		}
		public void addLable(JLabel label){
			this.add(label);
		}
	}
	private class CarLabel extends JLabel{
		private int id;
		public CarLabel(){
		}
		public CarLabel(CarEntity car){
			id = car.getId();
			String number = car.getNumber();
			String type = car.getType();
			String state = car.getState();
			String imagePath = "image\\car\\"+type+"-"+state+".png";
			ImageIcon icon = new ImageIcon(imagePath);
			icon.setImage(icon.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
			this.setText(number);
			this.setIcon(icon);
			setVerticalTextPosition(SwingConstants.BOTTOM);
			setHorizontalTextPosition(SwingConstants.CENTER);
		}
	}
	private class DriverLabel extends JLabel{
		private int id;
		public DriverLabel(){
		}
		public DriverLabel(DriverEntity driver){
			id = driver.getId_p();
			String name = driver.getName();
			String state = driver.getState();
			String imagePath = "image\\driver\\"+"人员"+"-"+state+".png";
			ImageIcon icon = new ImageIcon(imagePath);
			icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			this.setText(name);
			this.setIcon(icon);
			setVerticalTextPosition(SwingConstants.BOTTOM);
			setHorizontalTextPosition(SwingConstants.CENTER);
		}
	}
	//根据车辆数据建立标签
	public JLabel createLabel(final CarEntity carentity){
		 final JLabel label = new CarLabel(carentity);
		 //label.add(popup);
		label.addMouseListener(new MouseListener() {
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
				// TODO Auto-generated method stub
				delBorder(label);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				addBorder(label);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int mods=e.getModifiers(); 
				//鼠标右键 
				if((mods&InputEvent.BUTTON3_MASK)!=0){ 
				//弹出菜单 
					addBorder(label);
				}
				if (e.getButton() == MouseEvent.BUTTON1){
					new CarUpdateJFrame(carentity);
				}
			}
		}
		);
		return label;
	}
	
	//根据人员数据建立标签
	public JLabel createLabel2(final DriverEntity driverentity){
		  final JLabel label = new DriverLabel(driverentity);
		  final JPopupMenu popup = createPopMenu2(driverentity);
		 label.addMouseListener(new MouseListener() {
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
					// TODO Auto-generated method stub
					delBorder(label);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					addBorder(label);
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int mods=e.getModifiers(); 
					//鼠标右键 
					if((mods&InputEvent.BUTTON3_MASK)!=0){ 
					//弹出菜单 
						addBorder(label);
						popup.show(label,e.getX(),e.getY()); 
					} 
					if (e.getButton() == MouseEvent.BUTTON1){
							new DriverUpdateJFrame2(driverentity);
							
						}
				}
			}
			);
			return label;
	}
	public void addBorder(JLabel label){
		label.setOpaque(true);
		label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		label.setBackground(new Color(191,239,255));
		//label.setBorder(BorderFactory.createLineBorder(Color.black));
		//label.setBorder(BorderFactory.createBevelBorder(0));
		
	}
	public void delBorder(JLabel label){
		label.setOpaque(false);
		label.setBackground(new Color(255,255,255));
		//label.setBorder(BorderFactory.createEmptyBorder());
		//label.setForeground(Color.black);
		//label.setBorder(BorderFactory.createEmptyBorder());
	}
	public ArrayList<CarEntity> createCarList(){
		return CarDAO.findAll();
	}
	public ArrayList<DriverEntity> createDriverList(){
		return DriverDAO.findAll();
	}
	//创建菜单
	@SuppressWarnings("deprecation")
	/*public JPopupMenu createPopMenu(final CarEntity carentity) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem menu1 = new JMenuItem("");
		JMenuItem menu2 = new JMenuItem();
		JMenuItem menu3 = new JMenuItem();
		JMenuItem menu4 = new JMenuItem();
		JMenuItem menu5 = new JMenuItem();
		JMenuItem menu6 = new JMenuItem();
		JMenuItem menu7 = new JMenuItem();
		menu1.setText("加油登记");
		menu2.setText("维修登记");
		menu3.setText("维修取车");
		menu4.setText("停用");
		menu5.setText("启用");
		menu6.setText("其他状态");
		menu7.setText("正常可用");
		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new RepairCorJFrame1(carentity);	
				
			}
			
		});
		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(CarDAO.updateState(carentity.getId(), "可用")){	
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}
			}
			
		});
		menu4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String remark = JOptionPane.showInputDialog(null,
				         "请您输入停用原因","停用", JOptionPane.PLAIN_MESSAGE);
				if(remark==null||remark.equals("")){	
					
				}else{
					CarDAO.updateState(carentity.getId(), "停用");
					CarDAO.updateRemark(carentity.getId(), remark);
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}
				
			}
			
		});
		menu5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(CarDAO.updateState(carentity.getId(), "可用")){	
					CarDAO.updateRemark(carentity.getId(), "");
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}	
				
			}
			
		});
		menu6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String remark = JOptionPane.showInputDialog(null,
				         "请您输入其他原因","其他状态", JOptionPane.PLAIN_MESSAGE);
				if(remark==null||remark.equals("")){	
					
				}else{
					CarDAO.updateState(carentity.getId(), "其他");
					CarDAO.updateRemark(carentity.getId(), remark);
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}	
				
			}
			
		});
		menu7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(CarDAO.updateState(carentity.getId(), "可用")){	
					CarDAO.updateRemark(carentity.getId(), "");
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}	
				
			}
			
		});
		popup.add(menu1);
		popup.addSeparator();
		popup.add(menu2);
		popup.add(menu3);
		popup.addSeparator();
		popup.add(menu4);
		popup.add(menu5);
		popup.addSeparator();
		popup.add(menu6);
		popup.add(menu7);
		return popup;
	 }*/
	public JPopupMenu createPopMenu2(final DriverEntity driverentity) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem menu1 = new JMenuItem("");
		JMenuItem menu2 = new JMenuItem();
		JMenuItem menu3 = new JMenuItem();
		JMenuItem menu4 = new JMenuItem();
		JMenuItem menu5 = new JMenuItem();
		JMenuItem menu6 = new JMenuItem();
		JMenuItem menu7 = new JMenuItem();
		JMenuItem menu8 = new JMenuItem();
		menu1.setText("违章登记");
		menu4.setText("奖励登记");
		menu2.setText("请假登记");
		menu3.setText("销假");
		menu5.setText("公休登记");
		menu6.setText("到岗");
		menu7.setText("其他登记");
		menu8.setText("到岗");
		menu1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		menu2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		menu3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DriverDAO.updateState(driverentity.getId_p(), "正常")){	
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}
			}
			
		});
		menu4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		menu5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		menu6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DriverDAO.updateState(driverentity.getId_p(), "正常")){	
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}	
				
			}
			
		});
		menu7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String remark = JOptionPane.showInputDialog(null,
				         "请您输入其他原因","其他状态", JOptionPane.PLAIN_MESSAGE);
				if(remark==null||remark.equals("")){	
					
				}else{
					CarDAO.updateState(driverentity.getId_p(), "其他");
					//CarDAO.updateRemark(carentity.getId(), remark);
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}		
				
			}
			
		});
		menu8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(DriverDAO.updateState(driverentity.getId_p(), "正常")){	
					Manage.centerPanel.removeAll();
					Manage.centerPanel.add(new CarStatePanel());
					Manage.centerPanel.validate();
					Manage.centerPanel.repaint();
				}	
				
			}
			
		});
		popup.add(menu1);
		popup.add(menu4);
		popup.addSeparator();
		popup.add(menu2);
		popup.add(menu3);
		popup.addSeparator();
		popup.add(menu5);
		popup.add(menu6);
		popup.addSeparator();
		popup.add(menu7);
		popup.add(menu8);
		return popup;
	 }
}
