package com.ems.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import com.ems.conn.DataBaseConnectionManager;
import com.ems.conn.PredsUtilException;
import com.ems.dao.UserDao;
import com.ems.model.UserRegistrationInfo;
import com.ems.util.PasswordEncrypterUtil;


@Component("UserDao")
public class UserDaoImpl implements UserDao{

	@Override
	public List<UserRegistrationInfo> getAllUserDetails() throws Exception {
		
		List<UserRegistrationInfo> uri = new ArrayList<UserRegistrationInfo>();
		String query = "select u_id, u_name, u_address, u_phone, u_adhar, u_email, u_password, u_date, u_time, u_active from user_registration where isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				UserRegistrationInfo data=new UserRegistrationInfo();
				
                data.setUserId(rs.getString("u_id"));
				
				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
				data.setUserPhoneNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
				data.setUserAddharNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
				data.setUserEmailId(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
				data.setUserPassword(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password")));
				data.setUserDate(rs.getString("u_date"));
				data.setUserTime(rs.getString("u_time"));
				data.setUserActive(rs.getString("u_active"));
				uri.add(data);
			}
			

		} catch (PredsUtilException e) {

			throw new PredsUtilException(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(con);
		}
        
        
          return uri;
	}

	@Override
	public boolean registerUser( HttpSession session, UserRegistrationInfo userRegistrationInfo) throws PredsUtilException {
		 StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());

	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());
	            
	      
		  sb.append(" INSERT INTO user_registration  ")
			.append("( u_id, u_name, u_address, u_phone, u_adhar, ")
			.append("u_email, u_password, u_date, u_time, u_active, isActive) ")
			
			.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
	        Connection  con=null;
	        PreparedStatement ps=null;

	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, userRegistrationInfo.getUserId());
               ps.setString(2, userRegistrationInfo.getUserName());
               ps.setString(3, userRegistrationInfo.getUserAddress());
               ps.setString(4, userRegistrationInfo.getUserPhoneNo());
               ps.setString(5, userRegistrationInfo.getUserAddharNo());
               ps.setString(6, userRegistrationInfo.getUserEmailId());
               ps.setString(7, userRegistrationInfo.getUserPassword());
               ps.setString(8, date);
               ps.setString(9, time);
               ps.setBoolean(10, true);
               ps.setBoolean(11, true);
               
               int i=ps.executeUpdate();  
				System.out.println(i+" records inserted");  
				DataBaseConnectionManager.commit(con);
				
				
				 String query1 = "update user_registration set u_active=true where u_id = ?" ;
		          Connection  con1=null;
		          PreparedStatement ps1=null;
		      	  
		         
		  			con1=DataBaseConnectionManager.getConnection();
		  			ps1 = con1.prepareStatement(query1);
		  			ps1.setString(1, (String) session.getAttribute("logedUserId"));
		  			int i1 = ps1.executeUpdate(); 
		  			DataBaseConnectionManager.commit(con1);
				
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
			finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(con);
			}
	        session.setAttribute("logedUserId", userRegistrationInfo.getUserId());
	        return true;
	}

	
	@Override
	public int validateRegisterUser(UserRegistrationInfo userRegistrationInfo) throws Exception {

		 int c = 0;

		String query = "select u_email from user_registration where isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(userRegistrationInfo.getUserEmailId().equalsIgnoreCase(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email"))))
						{
					          c++; 
						}
				
		}
			return c;
			
        } catch (PredsUtilException e) {
        	
			throw new PredsUtilException(e);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(con);
		} 
		return c;
	}
	
	
	@Override
	public int loginUser(HttpSession session, UserRegistrationInfo userRegistrationInfo) throws Exception {

		 int c = 0;

		String query = "select u_id, u_name, u_email, u_password from user_registration where isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(userRegistrationInfo.getUserEmailId().equalsIgnoreCase(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email"))) && userRegistrationInfo.getUserPassword().equals(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password"))))
						{
					          c++;
					          session.setAttribute("logedUser",PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
					          session.setAttribute("logedUserId", rs.getString("u_id"));
					          
					          String query1 = "update user_registration set u_active=true where u_id = ?" ;
					          Connection  con1=null;
					          PreparedStatement ps1=null;
					      	  
					         
					  			con1=DataBaseConnectionManager.getConnection();
					  			ps1 = con1.prepareStatement(query1);
					  			ps1.setString(1, (String) session.getAttribute("logedUserId"));
					  			int i1 = ps1.executeUpdate(); 
					  			DataBaseConnectionManager.commit(con1);
					      
						}
				
		}
			return c;
			
        } catch (PredsUtilException e) {
        	
			throw new PredsUtilException(e);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(con);
		} 
		return c;
	}
	
	
	@Override
	public boolean logoutUser(String logedUserId) throws Exception {

         StringBuffer sb = new StringBuffer();
 
		  sb.append(" UPDATE user_registration ")
			.append("SET u_active = ?  WHERE u_id = ?");

        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
        	con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(sb.toString());
			
			ps.setBoolean(1, false);
			ps.setString(2, logedUserId);
			 
			int i=ps.executeUpdate();  
				//System.out.println(session.getAttribute("logedUser") + " logout");  
			DataBaseConnectionManager.commit(con);
        } catch (PredsUtilException e) {
        	
			throw new PredsUtilException(e);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(con);
		} 
		return true;
	}
	
	
	
	
	@Override
	public List<UserRegistrationInfo> getUserProfile(HttpSession session) throws Exception {
		
		List<UserRegistrationInfo> uri = new ArrayList<UserRegistrationInfo>();
		String query = "select u_id, u_name, u_address, u_phone, u_adhar, u_email, u_password, u_date, u_time, u_active from user_registration where isActive = ? and u_id = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setString(2, (String)session.getAttribute("logedUserId"));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				UserRegistrationInfo data=new UserRegistrationInfo();
				
                data.setUserId(rs.getString("u_id"));
				
				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
				data.setUserPhoneNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
				data.setUserAddharNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
				data.setUserEmailId(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
				data.setUserPassword(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password")));
				data.setUserDate(rs.getString("u_date"));
				data.setUserTime(rs.getString("u_time"));
				data.setUserActive(rs.getString("u_active"));
				uri.add(data);
			}
			

		} catch (PredsUtilException e) {

			throw new PredsUtilException(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(rs);
			DataBaseConnectionManager.close(con);
		}
        
        
          return uri;
	}

	
	@Override
	public boolean updateUserProfile(String logedUserId, UserRegistrationInfo userRegistrationInfo) throws Exception {

		StringBuffer sb = new StringBuffer();
		 
//		 String pattern = "dd-MM-yyyy";
//		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		 String date = simpleDateFormat.format(new Date());
//		 
//		 
//		 Date time = new Date();
//	      String strDateFormat = "HH:mm:ss a";
//	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
//	      
//		 
	      
	      
		  sb.append(" UPDATE user_registration ")
			.append("SET u_password = ? WHERE u_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, userRegistrationInfo.getUserPassword());
				ps.setString(2, logedUserId);

              int i=ps.executeUpdate();  
				System.out.println(i+" records Updated");  
				DataBaseConnectionManager.commit(con);
				
	        } catch (SQLException e) {
				e.printStackTrace();
	        }
			finally{
				DataBaseConnectionManager.close(ps);
				DataBaseConnectionManager.close(con);
			}
	        
	        return true;
	}
	
	
	
}
