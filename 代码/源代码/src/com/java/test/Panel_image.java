package com.java.test;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel_image extends JFrame
{
 JButton button;
 static Point origin = new Point();
 Point p;
 int width;
 int height;
 
 public Panel_image()
    {
        super("Title");
        button=new JButton();
         NewPanel p = new NewPanel();
        
         p.setOpaque(false);
         this.getContentPane().add(p); //将面板添加到JFrame上
         this.setSize(596,298); //初始窗口的大小
         this.setLocationRelativeTo(null); //设置窗口居中
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
    }
 
    public static void main(String[] args) {
        new Panel_image();
    }
    class NewPanel extends JPanel implements MouseListener, MouseMotionListener
   { 
    private    BasicStroke  stokeLine =   new   BasicStroke(   2.0f   ); 
     public NewPanel()
     { 
     Icon icon1=new ImageIcon("E:/picture/save.jpg"); 
      button.setIcon(icon1);
      button.addMouseListener(this);
      button.addMouseMotionListener(this);
      button.setBounds(width/2, height/2, 20, 20);
      add(button);   
     }
     @Override
	public void paintComponent(Graphics g)
     {
     
     //在jpanel添加图片做背景
        int x=0,y=0;
        ImageIcon icon=new ImageIcon("E:\\picture\\snow3.jpg");
        while(true)
        {
          g.drawImage(icon.getImage(),x,y,this);
          if(x>getSize().width && y>getSize().height)break;
          //这段代码是为了保证在窗口大于图片时，图片仍能覆盖整个窗口
          if(x>getSize().width)
          {
             x=0;
             y+=icon.getIconHeight();
          }
          else
           x+=icon.getIconWidth();
        }
       
        width=getSize().width;
      height=getSize().height;
      System.out.println("1width:"+width/2); 
      super.paintComponent(g);
      Graphics2D g2=(Graphics2D)g;
     g2.setStroke(   stokeLine   );   
   g2.setColor(Color.PINK);
      g2.drawLine(width/2,0,width/2,height);
      g2.drawLine(0,height/2,width,height/2);
     }
 @Override
 public void mouseClicked(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void mouseEntered(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void mouseExited(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void mousePressed(MouseEvent e) {
  origin.x = e.getX();
  origin.y = e.getY();
  p= button.getLocation();
  button.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
    - origin.y); 
   button.setToolTipText("("+String.valueOf(p.x)+","+String.valueOf(p.y)+")");
 }
 @Override
 public void mouseReleased(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void mouseDragged(MouseEvent e) {
  p= button.getLocation();
  button.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
    - origin.y); 
   button.setToolTipText("("+String.valueOf(p.x)+","+String.valueOf(p.y)+")");
  
 }
 @Override
 public void mouseMoved(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }
    
    
   }

}