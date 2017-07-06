package com.press.pojo;

/**
 * PointRelation entity. @author MyEclipse Persistence Tools
 */
public class PointRelation extends AbstractPointRelation implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PointRelation() {
	}

	/** full constructor */
	public PointRelation(Integer printId, Integer sendId) {
		super(printId, sendId);
	}

}
