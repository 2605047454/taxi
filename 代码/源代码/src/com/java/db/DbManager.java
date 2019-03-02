package com.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DbManager {
	private static Connection con = null;
	private static Statement sta = null;
	private static ResultSet rs = null;
	public DbManager(){
		try {
			Class.forName(Config.DRIVER);
			DbManager.con = DriverManager.getConnection(Config.url,Config.user,Config.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.url,Config.user,Config.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static Statement update(String sql){
		//int row = 0;
		try {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.url,Config.user,Config.password);
			sta = con.prepareStatement(sql);
			//row = sta.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sta;
	}
	
	public static ResultSet quert(String sql){
		try {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.url,Config.user,Config.password);
			sta = con.prepareStatement(sql);
			rs = sta.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void alter(String sql){
		try {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.url,Config.user,Config.password);
			sta = con.prepareStatement(sql);
			sta.execute(sql);
			//row = sta.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(){
		try{
		if(rs!=null){
			rs.close();
			rs=null;
		}
		if(sta!=null){
			sta.close();
			sta = null;
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
