package com.press.action.model;

public class PrintNumObject {
	private String printName;
	private int totalPrintNum;
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}
	public int getTotalPrintNum() {
		return totalPrintNum;
	}
	public void setTotalPrintNum(int totalPrintNum) {
		this.totalPrintNum = totalPrintNum;
	}
	@Override
	public String toString() {
		return "PrintNumObject [printName=" + printName + ", totalPrintNum=" + totalPrintNum + "]";
	}
	
}
