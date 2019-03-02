package com.java.swing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.java.addpanel.CarAndDriver;
import com.java.dao.ChargeDAO;
import com.java.entity.ChargeEntity;



public class SimulationPanel extends JPanel{
	ChargeEntity charge = new ChargeEntity();
	public static boolean startkey = false;
	JPanel paraPanel = new JPanel();
	JPanel drawPanel = new DrawPanel();
	JPanel pricePanel = new JPanel();
	JPanel comPanel = new JPanel();
	JPanel controlPanel = new JPanel();
	Thread thread;
	Font font;
	JLabel label1 ;
	JLabel label2 ;
	JLabel label3 ;
	JLabel label4 ;
	JLabel label5 ;
	JLabel label6 ;
	JLabel label7 ;
	JLabel label8 ;
	JLabel label9 ;
	JLabel label10 ;
	JLabel label11 ;
	JLabel label12 ;
	double mile;
	double chargesum;
	public static JLabel comlabel4 ;
	public static JLabel comlabel5 ;
	public static JLabel comlabel6 ;
	public static JButton startButton ;
	public int go =0;
	public SimulationPanel(){
		//初始化参数界面
		{	
			thread = null;
			pricePanel.setLayout(new GridLayout(4, 3));
			pricePanel.setBorder(BorderFactory.createTitledBorder("计价信息"));
			 font = new Font("黑体",Font.BOLD,18);
			 label1 = new JLabel("行驶里程:");
			 label2 = new JLabel("合计收费:");
			 label3 = new JLabel("等待时间:");
			 label4 = new JLabel("行驶时间:");
			 label5 = new JLabel("");
			 label6 = new JLabel("");
			 label7 = new JLabel("");
			 label8 = new JLabel("");
			 label9 = new JLabel("公里");
			 label10 = new JLabel("元");
			 label11 = new JLabel("秒");
			 label12 = new JLabel("秒");
		
			 label1.setFont(font);
			 label2.setFont(font);
			 label3.setFont(font);
			 label4.setFont(font);
			 label5.setFont(font);
			 label6.setFont(font);
			 label7.setFont(font);
			 label8.setFont(font);
			 label9.setFont(font);
			 label10.setFont(font);
			 label11.setFont(font);
			 label12.setFont(font);
			 
			pricePanel.add(label1);
			pricePanel.add(label5);
			pricePanel.add(label9);
			pricePanel.add(label2);
			pricePanel.add(label6);
			pricePanel.add(label10);
			pricePanel.add(label3);
			pricePanel.add(label7);
			pricePanel.add(label11);
			pricePanel.add(label4);
			pricePanel.add(label8);
			pricePanel.add(label12);
			
		}
		{
			comPanel.setLayout(new GridLayout(4, 3));
			comPanel.setBorder(BorderFactory.createTitledBorder("车辆/人员信息"));
			
			JLabel comlabel1 = new JLabel("雇主:");
			JLabel comlabel2 = new JLabel("司机:");
			JLabel comlabel3 = new JLabel("车辆:");
			comlabel4 = new JLabel();
			comlabel5 = new JLabel();
			comlabel6 = new JLabel();
			comlabel1.setFont(font);
			comlabel2.setFont(font);
			comlabel3.setFont(font);
			comlabel4.setFont(font);
			comlabel5.setFont(font);
			comlabel6.setFont(font);
			JButton selectButton = new JButton("派车/司机");
			selectButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new CarAndDriver();
					//System.out.println("执行了吗");
				}
			});
			comPanel.add(comlabel1);
			comPanel.add(comlabel4);
			comPanel.add(comlabel2);
			comPanel.add(comlabel5);
			comPanel.add(comlabel3);
			comPanel.add(comlabel6);
			comPanel.add(selectButton);
		}
		//初始化绘图界面
				{
					drawPanel.setBackground(Color.white);
					drawPanel.setSize(400, 600);
					
				}
		{
			controlPanel.setLayout(new GridLayout(3, 1));
			
			startButton =  createButton("image\\start.png","开始");
			startButton.setEnabled(false);
			final JButton suspendButton =  createButton("image\\suspend.png","等待");
			JButton stopButton =  createButton("image\\stop.png","结束");
			final Thread thread = new Thread((Runnable) drawPanel);
			
			startButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					thread.start();
				}
			});
			suspendButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(go==0){
					//thread.suspend();;
					go = 1;
					suspendButton.setText("继续");
					}else{
						//System.out.println(thread.isAlive());
						//thread.resume();;
						go = 0;
						suspendButton.setText("暂停");
					}
				}
			});
			stopButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					thread.stop();
					charge.setName(comlabel5.getText());
					charge.setNumber(comlabel6.getText());
					charge.setBoss(comlabel4.getText());
					charge.setMile(label5.getText());
					//charge.setCharge(Float.parseFloat(label6.getText()+"0.0"));
					charge.setCharge(label6.getText()+" ");
					System.out.println(label5.getText());
					ChargeDAO.save(charge);
					JOptionPane.showMessageDialog(null, "信息已记录，请到“出车信息”查询！");
					//charge.setNumber();
				}
			});
			controlPanel.add(startButton);
			controlPanel.add(suspendButton);
			controlPanel.add(stopButton);
		}
		
		paraPanel.setLayout(new GridLayout(3, 1));
		paraPanel.add(pricePanel);
		paraPanel.add(comPanel);
		paraPanel.add(controlPanel);
		
		//this.setLayout(null);
		this.setLayout(new BorderLayout());
		this.add(drawPanel,BorderLayout.CENTER);
		this.add(paraPanel,BorderLayout.EAST);
		this.setSize(600, 600);
		this.setVisible(true);
		//sthis.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setLayout(new FlowLayout());
		
	}
	//生成Button的函数，控制button的显示效果
	public JButton createButton(String imagePath,String name){
		final JButton button = new JButton(name);
		button.setIcon(new ImageIcon(imagePath));
		button.setSize(40, 100);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setBorderPainted(false);
		button.setBackground(new Color(191,239,255));
		
		//button.addActionListener(this);
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
	
	class DrawPanel extends JPanel implements Runnable{
		private int x=0;
		private int y=440;
		private void init(){
			  Thread thread=new Thread(this); 
			  thread.start();
			 }
		  @Override
		public void paint(Graphics g) {  
		    super.paintComponent(g);  
		    Graphics2D gr = (Graphics2D)g;
		    //设置笔触颜色
		    g.setColor(Color.BLACK); 
		    g.fillRect(0, 400, 1600, 50);
		    g.setColor(Color.WHITE);
		    g.setColor(Color.YELLOW);
		    g.drawLine(0, 450, 1600, 450);
		    g.setColor(Color.BLACK); 
		    g.fillRect(0, 452, 1600, 50);
		    g.setColor(Color.WHITE);
		    //画虚线
		    Stroke dash = new BasicStroke(2.5f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,
		    		3.5f,new float[]{15,10,},0f);
		    gr.setStroke(dash);
		    g.drawLine(0, 425, 1600, 425);
		    g.drawLine(0, 475, 1600, 475);
		    //添加背景图片
		    ImageIcon icon=new ImageIcon("image\\build1.png"); 
	        g.drawImage(icon.getImage(),140,350,this);
	        icon=new ImageIcon("image\\build2.png"); 
	        g.drawImage(icon.getImage(),250,330,this);
	        icon=new ImageIcon("image\\build4.png"); 
	        g.drawImage(icon.getImage(),550,350,this);
	        icon=new ImageIcon("image\\build5.png"); 
	        g.drawImage(icon.getImage(),750,340,this);
	        icon=new ImageIcon("image\\build6.png"); 
	        g.drawImage(icon.getImage(),1000,340,this);
	        icon=new ImageIcon("image\\build3.png"); 
	        g.drawImage(icon.getImage(),1500,330,this);
	        icon=new ImageIcon("image\\tree3.png"); 
	        Random random = new Random();
            for(int i = 0; i < 40;i++) {
            	/* int x = Math.abs(random.nextInt())%1600;
            	 int y = Math.abs(random.nextInt())%300;*/
            	for(int j=0;j<6;j++){
            	 
            	 int x = i*40;
            	 int y = j*60;
            	 g.drawImage(icon.getImage(),x,y,this);
            	}
            }
            for(int i = 0; i < 40;i++) {
           	 
            	for(int j=0;j<8;j++){
               	 
               	 int x = i*40;
               	 int y = j*60+500;
               	 g.drawImage(icon.getImage(),x,y,this);
               	}
           }
           
           //画汽车
            icon=new ImageIcon("image\\taxi.png");
            g.drawImage(icon.getImage(),x,y,this);
          //  icon=new ImageIcon("image\\tree3.png"); 
         
	       // g.drawImage(icon.getImage(),140,350,this);
	        
		  }
		  private void logic(){
			   x = x+10;
			  }
		 @Override
		public void run() {
			  int speed = 20;
			  int gotime = 0;
			  int sustime = 0;
			  int time = 0;
			  while(true){
			   time ++;
			   if(go==0){
			   if(x<1530){
			   gotime = gotime + 20;
			   x=x+speed/20;
			   repaint();
			   if(gotime%100==0)
			   {
				   mile = speed*gotime/80000.0;
				   label5.setText(Double.toString(speed*gotime/80000.0));
			   }
			   //计价原则
			   //起步价8元，超过2公里后每公里3元；
			   if(mile>2){
			   label6.setText(Double.toString(Math.ceil((mile-2))*5+3));
			   }else{
				   label6.setText("8");
			   }
			   	}
			   }
			   if(go==1){
				   //System.out.println("执行了吗");
				   sustime = sustime + 1;
				   if(sustime%50==0)
				   label7.setText(Integer.toString(sustime/50));
			   }
			   if(time%50==0)
			   label8.setText(Double.toString(time/50));
			   try {
			    Thread.sleep(20);
			   } catch (InterruptedException e) {
			    e.printStackTrace();
			   }
			  }
		 	}
		}  
	public static void main(String args[]){
		new SimulationPanel();
		
	}
	
	
}
