package com.java.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.dao.UserDAO;
import com.java.db.DbManager;
import com.java.entity.UserEntity;

public class Register {
	JLabel jl_account,jl_password,jl_type,jl_zhanghaotishi;
	JTextField jt_account;
	JPasswordField jp_password;
	JButton jb_enrol;
	JCheckBox jcb_dredge,jcb_policy;
	JComboBox jcb_type;
	public Register(){
		final JFrame jf = new JFrame("注册界面");
		JPanel jp = new JPanel();
		
		jl_zhanghaotishi = new JLabel("账号不能为空");
		jl_zhanghaotishi.setForeground(Color.red);
		jl_zhanghaotishi.setBounds(110, 110, 100, 20);
		jl_zhanghaotishi.setVisible(false);
		jp.add(jl_zhanghaotishi);
		
		jl_account = new JLabel("账号");
		jl_account.setFont(new Font("宋体", Font.BOLD, 20));
		jl_account.setBounds(50, 50, 70, 40);
		jp.add(jl_account);
		
		jt_account = new JTextField("请输入账号");
		jt_account.setFont(new Font("宋体", Font.BOLD, 20));
		jt_account.setForeground(Color.gray);
		jt_account.addKeyListener(new KeyAdapter() {
			public void keyTyped (KeyEvent e){
				if(jt_account.getText().equals("请输入账号")){
					jt_account.setForeground(Color.black);
					jt_account.setText("");
				}
			}
		});
		jt_account.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				jl_zhanghaotishi.setVisible(false);
			}
			public void focusLost(FocusEvent e){
				if(jt_account.getText().equals("请输入账号")){
					jt_account.setForeground(Color.gray);
					jl_zhanghaotishi.setVisible(true);
				}else if(jt_account.getText().equals("")){
					jt_account.setText("请输入账号");
					jt_account.setForeground(Color.gray);
					jl_zhanghaotishi.setVisible(true);
				}else{
					jl_zhanghaotishi.setVisible(false);
				}
			}
		});
		jt_account.setBounds(110, 50, 220, 40);
		jp.add(jt_account);
		
		jb_enrol = new JButton("立   即   注   册");
		jb_enrol.setBounds(50, 380, 280, 40);
		jb_enrol.setFont(new Font("宋体", Font.BOLD, 20));
		jb_enrol.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String account = jt_account.getText();
				String pass = jp_password.getText();
				String type = (String) jcb_type.getSelectedItem();
				if(!account.equals("请输入账号")
						&& !pass.equals("")){
					UserEntity ue = new UserEntity();
					ue.setUsername(account);
					ue.setPassword(pass);
					ue.setType(type);
					DbManager dm = new DbManager();
					Connection conn = dm.getConnection();
					UserDAO ud = new UserDAO(conn);
					UserEntity ue2 = ud.Enrol(ue);
					if(ue2!=null){
						JOptionPane.showMessageDialog(null, "注册成功");
						jf.dispose();
					}
				}else{
					JOptionPane.showMessageDialog(null, "请完善信息");
				}
			}
		});
		jp.add(jb_enrol);
		
		jl_password = new JLabel("密码");
		jl_password.setBounds(50, 160, 70, 40);
		jl_password.setFont(new Font("宋体", Font.BOLD, 20));
		jp.add(jl_password);
		
		jp_password = new JPasswordField();
		jp_password.setBounds(110, 160, 220, 40);
		jp_password.setFont(new Font("宋体", Font.BOLD, 20));
		jp_password.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e){
				jp_password.setEchoChar('\0'/*0表示查看文本*/);//显示内容
			}
			public void focusLost(FocusEvent e){
				jp_password.setEchoChar('*'/*将内容设置为*号*/);//隐藏内容
			}
		});
		jp.add(jp_password);
		
		jl_type = new JLabel("职位");
		jl_type.setFont(new Font("宋体", Font.BOLD, 20));
		jl_type.setBounds(50, 270, 70, 40);
		jp.add(jl_type);
		
		String [] province = {"司机"};
		jcb_type = new JComboBox(province);
		jcb_type.setBounds(110, 270, 220, 40);
		jcb_type.setFont(new Font("宋体", Font.BOLD, 20));
		jp.add(jcb_type);
		
		jp.setLayout(null);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(480, 130, 400, 500);
	}
}
