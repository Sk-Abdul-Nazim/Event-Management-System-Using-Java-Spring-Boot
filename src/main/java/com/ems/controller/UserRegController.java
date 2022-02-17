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
import com.ems.model.UserRegistrationInfo;
import com.ems.service.UserService;
import com.ems.util.PasswordEncrypterUtil;

@Controller
@SessionAttributes("userReg")
public class UserRegController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/registerUser", method = RequestMethod.GET)
	public String showUserRegisterPage(ModelMap model){
		return "userRegister";
	}
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public String saveUserData(HttpSession session, @ModelAttribute("UserRegistrationInfo") UserRegistrationInfo userRegistrationInfo,ModelMap model,@RequestParam String u_name, @RequestParam String u_address, @RequestParam String u_phone, @RequestParam String u_adhar, @RequestParam String u_email, @RequestParam String password) throws Exception{
		 
		userRegistrationInfo.setUserId(UUID.randomUUID().toString());
		userRegistrationInfo.setUserName(PasswordEncrypterUtil.getInstance().encrypt(u_name.trim()));
		userRegistrationInfo.setUserAddress(PasswordEncrypterUtil.getInstance().encrypt(u_address.trim()));
		userRegistrationInfo.setUserPhoneNo(PasswordEncrypterUtil.getInstance().encrypt(u_phone.trim()));
		userRegistrationInfo.setUserAddharNo(PasswordEncrypterUtil.getInstance().encrypt(u_adhar.trim()));
		userRegistrationInfo.setUserEmailId(PasswordEncrypterUtil.getInstance().encrypt(u_email.trim()));
		userRegistrationInfo.setUserPassword(PasswordEncrypterUtil.getInstance().encrypt(password.trim()));

		try {
			
		if(((session.getAttribute("emailExits") != session.getAttribute("emailExits")) && (session.getAttribute("validEmailUser") == session.getAttribute("validEmailUser")) || (session.getAttribute("emailExits") == null)||( session.getAttribute("validEmailUser") != null) )) {
				
				userService.registerUser(session,userRegistrationInfo);
				session.setAttribute("logedUser", u_name);
		}else {
			model.put("errorMessageEmail", "Email already exists");
			return "userRegister";
		}
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="/validUser", method = RequestMethod.POST)
	public String checkAvailability(HttpSession session, ModelMap model,@ModelAttribute("UserRegistrationInfo") UserRegistrationInfo userRegistrationInfo,  @RequestParam String u_name, @RequestParam String u_address, @RequestParam String u_phone, @RequestParam String u_adhar, @RequestParam String u_email, @RequestParam String password) throws Exception{

		userRegistrationInfo.setUserEmailId(u_email);
		int isValidUser = userService.validateRegisterUser(userRegistrationInfo);
		
		if (isValidUser > 0) {
				
		model.put("errorMessageEmail", "Email already exists");
		session.setAttribute("emailExits", "Email already exists");
      	}
		else {
			
			model.put("validEmail", "Valid for Registration");
			session.setAttribute("validEmailUser", "valid for registration");
		}
		
	    model.put("errorName", u_name);
		model.put("errorAddress", u_address);
		model.put("errorPhone", u_phone);
		model.put("errorAdhar", u_adhar);
		model.put("errorEmail", u_email);
		model.put("errorEmail", u_email);
		
		return "userRegister";
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public String getAllUserDetails(ModelMap model) throws Exception {
		try {
			model.put("allUserDetails", userService.getAllUserDetails());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/userDetails";
	}

	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String getUserProfile(HttpSession session, ModelMap model) throws Exception {
		try {
			model.put("userProfile", userService.getUserProfile(session));
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "userProfile";
	}
	
	
	
	@RequestMapping(value = "/editUserProfile", method = RequestMethod.GET)
	public String editUserProile(HttpSession session, ModelMap model) throws Exception {

		try {
			model.put("updateUserProfile", userService.getUserProfile(session));
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "editUserProfile";
	}
	
	
	@RequestMapping(value = "/editUserProfile", method = RequestMethod.POST)
	public String editUserProileDone(HttpSession session, @ModelAttribute("UserRegistrationInfo") UserRegistrationInfo userRegistrationInfo,ModelMap model, @RequestParam String old_password, @RequestParam String password) throws Exception {

		try {
			String logedUserId = (String) session.getAttribute("logedUserId");
	
			userRegistrationInfo.setUserPassword(PasswordEncrypterUtil.getInstance().encrypt(password.trim()));
			
			userService.updateUserProfile(logedUserId, userRegistrationInfo);
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/userProfile";
	}
}
