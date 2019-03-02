package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.LeaveEntity;

public class LeaveDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<LeaveEntity> list;
	public static boolean save(LeaveEntity leave){

        String sql = "INSERT INTO leavework(id_l,id_p,id_o,begintime,endtime,remark) VALUES(?,?,?,?,?,?)";
       // pstmt = this.con.prepareStatement(sql);
       
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.setInt(1, leave.getId_l());
			sta.setInt(2,leave.getId_p());
			sta.setInt(3,leave.getId_o());
			sta.setDate(4, new java.sql.Date(leave.getBegintime().getTime()));
			sta.setDate(5,new java.sql.Date(leave.getEndtime().getTime()));
			sta.setString(6, leave.getRemark());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(LeaveEntity leave){
		String sql="UPDATE leavework set id_l=?,id_p=?,id_o=?,begintime=?,endtime=?,remark=? where id_l='"+leave.getId_l()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				int i=1;
				sta.setInt(i++, leave.getId_l());
				sta.setInt(i++,leave.getId_p());
				sta.setInt(i++,leave.getId_o());
				sta.setDate(i++, new java.sql.Date(leave.getBegintime().getTime()));
				sta.setDate(i++, new java.sql.Date(leave.getEndtime().getTime()));
				sta.setString(i++, leave.getRemark());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				DbManager.close();
				return false;
			}
		 	DbManager.close();
	        return true;
	}
	public static ArrayList<LeaveEntity> findAll(){
		String sql = "select id_l,driver.name,other.name,begintime,endtime,leavework.remark from leavework,driver,other WHERE leavework.id_p=driver.id_p AND leavework.id_o=other.id_o";
		list = new ArrayList<LeaveEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				LeaveEntity leave = new LeaveEntity();
				int i=1;
				leave.setId_l(rs.getInt(i++));
				leave.setP_name(rs.getString(i++));
				leave.setO_name(rs.getString(i++));
				leave.setBegintime(rs.getDate(i++));
				leave.setEndtime(rs.getDate(i++));
				leave.setRemark(rs.getString(i++));
				list.add(leave);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static LeaveEntity findByID(int id){
		LeaveEntity leave = new LeaveEntity();
		//String sql="select * from addoil where id_a="+id;
		String sql = "select id_l,leavework.id_p,driver.name,leavework.id_o,other.name,begintime,endtime,leavework.remark from leavework,driver,other WHERE leavework.id_p=driver.id_p AND leavework.id_o=other.id_o AND leavework.id_l='"+id+"'";   
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i =1;
				leave.setId_l(rs.getInt(i++));
				leave.setId_p(rs.getInt(i++));
				leave.setP_name(rs.getString(i++));
				leave.setId_o(rs.getInt(i++));
				leave.setO_name(rs.getString(i++));
				leave.setBegintime(rs.getDate(i++));
				leave.setEndtime(rs.getDate(i++));
				leave.setRemark(rs.getString(i++));
				
			}
			DbManager.close();
			return leave;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static ArrayList<LeaveEntity> findByTime(String begintime,String endtime){
		LeaveEntity leave = new LeaveEntity();
		list = new ArrayList<LeaveEntity>();
		String sql = "select id_l,leavework.id_p,driver.name,leavework.id_o,other.name,begintime,endtime,leavework.remark from leavework,driver,other WHERE leavework.id_p=driver.id_p AND leavework.id_o=other.id_o AND leavework.begintime between '"+begintime+"' and '"+endtime+"'";  
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i =1;
				leave.setId_l(rs.getInt(i++));
				leave.setId_p(rs.getInt(i++));
				leave.setP_name(rs.getString(i++));
				leave.setId_o(rs.getInt(i++));
				leave.setO_name(rs.getString(i++));
				leave.setBegintime(rs.getDate(i++));
				leave.setEndtime(rs.getDate(i++));
				leave.setRemark(rs.getString(i++));
				list.add(leave);
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
		String sql="DELETE FROM leavework where id_l=?"; 
		
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
