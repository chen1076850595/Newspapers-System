package com.press.service;

import java.util.List;

import com.press.pojo.Bus;

public interface BusService {
	public void addBus(Bus Bus);
	public void delBus( Bus Bus);
	public List<Bus> getAllBus();
	public Bus getById(int id);
	public List<Bus> getByName(String name);

}
