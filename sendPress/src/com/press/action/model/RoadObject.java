package com.press.action.model;

import java.util.Date;

public class RoadObject {
	private int id;
	private String startAddr;
	private String endAddr;
	private Date arriveTime;
	private String busName;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartAddr() {
		return startAddr;
	}
	public void setStartAddr(String startAddr) {
		this.startAddr = startAddr;
	}
	public String getEndAddr() {
		return endAddr;
	}
	public void setEndAddr(String endAddr) {
		this.endAddr = endAddr;
	}
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
