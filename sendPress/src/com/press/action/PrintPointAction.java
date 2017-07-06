package com.press.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.If;
import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.press.action.model.PrintPointObject;
import com.press.dao.StaffDAO;
import com.press.pojo.PrintPoint;
import com.press.pojo.Staff;
import com.press.service.PrintPointServiceImpl;
import com.press.util.PressUtil;

public class PrintPointAction {

	private PrintPoint printPoint;
	private Staff staff;
	private List<PrintPoint> printList = new ArrayList<PrintPoint>();
	private String points;
	private PrintPointObject pointObject = new PrintPointObject();
	List<PrintPointObject> objects = new ArrayList<PrintPointObject>();


	public PrintPointObject getPointObject() {
		return pointObject;
	}

	public void setPointObject(PrintPointObject pointObject) {
		this.pointObject = pointObject;
	}

	public List<PrintPoint> getPrintList() {
		return printList;
	}

	public void setPrintList(List<PrintPoint> printList) {
		this.printList = printList;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public PrintPoint getPrintPoint() {
		return printPoint;
	}

	public void setPrintPoint(PrintPoint printPoint) {
		this.printPoint = printPoint;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Resource(name = "PrintPointServiceImpl")
	private PrintPointServiceImpl printPointServiceImpl;
	@Resource(name = "StaffDAO")
	private StaffDAO staffDAO;

	// 增删改查
	@Action(value = "addPrintPoint")
	public void add() {
		Staff user = new Staff(); 
		if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
		user = (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
		}
		if(user.getUsername()!=null){
		PrintPoint p = new PrintPoint();
		
		p.setLatitude(printPoint.getLatitude());
		p.setLongitude(printPoint.getLongitude());
		p.setPrintAddress(printPoint.getPrintAddress());
		p.setPrintName(printPoint.getPrintName());
		p.setSId(user.getId());
		p.setSTel(user.getTel());
		printPointServiceImpl.addPrintPoint(p);
		String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
		PressUtil.send(mess);
		}
		else{
			System.out.println("保存失败");
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！用户不存在")));
			PressUtil.send(mess);
	
		}
		
	}

	@Action(value = "deletePrintPoint")
	public void delete() {
		printPointServiceImpl.delPrintPoint(printPoint);
		String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("删除成功！")));
		PressUtil.send(mess);
	}

	@Action(value = "deletePrintPoints")
	public void deletes() {
		printPointServiceImpl.delPrintPoints(PressUtil.getId());
		String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("删除成功")));
		PressUtil.send(mess);
	}

	@Action(value = "updatePrintPoint")
	public void update() {
		Staff user = new Staff(); 
		if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
		user = (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
		}
		if(user.getUsername()!=null){
			PrintPoint p = new PrintPoint();
			p.setId(printPoint.getId());
			System.out.println(p.getId());
			p.setLatitude(printPoint.getLatitude());
			p.setLongitude(printPoint.getLongitude());
			p.setPrintAddress(printPoint.getPrintAddress());
			p.setPrintName(printPoint.getPrintName());
			p.setSId(user.getId());
			p.setSTel(user.getTel());
			System.out.println("等待更新");
			p.setId(printPoint.getId());

			printPointServiceImpl.updatePrintPoint(p);
			PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新成功"))));
			System.out.println("更新成功");
		}else{
			PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新失败！用户不存在"))));
	
		}
	}

	@Action(value = "selectPrintPoint")
	public void select() throws IOException {

		printList = printPointServiceImpl.getAllPrintPoint();
		points = PressUtil.getJSONPString(JSONObject.toJSONString(printList));
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(points);
		response.getWriter().close();

	}
	//多条件查询
	@Action(value = "selectPrintPointByCondition")
	public void getByCondition() throws IOException {
		Staff s = new Staff();
		if(staff.getUsername()!=null&&staff.getUsername().length()>1&&staffDAO.findByUsername(staff.getUsername()).size()>0){
		s= (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
		}
		if(s!=null){
		printPoint.setSId(s.getId());
		printPoint.setSTel(s.getTel());
		}
		if (printPoint.getId() != null && printPoint.getId() != 0) {
			System.out.println("id");
			PrintPoint n = printPointServiceImpl.getById(printPoint.getId());
			if(n!=null){
			Staff userStaff = new Staff();
			PrintPointObject p = new PrintPointObject();
			userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", n.getSId());
			p.setId(n.getId());
			p.setName(n.getPrintName());
			p.setAddr(n.getPrintAddress());
			if(userStaff!=null){
			p.setSName(userStaff.getUsername());
			p.setTel(userStaff.getTel());
			}
			
			points = PressUtil.getJSONPString(JSONObject.toJSONString(p));
			}else{
				points = PressUtil.getJSONPString(JSONObject.toJSONString(new String("没有查询到数据！")));
			}

		} else {
			System.out.println("全部查找");
			System.out.println(printPoint.getPrintName());
			printList = printPointServiceImpl.getByCondition(printPoint);
			System.out.println(printList.size());
			for(PrintPoint point : printList){
				System.out.println(point.getId());
				
				PrintPointObject p = new PrintPointObject();
				Staff userStaff = new Staff();
				if(point.getSId()!=null&&point.getSId()!=0){
				userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", point.getSId());
				}
				p.setId(point.getId());
				p.setName(point.getPrintName());
				p.setAddr(point.getPrintAddress());
				if(userStaff!=null){
				if(userStaff.getUsername()!=null){
				p.setSName(userStaff.getUsername());
				}
				if(userStaff.getTel()!=null){
				p.setTel(userStaff.getTel());
				}
				}
				objects.add(p);
			}
		
			points = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
		  }
		System.out.println(points);
		PressUtil.send(points);
		printPoint.setId(0);;
		staff.setId(0);;
		System.out.println("id:"+printPoint.getId());
	}
	

}
