package com.press.pojo;

import java.sql.Timestamp;


/**
 * Road entity. @author MyEclipse Persistence Tools
 */
public class Road extends AbstractRoad implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Road() {
    }

    
    /** full constructor */
    public Road(String startAddr, String endAddr, Timestamp arriveTime, Integer busId, Integer state) {
        super(startAddr, endAddr, arriveTime, busId, state);        
    }
   
}
