package com.press.pojo;

/**
 * AbstractBus entity provides the base persistence definition of the Bus
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String busName;
	private Integer SId;
	private Integer STel;

	// Constructors

	/** default constructor */
	public AbstractBus() {
	}

	/** full constructor */
	public AbstractBus(String busName, Integer SId, Integer STel) {
		this.busName = busName;
		this.SId = SId;
		this.STel = STel;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusName() {
		return this.busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
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

}