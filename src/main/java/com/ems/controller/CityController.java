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
import com.ems.model.CityInfo;
import com.ems.service.CityService;
import com.ems.util.PasswordEncrypterUtil;


@Controller
@SessionAttributes("city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public String getAllCity(ModelMap model) throws Exception {
		try {
			model.put("allCity", cityService.getAllCity());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/city";
	}
	
	@RequestMapping(value = "/addCity", method = RequestMethod.GET)
	public String ShowAddCityPage(ModelMap model) throws Exception {
		return "./admin/addCity";
	}
	
	
	@RequestMapping(value = "/addCity", method = RequestMethod.POST) 
	public String addCity(HttpSession session,@ModelAttribute("CityInfo") CityInfo cityInfo, ModelMap model, @RequestParam String cityname) throws Exception {
		try {
			cityInfo.setCityId(UUID.randomUUID().toString());
			cityInfo.setCityName(PasswordEncrypterUtil.getInstance().encrypt(cityname));
			
			cityService.addCity(cityInfo);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/city";
	}
	
	
	@RequestMapping(value = "/editCity", method = RequestMethod.GET)
	public String ShowEditCityPage(HttpSession session, @ModelAttribute("CityInfo") CityInfo cityInfo, ModelMap model , @RequestParam String id) throws Exception {
		
		cityInfo.setCityId(id);
		model.put("getCityNameWithParticularId", cityService.getCityNameWithParticularId(cityInfo));
		return "./admin/editCity";
	}
	
	
	@RequestMapping(value = "/editCity", method = RequestMethod.POST) 
	public String editCity(HttpSession session,@ModelAttribute("CityInfo") CityInfo cityInfo, ModelMap model, @RequestParam String editCityId, @RequestParam String cityname) throws Exception {
		try {
			cityInfo.setCityId(editCityId);
			cityInfo.setCityName(PasswordEncrypterUtil.getInstance().encrypt(cityname));
			
			cityService.editCity(cityInfo);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/city";
	}
	
	@RequestMapping(value = "/deleteCity", method = RequestMethod.GET)
	public String deleteCity(HttpSession session, ModelMap model , @ModelAttribute("CityInfo") CityInfo cityInfo, @RequestParam String id) throws Exception {
		
		cityInfo.setCityId(id);
		cityService.deleteCity(cityInfo); 
		
		
		return "redirect:/city";
	}
}
