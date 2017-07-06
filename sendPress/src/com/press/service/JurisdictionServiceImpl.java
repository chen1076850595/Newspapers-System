package com.press.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.JurisdictionDAO;
import com.press.pojo.Jurisdiction;
import com.press.pojo.Staff;

@Service("jurService")
public class JurisdictionServiceImpl implements JurisdictionService{

	@Resource(name="jurDao")
	private JurisdictionDAO jurisdictionDao;
	
	@Override
	public String add(Jurisdiction jurisdiction) {

		jurisdictionDao.save( jurisdiction );
		return "success";
	}

	@Override
	public Jurisdiction select(Integer id) {
		return  (Jurisdiction)jurisdictionDao.findById("com.press.pojo.Jurisdiction", id );
	}

	@Override
	public String update(Jurisdiction jurisdiction) {
		jurisdictionDao.update( jurisdiction );
		return "update";
	}

	@Override
	public String del(int id) {
		
		Jurisdiction jurisdiction = new Jurisdiction();
		jurisdiction.setId( id );
		jurisdictionDao.delete( jurisdiction );
		return "delete";
	}

}
