package com.java.entity;

import java.util.Date;

public class DriverOverEntity {
	public static String[] title = {"��ʻԱ","��������","��ǰ����","��������","��������"};
	private String name;
	private Date overtime;
	private int getday;
	private int overday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOvertime() {
		return overtime;
	}
	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}
	public int getGetday() {
		return getday;
	}
	public void setGetday(int getday) {
		this.getday = getday;
	}
	public int getOverday() {
		return overday;
	}
	public void setOverday(int overday) {
		this.overday = overday;
	}
}
