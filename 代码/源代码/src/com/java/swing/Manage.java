package com.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.java.entity.UserEntity;

public class Manage extends JFrame implements ActionListener{
	public static JPanel paneltool;
	public static JPanel centerPanel;
	public static UserEntity user;
	//InfoPanel infoPanel;
	JToolBar toolbar;
	JMenuBar menubar;
	JButton carstate;
	JButton car;
	JButton driver;
	/*JButton addoil;
	JButton repair;
	JButton breakrule;
	JButton award;
	JButton overtime;*/
	JButton simulation;
	JButton chargeInfPanel;
	JButton driverinf;
	
	public Manage(UserEntity user){
		super("货运综合管理系统");
		Manage.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(0, 0, 800, 800);
		paneltool = new JPanel();
		toolbar = new JToolBar();
		centerPanel = new CarStatePanel();
		//infoPanel = new InfoPanel();
		carstate = createButton("image\\state.png","车辆状态图");
		car = createButton("image\\car.png","车辆信息");
		driver = createButton("image\\driver.png","驾驶员信息");
		simulation = createButton("image\\leave.png","模拟演示效果");
		chargeInfPanel = createButton("image\\statistic.png","出车信息");
		
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(carstate);
		toolbar.add(car);
		toolbar.add(driver);
		toolbar.add(simulation);
		//toolbar.add(addoil);
		//toolbar.add(repair);
		//toolbar.add(breakrule);
		//toolbar.add(award);
		//toolbar.add(leave);
		toolbar.add(chargeInfPanel);
		toolbar.setBackground(new Color(191,239,255));
		JMenuBar bar = createMenuBar();
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new BorderLayout());
		toppanel.add(bar,BorderLayout.NORTH);
		toppanel.add(toolbar,BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		//this.add(bar,BorderLayout.NORTH);
		this.add(toppanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		//this.add(infoPanel,BorderLayout.SOUTH);


		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
	public JMenuBar createMenuBar(){
		  JMenu jm=new JMenu("日常处理") ;     //创建JMenu菜单对象
		  JMenuItem t1=new JMenuItem("加油记录") ;  //菜单项
		  JMenuItem t2=new JMenuItem("维修记录") ;//菜单项
		  JMenuItem t3=new JMenuItem("违章记录") ;//菜单项
		  JMenuItem t4=new JMenuItem("奖励记录") ;//菜单项
		  JMenuItem t5=new JMenuItem("休假加班记录") ;//菜单项
		  JMenuItem t6=new JMenuItem("车辆综合信息") ;//菜单项
		  JMenuItem t7=new JMenuItem("人员综合信息") ;//菜单项
		   jm.add(t1) ;   //将菜单项目添加到菜单
		   jm.add(t2) ;    //将菜单项目添加到菜单
		   jm.add(t3) ;    //将菜单项目添加到菜单
		   jm.add(t4) ;    //将菜单项目添加到菜单
		   jm.add(t5) ;    //将菜单项目添加到菜单
		   jm.add(t6) ;    //将菜单项目添加到菜单
		   jm.add(t7) ;    //将菜单项目添加到菜单
		   JMenu jm2=new JMenu("系统设置") ;     //创建JMenu菜单对象
		      JMenuItem t21=new JMenuItem("部门信息") ;  //菜单项
			  JMenuItem t22=new JMenuItem("职员信息") ;//菜单项
			  JMenuItem t23=new JMenuItem("车辆信息") ;//菜单项
			  JMenuItem t24=new JMenuItem("其他信息") ;//菜单项
			   jm2.add(t21) ;    //将菜单项目添加到菜单
			   jm2.add(t22) ;    //将菜单项目添加到菜单
			   jm2.add(t23) ;    //将菜单项目添加到菜单
			   jm2.addSeparator();
			   jm2.add(t24) ;    //将菜单项目添加到菜单
			   JMenu jm3=new JMenu("基础设置") ;     //创建JMenu菜单对象
			      JMenuItem t31=new JMenuItem("添加用户") ;  //菜单项
				  JMenuItem t32=new JMenuItem("修改密码") ;//菜单项
				   jm3.add(t31) ;    //将菜单项目添加到菜单
				   jm3.addSeparator();
				   jm3.add(t32) ;    //将菜单项目添加到菜单
			   JMenu jm4 = new JMenu("软件帮助");
			   	  JMenuItem t41=new JMenuItem("帮助");
			   	  JMenuItem t42=new JMenuItem("关于");
			   	   jm4.add(t41);
			   	   jm4.add(t42);
		  JMenuBar  br=new  JMenuBar() ;  //创建菜单工具栏
		   br.add(jm) ;      //将菜单增加到菜单工具栏
		   br.add(jm2) ;      //将菜单增加到菜单工具栏
		   br.add(jm3) ;      //将菜单增加到菜单工具栏
		   br.add(jm4) ;      //将菜单增加到菜单工具栏
		return br;
	}
	public JButton createButton(String imagePath,String name){
		final JButton button = new JButton(name);
		button.setIcon(new ImageIcon(imagePath));
		button.setSize(40, 100);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setBorderPainted(false);
		button.setBackground(new Color(191,239,255));
		
		button.addActionListener(this);
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
		if(e.getSource() == carstate){
			centerPanel.removeAll();
			centerPanel.add(new CarStatePanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		if(e.getSource() == car){
			centerPanel.removeAll();
			centerPanel.add(new CarManagePanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		
		if(e.getSource() == driver){
			centerPanel.removeAll();
			centerPanel.add(new DriverPanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		
		if(e.getSource() == simulation){
			centerPanel.removeAll();
			centerPanel.add(new SimulationPanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		if(e.getSource() == chargeInfPanel){
			centerPanel.removeAll();
			centerPanel.add(new ChargeInfPanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		if(e.getSource() == driverinf){
			centerPanel.removeAll();
			centerPanel.add(new DriverInfPanel());
			centerPanel.validate();
			centerPanel.repaint();
			this.validate();
			this.repaint();
		}
		 
		
	}
	
	/*public static void main(String args[]){
		new Manage();
	}*/
	
	/*public  class InfoPanel extends JPanel{
		JLabel label1;
		JLabel label2;
		private String message = " ";
		private int xCoordinate ;
		private int yCoordinate ;
		Timer timer;
		public InfoPanel(){
			//this.setLayout(null);
			this.setSize(1000, 20);
			System.out.println(this.getWidth());
			xCoordinate = this.getWidth()*3/4;
			yCoordinate = 12;
			this.message = "存在驾驶证到期，请及时处理！";
			timer = new Timer(100, new TimerListener());
			
			this.setLayout(new GridLayout(1, 12));
			Font font = new Font("宋体", 0, 14);
			label1 = new JLabel("版权所有：地勤货运保障队");
			label2 = new JLabel("|操作员：赵睿");
			
			label1.setFont(font);
			label2.setFont(font);
			add(label1);
			add(label2);
			add(new JLabel());
			add(new JLabel());
			add(new JLabel());
			add(new JLabel());
			add(new JLabel());
			if(!TimeOut.findDriverTimeOut().isEmpty()){
				timer.start();
		    }else{
		    	timer.stop();
		    }   
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
		

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.setFont(new Font("宋体", 0, 14));
			if (xCoordinate > getWidth())
			{
				timer.stop();
				g.drawString("", xCoordinate, yCoordinate);
				//xCoordinate = -100;
			}

			xCoordinate += 5;
			g.drawString(message, xCoordinate, yCoordinate);
		}

		class TimerListener implements ActionListener
		{

			public void actionPerformed(ActionEvent e)
			{
				repaint();
			}
		}
	}*/
	
}

	

