package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.db.DbManager;
import com.java.entity.StudentEntity;

public class StudentDAO {
	//private static final Connection con = null;
	private int departID;
	private String terminal;
	private String departName;
	private String manageName;
	private String departTel;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public StudentDAO(Connection con){
		this.con = con;
		
	}
/*	public boolean save(StudentEntity student){
		
	
		
		boolean flag = false;
        String sql = "INSERT INTO emp(empno,ename,job,hiredate,sal) VALUES(?,?,?,?,?)";
        pstmt = this.con.prepareStatement(sql);
        this.pstmt.setInt(1, student.getDepartID());
        this.pstmt.setString(2,student.getTerminal()) ;
        this.pstmt.setString(3,student.getDepartName()) ;
        this.pstmt.setString(4,student.getManageName()) ;
        this.pstmt.setString(5,student.getDepartTel()) ;
        if(this.pstmt.executeUpdate() > 0)
        {
            flag = true;
        }
        this.pstmt.close();
        return flag;
		
	}*/
/*	public boolean delete(int id){
		String sql="";
		return DbManager.update(sql)==1;
	}
	public boolean update(StudentEntity student){
		String sql="";
		return DbManager.update(sql)==1;
	}*/

	public StudentEntity findByID(int id){
		String sql="";
		DbManager.quert(sql);
		return null;
	}
	public StudentEntity findAll(){
		String sql="";
		DbManager.quert(sql);
		return null;
	}
	
	
}
