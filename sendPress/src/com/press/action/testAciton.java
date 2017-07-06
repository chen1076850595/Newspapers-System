package com.press.action;

import org.apache.struts2.convention.annotation.Action;

import com.press.action.model.PointRelationObject;
import com.press.action.model.PrintPointObject;

public class testAciton {
	private PointRelationObject pointRelationObject ;

	
	public PointRelationObject getPointRelationObject() {
		return pointRelationObject;
	}


	public void setPointRelationObject(PointRelationObject pointRelationObject) {
		this.pointRelationObject = pointRelationObject;
	}


	@Action(value="testAction")
	public void test(){
		System.out.println(pointRelationObject);
	}
}
