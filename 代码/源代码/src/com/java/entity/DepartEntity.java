package com.java.entity;

public class DepartEntity {
	public static String[] title = {"编码","部门名称","所属分队","主管","分队长","备注"};
	private int id_de;
	private String name;
	private String fendui;
	private String manager;
	private String fenduimanager;
	private String remark;
	public int getId_de() {
		return id_de;
	}
	public void setId_de(int id_de) {
		this.id_de = id_de;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFendui() {
		return fendui;
	}
	public void setFendui(String fendui) {
		this.fendui = fendui;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getFenduimanager() {
		return fenduimanager;
	}
	public void setFenduimanager(String fenduimanager) {
		this.fenduimanager = fenduimanager;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
