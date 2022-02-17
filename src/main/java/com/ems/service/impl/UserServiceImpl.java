package com.ems.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.conn.PredsUtilException;
import com.ems.dao.UserDao;
import com.ems.model.UserRegistrationInfo;
import com.ems.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<UserRegistrationInfo> getAllUserDetails() throws Exception {
		
		List<UserRegistrationInfo> userRegistrationInfo = userDao.getAllUserDetails();
		
		return userRegistrationInfo;
	}
	
	@Override
	public void registerUser(HttpSession session, UserRegistrationInfo userRegistrationInfo)throws PredsUtilException {
		
		boolean f = userDao.registerUser(session, userRegistrationInfo);
		
	}
	
	@Override
	public int validateRegisterUser(UserRegistrationInfo userRegistrationInfo) throws Exception{

		int f = userDao.validateRegisterUser(userRegistrationInfo);
		return f;
	}

	@Override
	public int loginUser(HttpSession session, UserRegistrationInfo userRegistrationInfo) throws Exception{
		
		int f = userDao.loginUser(session, userRegistrationInfo);
		return f;
	}
	
	@Override
	public void logoutUser(String logedUserId) throws Exception{
		
		boolean f = userDao.logoutUser( logedUserId);
	
	}
	
	
	@Override
	public List<UserRegistrationInfo> getUserProfile(HttpSession session) throws Exception {
		
		List<UserRegistrationInfo> userRegistrationInfo = userDao.getUserProfile(session);
		
		return userRegistrationInfo;
	}
	
	@Override
	public void updateUserProfile(String logedUserId, UserRegistrationInfo userRegistrationInfo)throws Exception{
		
		boolean f = userDao.updateUserProfile(logedUserId, userRegistrationInfo);
	
	}
	

}
