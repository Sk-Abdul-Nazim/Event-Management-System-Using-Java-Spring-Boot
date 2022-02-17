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
import com.ems.dao.CategoryDao;
import com.ems.model.CategoryInfo;
import com.ems.util.PasswordEncrypterUtil;

@Component("CategoryDao")
public class CategoryDaoImpl implements CategoryDao{

	
	@Override
	public List<CategoryInfo> getAllCategory() throws Exception {
		
		List<CategoryInfo> ci = new ArrayList<CategoryInfo>();
        String query = "select category_id, category_name, category_date, category_time from category where isActive = ? order by category_name" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CategoryInfo data=new CategoryInfo();
				
				data.setCategoryId(rs.getString("category_id"));
				data.setCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setCategoryDate(rs.getString("category_date"));
				data.setCategoryTime(rs.getString("category_time"));
				
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
	public boolean addCategory(CategoryInfo categoryInfo) throws PredsUtilException {
		 StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());
	      
		 
	      
	      
		  sb.append(" INSERT INTO category  ")
			.append("( category_id, category_name, category_date, category_time, isActive)")
			.append(" VALUES(?, ?, ?, ? ,?) ");
	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, categoryInfo.getCategoryId());
               ps.setString(2, categoryInfo.getCategoryName());
               ps.setString(3, date);
               ps.setString(4, time);
               ps.setBoolean(5, true);
              
         	  
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
	public boolean editCity(CategoryInfo categoryInfo) throws PredsUtilException {
		 StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());
	      
	      
		  sb.append(" UPDATE category ")
			.append("SET category_name = ?, category_date = ?, category_time = ? WHERE category_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, categoryInfo.getCategoryName());
				ps.setString(2, date);
				ps.setString(3, time);
				ps.setString(4, categoryInfo.getCategoryId());

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

	public List<CategoryInfo> getCategoryNameWithParticularId(CategoryInfo categoryInfo) throws Exception{
		
		List<CategoryInfo> ci = new ArrayList<CategoryInfo>();
        String query = "select category_id, category_name from category where category_id = ? and isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, categoryInfo.getCategoryId());
			ps.setBoolean(2, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				CategoryInfo data=new CategoryInfo();
				
				data.setCategoryId(rs.getString("category_id"));
				data.setCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				
				
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
	public boolean deleteCity(CategoryInfo categoryInfo) throws PredsUtilException {
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
	      
	      
		  sb.append(" UPDATE category ")
			.append("SET isActive = ? WHERE category_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setBoolean(1, false);
				ps.setString(2, categoryInfo.getCategoryId());

               int i=ps.executeUpdate();  
				System.out.println(i+" records Deleted");  
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
