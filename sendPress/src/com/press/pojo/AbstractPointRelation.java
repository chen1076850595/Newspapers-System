package com.press.pojo;

/**
 * AbstractPointRelation entity provides the base persistence definition of the
 * PointRelation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPointRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer printId;
	private Integer sendId;

	// Constructors

	/** default constructor */
	public AbstractPointRelation() {
	}

	/** full constructor */
	public AbstractPointRelation(Integer printId, Integer sendId) {
		this.printId = printId;
		this.sendId = sendId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrintId() {
		return this.printId;
	}

	public void setPrintId(Integer printId) {
		this.printId = printId;
	}

	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

}