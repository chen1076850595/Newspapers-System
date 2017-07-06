package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.PrintPointDAO;
import com.press.pojo.Newspaper;
import com.press.pojo.PrintPoint;

@Service("PrintPointServiceImpl")
public class PrintPointServiceImpl implements PrintPointService{
	
	@Resource(name="PrintPointDAO")
	private PrintPointDAO printPointDAO;

	@Override
	public void addPrintPoint(PrintPoint printPoint) {
		// TODO Auto-generated method stub
		printPointDAO.save(printPoint);
	}

	@Override
	public void delPrintPoint(PrintPoint printPoint) {
		// TODO Auto-generated method stub
		printPointDAO.delete(printPoint);
	}

	@Override
	public void delPrintPoints(int[] id) {
		// TODO Auto-generated method stub
		for(int i = 0;i<id.length;i++){
			PrintPoint printPoint = new PrintPoint();
			printPoint.setId(id[i]);
			printPointDAO.delete(printPoint);
		}
	}

	@Override
	public void updatePrintPoint(PrintPoint printPoint) {
		// TODO Auto-generated method stub
		printPointDAO.update(printPoint);
	}

	@Override
	public List<PrintPoint> getAllPrintPoint() {
		// TODO Auto-generated method stub
		return printPointDAO.findAll();
	}

	@Override
	public List<PrintPoint> getByCondition(PrintPoint printPoint) {
		// TODO Auto-generated method stub
		return printPointDAO.getByCondition(printPoint);
	}
	@Override
	public PrintPoint getById(int id) {
		// TODO Auto-generated method stub
		return printPointDAO.findById(id);
	}

	@Override
	public List<PrintPoint> getByName(String name) {
		// TODO Auto-generated method stub
		return printPointDAO.findByPrintName(name);
	}

}
