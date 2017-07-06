package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import com.press.dao.NewspaperDAO;
import com.press.pojo.Newspaper;


public interface NewspaperService {
	
	public void addNewspaper(Newspaper newspaper);
	public void delNewspaper(Newspaper newspaper);
	public void delNewspapers(int [] id);
	public void updateNewspaper(Newspaper newspaper);
	public List<Newspaper> getAllNewspaper();
	public List<Newspaper> getByCondition(Newspaper newspaper);
	public List<Newspaper> getByName(String name);
	public Newspaper getById(int id);
	
	
}
