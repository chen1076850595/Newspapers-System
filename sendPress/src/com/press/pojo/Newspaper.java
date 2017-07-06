package com.press.pojo;

//import java.sql.Timestamp;
import java.util.Date;


/**
 * Newspaper entity. @author MyEclipse Persistence Tools
 */
public class Newspaper extends AbstractNewspaper implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Newspaper() {
    }

    
    /** full constructor */
    public Newspaper(String name, String type, Integer pageNum, Double pageLength, Double pageWidth, String theme, Date date) {
        super(name, type, pageNum, pageLength, pageWidth, theme, date);        
    }
   
}
