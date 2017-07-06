package com.press.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.alibaba.fastjson.JSONObject;
import com.press.pojo.GroupRoad;
import com.press.service.GroupRoadServiceImpl;
import com.press.util.PressUtil;

public class GroupRoadAction {
	private GroupRoad groupRoad;
	private List<GroupRoad> groupRoads = new ArrayList<GroupRoad>();
	private String result;
	public GroupRoad getGroupRoad() {
		return groupRoad;
	}
	public void setGroupRoad(GroupRoad groupRoad) {
		this.groupRoad = groupRoad;
	}
	public List<GroupRoad> getGroupRoads() {
		return groupRoads;
	}
	public void setGroupRoads(List<GroupRoad> groupRoads) {
		this.groupRoads = groupRoads;
	}
	
	@Resource(name = "GroupRoadServiceImpl")
	private GroupRoadServiceImpl groupRoadServiceImpl;
	
	
	@Action(value="addGroupRoad")
	public void add(){
		groupRoadServiceImpl.addGroupRoad(groupRoad);
	}
	
	@Action(value="deleteGroupRoad")
	public void delete(){
		groupRoadServiceImpl.delGroupRoad(groupRoad);
	}
	
	@Action(value = "deleteGroupRoads")
	public void deletes(){
		groupRoadServiceImpl.delGroupRoads(PressUtil.getId());
	}
	
	@Action(value="updateGroupRoad")
	public void update(){
		groupRoadServiceImpl.updateRoad(groupRoad);
		}
	
	@Action(value="selectGroupRoad")
	public void select(){
		
		 groupRoads = groupRoadServiceImpl.getAllGroupRoad();
		 result = PressUtil.getJSONPString(JSONObject.toJSONString(groupRoads));
		 PressUtil.send(result);
	}
	
	@Action(value = "selectGroupRoadByCondition")
	public void getByCondition(){
		if(groupRoad.getId()!=null && groupRoad.getId()> 0){
			System.out.println("根据ID查询");
			GroupRoad n = groupRoadServiceImpl.getById(groupRoad.getId());
			result = PressUtil.getJSONPString(JSONObject.toJSONString(n));

		}else{
			System.out.println("多条件查询");
		System.out.println(groupRoad.getEndPoint());
		groupRoads = groupRoadServiceImpl.getByCondition(groupRoad);
		result = PressUtil.getJSONPString(JSONObject.toJSONString(groupRoads));
		System.out.println(result);
		}
		PressUtil.send(result);	
		
	}
}
