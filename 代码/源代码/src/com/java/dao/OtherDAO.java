package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.OtherEntity;

public class OtherDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<OtherEntity> list;
	public OtherDAO(Connection con){
		this.con = con;
		
	}
	public static boolean save(OtherEntity depart){

		boolean flag = false;
		String sql = "INSERT INTO other(name,remark,type) VALUES(?,?,?)";
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			int i=1;
			sta.setString(i++, depart.getName());
			sta.setString(i++, depart.getRemark());
			sta.setString(i++, depart.getType());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        return true;
	}
	public static boolean update(OtherEntity driver){
		String sql="UPDATE other set name = ?,sex=?,nation=?,jiguan=?,station=?,d_number=? where id_p=?";
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
	
	
	
	public static ArrayList<OtherEntity> findAll(String type){
		String sql = "SELECT * from other where type='"+type+"'";
		rs =DbManager.quert(sql);
		list = new ArrayList<OtherEntity>();
		//rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				OtherEntity other= new OtherEntity();
				int i=1;
				other.setId_o(rs.getInt(i++));
				other.setName(rs.getString(i++));
				other.setRemark(rs.getString(i++));
				other.setType(rs.getString(i++));
				list.add(other);
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
		String sql="DELETE FROM other where id_o=?"; 
		
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
