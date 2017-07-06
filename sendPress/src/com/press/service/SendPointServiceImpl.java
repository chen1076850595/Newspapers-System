package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.SendPointDAO;
import com.press.pojo.SendPoint;

@Service("SendPointServiceImpl")
public class SendPointServiceImpl implements SendPointService {
	
	@Resource(name="SendPointDAO")
    private SendPointDAO sendPointDAO;
	
	@Override
	public void addSendPoint(SendPoint sendPoint) {
		// TODO Auto-generated method stub
	
		sendPointDAO.save(sendPoint);
	}

	@Override
	public void delSendPoint(SendPoint sendPoint) {
		// TODO Auto-generated method stub

		sendPointDAO.delete(sendPoint);
	}

	@Override
	public void delSendPoints(int[] id) {
		// TODO Auto-generated method stub

		for(int i=0;i<id.length;i++){
			SendPoint sendPoint = new SendPoint();
			sendPoint.setId(id[i]);
			sendPointDAO.delete(sendPoint);
		}
	}

	@Override
	public void updateSendPoint(SendPoint sendPoint) {
		// TODO Auto-generated method stub

		sendPointDAO.update(sendPoint);
	}

	@Override
	public List<SendPoint> getAllSendPoint() {
		// TODO Auto-generated method stub
		return sendPointDAO.findAll();
	}

	@Override
	public List<SendPoint> getByCondition(SendPoint sendPoint) {
		// TODO Auto-generated method stub
		return sendPointDAO.getByCondition(sendPoint);
	}

	@Override
	public SendPoint getById(int id) {
		// TODO Auto-generated method stub
		return sendPointDAO.findById(id);
	}

	@Override
	public List<SendPoint> getByType(String type) {
		// TODO Auto-generated method stub
		return sendPointDAO.findByType(type);
	}



}
