package com.press.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.press.action.model.BundleObject;
import com.press.action.model.RoadObject;
import com.press.pojo.Bundle;
import com.press.pojo.PrintPoint;
import com.press.pojo.PrintPoint;
import com.press.pojo.Road;
import com.press.service.BundleServiceImpl;
import com.press.service.PrintPointServiceImpl;
import com.press.service.PrintPointServiceImpl;
import com.press.service.RoadServiceImpl;
import com.press.util.PressUtil;

public class BundleAction {
	private Bundle bundle;
	private List<Bundle> bundleList = new ArrayList<Bundle>();
	private List<BundleObject> objects = new ArrayList<BundleObject>();
	private String result;
	private PrintPoint printPoint;
	
	
	
	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	public List<Bundle> getBundleList() {
		return bundleList;
	}

	public void setBundleList(List<Bundle> bundleList) {
		this.bundleList = bundleList;
	}

	public List<BundleObject> getObjects() {
		return objects;
	}

	public void setObjects(List<BundleObject> objects) {
		this.objects = objects;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PrintPoint getPrintPoint() {
		return printPoint;
	}

	public void setPrintPoint(PrintPoint printPoint) {
		this.printPoint = printPoint;
	}
	@Resource(name="BundleServiceImpl")
	private BundleServiceImpl bundleServiceImpl;
	@Resource(name="PrintPointServiceImpl")
	private PrintPointServiceImpl printPointServiceImpl;
	
	// 增删改查
		@Action("addBundle")
		public void add() {
			PrintPoint b = new PrintPoint(); 
			if(printPoint.getPrintName()!=null&&printPointServiceImpl.getByName(printPoint.getPrintName()).size()!=0){
			b = printPointServiceImpl.getByName(printPoint.getPrintName()).get(0);
			}
			if(b.getPrintName()!=null&&b.getPrintName().length()>0){
			Bundle r = new Bundle();
			r.setId(bundle.getId());
			r.setBundleNum(bundle.getBundleNum());
			r.setPrintId(b.getId());
			bundleServiceImpl.addBundle(r);
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
			PressUtil.send(mess);
			}
			else{
				System.out.println("保存失败");
				String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！车队不存在")));
				PressUtil.send(mess);
		
			}
		
	    }
			
		@Action(value = "deleteBundle")
		public void delete() {
			bundleServiceImpl.delBundle(bundle);
		}

		@Action(value = "deleteRoads")
		public void deletes() {
			bundleServiceImpl.delBundles(PressUtil.getId());
		}

		@Action(value = "updateBundle")
		public void update() {
			PrintPoint b = new PrintPoint(); 
			if(printPoint.getPrintName()!=null&&printPointServiceImpl.getByName(printPoint.getPrintName()).size()!=0){
			b = printPointServiceImpl.getByName(printPoint.getPrintName()).get(0);
			}
			if(b.getPrintName()!=null&&b.getPrintName().length()>0){
			Bundle r = new Bundle();
			r.setId(bundle.getId());
			r.setBundleNum(bundle.getBundleNum());
			r.setPrintId(b.getId());
			bundleServiceImpl.updateBundle(r);
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
			PressUtil.send(mess);
			}
			else{
				System.out.println("保存失败");
				String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！车队不存在")));
				PressUtil.send(mess);
		
			}
		}

		@Action(value = "selectBundle")
		public void select() throws IOException {
			

		}
		//多条件查询
		@Action(value = "selectBundleByCondition")
		public void getByCondition() throws IOException {
			PrintPoint s = new PrintPoint();
			if(printPoint.getPrintName()!=null&&printPoint.getPrintName().length()>0&&printPointServiceImpl.getByName(printPoint.getPrintName()).size()>0){
			s= printPointServiceImpl.getByName(printPoint.getPrintName()).get(0);
			}
			if(s!=null){
			bundle.setPrintId(s.getId());
			}
			if (bundle.getId() != null && bundle.getId() != 0) {
				System.out.println("id");
				Bundle n = bundleServiceImpl.getById(bundle.getId());
				if(n!=null){
				PrintPoint userPrintPoint = new PrintPoint();
				BundleObject p = new BundleObject();
				userPrintPoint = printPointServiceImpl.getById(n.getPrintId());
				p.setId(n.getId());
				p.setBundleNum(n.getBundleNum());
				
				
				if(userPrintPoint!=null){
					p.setPrintName(userPrintPoint.getPrintName());

				}
				
				result = PressUtil.getJSONPString(JSONObject.toJSONString(p));
				}else{
					result = PressUtil.getJSONPString(JSONObject.toJSONString(new String("没有查询到数据！")));
				}

			} else {
				System.out.println("全部查找");
				bundleList = bundleServiceImpl.getByCondition(bundle);
				System.out.println(bundleList.size());
				for(Bundle bundle : bundleList){
					System.out.println(bundle.getId());
					
					BundleObject p = new BundleObject();
					PrintPoint userPrintPoint = new PrintPoint();
					if(bundle.getPrintId()!=null&&bundle.getPrintId()>0){
						userPrintPoint = printPointServiceImpl.getById(bundle.getPrintId());
					}
					p.setId(bundle.getId());
					p.setBundleNum(bundle.getBundleNum());
					
					
					if(userPrintPoint!=null){
						p.setPrintName(userPrintPoint.getPrintName());

					}
					objects.add(p);
				}
			
				result = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
			  }
			System.out.println(result);
			PressUtil.send(result);
			
		}

		}