package com.ems.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.ems.conn.PredsUtilException;
import com.ems.model.UserRegistrationInfo;

public interface UserService {
	
	List<UserRegistrationInfo> getAllUserDetails() throws Exception;
	
	void registerUser(HttpSession session, UserRegistrationInfo userRegistrationInfo) throws PredsUtilException;
	
	public int validateRegisterUser(UserRegistrationInfo userRegistrationInfo)throws Exception;
	
	public int loginUser(HttpSession session, UserRegistrationInfo userRegistrationInfo)throws Exception;

	void logoutUser(String logedUserId) throws Exception;

	List<UserRegistrationInfo> getUserProfile(HttpSession session) throws Exception;

	void updateUserProfile(String logedUserId, UserRegistrationInfo userRegistrationInfo)throws Exception;
}
