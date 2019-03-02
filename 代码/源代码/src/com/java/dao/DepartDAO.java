package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import com.java.db.DbManager;
import com.java.entity.DepartEntity;

public class DepartDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<DepartEntity> list;
	public DepartDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(DepartEntity depart){

		boolean flag = false;
		String sql = "INSERT INTO depart(name,fendui,manager,fenduimanager,remark) VALUES(?,?,?,?,?)";
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			int i=1;
			sta.setString(i++, depart.getName());
			sta.setString(i++, depart.getFendui());
			sta.setString(i++, depart.getManager());
			sta.setString(i++, depart.getFenduimanager());
			sta.setString(i++, depart.getRemark());
			
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(DepartEntity driver){
		String sql="UPDATE depart set name = ?,sex=?,nation=?,jiguan=?,station=?,d_number=? where id_p=?";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				//sta.setInt(1, driver.getId());
				/*sta.setString(1, driver.getName());
				sta.setString(2, driver.getSex());
				sta.setString(3, driver.getNation());
				sta.setString(4, driver.getJiguan());
				sta.setString(5, driver.getStation());
				sta.setInt(6, driver.getD_number());
				sta.setInt(7, driver.getId());*/
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	        return true;
	}
	
	public static HashSet<String> findDepartName(){
		String sql = "SELECT fendui from depart ";
		HashSet<String> departset = new HashSet<String>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				departset.add(rs.getString(1));
			}
		DbManager.close();
		return departset;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<DepartEntity> findAll(){
		String sql = "select * from depart";
		list = new ArrayList<DepartEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				DepartEntity driver= new DepartEntity();
				int i=1;
				driver.setId_de(rs.getInt(i++));
				driver.setName(rs.getString(i++));
				driver.setFendui(rs.getString(i++));
				driver.setManager(rs.getString(i++));
				driver.setFenduimanager(rs.getString(i++));
				driver.setRemark(rs.getString(i++));
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
	
	public static void delete(int id){
		String sql="DELETE FROM depart where id_de=?"; 
		
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
