package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.RoadDAO;
import com.press.pojo.Road;
import com.press.pojo.SendPoint;
@Service("RoadServiceImpl")
public class RoadServiceImpl implements RoadService {
	
	@Resource(name="RoadDAO")
	private RoadDAO roadDAO;
	@Override
	public void addRoad(Road Road) {
		// TODO Auto-generated method stub
		roadDAO.save(Road);
	}

	@Override
	public void delRoad(Road Road) {
		// TODO Auto-generated method stub
		roadDAO.delete(Road);
	}

	@Override
	public void delRoads(int[] id) {
		// TODO Auto-generated method stub
		for(int i=0;i<id.length;i++){
			Road road = new Road();
			road.setId(id[i]);
			roadDAO.delete(road);
		}
	}

	@Override
	public void updateRoad(Road Road) {
		// TODO Auto-generated method stub
		roadDAO.update(Road);
	}

	@Override
	public List<Road> getAllRoad() {
		// TODO Auto-generated method stub
		return roadDAO.findAll();
	}

	@Override
	public List<Road> getByCondition(Road Road) {
		// TODO Auto-generated method stub
		return roadDAO.getByCondition(Road);
	}

	@Override
	public Road getById(int id) {
		// TODO Auto-generated method stub
		return roadDAO.findById(id);
	}

}
