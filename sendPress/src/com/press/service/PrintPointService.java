package com.press.service;

import java.util.List;
import com.press.pojo.PrintPoint;

public interface PrintPointService {
	public void addPrintPoint(PrintPoint printPoint);
	public void delPrintPoint( PrintPoint printPoint);
	public void delPrintPoints(int [] id);
	public void updatePrintPoint(PrintPoint printPoint);
	public List<PrintPoint> getAllPrintPoint();
	public List<PrintPoint> getByName(String name);
	public List<PrintPoint> getByCondition(PrintPoint printPoint);
	public PrintPoint getById(int id);


}
