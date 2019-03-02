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
		/*add = new JButton("���");
		update = new JButton("�༭");
		delete = new JButton("ɾ��");*/
		add = createButton("image\\add.png","���");
		update = createButton("image\\edit.png","�༭");
		delete = createButton("image\\delete.png","ɾ��");
		//check = createButton("image\\state.png","�鿴");
		query = createButton("image\\search.png","��ѯ");
		show = createButton("image\\show.png","��ʾ");
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
	        //btn.setUI(new BasicButtonUI());// �ָ������Ӿ�Ч��
		    button.setPreferredSize(new Dimension(40, 40));// ���ð�ť��С
		    button.setContentAreaFilled(true);// ���ð�ť͸��
		    button.setFont(new Font("����", Font.PLAIN, 15));// ��ť�ı���ʽ
		    button.setMargin(new Insets(0, 0, 0, 0));// ��ť������߿����
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
