package com.press.pojo;

import java.sql.Timestamp;

/**
 * AbstractGroupRoad entity provides the base persistence definition of the
 * GroupRoad entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGroupRoad implements java.io.Serializable {

	// Fields

	private Integer id;
	private String startPoint;
	private String endPoint;
	private Timestamp arriveTime;
	private Integer busId;
	private Integer state;

	// Constructors

	/** default constructor */
	public AbstractGroupRoad() {
	}

	/** full constructor */
	public AbstractGroupRoad(String startPoint, String endPoint, Timestamp arriveTime, Integer busId, Integer state) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.arriveTime = arriveTime;
		this.busId = busId;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public Timestamp getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}