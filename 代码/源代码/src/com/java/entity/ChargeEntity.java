package com.java.entity;

public class ChargeEntity {
	public static String[] title = {"编码","驾驶员","车牌号","雇主","里程","收费"};
	public static int[] width = {10,15,15,15,15,15};
	private int id_ch;
	private String name;
	private String number;
	private String boss;
	private String mile;
	private String charge;
	public static int[] getWidth() {
		return width;
	}
	public static void setWidth(int[] width) {
		ChargeEntity.width = width;
	}
	public int getId_ch() {
		return id_ch;
	}
	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getMile() {
		return mile;
	}
	public void setMile(String mile) {
		this.mile = mile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
}
