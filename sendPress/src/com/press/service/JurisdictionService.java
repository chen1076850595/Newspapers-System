package com.press.service;

import com.press.pojo.Jurisdiction;
import com.press.pojo.Staff;

public interface JurisdictionService {
	//增
	public String add( Jurisdiction jurisdiction );
	//按ID查询
	public Jurisdiction select( Integer id );
	//改
	public String update( Jurisdiction jurisdiction );
	//查
	public String del( int id );
}
