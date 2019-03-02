package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.db.DbManager;
import com.java.entity.CarEntity;
import com.java.tool.ArrayListToString;

public class CarDAO {
/*	private static int id;
	private static String number;
	private static String type;
	private static String state;*/
	private Connection con;
	private static PreparedStatement sta;
	private static ResultSet rs;
	private static ArrayList<CarEntity> list;
	public CarDAO(Connection con){
		this.con = con;
		
	}
	public static ArrayList<CarEntity> findByStateAndType(String type,String state){
		String sql = "";
		if(type.endsWith("全部")&&state.endsWith("全部")){
			sql = "select * from car";
		}else if(type.endsWith("全部")){
			sql = "select * from car where state='"+state+"'";
		}else if(state.endsWith("全部")){
			sql = "select * from car where type='"+type+"'";
		}else{
			sql = "select * from car where state='"+state+"' and type = '"+type+"' ";
		}
		list = new ArrayList<CarEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				CarEntity car= new CarEntity();
				car.setId(rs.getInt(1));
				car.setNumber(rs.getString(2));
				car.setXinghao(rs.getString(3));
				car.setType(rs.getString(4));
				car.setF_number(rs.getString(5));
				car.setJ_number(rs.getString(6));
				car.setSelltime(new java.sql.Date(rs.getDate(7).getTime()));
				car.setState(rs.getString(8));
				car.setInf(rs.getString(9));
				list.add(car);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<CarEntity> findByState(String state){
		String sql = "select * from car where state='"+state+"'";
		list = new ArrayList<CarEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				CarEntity car= new CarEntity();
				car.setId(rs.getInt(1));
				car.setNumber(rs.getString(2));
				car.setXinghao(rs.getString(3));
				car.setType(rs.getString(4));
				car.setF_number(rs.getString(5));
				car.setJ_number(rs.getString(6));
				car.setSelltime(new java.sql.Date(rs.getDate(7).getTime()));
				car.setState(rs.getString(8));
				car.setInf(rs.getString(9));
				list.add(car);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<CarEntity> findAll(){
		
		String sql = "select * from car";
		list = new ArrayList<CarEntity>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				CarEntity car= new CarEntity();
				car.setId(rs.getInt(1));
				car.setNumber(rs.getString(2));
				car.setXinghao(rs.getString(3));
				car.setType(rs.getString(4));
				car.setF_number(rs.getString(5));
				car.setJ_number(rs.getString(6));
				car.setSelltime(new java.sql.Date(rs.getDate(7).getTime()));
				car.setState(rs.getString(8));
				car.setInf(rs.getString(9));
				list.add(car);
			}
			DbManager.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static CarEntity findByID(int id){
		CarEntity car= new CarEntity();
		String sql="select * from car where id_c="+id;
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				car.setId(rs.getInt(1));
				car.setNumber(rs.getString(2));
				car.setXinghao(rs.getString(3));
				car.setType(rs.getString(4));
				car.setF_number(rs.getString(5));
				car.setJ_number(rs.getString(6));
				car.setSelltime(new java.sql.Date(rs.getDate(7).getTime()));
				car.setState(rs.getString(8));
				car.setInf(rs.getString(9));
			}
			DbManager.close();
			return car;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("没有找到车辆信息");
		}
		return null;
		
	}
	public static CarEntity findByNumber(String number){
		CarEntity car= new CarEntity();
		String sql="select * from car where number='"+number+"'";
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				car.setId(rs.getInt(1));
				car.setNumber(rs.getString(2));
				car.setXinghao(rs.getString(3));
				car.setType(rs.getString(4));
				car.setF_number(rs.getString(5));
				car.setJ_number(rs.getString(6));
				car.setSelltime(new java.sql.Date(rs.getDate(7).getTime()));
				car.setState(rs.getString(8));
				car.setInf(rs.getString(9));
			}
			DbManager.close();
			return car;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
public static ArrayList<String> findAllNumber(){
		
		String sql = "select number from car";
		ArrayList<String> numberList = new ArrayList<String>();
		rs = DbManager.quert(sql);
		try {
			while(rs.next()){
				numberList.add(rs.getString(1));
				
			}
			DbManager.close();
			return numberList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean save(CarEntity car){

		boolean flag = false;
        String sql = "INSERT INTO car(number,xinghao,type,f_number,j_number,selltime,state,inf) VALUES(?,?,?,?,?,?,?,?)";
       // pstmt = this.con.prepareStatement(sql);
        try {
			sta = (PreparedStatement) DbManager.update(sql);
			//sta.setInt(1,null);
			//sta.setInt(1, car.getId());
			sta.setString(1, car.getNumber());
			sta.setString(2, car.getXinghao());
			sta.setString(3, car.getType());
			sta.setString(4, car.getF_number());
			sta.setString(5, car.getJ_number());
			sta.setDate(6,new java.sql.Date(car.getSelltime().getTime()));
			sta.setString(7, car.getState());
			sta.setString(8, car.getInf());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
        DbManager.close();
        return true;
	}
	public static boolean updateRemark(int id,String remark){
		String sql="UPDATE car set inf='"+remark+"' where id_c='"+id+"'";
		
		try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean updateState(int id,String state){
		String sql="UPDATE car set state='"+state+"' where id_c='"+id+"'";
		
		try {
			sta = (PreparedStatement) DbManager.update(sql);
			sta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean update(CarEntity car){
		String sql="UPDATE car set number=?,xinghao=?,type=?,f_number=?,j_number=?,selltime=?,state=?,inf=? where id_c='"+car.getId()+"'";
		 try {
				sta = (PreparedStatement) DbManager.update(sql);
				sta.setString(1, car.getNumber());
				sta.setString(2, car.getXinghao());
				sta.setString(3, car.getType());
				sta.setString(4, car.getF_number());
				sta.setString(5, car.getJ_number());
				sta.setDate(6,new java.sql.Date(car.getSelltime().getTime()));
				sta.setString(7, car.getState());
				sta.setString(8, car.getInf());
				sta.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		 DbManager.close();
	        return true;
	}
	public static void delete(int id){
		String sql="DELETE FROM car where id_c=?"; 
		
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
	public static ArrayList<String> showEnumContent(){
		ArrayList<String> carType = new ArrayList<String>();
		String sql = "show columns from car like 'type'";
		ResultSet rs = DbManager.quert(sql);
		try {
		      rs.next();
		      String enums = rs.getString("Type");
		      //System.out.println(enums);
		      int position = 0, count = 0;
		      String[] availableEnums = new String[10];

		      while ((position = enums.indexOf("'", position)) > 0) {
		        int secondPosition = enums.indexOf("'", position + 1);
		        availableEnums[count++] = enums.substring(position + 1,
		            secondPosition);

		        position = secondPosition + 1;
		        carType.add(availableEnums[count - 1]);
		       // System.out.println(availableEnums[count - 1]);
		      }
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		DbManager.close();
		return carType;
	}
	public static void addCarTyep(String newType){
		//String sql = "alter table car modify type enum("a","b","c","d","e","f")";
		 String[] oldcararray=ArrayListToString.arrayListToString( CarDAO.showEnumContent());
		 String[] newcararray = new String[oldcararray.length+1];
		 for(int i=0;i<oldcararray.length;i++){
			 newcararray[i] = oldcararray[i];
		 }
		 newcararray[newcararray.length-1] = newType;
 		String sql1 = "alter table car modify type enum(";
 		String sql2 = "";
 		for(int i=0;i<newcararray.length;i++){
 			sql2+="\'"+newcararray[i]+"\'"+",";
 		}
 		sql2 = sql2.substring(0,sql2.length()-1);
 		String sql3 = ")";
 		String sql = sql1+sql2+sql3;
		System.out.println(sql);
		//DbManager.alter(sql);
		System.out.println(showEnumContent().toString());
		DbManager.close();
	}
	/*public static void main(String args[]){
		addCarTyep("没有");
	}*/
	
}
