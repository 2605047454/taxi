package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.ChargeEntity;

public class ChargeDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<ChargeEntity> list;
	public ChargeDAO(Connection con){
		this.con = con;
		
	}
public static ArrayList<ChargeEntity> findAll(){
		
		String sql = "select * from charge";
		list = new ArrayList<ChargeEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				ChargeEntity charge= new ChargeEntity();
				charge.setId_ch(rs.getInt(1));
				charge.setName(rs.getString(2));
				charge.setNumber(rs.getString(3));
				charge.setBoss(rs.getString(4));
				charge.setMile(rs.getString(5));
				charge.setCharge(rs.getString(6));
				
				list.add(charge);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
public static boolean save(ChargeEntity charge){

    String sql = "INSERT INTO charge(name,number,boss,mile,charge) VALUES(?,?,?,?,?)";
   // pstmt = this.con.prepareStatement(sql);
    try {
		sta = (PreparedStatement) DbManager.update(sql);
		sta.setString(1, charge.getName());
		sta.setString(2, charge.getNumber());
		sta.setString(3, charge.getBoss());
		sta.setString(4, charge.getMile());
		sta.setString(5, charge.getCharge());

		sta.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
    DbManager.close();
    return true;
}
}
