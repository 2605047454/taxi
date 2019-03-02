package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.CarInfEntity;

public class CarInfDAO {
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<CarInfEntity> list;
	public CarInfDAO(Connection con){
		this.con = con;
	}
	public static ArrayList<CarInfEntity> findAll(){
			
			//String sql = "select car.id_c ,COUNT(addoil.id_a),COUNT(repair.id_r)  FROM car LEFT JOIN(addoil,repair)  on (car.id_c = addoil.id_c AND car.id_c=repair.id_c) GROUP BY car.id_c";
			String sql = "SELECT car.number ,"
					+ "(select COUNT(addoil.id_a)  FROM addoil WHERE car.id_c = addoil.id_c GROUP BY car.id_c),"
					+ "(SELECT COUNT(rEpair.id_r)  FROM repair WHERE car.id_c = repair.id_c GROUP BY car.id_c) FROM car";
			//,(SELECT COUNT(rEpair.id_r)  FROM repair WHERE car.id_c = repair.id_c GROUP BY car.id_c)
			//,(select COUNT(addoil.id_a)  FROM addoil WHERE  car.id_c = addoil.id_c GROUP BY car.id_c)
			list = new ArrayList<CarInfEntity>();
			rs = DbManager.quert(sql);
			try {
				while(rs.next()){
					CarInfEntity carinf= new CarInfEntity();
					carinf.setNumber(rs.getString(1));
					carinf.setAddoilcount(rs.getString(2));
					carinf.setRepaircount(rs.getString(3));
					list.add(carinf);
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
