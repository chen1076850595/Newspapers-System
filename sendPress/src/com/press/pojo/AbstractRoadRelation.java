package com.press.pojo;

/**
 * AbstractRoadRelation entity provides the base persistence definition of the
 * RoadRelation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRoadRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer groupId;
	private Integer roadId;

	// Constructors

	/** default constructor */
	public AbstractRoadRelation() {
	}

	/** full constructor */
	public AbstractRoadRelation(Integer groupId, Integer roadId) {
		this.groupId = groupId;
		this.roadId = roadId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRoadId() {
		return this.roadId;
	}

	public void setRoadId(Integer roadId) {
		this.roadId = roadId;
	}

}