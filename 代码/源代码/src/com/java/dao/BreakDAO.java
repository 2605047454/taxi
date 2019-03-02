package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.BreakEntity;

public class BreakDAO {
	private int id_b;
	private int id_p;
	private int id_c;
	private Date date;
	private String breakitem;
	private String money;
	private String score;
	private String place;
	private String remark;
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<BreakEntity> list;
	public BreakDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(BreakEntity breakentity){

        String sql = "INSERT INTO break(id_b,id_p,id_c,date,id_o,money,score,place,remark) VALUES(?,?,?,?,?,?,?,?,?)";
       // pstmt = this.con.prepareStatement(sql);
       
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.setInt(1, breakentity.getId_b());
			sta.setInt(2, breakentity.getId_p());
			sta.setInt(3, breakentity.getId_c());
			sta.setDate(4,new java.sql.Date(breakentity.getDate().getTime()));
			sta.setInt(5, breakentity.getId_o());
			sta.setString(6, breakentity.getMoney());
			sta.setString(7, breakentity.getScore());
			sta.setString(8, breakentity.getPlace());
			sta.setString(9, breakentity.getRemark());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(BreakEntity breakentity){
		String sql="UPDATE break set id_b=?,id_p=?,id_c=?,date=?,id_o=?,money=?,score=?,place=?,remark=? where id_b='"+breakentity.getId_b()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				sta.setInt(1, breakentity.getId_b());
				sta.setInt(2, breakentity.getId_p());
				sta.setInt(3, breakentity.getId_c());
				sta.setDate(4,new java.sql.Date(breakentity.getDate().getTime()));
				sta.setInt(5, breakentity.getId_o());
				sta.setString(6, breakentity.getMoney());
				sta.setString(7, breakentity.getScore());
				sta.setString(8, breakentity.getPlace());
				sta.setString(9, breakentity.getRemark());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	        return true;
	}
	public static ArrayList<BreakEntity> findAll(){
		String sql = "select id_b,driver.name,car.number,date,other.name,money,score,place,break.remark from break,car,driver,other WHERE break.id_p=driver.id_p AND break.id_c=car.id_c AND break.id_o=other.id_o";
		list = new ArrayList<BreakEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				BreakEntity breakentity = new BreakEntity();
				breakentity.setId_b(rs.getInt(1));
				breakentity.setP_name(rs.getString(2));
				breakentity.setC_number(rs.getString(3));
				breakentity.setDate(rs.getDate(4));
				breakentity.setO_name(rs.getString(5));
				breakentity.setMoney(rs.getString(6));
				breakentity.setScore(rs.getString(7));
				breakentity.setPlace(rs.getString(8));
				breakentity.setRemark(rs.getString(9));
				list.add(breakentity);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static BreakEntity findByID(int id){
		BreakEntity breakentity = new BreakEntity();
		//String sql="select * from break where id_b="+id;
		String sql = "select break.id_b,break.id_p,driver.name,break.id_c,car.number,date,break.id_o,other.name,money,score,place,break.remark from break,car,driver,other WHERE break.id_p=driver.id_p AND break.id_c=car.id_c AND break.id_o=other.id_o AND break.id_b='"+id+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				breakentity.setId_b(rs.getInt(i++));
				breakentity.setId_p(rs.getInt(i++));
				breakentity.setP_name(rs.getString(i++));
				breakentity.setId_c(rs.getInt(i++));
				breakentity.setC_number(rs.getString(i++));
				breakentity.setDate(rs.getDate(i++));
				breakentity.setId_o(rs.getInt(i++));
				breakentity.setO_name(rs.getString(i++));
				breakentity.setMoney(rs.getString(i++));
				breakentity.setScore(rs.getString(i++));
				breakentity.setPlace(rs.getString(i++));
				breakentity.setRemark(rs.getString(i++));
			}
			DbManager.close();
			return breakentity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static ArrayList<BreakEntity> findByTime( String begintime,String endtime){
		BreakEntity breakentity = new BreakEntity();
		list = new ArrayList<BreakEntity>();
		//String sql="select * from break where id_b="+id;
		String sql = "select break.id_b,break.id_p,driver.name,break.id_c,car.number,date,break.id_o,other.name,money,score,place,break.remark from break,car,driver,other WHERE break.id_p=driver.id_p AND break.id_c=car.id_c AND break.id_o=other.id_o AND break.date between '"+begintime+"' and '"+endtime+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i=1;
				breakentity.setId_b(rs.getInt(i++));
				breakentity.setId_p(rs.getInt(i++));
				breakentity.setP_name(rs.getString(i++));
				breakentity.setId_c(rs.getInt(i++));
				breakentity.setC_number(rs.getString(i++));
				breakentity.setDate(rs.getDate(i++));
				breakentity.setId_o(rs.getInt(i++));
				breakentity.setO_name(rs.getString(i++));
				breakentity.setMoney(rs.getString(i++));
				breakentity.setScore(rs.getString(i++));
				breakentity.setPlace(rs.getString(i++));
				breakentity.setRemark(rs.getString(i++));
				list.add(breakentity);
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
		String sql="DELETE FROM break where id_b=?"; 
		
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
