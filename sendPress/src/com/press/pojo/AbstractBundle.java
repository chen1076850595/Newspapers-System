package com.press.pojo;

/**
 * AbstractBundle entity provides the base persistence definition of the Bundle
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBundle implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer bundleNum;
	private Integer printId;

	// Constructors

	/** default constructor */
	public AbstractBundle() {
	}

	/** full constructor */
	public AbstractBundle(Integer bundleNum, Integer printId) {
		this.bundleNum = bundleNum;
		this.printId = printId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBundleNum() {
		return this.bundleNum;
	}

	public void setBundleNum(Integer bundleNum) {
		this.bundleNum = bundleNum;
	}

	public Integer getPrintId() {
		return this.printId;
	}

	public void setPrintId(Integer printId) {
		this.printId = printId;
	}

}