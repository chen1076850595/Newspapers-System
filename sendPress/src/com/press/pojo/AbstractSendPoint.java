package com.press.pojo;

/**
 * AbstractSendPoint entity provides the base persistence definition of the
 * SendPoint entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSendPoint implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sendName;
	private String address;
	private String longitude;
	private String latitude;
	private Integer SId;
	private Integer STel;
	private String type;
	private Integer needNum;

	// Constructors

	/** default constructor */
	public AbstractSendPoint() {
	}

	/** full constructor */
	public AbstractSendPoint(String sendName, String address, String longitude, String latitude, Integer SId,
			Integer STel, String type, Integer needNum) {
		this.sendName = sendName;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.SId = SId;
		this.STel = STel;
		this.type = type;
		this.needNum = needNum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSendName() {
		return this.sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNeedNum() {
		return this.needNum;
	}

	public void setNeedNum(Integer needNum) {
		this.needNum = needNum;
	}

}