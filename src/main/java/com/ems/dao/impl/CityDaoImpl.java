package com.ems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ems.conn.DataBaseConnectionManager;
import com.ems.conn.PredsUtilException;
import com.ems.dao.CityDao;
import com.ems.model.CityInfo;
import com.ems.model.UserRegistrationInfo;
import com.ems.util.PasswordEncrypterUtil;

@Component("CityDao")
public class CityDaoImpl implements CityDao{
	
	@Override
	public List<CityInfo> getAllCity() throws Exception {
		
		List<CityInfo> ci = new ArrayList<CityInfo>();
        String query = "select city_id, city_name from city where isActive = ? order by city_name" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CityInfo data=new CityInfo();
				
				data.setCityId(rs.getString("city_id"));
				data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				
				ci.add(data);
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
        
        
          return ci;
	}

	
	@Override
	public boolean addCity(CityInfo cityInfo) throws PredsUtilException {
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
	      
	      
		  sb.append(" INSERT INTO city  ")
			.append("( city_id, city_name, isActive)")
			.append(" VALUES(?, ?, ?) ");
	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, cityInfo.getCityId());
               ps.setString(2, cityInfo.getCityName());
               ps.setBoolean(3, true);
              
         	  
               int i=ps.executeUpdate();  
				System.out.println(i+" records inserted");  
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

	@Override
	public boolean editCity(CityInfo cityInfo) throws PredsUtilException {
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
	      
	      
		  sb.append(" UPDATE city ")
			.append("SET city_name = ? WHERE city_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, cityInfo.getCityName());
				ps.setString(2, cityInfo.getCityId());

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

	@Override
	public List<CityInfo> getCityNameWithParticularId(CityInfo cityInfo) throws Exception{
		
		List<CityInfo> ci = new ArrayList<CityInfo>();
        String query = "select city_id, city_name from city where city_id=? and isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
        	
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, cityInfo.getCityId());
			ps.setBoolean(2, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CityInfo data=new CityInfo();
				
				data.setCityId(rs.getString("city_id"));
				data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				
				
   //				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
   //				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
   //				data.setUserPhoneNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
   //				data.setUserAddharNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
   //				data.setUserEmailId(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
   //				data.setUserPassword(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password")));
   //				data.setUserEmailId(rs.getString("u_password"));
//				data.setUserEmailId(rs.getString("stream_name"));
				
				ci.add(data);
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
        
        
          return ci;
	}

	@Override
	public boolean deleteCity(CityInfo cityInfo) throws PredsUtilException {
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
	      
	      
		  sb.append(" UPDATE city ")
			.append("SET isActive = ? WHERE city_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setBoolean(1, false);
				ps.setString(2, cityInfo.getCityId());

               int i=ps.executeUpdate();  
				System.out.println(i+" records Daleted");  
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
