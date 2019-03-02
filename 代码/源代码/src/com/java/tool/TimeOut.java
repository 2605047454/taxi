package com.java.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TimeOut {
	Connection con;
	Statement sta;
	static ResultSet rs;
	/*public TimeOut(){
		findTimeOut();
	}*/
	/*public static ArrayList<DriverOverEntity> findDriverTimeOut(){
		Vector<Date> temp = new Vector<Date>();
		ArrayList<DriverOverEntity> list = new ArrayList<DriverOverEntity>();
		String sql = "SELECT overtime,name FROM driver";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				if(rs.getDate(1).before(new Date())){
					DriverOverEntity driverover = new DriverOverEntity();
					driverover.setOvertime(rs.getDate(1));
					driverover.setName(rs.getString(2));
					long diff = new Date().getTime()-rs.getDate(1).getTime();
					long days = diff / (1000 * 60 * 60 * 24);
					driverover.setOverday((int)days);
					list.add(driverover);
				}
				else if(rs.getDate(1).getTime() - new Date().getTime()>5)
				{
					DriverOverEntity driverover = new DriverOverEntity();
					driverover.setOvertime(rs.getDate(1));
					driverover.setName(rs.getString(2));
					long diff = rs.getDate(1).getTime()-new Date().getTime();
					long days = diff / (1000 * 60 * 60 * 24);
					driverover.setGetday((int)days);
					list.add(driverover);
				}
			}
			DbManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		
	}*/
	
}
