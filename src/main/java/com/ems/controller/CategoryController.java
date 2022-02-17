package com.ems.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ems.conn.PredsUtilException;
import com.ems.model.CategoryInfo;
import com.ems.service.CategoryService;
import com.ems.util.PasswordEncrypterUtil;

@Controller
@SessionAttributes("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getAllCategory(ModelMap model) throws Exception {
		try {
			model.put("allCategory", categoryService.getAllCategory());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/category";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String ShowAddCategoryPage(ModelMap model) throws Exception {
		return "./admin/addCategory";
	}
	
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST) 
	public String addCity(HttpSession session,@ModelAttribute("CategoryInfo") CategoryInfo categoryInfo, ModelMap model, @RequestParam String catname) throws Exception {
		try {
			categoryInfo.setCategoryId(UUID.randomUUID().toString());
			categoryInfo.setCategoryName(PasswordEncrypterUtil.getInstance().encrypt(catname));
			
			categoryService.addCategory(categoryInfo);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/category";
	}
	
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public String ShowEditCategoryPage(HttpSession session, @ModelAttribute("CategoryInfo") CategoryInfo categoryInfo, ModelMap model , @RequestParam String id) throws Exception {
		
		categoryInfo.setCategoryId(id);
		model.put("getCategoryNameWithParticularId", categoryService.getCategoryNameWithParticularId(categoryInfo));
		return "./admin/editCategory";
	}
	
	
	@RequestMapping(value = "/editCategory", method = RequestMethod.POST) 
	public String editCity(HttpSession session, @ModelAttribute("CategoryInfo") CategoryInfo categoryInfo, ModelMap model, @RequestParam String editCategoryId, @RequestParam String catname) throws Exception {
		try {
			categoryInfo.setCategoryId(editCategoryId);
			categoryInfo.setCategoryName(PasswordEncrypterUtil.getInstance().encrypt(catname));
			
			categoryService.editCity(categoryInfo);
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/category";
	}
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCity(HttpSession session, ModelMap model , @ModelAttribute("CategoryInfo") CategoryInfo categoryInfo, @RequestParam String id) throws Exception {
		
		categoryInfo.setCategoryId(id);
		
		categoryService.deleteCity(categoryInfo); 
		
		
		return "redirect:/category";
	}
}
