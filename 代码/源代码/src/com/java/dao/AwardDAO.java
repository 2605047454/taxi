package com.java.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.AwardEntity;

public class AwardDAO {
	private int id_w;
	private int id_p;
	private Date date;
	private String item;
	private String money;
	private String score;
	private String remark;
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<AwardEntity> list;
	public AwardDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(AwardEntity awardentity){

        String sql = "INSERT INTO award(id_w,id_p,date,id_o,money,score,remark) VALUES(?,?,?,?,?,?,?)";
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.setInt(1, awardentity.getId_w());
			sta.setInt(2, awardentity.getId_p());
			sta.setDate(3,new java.sql.Date(awardentity.getDate().getTime()));
			sta.setInt(4, awardentity.getId_o());
			sta.setString(5, awardentity.getMoney());
			sta.setString(6, awardentity.getScore());
			sta.setString(7, awardentity.getRemark());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(AwardEntity awardentity){
		String sql="UPDATE award set id_w=?,id_p=?,date=?,id_o=?,money=?,score=?,remark=? where id_w='"+awardentity.getId_w()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				sta.setInt(1, awardentity.getId_w());
				sta.setInt(2, awardentity.getId_p());
				sta.setDate(3,new java.sql.Date(awardentity.getDate().getTime()));
				sta.setInt(4, awardentity.getId_o());
				sta.setString(5, awardentity.getMoney());
				sta.setString(6, awardentity.getScore());
				sta.setString(7, awardentity.getRemark());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	        return true;
	}
	public static ArrayList<AwardEntity> findAll(){
		String sql = "select id_w,driver.name,date,other.name,money,score,award.remark from award,driver,other WHERE award.id_p=driver.id_p and award.id_o=other.id_o";
		list = new ArrayList<AwardEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				AwardEntity awardentity = new AwardEntity();
				awardentity.setId_w(rs.getInt(1));
				awardentity.setP_name(rs.getString(2));
				awardentity.setDate(rs.getDate(3));
				awardentity.setO_name(rs.getString(4));
				awardentity.setMoney(rs.getString(5));
				awardentity.setScore(rs.getString(6));
				awardentity.setRemark(rs.getString(7));
				list.add(awardentity);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static AwardEntity findByID(int id){
		AwardEntity awardentity = new AwardEntity();
		//String sql="select * from award where id_b="+id;
		String sql = "select award.id_w,award.id_p,driver.name,date,award.id_o,other.name,money,score,award.remark from award,driver,other WHERE award.id_p=driver.id_p and award.id_o=other.id_o and award.id_w='"+id+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i = 1;
				awardentity.setId_w(rs.getInt(i++));
				awardentity.setId_p(rs.getInt(i++));
				awardentity.setP_name(rs.getString(i++));
				awardentity.setDate(rs.getDate(i++));
				awardentity.setId_o(rs.getInt(i++));
				awardentity.setO_name(rs.getString(i++));
				awardentity.setMoney(rs.getString(i++));
				awardentity.setScore(rs.getString(i++));
				awardentity.setRemark(rs.getString(i++));
			}
			DbManager.close();
			return awardentity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public static ArrayList<AwardEntity> findByTime(String begintime,String endtime){
		AwardEntity awardentity = new AwardEntity();
		list = new ArrayList<AwardEntity>();
		String sql = "select award.id_w,award.id_p,driver.name,date,award.id_o,other.name,money,score,award.remark from award,driver,other WHERE award.id_p=driver.id_p and award.id_o=other.id_o and award.date between '"+begintime+"' and '"+endtime+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				int i = 1;
				awardentity.setId_w(rs.getInt(i++));
				awardentity.setId_p(rs.getInt(i++));
				awardentity.setP_name(rs.getString(i++));
				awardentity.setDate(rs.getDate(i++));
				awardentity.setId_o(rs.getInt(i++));
				awardentity.setO_name(rs.getString(i++));
				awardentity.setMoney(rs.getString(i++));
				awardentity.setScore(rs.getString(i++));
				awardentity.setRemark(rs.getString(i++));
				list.add(awardentity);
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
		String sql="DELETE FROM award where id_w=?"; 
		
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
