package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.java.db.DbManager;
import com.java.entity.DriverEntity;

public class DriverDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<DriverEntity> list;
	public DriverDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(DriverEntity driver){

		boolean flag = false;
        String sql = "INSERT INTO driver(name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			int i=1;
			sta.setString(i++, driver.getName());
		    sta.setString(i++, driver.getSex());
			sta.setString(i++, driver.getNation());
			sta.setString(i++, driver.getJiguan());
			sta.setString(i++, driver.getIdcard());
			sta.setString(i++, driver.getXueli());
			sta.setString(i++, driver.getSchool());
			sta.setString(i++, driver.getTel());
			sta.setString(i++, driver.getMail());
			sta.setString(i++, driver.getAddress());
			sta.setString(i++, driver.getState());
			
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean updateRemark(int id,String remark){
		String sql="UPDATE driver set inf='"+remark+"' where id_p='"+id+"'";
		
		try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean updateState(int id,String state){
		String sql="UPDATE driver set state='"+state+"' where id_p='"+id+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	        return true;
	}
	public static boolean update(DriverEntity driver){
		String sql="UPDATE driver set name=?,sex=?,nation=?,jiguan=?,idcard=?,xueli=?,school=?,tel=?,mail=?,address=?,state=? where id_p='"+driver.getId_p()+"'";
		try {
				sta = (PreparedStatement) DbManager.update(sql);
				//sta.setInt(1, driver.getId());
				int i = 1;
				sta.setString(i++, driver.getName());
				sta.setString(i++, driver.getSex());
				sta.setString(i++, driver.getNation());
				sta.setString(i++, driver.getJiguan());
				sta.setString(i++, driver.getIdcard());
				sta.setString(i++, driver.getXueli());
				sta.setString(i++, driver.getSchool());
				sta.setString(i++, driver.getTel());
				sta.setString(i++, driver.getMail());
				sta.setString(i++, driver.getAddress());
				sta.setString(i++, driver.getState());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				DbManager.close();
				return false;
			}
			DbManager.close();
	        return true;
	}
	public static ArrayList<DriverEntity> findByState(String state,String fendui){
		String sql = "";
		if(fendui.equals("全部"))
		{
		if(state.equals("全部")){
			sql = "select * from driver";
		}else{
			sql = "select * from driver where  state = '"+state+"' ";
		}
		}else{
			sql="select id_de from depart where fendui = '"+fendui+"'";
			ArrayList<Integer> departList = new ArrayList<Integer>();
			rs = DbManager.quert(sql);
			try{
				while(rs.next()){
					departList.add(rs.getInt(1));
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 if(state.equals("全部")){
				 int number = 0;
				 Iterator<Integer> it = departList.iterator();
				 sql = "select * from driver WHERE depart = ";
				 while(it.hasNext()){
				 number++;
				 sql = sql + "'"+it.next()+"'";
				 if(number!=departList.size()){
					 sql = sql + "or depart=";
				 }
				 }
			 }else{
				 sql = "select * from driver where  state = '"+state+"' AND (depart = ";
				 int number = 0;
				 Iterator<Integer> it = departList.iterator();
				 //sql = "select * from driver WHERE depart = ";
				 while(it.hasNext()){
				 number++;
				 sql = sql + "'"+it.next()+"'";
				 if(number!=departList.size()){
					 sql = sql + "or depart=";
				 }else{
					 sql = sql + ")";
				 }
				 }
			 }
		}
		list = new ArrayList<DriverEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				DriverEntity driver= new DriverEntity();
				driver.setId_p(rs.getInt(1));
				driver.setName(rs.getString(2));
				driver.setSex(rs.getString(3));
				driver.setNation(rs.getString(4));
				driver.setJiguan(rs.getString(5));
				driver.setIdcard(rs.getString(6));
				driver.setXueli(rs.getString(7));
				driver.setSchool(rs.getString(8));
				driver.setTel(rs.getString(9));
				driver.setMail(rs.getString(10));
				driver.setAddress(rs.getString(11));
				driver.setState(rs.getString(12));
				list.add(driver);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<DriverEntity> findAll(){
		String sql = "select id_p,driver.name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state from driver ";
		list = new ArrayList<DriverEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				DriverEntity driver= new DriverEntity();
				int i=1;
				driver.setId_p(rs.getInt(i++));
				driver.setName(rs.getString(i++));
				driver.setSex(rs.getString(i++));
				driver.setNation(rs.getString(i++));
				driver.setJiguan(rs.getString(i++));
				driver.setIdcard(rs.getString(i++));
				driver.setXueli(rs.getString(i++));
				driver.setSchool(rs.getString(i++));
				driver.setTel(rs.getString(i++));
				driver.setMail(rs.getString(i++));
				driver.setAddress(rs.getString(i++));
				driver.setState(rs.getString(i++));
				list.add(driver);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		DbManager.close();
		return null;
	}
	public static DriverEntity findByID(int id){
		DriverEntity driver= new DriverEntity();
		//String sql="select * from driver where id_p="+id;
		String sql = "select driver.id_p,driver.name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state from driver WHERE driver.id_p="+id;
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				driver.setId_p(rs.getInt(i++));
				driver.setName(rs.getString(i++));
				driver.setSex(rs.getString(i++));
				driver.setNation(rs.getString(i++));
				driver.setJiguan(rs.getString(i++));
				driver.setIdcard(rs.getString(i++));
				driver.setXueli(rs.getString(i++));
				driver.setSchool(rs.getString(i++));
				driver.setTel(rs.getString(i++));
				driver.setMail(rs.getString(i++));
				driver.setAddress(rs.getString(i++));
				driver.setState(rs.getString(i++));
			}
			DbManager.close();
			return driver;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbManager.close();
		return null;
		
	}
	public static ArrayList<DriverEntity> findByName(String name){
		
		DriverEntity driver= new DriverEntity();
		list = new ArrayList<DriverEntity>();
		//String sql="select * from driver where id_p="+id;
		String sql = "select driver.id_p,name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state from driver WHERE driver.name='"+name+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				driver.setId_p(rs.getInt(i++));
				driver.setName(rs.getString(i++));
				driver.setSex(rs.getString(i++));
				driver.setNation(rs.getString(i++));
				driver.setJiguan(rs.getString(i++));
				driver.setIdcard(rs.getString(i++));
				driver.setXueli(rs.getString(i++));
				driver.setSchool(rs.getString(i++));
				driver.setTel(rs.getString(i++));
				driver.setMail(rs.getString(i++));
				driver.setAddress(rs.getString(i++));
				driver.setState(rs.getString(i++));
				
				list.add(driver);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbManager.close();
		return null;
	}
public static ArrayList<DriverEntity> findByZhiWu(String zhiwu){
		DriverEntity driver= new DriverEntity();
		list = new ArrayList<DriverEntity>();
		//String sql="select * from driver where id_p="+id;
		System.out.println(zhiwu);
		String sql = "select name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state from driver WHERE sex='"+zhiwu+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				driver.setName(rs.getString(i++));
				driver.setSex(rs.getString(i++));
				driver.setNation(rs.getString(i++));
				driver.setJiguan(rs.getString(i++));
				driver.setIdcard(rs.getString(i++));
				driver.setXueli(rs.getString(i++));
				driver.setSchool(rs.getString(i++));
				driver.setTel(rs.getString(i++));
				driver.setMail(rs.getString(i++));
				driver.setAddress(rs.getString(i++));
				driver.setState(rs.getString(i++));
				
				list.add(driver);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbManager.close();
		return null;
	}
public static ArrayList<String> findAllName(){
	String sql = "select name from driver ";
	ArrayList<String> nameList = new ArrayList<String>();
	rs = DbManager.quert(sql);
	try {
		while(rs.next()){
			int i=1;
			nameList.add(rs.getString(i++));
		}
		DbManager.close();
		return nameList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
	DbManager.close();
	return null;
}
	public static DriverEntity findByID2(int id){
		DriverEntity driver= new DriverEntity();
		String sql = "select id_p,driver.name,sex,nation,jiguan,idcard,xueli,school,tel,mail,address,state WHERE driver.id_p="+id;
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				driver.setId_p(rs.getInt(i++));
				driver.setName(rs.getString(i++));
				driver.setSex(rs.getString(i++));
				driver.setNation(rs.getString(i++));
				driver.setJiguan(rs.getString(i++));
				driver.setIdcard(rs.getString(i++));
				driver.setXueli(rs.getString(i++));
				driver.setSchool(rs.getString(i++));
				driver.setTel(rs.getString(i++));
				driver.setMail(rs.getString(i++));
				driver.setAddress(rs.getString(i++));
				driver.setState(rs.getString(i++));
				
			}
			DbManager.close();
			return driver;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbManager.close();
		return null;
	}
	
	
	
	public static void delete(int id){
		String sql="DELETE FROM driver where id_p=?"; 
		
		try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.setInt(1,id	);
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbManager.close();
	}
	
	
}
