package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.NewspaperDAO;
import com.press.pojo.Newspaper;

@Service("NewspaperServiceImpl")
public class NewspaperServiceImpl implements NewspaperService{
	@Resource(name="NewspaperDAO")
	private NewspaperDAO newspaperDAO;
	
	@Override
	public void addNewspaper(Newspaper newspaper){
		newspaperDAO.save(newspaper);
	}
	@Override
	public void delNewspaper(Newspaper newspaper){
		newspaperDAO.delete(newspaper);
	}
	@Override
	public void updateNewspaper(Newspaper newspaper){
		newspaperDAO.update(newspaper);
	}
	@Override
	public List<Newspaper> getAllNewspaper(){
		return newspaperDAO.findAll();
	}
	@Override
	public List<Newspaper> getByCondition(Newspaper newspaper) {
		// TODO Auto-generated method stub
		
		return newspaperDAO.getByCondition(newspaper);
	}
	@Override
	public List<Newspaper> getByName(String name) {
		// TODO Auto-generated method stub
		return newspaperDAO.findByName(name);
	}
	@Override
	public Newspaper getById(int id) {
		// TODO Auto-generated method stub
		return newspaperDAO.findById(id);
		
	}
	@Override
	public void delNewspapers(int[] id) {
		// TODO Auto-generated method stub
		for(int i = 0;i<id.length;i++){
			Newspaper newspaper = new Newspaper();
			newspaper.setId(id[i]);
			newspaperDAO.delete(newspaper);
		}
	}
	
	
	
}
