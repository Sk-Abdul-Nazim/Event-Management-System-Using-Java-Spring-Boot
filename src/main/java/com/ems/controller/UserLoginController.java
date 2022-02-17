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
import com.ems.model.UserRegistrationInfo;
import com.ems.service.UserService;

@Controller
@SessionAttributes("userLogin")

public class UserLoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showUserLoginPage(ModelMap model){
		return "userLogin";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loggedinUser(HttpSession session, ModelMap model, @ModelAttribute("UserRegistrationInfo") UserRegistrationInfo userRegistrationInfo ,@RequestParam String u_email, @RequestParam String password) throws Exception{

		try {
			userRegistrationInfo.setUserEmailId(u_email.trim());
			userRegistrationInfo.setUserPassword(password.trim());
		int isValidUser = userService.loginUser(session,userRegistrationInfo);
		
		if (isValidUser > 0) {		
			 return "redirect:/";
      	}
		else {
			model.put("errorLoginMessageEmail", "Email or Password does not exists");
			model.put("errorLoginEmail", u_email);
			model.put("errorLoginPassword", password);
			return "userLogin";
		}
		
	} catch (PredsUtilException e) {
		e.printStackTrace();
	}
		 return "redirect:/login";
	}
	

	@RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
	public String logOut(HttpSession session, ModelMap model) throws Exception {
		
		String logedUserId = (String) session.getAttribute("logedUserId");
		userService.logoutUser(logedUserId);
		
		session.removeAttribute("logedUser");
		session.removeAttribute("logedUserId");
//		session.removeAttribute("emailExits");
//		session.removeAttribute("validEmailUser");
//		session.removeAttribute("loggedAdmin");
		return "redirect:/";
	}
}
