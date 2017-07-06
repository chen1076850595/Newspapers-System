package com.press.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.press.pojo.Department;
import com.press.service.DepartmentServiceImpl;



@Action(value = "departmentAction", results = {
        @Result(name = "success", location = "/addsuccess.jsp"),  	
})
public class DepartmentAction {
	
	@Resource(name="departmentService")
	private DepartmentServiceImpl deServiceImpl;
	
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String addDepartment() {
		department.setState(1);
		String reback = deServiceImpl.add( department );
		return reback;
	}
	
}
