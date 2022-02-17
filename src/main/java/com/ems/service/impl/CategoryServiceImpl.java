package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.CategoryDao;
import com.ems.model.CategoryInfo;
import com.ems.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<CategoryInfo> getAllCategory() throws Exception {
		
		List<CategoryInfo> categoryInfo = categoryDao.getAllCategory();
		
		return categoryInfo;
	}
	
	@Override
	public void addCategory(CategoryInfo categoryInfo) throws Exception{
		
		boolean c = categoryDao.addCategory(categoryInfo);
	}
	
	@Override
	public void editCity(CategoryInfo categoryInfo) throws Exception{
		
		boolean c = categoryDao.editCity(categoryInfo);
	}
	
	@Override
	public List<CategoryInfo> getCategoryNameWithParticularId(CategoryInfo categoryInfo) throws Exception{
	
		List<CategoryInfo> particularCategoryInfo = categoryDao.getCategoryNameWithParticularId(categoryInfo);
		
		return particularCategoryInfo;
	}
	
	@Override
	public void deleteCity(CategoryInfo categoryInfo) throws Exception{
		
		boolean c = categoryDao.deleteCity(categoryInfo);
	}
}
