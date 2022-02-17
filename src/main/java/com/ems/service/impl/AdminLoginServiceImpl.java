package com.ems.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ems.conn.PredsUtilException;
import com.ems.dao.AdminLoginDao;
import com.ems.model.AdminLoginInfo;
import com.ems.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	private AdminLoginDao adminLoginDao;
	
	@Override
	public int loginAdmin( HttpSession session, AdminLoginInfo adminLoginInfo) throws Exception{
		
		int f = adminLoginDao.loginAdmin(session,adminLoginInfo);
		return f;
	}

	@Override
	public List<AdminLoginInfo> getAdminProfile(String logedAdminId) throws Exception{
		
		List<AdminLoginInfo> adminLoginInfo = adminLoginDao.getAdminProfile(logedAdminId);
		return adminLoginInfo;
	}
	
	
	@Override
	public void editAdminProfile(AdminLoginInfo adminLoginInfo, String logedAdminId) throws Exception{
		
		boolean f = adminLoginDao.editAdminProfile(adminLoginInfo, logedAdminId);
		
	}
}
