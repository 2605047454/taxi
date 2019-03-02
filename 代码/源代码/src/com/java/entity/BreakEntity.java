package com.java.entity;

import java.util.Date;

public class BreakEntity {
	public static String[] title = {"编码","驾驶员","车牌号","时间","违章项目","罚款","扣分","地点","备注"};
	public static int[] width = {8,15,15,18,15,10,10,20,8};
	private int id_b;
	private int id_p;
	private int id_c;
	private Date date;
	private int id_o;
	private String money;
	private String score;
	private String place;
	private String remark;
	private String p_name;
	private String c_number;
	private String o_name;
	public int getId_b() {
		return id_b;
	}
	public void setId_b(int idB) {
		id_b = idB;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int idP) {
		id_p = idP;
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
	public int getId_o() {
		return id_o;
	}
	public void setId_o(int id_o) {
		this.id_o = id_o;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getC_number() {
		return c_number;
	}
	public void setC_number(String c_number) {
		this.c_number = c_number;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
}
