package com.java.entity;

import java.util.Date;

public class AwardEntity {
	public static String[] title = {"编码","人员","时间","奖励项目","奖金","加分","备注"};
	public static int[] width = {8,15,20,20,10,10,10};
	private int id_w;
	private int id_p;
	private Date date;
	private int id_o;
	private String money;
	private String score;
	private String remark;
	private String p_name;
	private String o_name;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getId_w() {
		return id_w;
	}
	public void setId_w(int id_w) {
		this.id_w = id_w;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public int getId_o() {
		return id_o;
	}
	public void setId_o(int id_o) {
		this.id_o = id_o;
	}
}
