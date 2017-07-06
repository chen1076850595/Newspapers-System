package com.press.pojo;

public class ChangeLevel {

	private Integer sno;
	private String sname;
	private Integer level;
	private String ldescription;
	
	public ChangeLevel(){}
	
	public ChangeLevel(Integer sno, String sname, Integer level, String ldescription) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.level = level;
		this.ldescription = ldescription;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getLdescription() {
		return ldescription;
	}
	public void setLdescription(String ldescription) {
		this.ldescription = ldescription;
	}
	
	
}
