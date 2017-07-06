package com.press.pojo;

/**
 * AbstractPrintPoint entity provides the base persistence definition of the
 * PrintPoint entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPrintPoint implements java.io.Serializable {

	// Fields

	private Integer id;
	private String printName;
	private String printAddress;
	private Integer SId;
	private Integer STel;
	private String longitude;
	private String latitude;

	// Constructors

	/** default constructor */
	public AbstractPrintPoint() {
	}

	/** full constructor */
	public AbstractPrintPoint(String printName, String printAddress, Integer SId, Integer STel, String longitude,
			String latitude) {
		this.printName = printName;
		this.printAddress = printAddress;
		this.SId = SId;
		this.STel = STel;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrintName() {
		return this.printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public String getPrintAddress() {
		return this.printAddress;
	}

	public void setPrintAddress(String printAddress) {
		this.printAddress = printAddress;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public Integer getSTel() {
		return this.STel;
	}

	public void setSTel(Integer STel) {
		this.STel = STel;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}