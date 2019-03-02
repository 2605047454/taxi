package com.java.addpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.java.dao.CarDAO;
import com.java.entity.CarEntity;
import com.java.swing.CarManagePanel;

public class CarCorJFrame extends JFrame{
	ArrayList<CarEntity> list;
	Vector<String>	dataline;
/*	private JLabel id_c;
	private JLabel number;
	private JLabel type;
	private JLabel state;*/

	private JTextField id_c;
	private JTextField number;
	private JTextField xinghao;
	private JTextField type;
	private JTextField f_number;
	private JTextField j_number;
	private JTextField selltime;
	private JTextField state;
	private JTextField inf;
	private JTextField[] textfields;
	public CarCorJFrame(){
		new BorderLayout();
		this.getContentPane().add(new DriverAddPanel(),BorderLayout.CENTER);
		new BorderLayout();
		this.getContentPane().add(new controlPanel(),BorderLayout.SOUTH);
		setVisible(true);
		setLocation(200,100);
		setSize(620,350);
		
	}
	private class controlPanel extends JPanel implements ActionListener{
		JButton save;
		JButton exit;
		public controlPanel(){
			save = new JButton("保存");
			exit = new JButton("退出");
			save.addActionListener(this);
			exit.addActionListener(this);
			setLayout(new FlowLayout(1,20,10));
			add(save);
			add(exit);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==save){
				CarEntity car = new CarEntity();
				car.setId(Integer.parseInt(id_c.getText()));
				car.setNumber(number.getText());
				car.setXinghao(xinghao.getText());
				car.setType(type.getText());
				car.setF_number(f_number.getText());
				car.setJ_number(j_number.getText());
				//car.setSelltime(selltime.getText());
				car.setState(state.getText());
				car.setInf(inf.getText());
				
				CarDAO.save(car);
				//更新表格内容
				ArrayList<CarEntity> list = CarDAO.findAll();
				CarManagePanel.data.clear();
				for(CarEntity temp : list){
					Vector<String> dataline = new Vector<String>();
					dataline.add(Integer.toString(temp.getId()));
					dataline.add(temp.getNumber());
					dataline.add(temp.getXinghao());
					dataline.add(temp.getType());
					dataline.add(temp.getF_number());
					dataline.add(temp.getJ_number());
					dataline.add(temp.getSelltime().toString());
					dataline.add(temp.getState());
					dataline.add(temp.getInf());
					CarManagePanel.data.add(dataline);
				}
				CarManagePanel.table.updateUI();
				
			}
			if(e.getSource()==exit){
			}
		}
	}
	private class DriverAddPanel extends JPanel{
		private int labelWidth;
		private int labelHeigh;
		private int textWidth;
		private int textHeigh;
		private int buttonWidth;
		private int buttonHeigh;
		private JLabel[] labels;

		private JButton[] buttons;
		public DriverAddPanel(){
			setVisible(true);
			
			labelWidth = 60;
			labelHeigh =40;
			textWidth = 100;
			textHeigh = 20;
			buttonWidth =20;
			buttonHeigh =20;
			setBackground(Color.WHITE);
			this.setLayout(null);
			initLabels();
			initJTextField();
			initButton();
			int j=0;
			for(int i=0;i<labels.length;i++){
				if(i==0){
					labels[i].setLocation(5, 10);
					this.add(labels[i]);
					textfields[i].setLocation(5+labelWidth, 20);
					//textfields[i].setEditable(false);
					this.add(textfields[i]);
					buttons[i].setLocation(5+labelWidth+textWidth, 20);
					this.add(buttons[i]);
				}else{
					labels[i].setLocation(5+((i-1)%3)*200, 10+40*j);
					this.add(labels[i]);
					textfields[i].setLocation(5+((i-1)%3)*200+labelWidth, 20+40*j);
					this.add(textfields[i]);
					buttons[i].setLocation(5+((i-1)%3)*200+labelWidth+textWidth, 20+40*j);
					this.add(buttons[i]);
				}
				if(i==2||i==3||i==6||i==7){
					buttons[i].setVisible(true);
				}
				if(i%3==0)
				{
					j++;
				}
			}
		/*	//给保存，退出按钮设置位置
			save.setLocation(180, 300);
			exit.setLocation(330, 300);
			this.add(save);
			this.add(exit);*/
		}
		private void initJTextField(){
			textfields = new JTextField[9];
			 id_c = createJText();
			 number = createJText();
			 xinghao = createJText();
			 type = createJText();
			 f_number = createJText();
			 j_number = createJText();
			 selltime = createJText();
			 state = createJText();
			 inf = createJText();
			 textfields[0] = id_c; 
			 textfields[1] = number; 
			 textfields[2] = xinghao; 
			 textfields[3] = type; 
			 textfields[4] = f_number; 
			 textfields[5] = j_number; 
			 textfields[6] = selltime; 
			 textfields[7] = state; 
			 textfields[8] = inf; 
		}
		private void initLabels(){
			labels = new JLabel[9];

			labels[0] = createJLabel("编码");
			labels[1] = createJLabel("车牌号");
			labels[2] = createJLabel("品牌型号");
			labels[3] = createJLabel("车辆类型");
			labels[4] = createJLabel("发动机号");
			labels[5] = createJLabel("车架号");
			labels[6] = createJLabel("购入日期");
			labels[7] = createJLabel("车辆状态");
			labels[8] = createJLabel("备注");

		
		}
		private void initButton(){
			buttons = new JButton[9];
			for(int i=0;i<buttons.length;i++){
				buttons[i] = new JButton();
				buttons[i].setSize(buttonWidth, buttonHeigh);
				buttons[i].setVisible(false);
			}
		}
	
		private JTextField createJText(){
			JTextField text = new JTextField();
			text.setSize(textWidth, textHeigh);
			text.setBorder(new MatteBorder(0, 0, 1, 0, Color.DARK_GRAY));
			text.setBackground(Color.WHITE);
			text.setVisible(true);
			return text;
		}
		private JLabel createJLabel(String labelname){
			JLabel label = new JLabel(labelname);
			label.setSize(labelWidth, labelHeigh);
			return label;
		}
	}

}
