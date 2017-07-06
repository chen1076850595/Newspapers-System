package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.PointRelationDAO;
import com.press.pojo.PointRelation;

@Service("PointRelationServiceImpl")
public class PointRelationServiceImpl implements PointRelationService {
	
	
	@Resource(name="PointRelationDAO")
	private PointRelationDAO pointRelationDAO;
	
	@Override
	public void addPointRelation(PointRelation pointRelation) {
		// TODO Auto-generated method stub
		pointRelationDAO.save(pointRelation);
	}

	@Override
	public void delPointRelation(PointRelation pointRelation) {
		// TODO Auto-generated method stub
		pointRelationDAO.delete(pointRelation);
	}

	@Override
	public void delPointRelations(int[] id) {
		// TODO Auto-generated method stub
		for(int i = 0;i<id.length;i++){
			PointRelation pointRelation = new PointRelation();
			pointRelation.setId(id[i]);
			pointRelationDAO.delete(pointRelation);
		}
	}

	@Override
	public void updatePointRelation(PointRelation pointRelation) {
		// TODO Auto-generated method stub
		pointRelationDAO.update(pointRelation);
	}

	@Override
	public List<PointRelation> getAllPointRelation() {
		// TODO Auto-generated method stub
		return pointRelationDAO.findAll();
	}

	@Override
	public List<PointRelation> getByCondition(PointRelation pointRelation) {
		// TODO Auto-generated method stub
		return pointRelationDAO.getByCondition(pointRelation);
	}

	@Override
	public PointRelation getById(int id) {
		// TODO Auto-generated method stub
		return pointRelationDAO.findById(id);
	}

	@Override
	public List<PointRelation> getBySendId(int id) {
		// TODO Auto-generated method stub
		return pointRelationDAO.findBySendId(id);
	}

	@Override
	public List<PointRelation> getByPrintId(int id) {
		// TODO Auto-generated method stub
		return pointRelationDAO.findByPrintId(id);
	}
	

}
