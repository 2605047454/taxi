package com.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.java.addpanel.DriverCorJFrame2;


public class QueryPanel extends JToolBar implements ActionListener{
	private JToolBar querybar;
	private JButton add;
	private JButton update;
	private JButton delete;
	private JButton check;
	private JButton query;
	private JButton show;
	public QueryPanel(){
		//querybar = new JToolBar();
		/*add = new JButton("添加");
		update = new JButton("编辑");
		delete = new JButton("删除");*/
		add = createButton("image\\add.png","添加");
		update = createButton("image\\edit.png","编辑");
		delete = createButton("image\\delete.png","删除");
		//check = createButton("image\\state.png","查看");
		query = createButton("image\\search.png","查询");
		show = createButton("image\\show.png","显示");
		//Separator sep = new Separator();
		//sep.setSize(10, 20);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//querybar.setSize(300, 50);
		add.addActionListener(this);
		add(add);
		add(update);
		add(delete);
		this.addSeparator();
		//add(check);
		add(query);
		add(show);
		//add(querybar);
	}
	public JButton createButton(String imagePath,String name){
		    final JButton button = new JButton(name);
		    button.setVerticalTextPosition(SwingConstants.EAST);
	        //btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		    button.setPreferredSize(new Dimension(40, 40));// 设置按钮大小
		    button.setContentAreaFilled(true);// 设置按钮透明
		    button.setFont(new Font("粗体", Font.PLAIN, 15));// 按钮文本样式
		    button.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
	        button.setIcon(new ImageIcon(imagePath));
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
		if(e.getSource()==add){
			new DriverCorJFrame2();
		}
	}
}
