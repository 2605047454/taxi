package com.java.entity;

public class CarInfEntity {
	public static String[] title = {"车牌号","加油次数","维修次数"};
	public static int[] width = {10,15,15};
	private String number;
	private String addoilcount;
	private String repaircount;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddoilcount() {
		return addoilcount;
	}
	public void setAddoilcount(String addoilcount) {
		this.addoilcount = addoilcount;
	}
	public String getRepaircount() {
		return repaircount;
	}
	public void setRepaircount(String repaircount) {
		this.repaircount = repaircount;
	}
}
