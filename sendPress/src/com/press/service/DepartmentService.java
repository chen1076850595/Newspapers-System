package com.press.service;

import com.press.pojo.Department;
import com.press.pojo.Staff;

public interface DepartmentService {
	
	//增
	public String add( Department department );
	//按ID查询
	public Department select( Integer id );
	//改
	public String update( Department department);
	//删
	public String del( int id );
}
