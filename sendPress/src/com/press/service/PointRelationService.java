package com.press.service;

import java.util.List;

import com.press.pojo.PointRelation;

public interface PointRelationService {

	public void addPointRelation(PointRelation pointRelation);
	public void delPointRelation( PointRelation pointRelation);
	public void delPointRelations(int [] id);
	public void updatePointRelation(PointRelation pointRelation);
	public List<PointRelation> getAllPointRelation();
	public List<PointRelation> getByCondition(PointRelation pointRelation);
	public PointRelation getById(int id);
	public List<PointRelation> getBySendId(int id);
	public List<PointRelation> getByPrintId(int id);
}
