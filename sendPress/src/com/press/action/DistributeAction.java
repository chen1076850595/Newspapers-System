package com.press.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.press.action.model.DistributeObject;
import com.press.action.model.SendPointObject;
import com.press.pojo.SendPoint;
import com.press.service.BundleServiceImpl;
import com.press.service.PointRelationServiceImpl;
import com.press.service.SendPointServiceImpl;
import com.press.util.PressUtil;
import com.press.util.TranslatePDF;

public class DistributeAction {
	private List<DistributeObject> distributeObjects = new ArrayList<DistributeObject>();
	private String result;
	
	@Resource(name ="SendPointServiceImpl")
	private SendPointServiceImpl sendPointServiceImpl;
	@Resource(name="PointRelationServiceImpl")
	private PointRelationServiceImpl pointRelationServiceImpl;
	@Resource(name="BundleServiceImpl")
	private BundleServiceImpl bundleServiceImpl;
	
	@Action("selectDistribute")
	public void selectDistribute(){
		 List<SendPoint> distributePoints = sendPointServiceImpl.getByType(new String("分站"));
		 for(SendPoint sendPoint:distributePoints){
			 DistributeObject distributeObject = new DistributeObject();
			 distributeObject.setId(sendPoint.getId());
			 distributeObject.setAddress(sendPoint.getAddress());
			 distributeObject.setSendName(sendPoint.getSendName());
			 distributeObject.setType(sendPoint.getType());
			 if(pointRelationServiceImpl.getBySendId(sendPoint.getId()).size()>0){
				 //根据三张表获得打包数量
			 int bundleNum = bundleServiceImpl.getByPrintId(
					 				pointRelationServiceImpl
					 				.getBySendId(sendPoint
							 		.getId()).get(0)
					 				.getPrintId()).get(0)
					 				.getBundleNum();
			 
			 int needNum = sendPoint.getNeedNum();
			 distributeObject.setNeedBundle(needNum/bundleNum);
			 distributeObject.setNeedUnitNum(needNum%bundleNum);
			 distributeObjects.add(distributeObject);
			 }
			 
		 }
		 result = PressUtil.getJSONPString(JSONObject.toJSONString(distributeObjects));
		 System.out.println(result);
		 PressUtil.send(result);
	}
	public List<DistributeObject> distriPDF() {
		
		return distributeObjects;
	}
	//打印汇总二
	@Action(value="printDistribute")
	public void printTwo() {
		List<SendPoint> distributePoints = sendPointServiceImpl.getByType(new String("分站"));
		 for(SendPoint sendPoint:distributePoints){
			 DistributeObject distributeObject = new DistributeObject();
			 distributeObject.setId(sendPoint.getId());
			 distributeObject.setAddress(sendPoint.getAddress());
			 distributeObject.setSendName(sendPoint.getSendName());
			 distributeObject.setType(sendPoint.getType());
			 if(pointRelationServiceImpl.getBySendId(sendPoint.getId()).size()>0){
				 //根据三张表获得打包数量
			 int bundleNum = bundleServiceImpl.getByPrintId(
					 				pointRelationServiceImpl
					 				.getBySendId(sendPoint
							 		.getId()).get(0)
					 				.getPrintId()).get(0)
					 				.getBundleNum();
			 
			 int needNum = sendPoint.getNeedNum();
			 distributeObject.setNeedBundle(needNum/bundleNum);
			 distributeObject.setNeedUnitNum(needNum%bundleNum);
			 distributeObjects.add(distributeObject);
			 }
			 
		 }
		 result = PressUtil.getJSONPString(JSONObject.toJSONString(distributeObjects));
		 System.out.println(result);
		String path = "D:/summary3.pdf";
		List<DistributeObject> distri = distributeObjects;
		try {
			TranslatePDF.changePDF(distri, path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
