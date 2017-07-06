package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.BusDAO;
import com.press.pojo.Bus;
@Service("BusServiceImpl")
public class BusServiceImpl implements BusService {
	
	@Resource(name="BusDAO")
	private BusDAO busDAO;
	
	@Override
	public void addBus(Bus Bus) {
		// TODO Auto-generated method stub
		busDAO.save(Bus);
	}

	@Override
	public void delBus(Bus Bus) {
		// TODO Auto-generated method stub
		busDAO.delete(Bus);
	}

	

	@Override
	public List<Bus> getAllBus() {
		// TODO Auto-generated method stub
		return busDAO.findAll();
	}



	@Override
	public Bus getById(int id) {
		// TODO Auto-generated method stub
		return busDAO.findById(id);
	}

	@Override
	public List<Bus> getByName(String name) {
		// TODO Auto-generated method stub
		return busDAO.findByBusName(name);
	}
	

}
