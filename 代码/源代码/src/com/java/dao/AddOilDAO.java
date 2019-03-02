package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.AddOilEntity;

public class AddOilDAO {
	private static int id;
	private static String name;
	private static String sex;
	private static String nation;
	private static String jiguan;
	private static String station;
	private static int d_number;
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<AddOilEntity> list;
	public AddOilDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(AddOilEntity addoil){

        String sql = "INSERT INTO addoil(id_c,date,code,oiltype,mass,meter,id_p,remark) VALUES(?,?,?,?,?,?,?,?)";
       // pstmt = this.con.prepareStatement(sql);
       
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			//sta.setInt(1, addoil.getId_a());
			sta.setInt(1,addoil.getId_c());
			sta.setDate(2,new java.sql.Date(addoil.getDate().getTime()));
			sta.setString(3, addoil.getCode());
			sta.setString(4, addoil.getOiltype());
			sta.setString(5, addoil.getMass());
			sta.setString(6, addoil.getMeter());
			sta.setInt(7, addoil.getId_p());
			sta.setString(8, addoil.getRemark());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(AddOilEntity addoil){
		String sql="UPDATE addoil set id_c=?,date=?,code=?,oiltype=?,mass=?,meter=?,id_p=?,remark=? where id_a='"+addoil.getId_a()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				//sta.setInt(1, driver.getId());
				int i = 1;
				sta.setInt(i++,addoil.getId_c());
				sta.setDate(i++, new java.sql.Date(addoil.getDate().getTime()));
				sta.setString(i++, addoil.getCode());
				sta.setString(i++, addoil.getOiltype());
				sta.setString(i++, addoil.getMass());
				sta.setString(i++, addoil.getMeter());
				sta.setInt(i++, addoil.getId_p());
				sta.setString(i++, addoil.getRemark());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	        return true;
	}
	public static ArrayList<AddOilEntity> findAll(){
		String sql = "select id_a,car.number,date,code,oiltype,mass,meter,driver.name,remark from addoil,driver,car WHERE addoil.id_p=driver.id_p and addoil.id_c=car.id_c";
		list = new ArrayList<AddOilEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				AddOilEntity addoil = new AddOilEntity();
				addoil.setId_a(rs.getInt(1));
				addoil.setC_number(rs.getString(2));
				addoil.setDate(rs.getDate(3));
				addoil.setCode(rs.getString(4));
				addoil.setOiltype(rs.getString(5));
				addoil.setMass(rs.getString(6));
				addoil.setMeter(rs.getString(7));
				addoil.setP_name(rs.getString(8));
				addoil.setRemark(rs.getString(9));
				list.add(addoil);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static AddOilEntity findByID(int id){
		AddOilEntity addoil = new AddOilEntity();
		String sql = "select id_a,addoil.id_c,car.number,date,code,oiltype,mass,meter,addoil.id_p,driver.name,remark from addoil,driver,car WHERE addoil.id_p=driver.id_p and addoil.id_c=car.id_c and addoil.id_a='"+id+"'";   
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i =1;
				addoil.setId_a(rs.getInt(i++));
				addoil.setId_c(rs.getInt(i++));
				addoil.setC_number(rs.getString(i++));
				addoil.setDate(rs.getDate(i++));
				addoil.setCode(rs.getString(i++));
				addoil.setOiltype(rs.getString(i++));
				addoil.setMass(rs.getString(i++));
				addoil.setMeter(rs.getString(i++));
				addoil.setId_p(rs.getInt(i++));
				addoil.setP_name(rs.getString(i++));
				addoil.setRemark(rs.getString(i++));
				
			}
			DbManager.close();
			return addoil;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<AddOilEntity> findByTime(String begintime,String endtime){
		AddOilEntity addoil = new AddOilEntity();
		list = new ArrayList<AddOilEntity>();
		String sql = "select id_a,addoil.id_c,car.number,date,code,oiltype,mass,meter,addoil.id_p,driver.name,remark from addoil,driver,car WHERE addoil.id_p=driver.id_p and addoil.id_c=car.id_c and addoil.date between '"+begintime+"' and '"+endtime+"'";   
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i =1;
				addoil.setId_a(rs.getInt(i++));
				addoil.setId_c(rs.getInt(i++));
				addoil.setC_number(rs.getString(i++));
				addoil.setDate(rs.getDate(i++));
				addoil.setCode(rs.getString(i++));
				addoil.setOiltype(rs.getString(i++));
				addoil.setMass(rs.getString(i++));
				addoil.setMeter(rs.getString(i++));
				addoil.setId_p(rs.getInt(i++));
				addoil.setP_name(rs.getString(i++));
				addoil.setRemark(rs.getString(i++));
				list.add(addoil);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void delete(int id){
		String sql="DELETE FROM addoil where id_a=?"; 
		
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
