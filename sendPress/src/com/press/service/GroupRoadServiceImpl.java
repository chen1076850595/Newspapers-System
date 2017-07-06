package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.GroupRoadDAO;
import com.press.pojo.GroupRoad;
@Service("GroupRoadServiceImpl")
public class GroupRoadServiceImpl implements GroupRoadService {
	
	@Resource(name="GroupRoadDAO")
	private GroupRoadDAO groupRoadDAO;
	
	@Override
	public void addGroupRoad(GroupRoad Road) {
		// TODO Auto-generated method stub
		groupRoadDAO.save(Road);
	}

	@Override
	public void delGroupRoad(GroupRoad Road) {
		// TODO Auto-generated method stub
		groupRoadDAO.delete(Road);
	}

	@Override
	public void delGroupRoads(int[] id) {
		// TODO Auto-generated method stub
		for(int i=0;i<id.length;i++){
			GroupRoad groupRoad = new GroupRoad();
			groupRoad.setId(id[i]);
			groupRoadDAO.delete(groupRoad);
		}
	}

	@Override
	public void updateRoad(GroupRoad Road) {
		// TODO Auto-generated method stub
		groupRoadDAO.update(Road);
	}

	@Override
	public List<GroupRoad> getAllGroupRoad() {
		// TODO Auto-generated method stub
		return groupRoadDAO.findAll();
	}

	@Override
	public List<GroupRoad> getByCondition(GroupRoad Road) {
		// TODO Auto-generated method stub
		return groupRoadDAO.getByCondition(Road);
	}

	@Override
	public GroupRoad getById(int id) {
		// TODO Auto-generated method stub
		return groupRoadDAO.findById(id);
	}

}
