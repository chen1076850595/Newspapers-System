package com.press.action;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.press.action.model.PrintNumObject;
import com.press.pojo.Newspaper;
import com.press.pojo.PointRelation;
import com.press.pojo.PrintPoint;
import com.press.pojo.Staff;
import com.press.service.PointRelationServiceImpl;
import com.press.service.PrintPointServiceImpl;
import com.press.service.SendPointServiceImpl;
import com.press.util.PressUtil;
import com.press.util.TranslatePDF;

public class TotalPrintNumAction {
	private List<PrintNumObject> printNumObjects = new ArrayList<PrintNumObject>();
	private String result;
	
	@Resource(name = "PointRelationServiceImpl")
	private PointRelationServiceImpl pointRelationServiceImpl;
	
	@Resource(name="SendPointServiceImpl")
	private SendPointServiceImpl sendPointServiceImpl;
	
	@Resource(name="PrintPointServiceImpl")
	private PrintPointServiceImpl printPointServiceImpl;
	
	@Action(value="totalPrintNumAction")
	public void totalPrintNumAction(){
		List<PrintPoint> printPoints = new ArrayList<PrintPoint>();
		printPoints = printPointServiceImpl.getAllPrintPoint();
		for(PrintPoint printPoint:printPoints){
			PrintNumObject printNumObject = new PrintNumObject();
			List<PointRelation> pointRelations = new ArrayList<PointRelation>();
			pointRelations = pointRelationServiceImpl.getByPrintId(printPoint.getId());
			int OnePrintNeedNum=0;
			if(pointRelations.size()>0){
				
				for(PointRelation pointRelation:pointRelations){
					OnePrintNeedNum += sendPointServiceImpl.getById(pointRelation.getSendId()).getNeedNum();
				}
				
				
			}
			printNumObject.setTotalPrintNum(OnePrintNeedNum);
			printNumObject.setPrintName(printPoint.getPrintName());
			printNumObjects.add(printNumObject);
		}
		result = PressUtil.getJSONPString(JSONObject.toJSONString(printNumObjects));
		
		PressUtil.send(result);
		System.out.println(result);
	}
	public List<PrintNumObject> printNumPDF(){
		return printNumObjects;
	}
	

	//打印汇总一
	@Action(value="printTotalNum")
	public void printOne() {
		List<PrintPoint> printPoints = new ArrayList<PrintPoint>();
		printPoints = printPointServiceImpl.getAllPrintPoint();
		for(PrintPoint printPoint:printPoints){
			PrintNumObject printNumObject = new PrintNumObject();
			List<PointRelation> pointRelations = new ArrayList<PointRelation>();
			pointRelations = pointRelationServiceImpl.getByPrintId(printPoint.getId());
			int OnePrintNeedNum=0;
			if(pointRelations.size()>0){
				
				for(PointRelation pointRelation:pointRelations){
					OnePrintNeedNum += sendPointServiceImpl.getById(pointRelation.getSendId()).getNeedNum();
				}
				
				
			}
			printNumObject.setTotalPrintNum(OnePrintNeedNum);
			printNumObject.setPrintName(printPoint.getPrintName());
			printNumObjects.add(printNumObject);
		}
		result = PressUtil.getJSONPString(JSONObject.toJSONString(printNumObjects));
		
		PressUtil.send(result);
		//调用汇总函数，得到一个List对象
		String path = "D:/summary1.pdf";
		List<PrintNumObject> prints = printNumObjects;
		try {
			TranslatePDF.changePDF(prints, path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
