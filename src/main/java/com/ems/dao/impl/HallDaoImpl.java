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
import com.ems.dao.HallDao;
import com.ems.model.CovidModel;
import com.ems.model.DropDownBox;
import com.ems.model.HallInfo;
import com.ems.util.PasswordEncrypterUtil;

@Component("HallDao")
public class HallDaoImpl implements HallDao{

	@Override
	public List<HallInfo> getAllActiveHall() throws Exception {
		
		List<HallInfo> hi = new ArrayList<HallInfo>();
        String query = "SELECT hall_id, hall_name, hall_place, hall_seat, hall_date, hall_time, hall_price, hall_availability, hall_image, h.category_id, h.city_id, cat.category_name category_name, cit.city_name city_name FROM hall h inner join category cat on h.category_id = cat.category_id inner join city cit on h.city_id = cit.city_id where h.isActive = ? and cat.isActive = ? and cit.isActive = ? and h.hall_availability = ? order by hall_name" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setBoolean(2, true);
			ps.setBoolean(3, true);
			ps.setString(4, PasswordEncrypterUtil.getInstance().encrypt("YES"));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
				data.setHallCategoryId(rs.getString("category_id"));
				data.setHallCityId(rs.getString("city_id"));
				//data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallDate(rs.getString("hall_date"));
				data.setHallTime(rs.getString("hall_time"));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallAvailability(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_availability")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
   //				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
   //				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
   //				data.setUserPhoneNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
   //				data.setUserAddharNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
   //				data.setUserEmailId(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
   //				data.setUserPassword(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password")));
   //				data.setUserEmailId(rs.getString("u_password"));
//				data.setUserEmailId(rs.getString("stream_name"));
//				System.out.println(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
//				System.out.println(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				hi.add(data);
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
        
        
          return hi;
	}

	@Override
	public List<DropDownBox> getDropDownCategory() throws Exception {
		
		List<DropDownBox> ddbc = new ArrayList<DropDownBox>(); 
		
		String query = "select * from category where isActive = ? " ;
		Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				DropDownBox data =new DropDownBox();
				
				data.setId(rs.getString("category_id"));
				data.setName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				
				ddbc.add(data);
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
        
        
          return ddbc;
	}

	
	@Override
	public List<DropDownBox> getDropDownCity() throws Exception {
		
		List<DropDownBox> ddbc = new ArrayList<DropDownBox>(); 
		
		String query = "select * from city where isActive = ? " ;
		Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				DropDownBox data =new DropDownBox();
				
				data.setId(rs.getString("city_id"));
				data.setName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				
				ddbc.add(data);
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
        
        
          return ddbc;
	}

	
	
	
//	private List<DropDownBox> getDropDownData(String query) throws Exception{
//		List<DropDownBox> pm = new ArrayList<DropDownBox>();
//        Connection  con=null;
//        PreparedStatement ps=null;
//    	ResultSet rs=null;
//        try {
//			con=DataBaseConnectionManager.getConnection();
//			ps = con.prepareStatement(query);
//			rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				
//				DropDownBox data=new DropDownBox();
//				data.setId(rs.getString("id"));
//				data.setName(PasswordEncrypterUtil.getInstance().decript(rs.getString("name")));
//				
//				pm.add(data);
//			}
//			
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		finally{
//			DataBaseConnectionManager.close(ps);
//			DataBaseConnectionManager.close(rs);
//			DataBaseConnectionManager.close(con);
//		}
//        
//          return pm;
//	}
//	
	
	@Override
	public boolean addActiveHall(HallInfo hallInfo) throws PredsUtilException{
		 StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());		 
	      
	      
		  sb.append(" INSERT INTO hall  ")
			.append("( hall_id, hall_name, hall_place, hall_seat, hall_date, hall_time, hall_price, hall_availability, hall_image, category_id, city_id, isActive)")
			.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
	        
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, hallInfo.getHallId());
               ps.setString(2, hallInfo.getHallName());
               ps.setString(3, hallInfo.getHallPlace());
               ps.setString(4, hallInfo.getHallSeat());
               ps.setString(5, date);
               ps.setString(6, time);
               ps.setString(7, hallInfo.getHallPrice());
               ps.setString(8, hallInfo.getHallAvailability());

               ps.setString(9, hallInfo.getHallImage());
          
               
               ps.setString(10, hallInfo.getHallCategoryId());
               ps.setString(11, hallInfo.getHallCityId());
               ps.setBoolean(12, true);
              
         	  
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
	public boolean editActiveHall(HallInfo hallInfo) throws PredsUtilException {
		 StringBuffer sb = new StringBuffer();
		 
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());		
	      
	      
		  sb.append(" UPDATE hall ")
			.append("SET hall_name = ?, hall_place = ?, hall_seat = ?, hall_date = ?, hall_time = ?, hall_price = ?, hall_availability = ?, hall_image = ?, category_id = ?, city_id = ?, isActive = ? WHERE hall_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, hallInfo.getHallName());
				ps.setString(2, hallInfo.getHallPlace());
				ps.setString(3, hallInfo.getHallSeat());
				ps.setString(4, date);
				ps.setString(5, time);
				ps.setString(6, hallInfo.getHallPrice());
				ps.setString(7, hallInfo.getHallAvailability());
				ps.setString(8, hallInfo.getHallImage());
				ps.setString(9, hallInfo.getHallCategoryId());
				ps.setString(10, hallInfo.getHallCityId());
				ps.setBoolean(11, true);
				ps.setString(12, hallInfo.getHallId());

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

	public List<HallInfo> getHallNameWithParticularId(HallInfo hallInfo) throws Exception{
		
		List<HallInfo> hi = new ArrayList<HallInfo>();
        String query = "select hall_id, hall_name, hall_place, hall_seat, hall_price, hall_availability, hall_image, h.category_id, h.city_id, cat.category_name category_name, cit.city_name city_name from hall h inner join category cat on cat.category_id = ? inner join city cit on cit.city_id = ? where h.hall_id = ? and h.isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
        	
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, hallInfo.getHallCategoryId());
			ps.setString(2, hallInfo.getHallCityId());
			ps.setString(3, hallInfo.getHallId());
			ps.setBoolean(4, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
				data.setHallCategoryId(rs.getString("category_id"));
				data.setHallCityId(rs.getString("city_id"));
				
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallAvailability(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_availability")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				
				
				hi.add(data);
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
        
        
          return hi;
	}
	
	
	

	@Override
	public boolean deleteActiveHall(HallInfo hallInfo) throws PredsUtilException {
		 StringBuffer sb = new StringBuffer();
		      
		  sb.append(" UPDATE hall ")
			.append("SET isActive = ? WHERE hall_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setBoolean(1, false);
				ps.setString(2, hallInfo.getHallId());

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
	
	
	
	@Override
	public List<HallInfo> showBookedHall() throws Exception {
		
		List<HallInfo> nahi = new ArrayList<HallInfo>();
        String query = "SELECT hall_id, hall_name, hall_place, hall_seat, hall_date, hall_time, hall_price, hall_availability, hall_image, h.category_id, h.city_id, cat.category_name category_name, cit.city_name city_name FROM hall h inner join category cat on h.category_id = cat.category_id inner join city cit on h.city_id = cit.city_id where h.isActive = ? and hall_availability = ? and cat.isActive = ? and cit.isActive = ? order by hall_name" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setString(2, PasswordEncrypterUtil.getInstance().encrypt("NO"));
			ps.setBoolean(3, true);
			ps.setBoolean(4, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
				data.setHallCategoryId(rs.getString("category_id"));
				data.setHallCityId(rs.getString("city_id"));
				//data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallDate(rs.getString("hall_date"));
				data.setHallTime(rs.getString("hall_time"));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallAvailability(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_availability")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
   //				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
   //				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
   //				data.setUserPhoneNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
   //				data.setUserAddharNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
   //				data.setUserEmailId(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
   //				data.setUserPassword(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_password")));
   //				data.setUserEmailId(rs.getString("u_password"));
//				data.setUserEmailId(rs.getString("stream_name"));
//				System.out.println(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
//				System.out.println(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				nahi.add(data);
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
        
        
          return nahi;
	}
	
	
	@Override
	public boolean activatedHall(HallInfo hallInfo) throws Exception {
		
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());		
		
		StringBuffer sb = new StringBuffer();
		      
		  sb.append(" UPDATE hall ")
			.append("SET hall_date = ?, hall_time = ? , hall_availability = ?, isActive = ? WHERE hall_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;
//	        String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//	        		studentRegistrationInfo.getStudentCategoryId(), 
//	        		studentRegistrationInfo.getAcademicYear());
	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, date);
				ps.setString(2, time);
				ps.setString(3, PasswordEncrypterUtil.getInstance().encrypt("YES"));
				ps.setBoolean(4, true);
				ps.setString(5, hallInfo.getHallId());

               int i=ps.executeUpdate();  
				System.out.println(i+" Hall Activated");  
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
	public List<HallInfo> getAllEventsHall() throws Exception {
		
		List<HallInfo> hi = new ArrayList<HallInfo>();
        String query = "SELECT hall_id, hall_name, hall_place,  hall_price,  hall_image, h.category_id, h.city_id, cat.category_name category_name, cit.city_name city_name FROM hall h inner join category cat on h.category_id = cat.category_id inner join city cit on h.city_id = cit.city_id where h.isActive = ? and cat.isActive = ? and cit.isActive = ? and h.hall_availability= ? LIMIT 6" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setBoolean(2, true);
			ps.setBoolean(3, true);
			ps.setString(4, PasswordEncrypterUtil.getInstance().encrypt("YES"));

			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
				data.setHallCategoryId(rs.getString("category_id"));
				data.setHallCityId(rs.getString("city_id"));

				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));

				hi.add(data);
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
        
        
          return hi;
	}

	
	
	@Override
	public List<HallInfo> getParticularEventsHall(HallInfo hallInfo) throws Exception {
		
		List<HallInfo> hi = new ArrayList<HallInfo>();
        String query = "SELECT hall_id, hall_name, hall_place, hall_price, hall_seat, hall_image, cat.category_name category_name, cit.city_name city_name FROM hall h inner join category cat on h.category_id = cat.category_id inner join city cit on h.city_id = cit.city_id where h.isActive = ? and cat.isActive = ? and cit.isActive = ? and h.hall_availability= ? and h.hall_id = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setBoolean(2, true);
			ps.setBoolean(3, true);
			ps.setString(4, PasswordEncrypterUtil.getInstance().encrypt("YES"));
            ps.setString(5, hallInfo.getHallId());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
                 data.setHallCategoryId(hallInfo.getHallCategoryId());
                 data.setHallCityId(hallInfo.getHallCityId());
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
                data.setHallArrDate(hallInfo.getHallArrDate());
                data.setHallDepDate(hallInfo.getHallDepDate());
                
				hi.add(data);
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
        
        
          return hi;
	}
	
	
	
	
	
	@Override
	public List<HallInfo> searchHall(HallInfo hallInfo) throws Exception {
		
		List<HallInfo> hi = new ArrayList<HallInfo>();
        String query = "SELECT hall_id, hall_name, hall_place,  hall_price,  hall_image, h.category_id, h.city_id, cat.category_name category_name, cit.city_name city_name FROM hall h inner join category cat on h.category_id = cat.category_id inner join city cit on h.city_id = cit.city_id where h.isActive = ? and h.category_id= ? and cat.isActive = ? and cit.isActive = ? and h.hall_availability= ? and h.hall_name = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			
		
			ps.setBoolean(1, true);
			ps.setString(2, hallInfo.getHallCategoryId());
			ps.setBoolean(3, true);
			ps.setBoolean(4, true);
			ps.setString(5, PasswordEncrypterUtil.getInstance().encrypt("YES"));
			ps.setString(6, hallInfo.getHallName());
			//ps.setString(7, hallInfo.getHallName());


			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				HallInfo data=new HallInfo();
				
				data.setHallId(rs.getString("hall_id"));
				data.setHallCategoryId(rs.getString("category_id"));
				data.setHallCityId(rs.getString("city_id"));

				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setHallImage(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setHallCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));

				hi.add(data);
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
        
        
          return hi;
	}

	
@Override	
public int getDoes(String appdate, String vaccine) throws Exception{
		
	//String pattern = "dd-MMMM-yyyy";
//	 Date date1 = new SimpleDateFormat().parse(appdate);
//	 String date = new SimpleDateFormat("dd-MMMM-yyyy").format(date1);
//	 System.out.println(date);
        String query = "select vaccinename, noofdose from doses where bookingdate='03-MAY-2021'" ;
        Connection  con=null;
        PreparedStatement ps=null;
       // ps.setString(1, covidModel.getVaccine());
    	ResultSet rs=null;
        try {
        	
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				if((vaccine.equalsIgnoreCase(rs.getString("vaccinename")))) {
					return rs.getInt("noofdose");
				}
				
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
        
        
          return 33;
	}

@Override
public void doesDeduct(int noOfDoes, CovidModel covidModel) throws Exception {
	StringBuffer sb = new StringBuffer();
    
	  sb.append(" UPDATE doses ")
		.append("SET noofdose=? WHERE vaccinename = ?");

	  int ss = noOfDoes-1;
      Connection  con=null;
      PreparedStatement ps=null;
//      String genId = getStudendGenId("SVIST", studentRegistrationInfo.getStreamId(), 
//      		studentRegistrationInfo.getStudentCategoryId(), 
//      		studentRegistrationInfo.getAcademicYear());
      try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(sb.toString());
			 
			ps.setInt(1, ss);
			ps.setString(2, covidModel.getVaccine());

         int i=ps.executeUpdate();  
			System.out.println(i+" vaccine deduct");  
			DataBaseConnectionManager.commit(con);
			
      } catch (SQLException e) {
			e.printStackTrace();
      }
		finally{
			DataBaseConnectionManager.close(ps);
			DataBaseConnectionManager.close(con);
		}
      
     // return true;
}
}






