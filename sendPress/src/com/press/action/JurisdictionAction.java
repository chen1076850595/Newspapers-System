package com.press.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.press.pojo.Jurisdiction;
import com.press.service.JurisdictionServiceImpl;



@Action( value = "jurAction", results = { 
		@Result( name = "success", location = "/delSuccess.jsp")
})
public class JurisdictionAction {
	
	private Jurisdiction jurisdiction;

	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	@Resource(name="jurService")
	private JurisdictionServiceImpl jurServiceImpl;
	
	public String add() {
		
		String reback = jurServiceImpl.add(jurisdiction);
		return reback;
	}
}
