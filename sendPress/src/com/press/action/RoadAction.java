package com.press.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.press.action.model.RoadObject;
import com.press.pojo.Bus;
import com.press.pojo.PrintPoint;
import com.press.pojo.Road;
import com.press.pojo.Staff;
import com.press.service.BusServiceImpl;
import com.press.service.RoadServiceImpl;
import com.press.util.PressUtil;

public class RoadAction {
	private Road road;
	private List<Road> roadList = new ArrayList<Road>();
	private List<RoadObject> objects = new ArrayList<RoadObject>();
	private String result;
	private Bus bus;
	
	public List<Road> getRoadList() {
		return roadList;
	}
	public void setRoadList(List<Road> roadList) {
		this.roadList = roadList;
	}
	public Road getRoad() {
		return road;
	}
	public void setRoad(Road road) {
		this.road = road;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Resource(name="RoadServiceImpl")
	private RoadServiceImpl roadServiceImpl;
	@Resource(name="BusServiceImpl")
	private BusServiceImpl busServiceImpl;
	
	// 增删改查
		@Action(value = "addRoad")
		public void add() {
			Bus b = new Bus(); 
			if(bus.getBusName()!=null&&busServiceImpl.getByName(bus.getBusName()).size()!=0){
			b = busServiceImpl.getByName(bus.getBusName()).get(0);
			}
			if(b.getBusName()!=null){
			Road r = new Road();
			r.setStartAddr(road.getStartAddr());
			r.setEndAddr(road.getEndAddr());
			r.setArriveTime(road.getArriveTime());
			r.setState(road.getState());
			r.setBusId(b.getId());
			roadServiceImpl.addRoad(r);
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
			PressUtil.send(mess);
			}
			else{
				System.out.println("保存失败");
				String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！车队不存在")));
				PressUtil.send(mess);
		
			}
		
	    }
			
		@Action(value = "deleteRoad")
		public void delete() {
			roadServiceImpl.delRoad(road);
		}

		@Action(value = "deleteRoads")
		public void deletes() {
			roadServiceImpl.delRoads(PressUtil.getId());
		}

		@Action(value = "updateRoad")
		public void update() {
			Bus b = new Bus(); 
			if(bus.getBusName()!=null&&busServiceImpl.getByName(bus.getBusName()).size()!=0){
			b = busServiceImpl.getByName(bus.getBusName()).get(0);
			}
			if(b.getBusName()!=null){
			Road r = new Road();
			r.setStartAddr(road.getStartAddr());
			r.setEndAddr(road.getEndAddr());
			r.setArriveTime(road.getArriveTime());
			r.setState(road.getState());
			r.setBusId(b.getId());
			roadServiceImpl.updateRoad(r);
			String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存成功")));
			PressUtil.send(mess);
			}
			else{
				System.out.println("保存失败");
				String mess =PressUtil.getJSONPString(JSONObject.toJSONString(new String("保存失败！车队不存在")));
				PressUtil.send(mess);
		
			}
		}

		@Action(value = "selectRoad")
		public void select() throws IOException {
			

		}
		//多条件查询
		@Action(value = "selectRoadByCondition")
		public void getByCondition() throws IOException {
			System.out.println("输出");
			Bus s = new Bus();
			System.out.println("bus:"+bus.getBusName());
			if(bus.getBusName()!=null&&bus.getBusName().length()>1&&busServiceImpl.getByName(bus.getBusName()).size()>0){
			s= busServiceImpl.getByName(bus.getBusName()).get(0);
			}
			if(s!=null){
			road.setBusId(s.getId());
			}
			if (road.getId() != null && road.getId() != 0) {
				System.out.println("id");
				Road n = roadServiceImpl.getById(road.getId());
				if(n!=null){
				Bus userBus = new Bus();
				RoadObject p = new RoadObject();
				userBus = busServiceImpl.getById(n.getBusId());
				p.setId(n.getId());
				p.setStartAddr(n.getStartAddr());
				p.setEndAddr(n.getEndAddr());
				p.setArriveTime(n.getArriveTime());
				p.setState(n.getState());
				if(userBus!=null){
					p.setBusName(userBus.getBusName());

				}
				
				result = PressUtil.getJSONPString(JSONObject.toJSONString(p));
				}else{
					result = PressUtil.getJSONPString(JSONObject.toJSONString(new String("没有查询到数据！")));
				}

			} else {
				System.out.println("全部查找");
				roadList = roadServiceImpl.getByCondition(road);
				System.out.println(roadList.size());
				for(Road road : roadList){
					System.out.println(road.getId());
					
					RoadObject p = new RoadObject();
					Bus userBus = new Bus();
					if(road.getBusId()!=null&&road.getBusId()!=0){
						userBus = busServiceImpl.getById(road.getBusId());
					}
					p.setId(road.getId());
					p.setStartAddr(road.getStartAddr());
					p.setEndAddr(road.getEndAddr());
					p.setArriveTime(road.getArriveTime());
					p.setState(road.getState());
					if(userBus!=null){
						p.setBusName(userBus.getBusName());

					}
					objects.add(p);
				}
			
				result = PressUtil.getJSONPString(JSONObject.toJSONString(objects));
			  }
			System.out.println(result);
			PressUtil.send(result);
			
		}

		}


