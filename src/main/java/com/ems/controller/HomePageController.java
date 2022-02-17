package com.ems.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ems.dao.HallDao;
import com.ems.model.CovidModel;
import com.ems.model.HallInfo;
import com.ems.service.HallService;

@Controller
@SessionAttributes("name")
public class HomePageController {
		
	@Autowired
	private HallService hallService; 
	
	@Autowired
	private HallDao hallDao; 
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) throws Exception{
		
		model.put("dropDownCategory", hallService.getDropDownCategory());
		return "homepage";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String showAboutPage(ModelMap model){
		return "about";
	}
	
	@RequestMapping(value="/blog", method = RequestMethod.GET)
	public String showBlogPage(ModelMap model){
		return "blog";
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String showContactPage(ModelMap model){
		return "contact";
	}
	
	@RequestMapping(value="/gallery", method = RequestMethod.GET)
	public String showGalleryPage(ModelMap model){
		return "gallery";
	}
	
	@RequestMapping(value="/covid", method = RequestMethod.GET)
	public String covidPage(ModelMap model){
		return "covid";
	
	}
	
	@RequestMapping(value="/covid", method = RequestMethod.POST)
	public String covidPagePost(@ModelAttribute("CovidModel") CovidModel covidModel , HttpSession session, ModelMap model, @RequestParam String adhar,
	@RequestParam String dob, @RequestParam String phone, @RequestParam String appdate, @RequestParam String condition, @RequestParam String vaccine ) throws Exception{
		int noOfDoes = hallDao.getDoes(appdate, vaccine);
		if(noOfDoes <=0) {
			 System.out.println("PLEASE TRY AGAIN TOMORROW; ALL DOESES ARE BLOCKED FOR THOSE WHO ARE AHEAD OF YOU IN LINE; THANK YOU FOR YOUR PATIENCE");
			 return "covid";
		}
		else if(!appdate.equals("2021-05-03") ) {
			//System.out.println("dattttttt"+appdate);
			System.out.println("Please check date only valid 03-05-2021");
		}
		else if(condition.equals("yes") ) {
    	  System.out.println("PLEASE SEE YOUR PRIMARY CARE PHYSICIAN AND BOOK APPOINYMENT THROUGH HOSPITAL");
    	  session.removeAttribute("userAdhar");
      }
		else {
			session.setAttribute("userAdhar", adhar);
			//System.out.println(session.getAttribute("userAdhar"));
	        covidModel.setAdhar(adhar);
	        covidModel.setDob(dob);
	        covidModel.setAppdate(appdate);
	        covidModel.setCondition(condition);
	        covidModel.setPhone(phone);
	        covidModel.setvaccine(vaccine);
	        hallDao.doesDeduct(noOfDoes,covidModel);
	        System.out.println("Success");
			}
		return "covid";
		
		
		
		//String noofdoes = hallService
		
	
	}

}
