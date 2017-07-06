package com.press.pojo;

import java.sql.Timestamp;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String username;
	private String password;
	private Timestamp birthday;
	private Integer tel;
	private String dno;
	private Integer level;
	private String jop;
	private Timestamp regdate;
	private Integer state;

	// Constructors

	/** default constructor */
	public Staff() {
	}
	/** full constructor */
	public Staff(String account, String password, String username, Timestamp birthday,
			Integer tel, String dno, Integer level, String jop,
			Timestamp regdate, Integer state) {
		this.account = account;
		this.password = password;
		this.username = username;
		this.birthday = birthday;
		this.tel = tel;
		this.dno = dno;
		this.level = level;
		this.jop = jop;
		this.regdate = regdate;
		this.state = state;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getDno() {
		return this.dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getJop() {
		return this.jop;
	}

	public void setJop(String jop) {
		this.jop = jop;
	}

	public Timestamp getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", account=" + account + ", username="
				+ username + ", tel=" + tel + ", jop=" + jop + ", state="
				+ state + "]";
	}

}