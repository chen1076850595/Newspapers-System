package com.press.service;

import java.util.List;

import com.press.pojo.SendPoint;

public interface SendPointService {
	public void addSendPoint(SendPoint sendPoint);
	public void delSendPoint( SendPoint sendPoint);
	public void delSendPoints(int [] id);
	public void updateSendPoint(SendPoint sendPoint);
	public List<SendPoint> getAllSendPoint();
	public List<SendPoint> getByCondition(SendPoint sendPoint);
	public SendPoint getById(int id);
	public List<SendPoint> getByType(String type);


}
