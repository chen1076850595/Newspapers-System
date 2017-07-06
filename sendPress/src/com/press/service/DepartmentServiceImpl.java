package com.press.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.DepartmentDAO;
import com.press.pojo.Department;
import com.press.pojo.Staff;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Resource(name="DepartmentDAO")
	private DepartmentDAO departmentDao;
	@Override
	public String add( Department department ) {
		departmentDao.save( department );
		return "success";
	}

	@Override
	public Department select(Integer id) {
		return (Department) departmentDao.findById("com.press.pojo.Department", id );
	}

	@Override
	public String update(Department department) {
		departmentDao.update( department );
		return "update";
	}

	@Override
	public String del(int id) {
		
		Department department = new Department();
		department.setDNo( id );
		departmentDao.delete( department );
		return "delete";
	}

}
