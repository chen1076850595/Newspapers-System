package com.press.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.press.action.model.PointRelationObject;
import com.press.pojo.PointRelation;
import com.press.pojo.PrintPoint;
import com.press.pojo.SendPoint;
import com.press.service.PointRelationServiceImpl;
import com.press.service.PrintPointServiceImpl;
import com.press.service.SendPointServiceImpl;
import com.press.util.PressUtil;

public class PointRelationAction {
	private PrintPoint printPoint;
	private SendPoint sendPoint;
	private PointRelation pointRelation = new PointRelation();   //注入的实体
	private PointRelationObject pointRelationObject;

	private String result;   //返回的jsonp格式string
	private List<PointRelation> pointRelations = new ArrayList<PointRelation>();
	
	public PrintPoint getPrintPoint() {
		return printPoint;
	}
	public void setPrintPoint(PrintPoint printPoint) {
		this.printPoint = printPoint;
	}
	public SendPoint getSendPoint() {
		return sendPoint;
	}
	public void setSendPoint(SendPoint sendPoint) {
		this.sendPoint = sendPoint;
	}
	public PointRelation getPointRelation() {
		return pointRelation;
	}
	public void setPointRelation(PointRelation pointRelation) {
		this.pointRelation = pointRelation;
	}
	
	
	public PointRelationObject getPointRelationObject() {
		return pointRelationObject;
	}
	public void setPointRelationObject(PointRelationObject pointRelationObject) {
		this.pointRelationObject = pointRelationObject;
	}


	@Resource(name="SendPointServiceImpl")
	private SendPointServiceImpl sendPointServiceImpl;
	
	@Resource(name="PrintPointServiceImpl")
	private PrintPointServiceImpl printPointServiceImpl;
	
	@Resource(name="PointRelationServiceImpl")
	private PointRelationServiceImpl pointRelationServiceImpl;
	
	// 增删改查
	@Action(value = "addPointRelation")
			public void add() {
				if(pointRelationObject.getPrintPointName()!=null
						&&pointRelationObject.getSendPointName()!=null){
					SendPoint s = new SendPoint();
					s.setSendName(pointRelationObject.getSendPointName());
					PrintPoint p = new PrintPoint();
					p.setPrintName(pointRelationObject.getPrintPointName());
					if(printPointServiceImpl.getByCondition(p).size()!=0
							&&sendPointServiceImpl.getByCondition(s).size()!=0){
						pointRelation.setPrintId(printPointServiceImpl.getByCondition(p).get(0).getId());
						pointRelation.setSendId(sendPointServiceImpl.getByCondition(s).get(0).getId());
						pointRelationServiceImpl.addPointRelation(pointRelation);
						PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("添加成功！"))));
					}else{
						PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！"))));

					}
					
				}

			
			}

			@Action(value = "deletePointRelation")
			public void delete() {
				pointRelationServiceImpl.delPointRelation(pointRelation);
			}

			@Action(value = "deletePointRelations")
			public void deletes() {
				pointRelationServiceImpl.delPointRelations(PressUtil.getId());
			}

			@Action(value = "updatePointRelation")
			public void update() {
				if(pointRelationObject.getPrintPointName()!=null
						&&pointRelationObject.getSendPointName()!=null){
					SendPoint s = new SendPoint();
					s.setSendName(pointRelationObject.getSendPointName());
					PrintPoint p = new PrintPoint();
					p.setPrintName(pointRelationObject.getPrintPointName());
					if(printPointServiceImpl.getByCondition(p).size()!=0
							&&sendPointServiceImpl.getByCondition(s).size()!=0){
						pointRelation.setPrintId(printPointServiceImpl.getByCondition(p).get(0).getId());
						pointRelation.setSendId(sendPointServiceImpl.getByCondition(s).get(0).getId());
						pointRelationServiceImpl.updatePointRelation(pointRelation);
						PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新成功！"))));
					}else{
						PressUtil.send(PressUtil.getJSONPString(JSONObject.toJSONString(new String("更新失败！"))));

					}
					
				}
			}

			@Action(value = "selectPointRelation")
			public void select(){

				

			}
			//多条件查询
			@Action(value = "selectPointRelationByCondition")
			public void getByCondition(){
				if(pointRelationObject.getId()!=null&&pointRelationObject.getId().length()>0){
					System.out.println("根据Id查找");
					pointRelation = pointRelationServiceImpl.getById(Integer.parseInt(pointRelationObject.getId()));
					PointRelationObject n = new PointRelationObject();
					if(pointRelation!=null){
					n.setId(String.valueOf(pointRelation.getId()));
					n.setPrintPointName(printPointServiceImpl.getById(pointRelation.getPrintId()).getPrintName());
					n.setSendPointName(sendPointServiceImpl.getById(pointRelation.getSendId()).getSendName());

					}
					result = PressUtil.getJSONPString(JSONObject.toJSONString(n));
				}else{
					System.out.println("多条件查询");
					if(pointRelationObject.getPrintPointName()!=null
							&&pointRelationObject.getPrintPointName().length()>1){
						PrintPoint p = new PrintPoint();
						p.setPrintName(pointRelationObject.getPrintPointName());
						if(printPointServiceImpl.getByCondition(p).size()>0){
							p = printPointServiceImpl.getByCondition(p).get(0);
						}
						pointRelation.setPrintId(p.getId());

					}
					if(pointRelationObject.getSendPointName()!=null
							&&pointRelationObject.getSendPointName().length()>1){
						SendPoint p = new SendPoint();
						p.setSendName(pointRelationObject.getSendPointName());
						if(sendPointServiceImpl.getByCondition(p).size()>0){
							p = sendPointServiceImpl.getByCondition(p).get(0);
						}
						pointRelation.setSendId(p.getId());			

					}
					pointRelations = pointRelationServiceImpl.getByCondition(pointRelation);
					List<PointRelationObject> oj = new ArrayList<PointRelationObject>();
					for(PointRelation p : pointRelations){
						PointRelationObject n = new PointRelationObject();
						n.setId(String.valueOf(p.getId()));
						System.out.println(p.getPrintId());
						System.out.println("测试"+p.getPrintId());
						n.setPrintPointName(printPointServiceImpl.getById(p.getPrintId()).getPrintName());
						n.setSendPointName(sendPointServiceImpl.getById(p.getSendId()).getSendName());
						oj.add(n);
							
					}
					result = PressUtil.getJSONPString(JSONObject.toJSONString(oj));
				}
				System.out.println(result);
				PressUtil.send(result);
			}
}
