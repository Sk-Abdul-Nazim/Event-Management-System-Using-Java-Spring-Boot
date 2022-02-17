package com.ems.dao;

import java.util.List;

import com.ems.model.CategoryInfo;

public interface CategoryDao {


	List<CategoryInfo> getAllCategory() throws Exception;

	boolean addCategory(CategoryInfo categoryInfo) throws Exception;

	List<CategoryInfo> getCategoryNameWithParticularId(CategoryInfo categoryInfo) throws Exception;

	boolean editCity(CategoryInfo categoryInfo)throws Exception;

	boolean deleteCity(CategoryInfo categoryInfo) throws Exception;



}
