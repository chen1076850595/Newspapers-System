package com.press.pojo;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer fromMan;
	private Integer toMan;
	private String content;
	private Timestamp ntime;
	private Integer readstate;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(Integer fromMan, Integer toMan, String content,
			Timestamp ntime, Integer readstate) {
		this.fromMan = fromMan;
		this.toMan = toMan;
		this.content = content;
		this.ntime = ntime;
		this.readstate = readstate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromMan() {
		return this.fromMan;
	}

	public void setFromMan(Integer fromMan) {
		this.fromMan = fromMan;
	}

	public Integer getToMan() {
		return this.toMan;
	}

	public void setToMan(Integer toMan) {
		this.toMan = toMan;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getNtime() {
		return this.ntime;
	}

	public void setNtime(Timestamp ntime) {
		this.ntime = ntime;
	}

	public Integer getReadstate() {
		return this.readstate;
	}

	public void setReadstate(Integer readstate) {
		this.readstate = readstate;
	}

}