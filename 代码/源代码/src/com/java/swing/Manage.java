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
		super("�����ۺϹ���ϵͳ");
		Manage.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(0, 0, 800, 800);
		paneltool = new JPanel();
		toolbar = new JToolBar();
		centerPanel = new CarStatePanel();
		//infoPanel = new InfoPanel();
		carstate = createButton("image\\state.png","����״̬ͼ");
		car = createButton("image\\car.png","������Ϣ");
		driver = createButton("image\\driver.png","��ʻԱ��Ϣ");
		simulation = createButton("image\\leave.png","ģ����ʾЧ��");
		chargeInfPanel = createButton("image\\statistic.png","������Ϣ");
		
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
		  JMenu jm=new JMenu("�ճ�����") ;     //����JMenu�˵�����
		  JMenuItem t1=new JMenuItem("���ͼ�¼") ;  //�˵���
		  JMenuItem t2=new JMenuItem("ά�޼�¼") ;//�˵���
		  JMenuItem t3=new JMenuItem("Υ�¼�¼") ;//�˵���
		  JMenuItem t4=new JMenuItem("������¼") ;//�˵���
		  JMenuItem t5=new JMenuItem("�ݼټӰ��¼") ;//�˵���
		  JMenuItem t6=new JMenuItem("�����ۺ���Ϣ") ;//�˵���
		  JMenuItem t7=new JMenuItem("��Ա�ۺ���Ϣ") ;//�˵���
		   jm.add(t1) ;   //���˵���Ŀ��ӵ��˵�
		   jm.add(t2) ;    //���˵���Ŀ��ӵ��˵�
		   jm.add(t3) ;    //���˵���Ŀ��ӵ��˵�
		   jm.add(t4) ;    //���˵���Ŀ��ӵ��˵�
		   jm.add(t5) ;    //���˵���Ŀ��ӵ��˵�
		   jm.add(t6) ;    //���˵���Ŀ��ӵ��˵�
		   jm.add(t7) ;    //���˵���Ŀ��ӵ��˵�
		   JMenu jm2=new JMenu("ϵͳ����") ;     //����JMenu�˵�����
		      JMenuItem t21=new JMenuItem("������Ϣ") ;  //�˵���
			  JMenuItem t22=new JMenuItem("ְԱ��Ϣ") ;//�˵���
			  JMenuItem t23=new JMenuItem("������Ϣ") ;//�˵���
			  JMenuItem t24=new JMenuItem("������Ϣ") ;//�˵���
			   jm2.add(t21) ;    //���˵���Ŀ��ӵ��˵�
			   jm2.add(t22) ;    //���˵���Ŀ��ӵ��˵�
			   jm2.add(t23) ;    //���˵���Ŀ��ӵ��˵�
			   jm2.addSeparator();
			   jm2.add(t24) ;    //���˵���Ŀ��ӵ��˵�
			   JMenu jm3=new JMenu("��������") ;     //����JMenu�˵�����
			      JMenuItem t31=new JMenuItem("����û�") ;  //�˵���
				  JMenuItem t32=new JMenuItem("�޸�����") ;//�˵���
				   jm3.add(t31) ;    //���˵���Ŀ��ӵ��˵�
				   jm3.addSeparator();
				   jm3.add(t32) ;    //���˵���Ŀ��ӵ��˵�
			   JMenu jm4 = new JMenu("�������");
			   	  JMenuItem t41=new JMenuItem("����");
			   	  JMenuItem t42=new JMenuItem("����");
			   	   jm4.add(t41);
			   	   jm4.add(t42);
		  JMenuBar  br=new  JMenuBar() ;  //�����˵�������
		   br.add(jm) ;      //���˵����ӵ��˵�������
		   br.add(jm2) ;      //���˵����ӵ��˵�������
		   br.add(jm3) ;      //���˵����ӵ��˵�������
		   br.add(jm4) ;      //���˵����ӵ��˵�������
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
			this.message = "���ڼ�ʻ֤���ڣ��뼰ʱ����";
			timer = new Timer(100, new TimerListener());
			
			this.setLayout(new GridLayout(1, 12));
			Font font = new Font("����", 0, 14);
			label1 = new JLabel("��Ȩ���У����ڻ��˱��϶�");
			label2 = new JLabel("|����Ա�����");
			
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
			g.setFont(new Font("����", 0, 14));
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

	

