package com.java.entity;

import java.util.Date;

public class CarEntity {
	public static String[] title = {"ID","车牌号","品牌型号","车辆类型","发动机号","车架号","购入日期","车辆状态","备注"};
	public static int[] width = {8,15,15,15,15,10,15,15,8};
	private int id;
	private String number;
	private String xinghao;
	private String type;
	private String f_number;
	private String j_number;
	private Date selltime;
	private String state;
	private String inf;
	public CarEntity(){
		
	}
	public CarEntity(int id,String number,String xinghao,String type,String f_number,String j_number,Date selltime,
			String state,String inf){
		this.id = id;
		this.number = number;
		this.type = type;
		this.state = state;
		this.xinghao = xinghao;
		this.f_number = f_number;
		this.j_number = j_number;
		this.selltime = selltime;
		this.inf = inf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getXinghao() {
		return xinghao;
	}
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	public String getF_number() {
		return f_number;
	}
	public void setF_number(String fNumber) {
		f_number = fNumber;
	}
	public String getJ_number() {
		return j_number;
	}
	public void setJ_number(String jNumber) {
		j_number = jNumber;
	}

	public String getInf() {
		return inf;
	}
	public void setInf(String inf) {
		this.inf = inf;
	}
	public Date getSelltime() {
		return selltime;
	}
	public void setSelltime(Date selltime) {
		this.selltime = selltime;
	}
}
