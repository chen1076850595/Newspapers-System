package com.press.action.model;



public class DistributeObject {
	private int id;
	private String sendName;
	private String address;
	private String type;
	private int needBundle;
	private int needUnitNum;   //零头
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNeedBundle() {
		return needBundle;
	}
	public void setNeedBundle(int needBundle) {
		this.needBundle = needBundle;
	}
	public int getNeedUnitNum() {
		return needUnitNum;
	}
	public void setNeedUnitNum(int needUnitNum) {
		this.needUnitNum = needUnitNum;
	}
	@Override
	public String toString() {
		return "DistributeObject [id=" + id + ", sendName=" + sendName + ", address=" + address + ", type=" + type
				+ ", needBundle=" + needBundle + ", needUnitNum=" + needUnitNum + "]";
	}

	
}
