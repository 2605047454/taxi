package com.java.entity;

import java.util.Date;

public class LeaveEntity {
	public static String[] title ={"编码","姓名","请假/加班","起始时间","结束时间","备注"};
	public static int[] width = {8,15,15,20,20,15};
	private int id_l;
	private int id_p;
	private int id_o;
	private Date begintime;
	private Date endtime;
	private String remark;
	private String p_name;
	private String o_name;
	public LeaveEntity(){
		
	}
	public int getId_l() {
		return id_l;
	}
	public void setId_l(int id_l) {
		this.id_l = id_l;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public int getId_o() {
		return id_o;
	}
	public void setId_o(int id_o) {
		this.id_o = id_o;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
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
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
}
