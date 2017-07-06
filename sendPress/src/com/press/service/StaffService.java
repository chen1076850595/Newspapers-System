package com.press.service;

import java.util.List;

import com.press.pojo.Staff;
import com.press.pojo.changeJop;

public interface StaffService {
	
	//增
	public String add( Staff staff );
	//按ID查询
	public Staff select( Integer id );
	//改
	public String update( Staff staff );
	//删
	public String del( int id );
	//查找所有用户
	public List<Staff> selectAll();
	//多条件查询用户信息
	public List<Staff> multipleSelect(Staff staff);
	//多条件查询用户信息以及职位
	public List<changeJop> multipleSelect2(changeJop jop);
	//批量删除
	public void batchDel(Integer[] getid);
	//登录检验用户名和密码
	public Object loginCheck(Staff staff);
}
