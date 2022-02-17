package com.ems.service;

import java.util.List;

import com.ems.model.CategoryInfo;


public interface CategoryService {


	List<CategoryInfo> getAllCategory() throws Exception;

	void addCategory(CategoryInfo categoryInfo) throws Exception;

	List<CategoryInfo> getCategoryNameWithParticularId(CategoryInfo categoryInfo) throws Exception;

	void editCity(CategoryInfo categoryInfo)  throws Exception;

	void deleteCity(CategoryInfo categoryInfo)  throws Exception;


}
