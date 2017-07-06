package com.press.pojo;

public class changeJop {
	private Integer sno;
	private String sname;
	private String dname;
	private String djop;
	
	public changeJop(){}
	
	public changeJop(Integer sno, String sname, String dname, String djop) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.dname = dname;
		this.djop = djop;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDjop() {
		return djop;
	}
	public void setDjop(String djop) {
		this.djop = djop;
	}
	
	
}
