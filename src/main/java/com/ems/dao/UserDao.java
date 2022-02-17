package com.ems.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ems.conn.PredsUtilException;
import com.ems.model.UserRegistrationInfo;

public interface UserDao {
	
	
	List<UserRegistrationInfo> getAllUserDetails() throws Exception;
	
	boolean registerUser(HttpSession session,UserRegistrationInfo userRegistrationInfo) throws PredsUtilException;
	
	public int validateRegisterUser(UserRegistrationInfo userRegistrationInfo) throws Exception;
	
	public int loginUser(HttpSession session, UserRegistrationInfo userRegistrationInfo) throws Exception;

	boolean logoutUser(String logedUserId)throws Exception;

	List<UserRegistrationInfo> getUserProfile(HttpSession session) throws Exception;

	boolean updateUserProfile(String logedUserId,UserRegistrationInfo userRegistrationInfo) throws Exception;

	
}
