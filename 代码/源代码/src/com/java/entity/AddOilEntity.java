package com.java.entity;

import java.util.Date;


public class AddOilEntity {
	public static String[] title = {"编码","车牌号","加油日期","油卡编号","油料标号","加油量","里程","经手人","备注"};
	public static int[] width = {10,15,18,15,15,10,10,10,15};
	private int id_a;
	private int id_c;
	private Date date;
	private String code;
	private String oiltype;
	private String mass;
	private String meter;
	private int id_p;
	private String remark;
	private String c_number;
	private String p_name;
	public static String[] getTitle() {
		return title;
	}
	public static void setTitle(String[] title) {
		AddOilEntity.title = title;
	}
	public int getId_a() {
		return id_a;
	}
	public void setId_a(int idA) {
		id_a = idA;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int idC) {
		id_c = idC;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOiltype() {
		return oiltype;
	}
	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	public String getMeter() {
		return meter;
	}
	public void setMeter(String meter) {
		this.meter = meter;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int idP) {
		id_p = idP;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getC_number() {
		return c_number;
	}
	public void setC_number(String c_number) {
		this.c_number = c_number;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
}

