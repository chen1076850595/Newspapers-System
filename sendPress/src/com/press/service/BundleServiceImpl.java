package com.press.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.press.dao.BundleDAO;
import com.press.pojo.Bundle;

@Service("BundleServiceImpl")
public class BundleServiceImpl implements BundleService {
	
	@Resource(name = "BundleDAO")
	private BundleDAO bundleDAO;
	
	@Override
	public void addBundle(Bundle Bundle) {
		// TODO Auto-generated method stub
		bundleDAO.save(Bundle);
	}

	@Override
	public void delBundle(Bundle Bundle) {
		// TODO Auto-generated method stub
		bundleDAO.delete(Bundle);
	}

	@Override
	public List<Bundle> getAllBundle() {
		// TODO Auto-generated method stub
		return bundleDAO.findAll();
	}

	@Override
	public Bundle getById(int id) {
		// TODO Auto-generated method stub
		return bundleDAO.findById(id);
	}

	

	@Override
	public List<Bundle> getByCondition(Bundle bundle) {
		// TODO Auto-generated method stub
		return bundleDAO.getByCondition(bundle);
	}

	@Override
	public void delBundles(int[] id) {
		// TODO Auto-generated method stub
		for(int i=0;i<id.length;i++){
			Bundle bundle = new Bundle();
			bundle.setId(id[i]);
			bundleDAO.delete(bundle);
		}
	}

	@Override
	public void updateBundle(Bundle bundle) {
		// TODO Auto-generated method stub
		bundleDAO.update(bundle);
	}

	@Override
	public List<Bundle> getByPrintId(int id) {
		// TODO Auto-generated method stub
		return bundleDAO.findByPrintId(id);
	}

}
