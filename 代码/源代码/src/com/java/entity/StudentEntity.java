package com.java.entity;

public class StudentEntity {
	private int departID;
	private String terminal;
	private String departName;
	private String manageName;
	private String departTel;
	public StudentEntity(){
		super();
	}
	public StudentEntity(int departID,String terminal,String departName,String manageName, String departTel){
		super();
		this.departID = departID;
		this.terminal = terminal;
		this.departName = departName;
		this.manageName = manageName;
		this.departTel = departTel;
	}
	public int getDepartID() {
		return departID;
	}
	public void setDepartID(int departID) {
		this.departID = departID;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getDepartTel() {
		return departTel;
	}
	public void setDepartTel(String departTel) {
		this.departTel = departTel;
	}
	
}
