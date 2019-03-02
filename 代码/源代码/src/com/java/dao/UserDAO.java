package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.UserEntity;

public class UserDAO {
	private static String username;
	private static String password;
	private static String type;
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<UserEntity> list;
	public UserDAO(Connection con){
		this.con = con;
		
	}
	public static ArrayList<UserEntity> findAll(){
		String sql = "select username,password,type from user";
		list = new ArrayList<UserEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				UserEntity user = new UserEntity();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setType(rs.getString(3));
				list.add(user);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public UserEntity Enrol(UserEntity ub){
		int num = 0;
		try {
			PreparedStatement ps =
					con.prepareStatement("insert into user (username,password,type) values (?,?,?)");
			ps.setString(1, ub.getUsername());
			ps.setString(2, ub.getPassword());
			ps.setString(3, ub.getType());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num>0){
			return ub;
		}else{
			return null;
		}
	}
}
