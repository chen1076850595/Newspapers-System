package com.press.service;

import java.util.List;

import com.press.pojo.Road;

public interface RoadService {
	public void addRoad(Road Road);
	public void delRoad( Road Road);
	public void delRoads(int [] id);
	public void updateRoad(Road Road);
	public List<Road> getAllRoad();
	public List<Road> getByCondition(Road Road);
	public Road getById(int id);
}
