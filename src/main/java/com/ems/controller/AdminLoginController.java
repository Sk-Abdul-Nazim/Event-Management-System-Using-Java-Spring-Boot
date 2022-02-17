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

import com.ems.conn.PredsUtilException;
import com.ems.mail.SendEmail;
import com.ems.model.AdminLoginInfo;
import com.ems.service.AdminLoginService;

@Controller
@SessionAttributes("admin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;

	@RequestMapping(value="/adminHomepage", method = RequestMethod.GET)
	public String showAdminPage(ModelMap model){

		return "./admin/admin_homepage";
	}
	
	@RequestMapping(value="/adminProfile", method = RequestMethod.GET)
	public String showAdminProfilePage(HttpSession session, ModelMap model) throws Exception{
		try {
			String logedAdminId = (String)session.getAttribute("logedAdminId");
			model.put("getAdminProfile", adminLoginService.getAdminProfile(logedAdminId));
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/adminProfile";
	}
	
	@RequestMapping(value="/editAdminProfile", method = RequestMethod.GET)
	public String showAdminEditProfilePage(HttpSession session, ModelMap model) throws Exception{
		try {
			String logedAdminId = (String)session.getAttribute("logedAdminId");
			model.put("getAdminProfile", adminLoginService.getAdminProfile(logedAdminId));
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/adminEditProfile";
	}
	
	@RequestMapping(value="/editAdminProfile", method = RequestMethod.POST)
	public String showAdminEditProfile(HttpSession session, ModelMap model, @ModelAttribute("AdminLoginInfo") AdminLoginInfo adminLoginInfo, @RequestParam String username, @RequestParam String password) throws Exception{
		try {
			adminLoginInfo.setAdminUsername(username);
			adminLoginInfo.setAdminPassword(password);
			String logedAdminId = (String)session.getAttribute("logedAdminId");
			adminLoginService.editAdminProfile(adminLoginInfo, logedAdminId);
			session.removeAttribute("loggedAdmin");
			session.setAttribute("loggedAdmin", username);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		 return "redirect:/adminProfile";
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model){

		return "./admin/adminLogin";
	}
	
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.POST)
	public String loggedinAdmin(HttpSession session,@ModelAttribute("AdminLoginInfo") AdminLoginInfo adminLoginInfo, ModelMap model, @RequestParam String username, @RequestParam String password) throws Exception{

		try {
			
			
			adminLoginInfo.setAdminUsername(username);
			adminLoginInfo.setAdminPassword(password);
			
		int isValidUser = adminLoginService.loginAdmin(session, adminLoginInfo);

		if (isValidUser > 0) {	
			
			session.setAttribute("loggedAdmin", username);
			SendEmail.sendEmail();
			 return "redirect:/adminHomepage";
      	}
		else {
			model.put("errorAdminLoginMessageEmail", "Username or Password does not exists");
//			model.put("errorLoginEmail", username);
//			model.put("errorLoginPassword", password);
			return "./admin/adminLogin";
		}
		
	} catch (PredsUtilException e) {
	
		e.printStackTrace();
	}
		 return "redirect:/adminLogin";
	}
	
	
	@RequestMapping(value="/adminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpSession session, ModelMap model){

		session.removeAttribute("loggedAdmin");
		session.removeAttribute("logedAdminId");
		return "./admin/adminLogin";
	}
	
}
