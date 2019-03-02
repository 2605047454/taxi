package com.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.java.dao.UserDAO;
import com.java.entity.UserEntity;
import com.java.swing.Manage;

public class Main extends JFrame{
	public static void main(String[] args) {  
		try
		  {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//Windows风格 
		    //可以传入以下参数javax.swing.plaf.metal.MetalLookAndFeel;   Metal外观  
		  //com.sun.java.swing.plaf.motif.MotifLookAndFeel;   Motif外观  
		  //com.sun.java.swing.plaf.windows.WindowsLookAndFeel;   windows外观 
		    //SwingUtilities.updateComponentTreeUI(getContentPane());
		  }
		  catch(Exception e)
		  {
		   
		  }
		Main j = new Main();  
        j.setVisible(true);  
    }  
	 private static final long serialVersionUID = 1L;  
	    //用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame  
	    int xOld = 0;  
	    int yOld = 0;  
		private JPanel imagePanel;
		private ImageIcon background; 
	    public Main() {  
	    	final JTextField text1 = new JTextField();
	        this.setLayout(null);  
	        //设置出现位置
	        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        this.setBounds(((int)dimension.getWidth() - 500) / 2, ((int)dimension.getHeight() - 500) / 2, 500, 255);
	        //处理拖动事件  
	        this.addMouseListener(new MouseAdapter() {  
	            @Override  
	            public void mousePressed(MouseEvent e) {  
	                xOld = e.getX();  
	                yOld = e.getY();  
	            }  
	        });  
	        this.addMouseMotionListener(new MouseMotionAdapter() {  
	            @Override  
	            public void mouseDragged(MouseEvent e) {  
	                int xOnScreen = e.getXOnScreen();  
	                int yOnScreen = e.getYOnScreen();  
	                int xx = xOnScreen - xOld;  
	                int yy = yOnScreen - yOld;  
	                Main.this.setLocation(xx, yy);  
	            }  
	        });  
	        this.addWindowListener(new WindowAdapter() { 
	            @Override
				public void windowActivated(WindowEvent e) { 
	            	text1.requestFocusInWindow(); 
	            } 
	       });
	        background = new ImageIcon("image\\background.jpg");// 背景图片
			JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
			// 把标签的大小位置设置为图片刚好填充整个面板
			label.setBounds(0, 0, background.getIconWidth(),
					background.getIconHeight());
			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			imagePanel = (JPanel) this.getContentPane();
			imagePanel.setOpaque(false);
			// 内容窗格默认的布局管理器为BorderLayout
			imagePanel.setLayout(null);
			imagePanel.add(new JButton("测试按钮"));

			this.getLayeredPane().setLayout(null);
			// 把背景图片添加到分层窗格的最底层作为背景
			this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(background.getIconWidth(), background.getIconHeight());
			this.setResizable(false);
	        
			//jFrame.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 400, 50);
			//jFrame.setResizable(false);
			//setLayout(null);
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Font f = new Font("楷体", Font.BOLD, 18);
			JLabel label1 = new JLabel("用户名：");
			label1.setFont(f);
			label1.setBounds(150, 290, 100, 30);
			imagePanel.add(label1);
			
			JLabel label2 = new JLabel("密  码：");
			label2.setBounds(150, 320, 100, 30);
			label2.setFont(f);
			imagePanel.add(label2);
			
			text1.setBounds(220, 295, 130, 20);
			text1.requestFocus();
			imagePanel.add(text1);
			
			final JPasswordField text2 = new JPasswordField();
			text2.setBounds(220, 325, 130, 20);
			text2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Boolean key = false;
					ArrayList<UserEntity> user = UserDAO.findAll();
					for(UserEntity temp : user){
						if(temp.getUsername().equals(text1.getText()) && temp.getPassword().equals(text2.getText())) {
							JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new Manage(temp);
							key = true;
							break;
						}
					}
					if(key == false)
					{
						JOptionPane.showMessageDialog(null, "用户名-密码错误", "提示", JOptionPane.ERROR_MESSAGE);
						text1.setText("");
						text2.setText("");
					}
				}
				
			});
			imagePanel.add(text2);
			
			JButton button1 = new JButton("登录");
			button1.setBounds(220, 355, 60, 20);
			imagePanel.add(button1);
			JButton button2 = new JButton("取消");
			button2.setBounds(290, 355, 60, 20);
			imagePanel.add(button2);
			JLabel label3 = new JLabel("注册新用户");
			label3.setForeground(Color.gray);
			label3.setBounds(10, 390, 60, 20);
			imagePanel.add(label3);
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Boolean key = false;
					ArrayList<UserEntity> user = UserDAO.findAll();
					for(UserEntity temp : user){
						if(temp.getUsername().equals(text1.getText()) && temp.getPassword().equals(text2.getText())) {
							JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new Manage(temp);
							key = true;
							break;
						}
					}
					if(key == false)
					{
						JOptionPane.showMessageDialog(null, "错误", "提示", JOptionPane.ERROR_MESSAGE);
						text1.setText("");
						text2.setText("");
					}
				}
			});
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					 System.exit(0);
				}
			});
			setUndecorated(true);
			//setBounds(50,50,500,255);  
			label3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					new Register();
				}
			});
	    }  
	/*public static void main(String[] args) {
		 JPanel imagePanel;
		 ImageIcon background;
		final JFrame jFrame = new JFrame();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		//JLayeredPane用于添加两个图层的，一个用于背景，一个用于界面  
        JLayeredPane layeredPane = new JLayeredPane();  
        layeredPane.setBounds(0, 0, 500, 255);  
        jFrame.add(layeredPane);  
          
        //背景Panel  
        JPanel bgPanel = new JPanel();  
        bgPanel.setBounds(0, 0, 500, 255);  
        layeredPane.add(bgPanel);  
          
        //背景图片，添加到背景Panel里面  
        JLabel bgLabel = new JLabel(new ImageIcon("image/background.jpg"));  
        bgPanel.add(bgLabel);  
        
        //主界面，也就是背景上面的一层Panel  
        JPanel mainPanel = new JPanel();  
        mainPanel.setBounds(0, 0, 500, 255);  
        mainPanel.setLayout(null);  
        layeredPane.add(mainPanel);  
        
		//jFrame.setBounds(((int)dimension.getWidth() - 200) / 2, ((int)dimension.getHeight() - 300) / 2, 400, 50);
		//jFrame.setResizable(false);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label1 = new JLabel("用户名");
		label1.setBounds(10, 10, 100, 30);
		mainPanel.add(label1);
		
		JLabel label2 = new JLabel("密码");
		label2.setBounds(10, 40, 100, 30);
		mainPanel.add(label2);
		
		final JTextField text1 = new JTextField();
		text1.setBounds(50, 15, 130, 20);
		mainPanel.add(text1);
		
		final JPasswordField text2 = new JPasswordField();
		text2.setBounds(50, 45, 130, 20);
		mainPanel.add(text2);
		
		JButton button = new JButton("登录");
		button.setBounds(50, 75, 100, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean key = false;
				ArrayList<UserEntity> user = UserDAO.findAll();
				for(UserEntity temp : user){
					if(temp.getUsername().equals(text1.getText()) && temp.getPassword().equals(text2.getText())) {
						JOptionPane.showMessageDialog(null, "登陆成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						jFrame.dispose();
						new Manage(temp);
						key = true;
						break;
					}
				}
				if(key == false)
				{
					JOptionPane.showMessageDialog(null, "错误", "提示", JOptionPane.ERROR_MESSAGE);
					text1.setText("");
					text2.setText("");
				}
			}
		});
		mainPanel.add(button);
		jFrame.setVisible(true);
		jFrame.setBounds(50,50,500,255);  
		jFrame.setUndecorated(true); 
	}*/

}
