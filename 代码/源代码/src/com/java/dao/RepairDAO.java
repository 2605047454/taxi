package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.RepairEntity;

public class RepairDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<RepairEntity> list;
	
	public static boolean save(RepairEntity repair){

        String sql = "INSERT INTO repair(id_r,id_c,id_m,ifcare,date,id_p,reason,remark) VALUES(?,?,?,?,?,?,?,?)";
       // pstmt = this.con.prepareStatement(sql);
       
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.setInt(1, repair.getId_r());
			sta.setInt(2,repair.getId_c());
			sta.setInt(3,repair.getId_m());
			sta.setString(4, repair.getIfcare());
			sta.setDate(5,new java.sql.Date(repair.getDate().getTime()));
			sta.setInt(6, repair.getId_p());
			sta.setString(7, repair.getReason());
			sta.setString(8, repair.getRemark());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(RepairEntity repair){
		String sql="UPDATE repair set id_r=?,id_c=?,id_m=?,ifcare=?,date=?,id_p=?,reason=?,remark=? where id_r='"+repair.getId_r()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				sta.setInt(1, repair.getId_r());
				sta.setInt(2,repair.getId_c());
				sta.setInt(3,repair.getId_m());
				sta.setString(4, repair.getIfcare());
				sta.setDate(5,new java.sql.Date(repair.getDate().getTime()));
				sta.setInt(6, repair.getId_p());
				sta.setString(7, repair.getReason());
				sta.setString(8, repair.getRemark());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				DbManager.close();
				return false;
			}
		 	DbManager.close();
	        return true;
	}
	public static ArrayList<RepairEntity> findAll(){
		String sql = "select repair.id_r,car.number,other.name,ifcare,date,driver.name,reason,repair.remark from repair,car,driver,other WHERE repair.id_c=car.id_c AND repair.id_p=driver.id_p AND repair.id_m=other.id_o";
		list = new ArrayList<RepairEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				RepairEntity repair = new RepairEntity();
				repair.setId_r(rs.getInt(1));
				repair.setC_number(rs.getString(2));
				repair.setM_name(rs.getString(3));
				repair.setIfcare(rs.getString(4));
				repair.setDate(rs.getDate(5));
				repair.setP_name(rs.getString(6));
				repair.setReason(rs.getString(7));
				repair.setRemark(rs.getString(8));
				list.add(repair);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static RepairEntity findByID(int id){
		RepairEntity repair = new RepairEntity();
		//String sql="select * from repair where id_r="+id;
		String sql = "select id_r,repair.id_c,car.number,repair.id_m,other.name,ifcare,date,repair.id_p,driver.name,reason,repair.remark from repair,car,driver,other WHERE repair.id_c=car.id_c AND repair.id_p=driver.id_p AND repair.id_m=other.id_o and repair.id_r='"+id+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i = 1;
				repair.setId_r(rs.getInt(i++));
				repair.setId_c(rs.getInt(i++));
				repair.setC_number(rs.getString(i++));
				repair.setId_m(rs.getInt(i++));
				repair.setM_name(rs.getString(i++));
				repair.setIfcare(rs.getString(i++));
				repair.setDate(rs.getDate(i++));
				repair.setId_p(rs.getInt(i++));
				repair.setP_name(rs.getString(i++));
				repair.setReason(rs.getString(i++));
				repair.setRemark(rs.getString(i++));
			}
			DbManager.close();
			return repair;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static ArrayList<RepairEntity> findByTime(String begintime,String endtime){
		RepairEntity repair = new RepairEntity();
		list = new ArrayList<RepairEntity>();
		String sql = "select id_r,repair.id_c,car.number,repair.id_m,other.name,ifcare,date,repair.id_p,driver.name,reason,repair.remark from repair,car,driver,other WHERE repair.id_c=car.id_c AND repair.id_p=driver.id_p AND repair.id_m=other.id_o and repair.date between '"+begintime+"' and '"+endtime+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i = 1;
				repair.setId_r(rs.getInt(i++));
				repair.setId_c(rs.getInt(i++));
				repair.setC_number(rs.getString(i++));
				repair.setId_m(rs.getInt(i++));
				repair.setM_name(rs.getString(i++));
				repair.setIfcare(rs.getString(i++));
				repair.setDate(rs.getDate(i++));
				repair.setId_p(rs.getInt(i++));
				repair.setP_name(rs.getString(i++));
				repair.setReason(rs.getString(i++));
				repair.setRemark(rs.getString(i++));
				list.add(repair);
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
		String sql="DELETE FROM repair where id_r=?"; 
		
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
