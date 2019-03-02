package com.java.entity;

public class DriverInfEntity {
	public static String[] title = {"姓名","加油次数","维修次数","违章次数","扣分额","请假次数","加班次数","加分额"};
	public static int[] width = {12,10,10,10,10,10,10,10};
	private String name;
	private String addoilcount;
	private String repaircount;
	private String breakcount;
	private String scorecount;
	private String leavecount;
	private String workcount;
	private String addscorcount;
	//private String scorecount;
	public static String[] getTitle() {
		return title;
	}
	public static void setTitle(String[] title) {
		DriverInfEntity.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getBreakcount() {
		return breakcount;
	}
	public void setBreakcount(String breakcount) {
		this.breakcount = breakcount;
	}
	public String getScorecount() {
		return scorecount;
	}
	public void setScorecount(String scorecount) {
		this.scorecount = scorecount;
	}
	public String getLeavecount() {
		return leavecount;
	}
	public void setLeavecount(String leavecount) {
		this.leavecount = leavecount;
	}
	public String getWorkcount() {
		return workcount;
	}
	public void setWorkcount(String workcount) {
		this.workcount = workcount;
	}
	public String getAddscorcount() {
		return addscorcount;
	}
	public void setAddscorcount(String addscorcount) {
		this.addscorcount = addscorcount;
	}
	
}
