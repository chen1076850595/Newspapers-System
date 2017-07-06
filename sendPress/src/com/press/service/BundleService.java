package com.press.service;

import java.util.List;

import com.press.pojo.Bundle;

public interface BundleService {
	public void addBundle(Bundle Bundle);
	public void delBundle( Bundle Bundle);
	public void delBundles( int[] id);
	public void updateBundle(Bundle bundle);
	public List<Bundle> getAllBundle();
	public Bundle getById(int id);
	public List<Bundle> getByCondition(Bundle bundle);
	public List<Bundle> getByPrintId(int id);
}
