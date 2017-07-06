package com.press.pojo;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer DNo;
	private String DName;
	private Integer DTel;
	private Integer state;

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String DName, Integer DTel, Integer state) {
		this.DName = DName;
		this.DTel = DTel;
		this.state = state;
	}

	// Property accessors

	public Integer getDNo() {
		return this.DNo;
	}

	public void setDNo(Integer DNo) {
		this.DNo = DNo;
	}

	public String getDName() {
		return this.DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public Integer getDTel() {
		return this.DTel;
	}

	public void setDTel(Integer DTel) {
		this.DTel = DTel;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}