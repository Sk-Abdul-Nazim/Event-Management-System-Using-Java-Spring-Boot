package com.ems.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ems.conn.PredsUtilException;
import com.ems.model.AdminLoginInfo;

public interface AdminLoginDao {
	
	public int loginAdmin(HttpSession session,AdminLoginInfo adminLoginInfo)throws PredsUtilException, Exception;

	public List<AdminLoginInfo> getAdminProfile(String logedAdminId)throws Exception;

	public boolean editAdminProfile(AdminLoginInfo adminLoginInfo, String logedAdminId) throws Exception;

}
