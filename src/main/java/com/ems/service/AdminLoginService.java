package com.ems.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.ems.conn.PredsUtilException;
import com.ems.model.AdminLoginInfo;

public interface AdminLoginService {

	
	public int loginAdmin( HttpSession session, AdminLoginInfo adminLoginInfo) throws PredsUtilException, Exception;

	public List<AdminLoginInfo> getAdminProfile(String logedAdminId) throws Exception;

	public void editAdminProfile( AdminLoginInfo adminLoginInfo,String logedAdminId) throws Exception;
	
}
