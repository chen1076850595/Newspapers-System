package com.press.pojo;


import java.util.Date;


/**
 * AbstractNewspaper entity provides the base persistence definition of the Newspaper entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractNewspaper  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String type;
     private Integer pageNum;
     private Double pageLength;
     private Double pageWidth;
     private String theme;
     private Date date;


    // Constructors

    /** default constructor */
    public AbstractNewspaper() {
    }

    
    /** full constructor */
    public AbstractNewspaper(String name, String type, Integer pageNum, Double pageLength, Double pageWidth, String theme, Date date) {
        this.name = name;
        this.type = type;
        this.pageNum = pageNum;
        this.pageLength = pageLength;
        this.pageWidth = pageWidth;
        this.theme = theme;
        this.date = date;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }
    
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Double getPageLength() {
        return this.pageLength;
    }
    
    public void setPageLength(Double pageLength) {
        this.pageLength = pageLength;
    }

    public Double getPageWidth() {
        return this.pageWidth;
    }
    
    public void setPageWidth(Double pageWidth) {
        this.pageWidth = pageWidth;
    }

    public String getTheme() {
        return this.theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
   








}