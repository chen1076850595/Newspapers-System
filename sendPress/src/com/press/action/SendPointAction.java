package com.press.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;
import com.press.action.model.SendPointObject;
import com.press.dao.StaffDAO;
import com.press.pojo.Newspaper;
import com.press.pojo.SendPoint;
import com.press.pojo.Staff;
import com.press.service.SendPointServiceImpl;
import com.press.util.PressUtil;
import com.press.util.TranslatePDF;

public class SendPointAction {
	private SendPoint sendPoint;
	private List<SendPoint> sendList = new ArrayList<SendPoint>();
	private String points;
	private Staff staff;
	private SendPointObject sendPointObject = new SendPointObject();
	List<SendPointObject> objects = new ArrayList<SendPointObject>();
	
	

	public SendPoint getSendPoint() {
		return sendPoint;
	}

	public void setSendPoint(SendPoint sendPoint) {
		this.sendPoint = sendPoint;
	}

	public List<SendPoint> getSendList() {
		return sendList;
	}

	public void setSendList(List<SendPoint> sendList) {
		this.sendList = sendList;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public SendPointObject getSendPointObject() {
		return sendPointObject;
	}

	public void setSendPointObject(SendPointObject sendPointObject) {
		this.sendPointObject = sendPointObject;
	}

	public List<SendPointObject> getObjects() {
		return objects;
	}

	public void setObjects(List<SendPointObject> objects) {
		this.objects = objects;
	}
	@Resource(name = "SendPointServiceImpl")
	private SendPointServiceImpl sendPointServiceImpl;
	@Resource(name = "staffDao")
	private StaffDAO staffDAO;
	// 增删改查
		@Action(value = "addSendPoint")
		public void add() {
			Staff user = new Staff(); 
			if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
			user = (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
			}
			if(user.getUsername()!=null){
			sendPoint.setSId(user.getId());
			sendPoint.setSTel(user.getTel());
			sendPointServiceImpl.addSendPoint(sendPoint);
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
			System.out.println(mess);
			PressUtil.send(mess);
			}
			else{
				System.out.println("保存失败");
				String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！用户不存在")));
				System.out.println(mess);
				PressUtil.send(mess);
		
			}
			
		}

		@Action(value = "deleteSendPoint")
		public void delete() {
			sendPointServiceImpl.delSendPoint(sendPoint);
		}

		@Action(value = "deleteSendPoints")
		public void deletes() {
			sendPointServiceImpl.delSendPoints(PressUtil.getId());
		}

		@Action(value = "updateSendPoint")
		public void update() {
			Staff user = new Staff(); 
			if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
			user = (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
			}
			if(user.getUsername()!=null){
				sendPoint.setSId(user.getId());
				sendPoint.setSTel(user.getTel());
				sendPointServiceImpl.updateSendPoint(sendPoint);
				PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新成功"))));
			
			}else{
				PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新失败！用户不存在"))));
		
			}
		}

		@Action(value = "selectSendPoint")
		public void select() throws IOException {

			sendList = sendPointServiceImpl.getAllSendPoint();
			points = PressUtil.getJSONPString(JSONObject.toJSONString(sendList));
			PressUtil.send(points);

		}
		//多条件查询
		@Action(value = "selectSendPointByCondition")
		public void getByCondition() throws IOException {
			Staff s = new Staff();
			if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
			s= (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
			}
			if(s!=null){
				sendPoint.setSId(s.getId());
			//sendPoint.setSTel(s.getTel());
			}
			if (sendPoint.getId() != null && sendPoint.getId() != 0) {
				System.out.println("id");
				SendPoint n = sendPointServiceImpl.getById(sendPoint.getId());
				Staff userStaff = new Staff();
				SendPointObject p = new SendPointObject();
				userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", n.getSId());
				p.setId(n.getId());
				p.setName(n.getSendName());
				p.setAddr(n.getAddress());
				if(userStaff!=null){
				p.setSName(userStaff.getUsername());
				p.setTel(userStaff.getTel());
				}
				points = PressUtil.getJSONPString(JSONObject.toJSONString(p));

			} else {
				System.out.println("全部查找");
				sendList = sendPointServiceImpl.getByCondition(sendPoint);
				for(SendPoint point : sendList){
					System.out.println(point.getId());
					SendPointObject p = new SendPointObject();
					Staff userStaff = new Staff();
					userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", point.getSId());
					p.setId(point.getId());
					p.setName(point.getSendName());
					p.setAddr(point.getAddress());
					p.setNeedNum(point.getNeedNum());
					p.setType(point.getType());
					if(userStaff!=null){
					if(userStaff.getUsername()!=null){
					//p.setSName(userStaff.getUsername());
					}
					if(userStaff.getTel()!=null){
					//p.setTel(userStaff.getTel());
					}
					}
					objects.add(p);
				}
			
				points = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
				System.out.println(points);
			  }
			
		      PressUtil.send(points);
		}
		
		//多条件查询
				@Action(value = "selectSpecialSendPointByCondition")
				public void getSpelcialByCondition() throws IOException {
					Staff s = new Staff();
					if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
					s= (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
					}
					if(s!=null){
						sendPoint.setSId(s.getId());
					//sendPoint.setSTel(s.getTel());
					}
					sendPoint.setType(new String("特殊送报点"));
					if (sendPoint.getId() != null && sendPoint.getId() != 0) {
						System.out.println("id");
						SendPoint n = sendPointServiceImpl.getById(sendPoint.getId());
						Staff userStaff = new Staff();
						SendPointObject p = new SendPointObject();
						userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", n.getSId());
						p.setId(n.getId());
						p.setName(n.getSendName());
						p.setAddr(n.getAddress());
						if(userStaff!=null){
						p.setSName(userStaff.getUsername());
						p.setTel(userStaff.getTel());
						}
						points = PressUtil.getJSONPString(JSONObject.toJSONString(p));

					} else {
						System.out.println("全部查找");
						sendList = sendPointServiceImpl.getByCondition(sendPoint);
						for(SendPoint point : sendList){
							System.out.println(point.getId());
							SendPointObject p = new SendPointObject();
							Staff userStaff = new Staff();
							userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", point.getSId());
							p.setId(point.getId());
							p.setName(point.getSendName());
							p.setAddr(point.getAddress());
							p.setNeedNum(point.getNeedNum());
							p.setType(point.getType());
							if(userStaff!=null){
							if(userStaff.getUsername()!=null){
							//p.setSName(userStaff.getUsername());
							}
							if(userStaff.getTel()!=null){
							//p.setTel(userStaff.getTel());
							}
							}
							objects.add(p);
						}
					
						points = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
						System.out.println(points);
					  }
					
				      PressUtil.send(points);
				}

		public  List<SendPointObject> printNumPDF2() {
			
			return objects;
			}
		//打印汇总三
		@Action(value="printSendPoint")
		public void printTwo() {
			Staff s = new Staff();
			if(staff.getUsername()!=null&&staffDAO.findByUsername(staff.getUsername()).size()>0){
			s= (Staff)staffDAO.findByUsername(staff.getUsername()).get(0);
			}
			if(s!=null){
				sendPoint.setSId(s.getId());
			//sendPoint.setSTel(s.getTel());
			}
			if (sendPoint.getId() != null && sendPoint.getId() != 0) {
				System.out.println("id");
				SendPoint n = sendPointServiceImpl.getById(sendPoint.getId());
				Staff userStaff = new Staff();
				SendPointObject p = new SendPointObject();
				userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", n.getSId());
				p.setId(n.getId());
				p.setName(n.getSendName());
				p.setAddr(n.getAddress());
				if(userStaff!=null){
				p.setSName(userStaff.getUsername());
				p.setTel(userStaff.getTel());
				}
				points = PressUtil.getJSONPString(JSONObject.toJSONString(p));

			} else {
				System.out.println("全部查找");
				sendList = sendPointServiceImpl.getByCondition(sendPoint);
				for(SendPoint point : sendList){
					System.out.println(point.getId());
					SendPointObject p = new SendPointObject();
					Staff userStaff = new Staff();
					userStaff = (Staff) staffDAO.findById("com.press.pojo.Staff", point.getSId());
					p.setId(point.getId());
					p.setName(point.getSendName());
					p.setAddr(point.getAddress());
					p.setNeedNum(point.getNeedNum());
					p.setType(point.getType());
					if(userStaff!=null){
					if(userStaff.getUsername()!=null){
					//p.setSName(userStaff.getUsername());
					}
					if(userStaff.getTel()!=null){
					//p.setTel(userStaff.getTel());
					}
					}
					objects.add(p);
				}
			
				points = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
				System.out.println(points);
			  }
			
		      
			String path = "D:/summary2.pdf";
			List<SendPointObject> sendPointObjects = objects;
			try {
				TranslatePDF.changePDF(sendPointObjects, path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
