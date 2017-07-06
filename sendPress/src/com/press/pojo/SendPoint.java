package com.press.pojo;

/**
 * SendPoint entity. @author MyEclipse Persistence Tools
 */
public class SendPoint extends AbstractSendPoint implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public SendPoint() {
	}

	/** full constructor */
	public SendPoint(String sendName, String address, String longitude, String latitude, Integer SId, Integer STel,
			String type, Integer needNum) {
		super(sendName, address, longitude, latitude, SId, STel, type, needNum);
	}

}
