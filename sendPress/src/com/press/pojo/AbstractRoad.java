package com.press.pojo;

import java.sql.Timestamp;


/**
 * AbstractRoad entity provides the base persistence definition of the Road entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRoad  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String startAddr;
     private String endAddr;
     private Timestamp arriveTime;
     private Integer busId;
     private Integer state;


    // Constructors

    /** default constructor */
    public AbstractRoad() {
    }

    
    /** full constructor */
    public AbstractRoad(String startAddr, String endAddr, Timestamp arriveTime, Integer busId, Integer state) {
        this.startAddr = startAddr;
        this.endAddr = endAddr;
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

    public String getStartAddr() {
        return this.startAddr;
    }
    
    public void setStartAddr(String startAddr) {
        this.startAddr = startAddr;
    }

    public String getEndAddr() {
        return this.endAddr;
    }
    
    public void setEndAddr(String endAddr) {
        this.endAddr = endAddr;
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