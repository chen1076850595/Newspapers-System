package com.press.service;

import java.util.List;

import com.press.pojo.GroupRoad;

public interface GroupRoadService {
	public void addGroupRoad(GroupRoad Road);
	public void delGroupRoad( GroupRoad Road);
	public void delGroupRoads(int [] id);
	public void updateRoad(GroupRoad Road);
	public List<GroupRoad> getAllGroupRoad();
	public List<GroupRoad> getByCondition(GroupRoad Road);
	public GroupRoad getById(int id);
}
