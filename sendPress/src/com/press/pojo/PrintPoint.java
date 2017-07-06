package com.press.pojo;

/**
 * PrintPoint entity. @author MyEclipse Persistence Tools
 */
public class PrintPoint extends AbstractPrintPoint implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public PrintPoint() {
	}

	/** full constructor */
	public PrintPoint(String printName, String printAddress, Integer SId, Integer STel, String longitude,
			String latitude) {
		super(printName, printAddress, SId, STel, longitude, latitude);
	}

}
