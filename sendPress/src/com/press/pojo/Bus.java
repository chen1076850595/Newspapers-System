package com.press.pojo;

/**
 * Bus entity. @author MyEclipse Persistence Tools
 */
public class Bus extends AbstractBus implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Bus() {
	}

	/** full constructor */
	public Bus(String busName, Integer SId, Integer STel) {
		super(busName, SId, STel);
	}

}
