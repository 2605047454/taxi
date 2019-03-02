package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.DriverInfEntity;

public class DriverInfDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<DriverInfEntity> list;
	public DriverInfDAO(Connection con){
		this.con = con;
	}
	public static ArrayList<DriverInfEntity> findAll(){
			
			//String sql = "select car.id_c ,COUNT(addoil.id_a),COUNT(repair.id_r)  FROM car LEFT JOIN(addoil,repair)  on (car.id_c = addoil.id_c AND car.id_c=repair.id_c) GROUP BY car.id_c";
			/*String sql = "SELECT driver.name ,"
					+ "(SELECT COUNT(addoil.id_a)  FROM addoil WHERE driver.id_p = addoil.id_p GROUP BY driver.id_p),"
					+ "(SELECT COUNT(repair.id_r)  FROM repair WHERE driver.id_p = repair.id_p GROUP BY driver.id_p),"
					+ "(SELECT COUNT(break.id_b)  FROM break WHERE driver.id_p = break.id_p GROUP BY driver.id_p),"
					+ "(SELECT SUM(break.score)  FROM break WHERE driver.id_p = break.id_p GROUP BY driver.id_p), "
					+ "(SELECT COUNT(leavework.id_l)  FROM leavework,other WHERE driver.id_p = leavework.id_p AND leavework.id_o=other.id_o AND other.name !='¼Ó°à' GROUP BY driver.id_p),"
					+ "(SELECT COUNT(leavework.id_l)  FROM leavework,other WHERE driver.id_p = leavework.id_p AND leavework.id_o=other.id_o AND other.name ='¼Ó°à' GROUP BY driver.id_p)"
					+ "FROM driver";*/
			String sql = "select * from driverinf";
			//,(SELECT COUNT(rEpair.id_r)  FROM repair WHERE car.id_c = repair.id_c GROUP BY car.id_c)
			//,(select COUNT(addoil.id_a)  FROM addoil WHERE  car.id_c = addoil.id_c GROUP BY car.id_c)
			list = new ArrayList<DriverInfEntity>();
			rs = DbManager.quert(sql);
			try {
				while(rs.next()){
					DriverInfEntity driver= new DriverInfEntity();
					driver.setName(rs.getString(1));
					driver.setAddoilcount(rs.getString(2));
					driver.setRepaircount(rs.getString(3));
					driver.setBreakcount(rs.getString(4));
					driver.setScorecount(rs.getString(5));
					driver.setLeavecount(rs.getString(6));
					driver.setWorkcount(rs.getString(7));
					driver.setAddscorcount(rs.getString(8));
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
}
