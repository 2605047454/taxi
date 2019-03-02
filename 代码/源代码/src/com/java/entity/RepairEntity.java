package com.java.entity;

import java.util.Date;

public class RepairEntity {
	public static String[] title = {"编码","车牌号","修理厂","是否保养","送修日期","经手人","送修原因","备注"};
	public static int[] width = {8,15,15,10,20,10,15,10};
	private int id_r;
	private int id_c;
	private int id_m;
	private String ifcare;
	private Date date;
	private int id_p;
	private String reason;
	private String remark;
	private String c_number;
	private String m_name;
	private String p_name;
	public static String[] getTitle() {
		return title;
	}
	public static void setTitle(String[] title) {
		RepairEntity.title = title;
	}
	public int getId_r() {
		return id_r;
	}
	public void setId_r(int idR) {
		id_r = idR;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int idC) {
		id_c = idC;
	}
	public int getId_m() {
		return id_m;
	}
	public void setId_m(int idM) {
		id_m = idM;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int idP) {
		id_p = idP;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIfcare() {
		return ifcare;
	}
	public void setIfcare(String ifcare) {
		this.ifcare = ifcare;
	}
	public String getC_number() {
		return c_number;
	}
	public void setC_number(String c_number) {
		this.c_number = c_number;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
}
