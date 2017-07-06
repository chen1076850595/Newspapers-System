package com.press.pojo;

import java.sql.Timestamp;

/**
 * GroupRoad entity. @author MyEclipse Persistence Tools
 */
public class GroupRoad extends AbstractGroupRoad implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public GroupRoad() {
	}

	/** full constructor */
	public GroupRoad(String startPoint, String endPoint, Timestamp arriveTime, Integer busId, Integer state) {
		super(startPoint, endPoint, arriveTime, busId, state);
	}

}
