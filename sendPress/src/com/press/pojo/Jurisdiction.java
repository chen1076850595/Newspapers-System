package com.press.pojo;

/**
 * Jurisdiction entity. @author MyEclipse Persistence Tools
 */

public class Jurisdiction implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer level;
	private String description;

	// Constructors

	/** default constructor */
	public Jurisdiction() {
	}

	/** full constructor */
	public Jurisdiction(Integer level, String description) {
		this.level = level;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Jurisdiction [id=" + id + ", level=" + level + ", description="
				+ description + "]";
	}
	
}