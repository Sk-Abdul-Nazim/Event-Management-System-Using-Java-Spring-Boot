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
import com.ems.dao.ReservationDao;
import com.ems.model.ReservationInfo;
import com.ems.util.PasswordEncrypterUtil;

@Component("ReservationDao")
public class ReservationDaoImpl implements ReservationDao{

	@Override
	public List<ReservationInfo> getAllReservationHall() throws Exception {
		
		List<ReservationInfo> ri = new ArrayList<ReservationInfo>();
        String query = "SELECT reserv_id, order_no, arrival_date, departure_date, booked_date, booked_time,u.u_name u_name, u.u_email u_email, u.u_phone u_phone, u.u_adhar u_adhar, u.u_address u_address,h.hall_name hall_name,cat.category_name category_name,h.hall_place hall_place,cit.city_name city_name,h.hall_seat hall_seat, h.hall_price hall_price,p.payment_name payment_name FROM reservationhall r inner join user_registration u on r.u_id = u.u_id  inner join city cit on r.city_id = cit.city_id inner join category cat on r.category_id = cat.category_id   inner join hall h on r.hall_id = h.hall_id inner join paymentmethod p on r.payment_id = p.payment_id where  r.isActive =true and u.isActive = true and cat.isActive = true and cit.isActive = true and p.isActive = true" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
	
			rs = ps.executeQuery();
	
			
			while (rs.next()) {
				
				
				ReservationInfo data=new ReservationInfo();
				data.setReservId(rs.getString("reserv_id"));
				data.setOrderNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("order_no")));
				data.setArrivalDate(rs.getString("arrival_date"));
				data.setDepartureDate(rs.getString("departure_date"));
				data.setBookedDate(rs.getString("booked_date"));
				data.setBookedTime(rs.getString("booked_time"));
				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
				data.setUserEmail(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
				data.setUserPhone(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
				data.setUserAdhar(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setPaymentName(PasswordEncrypterUtil.getInstance().decript(rs.getString("payment_name")));
				
				ri.add(data);
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
        
          return ri;
	}
	
	
	@Override
	public List<ReservationInfo> getAllReservationHallOfParticulatId(String logedUserId) throws Exception {
		
		List<ReservationInfo> ri = new ArrayList<ReservationInfo>();
        String query = "SELECT reserv_id, order_no, arrival_date, departure_date, booked_date, booked_time,u.u_name u_name, u.u_email u_email, u.u_phone u_phone, u.u_adhar u_adhar, u.u_address u_address,h.hall_name hall_name,cat.category_name category_name,h.hall_place hall_place, h.hall_image hall_image,cit.city_name city_name,h.hall_seat hall_seat, h.hall_price hall_price,p.payment_name payment_name FROM reservationhall r inner join user_registration u on r.u_id = u.u_id  inner join city cit on r.city_id = cit.city_id inner join category cat on r.category_id = cat.category_id   inner join hall h on r.hall_id = h.hall_id inner join paymentmethod p on r.payment_id = p.payment_id where  r.u_id = ? and r.isActive =true and u.isActive = true and cat.isActive = true and cit.isActive = true and p.isActive = true" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, logedUserId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				
				ReservationInfo data=new ReservationInfo();
				data.setReservId(rs.getString("reserv_id"));
				data.setOrderNo(PasswordEncrypterUtil.getInstance().decript(rs.getString("order_no")));
				data.setArrivalDate(rs.getString("arrival_date"));
				data.setDepartureDate(rs.getString("departure_date"));
				data.setBookedDate(rs.getString("booked_date"));
				data.setBookedTime(rs.getString("booked_time"));
				data.setUserName(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_name")));
				data.setUserEmail(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_email")));
				data.setUserPhone(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_phone")));
				data.setUserAdhar(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_adhar")));
				data.setUserAddress(PasswordEncrypterUtil.getInstance().decript(rs.getString("u_address")));
				data.setHallName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_name")));
				data.setCategoryName(PasswordEncrypterUtil.getInstance().decript(rs.getString("category_name")));
				data.setHallPlace(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_place")));
				data.setHallImageName(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_image")));
				data.setCityName(PasswordEncrypterUtil.getInstance().decript(rs.getString("city_name")));
				data.setHallSeat(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_seat")));
				data.setHallPrice(PasswordEncrypterUtil.getInstance().decript(rs.getString("hall_price")));
				data.setPaymentName(PasswordEncrypterUtil.getInstance().decript(rs.getString("payment_name")));
		
				ri.add(data);
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
        
          return ri;
	}
	
	@Override
     public boolean deleteReservationHall(ReservationInfo reservationInfo) throws Exception{
		
		String query = "UPDATE reservationHall SET isActive = ? WHERE reserv_id = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, false);
			ps.setString(2, reservationInfo.getReservId());
			
			int i=ps.executeUpdate();  
			System.out.println(i+" records Daleted");  
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
    public boolean cancelReservedHall(ReservationInfo reservationInfo) throws Exception{
		
		String query = "UPDATE reservationHall SET isActive = ? WHERE reserv_id = ?" ;
       Connection  con=null;
       PreparedStatement ps=null;
   	ResultSet rs=null;
       try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, false);
			ps.setString(2, reservationInfo.getReservId());
			
			int i=ps.executeUpdate();  
			System.out.println(i+" records Cancel");  
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
    public boolean bookedReservationHall(ReservationInfo reservationInfo) throws Exception{
		
       StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());
		 
		 
	
	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());		 
	      
	      
		  sb.append(" INSERT INTO reservationhall  ")
			.append("( reserv_id, order_no, arrival_date, departure_date, booked_date, booked_time, u_id, hall_id, category_id, city_id, payment_id, isActive)")
			.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		  
       Connection  con=null;
       PreparedStatement ps=null;
   	ResultSet rs=null;
       try {
    		con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(sb.toString());
			
			ps.setString(1, reservationInfo.getReservId());
			ps.setString(2, reservationInfo.getOrderNo());
			ps.setString(3, reservationInfo.getArrivalDate());
			ps.setString(4, reservationInfo.getDepartureDate());
			ps.setString(5, date);
			ps.setString(6, time);
			ps.setString(7, reservationInfo.getUserId());
			ps.setString(8, reservationInfo.getHallId());
			ps.setString(9, reservationInfo.getCategoryId());
			ps.setString(10, reservationInfo.getCityId());
			ps.setString(11, reservationInfo.getPaymentd());
			ps.setBoolean(12, true);
			
			int i=ps.executeUpdate();  
			System.out.println(i+" Hall Booked");  
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
    public boolean updateReservationHall(ReservationInfo reservationInfo) throws Exception{
		
		String query = "UPDATE hall SET hall_availability = ? WHERE hall_id = ?" ;
       Connection  con=null;
       PreparedStatement ps=null;
   	ResultSet rs=null;
       try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, PasswordEncrypterUtil.getInstance().encrypt("NO"));
			ps.setString(2, reservationInfo.getHallId());
			
			int i=ps.executeUpdate();  
			System.out.println(i+" Update hall Availibility = No");  
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
}
