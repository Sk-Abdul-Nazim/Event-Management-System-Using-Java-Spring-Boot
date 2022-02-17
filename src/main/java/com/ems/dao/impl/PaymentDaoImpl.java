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
import com.ems.dao.PaymentDao;
import com.ems.model.PaymentInfo;
import com.ems.util.PasswordEncrypterUtil;

@Component(value="PaymentDao")
public class PaymentDaoImpl implements PaymentDao{

	@Override
	public List<PaymentInfo> getAllPayment() throws Exception {
		
		List<PaymentInfo> pi = new ArrayList<PaymentInfo>();
        String query = "select payment_id, payment_name, payment_date, payment_time from paymentmethod where isActive = ? order by payment_name" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				PaymentInfo data=new PaymentInfo();
				
				data.setPaymentId(rs.getString("payment_id"));
				data.setPaymentName(PasswordEncrypterUtil.getInstance().decript(rs.getString("payment_name")));
				data.setPaymentDate(rs.getString("payment_date"));
				data.setPaymentTime(rs.getString("payment_time"));
				
				pi.add(data);
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
          return pi;
	}
	

	@Override
	public boolean addPaymentMethod(PaymentInfo paymentInfo) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());

	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());		 	 
	      
	      
		  sb.append(" INSERT INTO paymentmethod  ")
			.append("( payment_id, payment_name, payment_date, payment_time, isActive)")
			.append(" VALUES(?, ?, ?, ?, ?) ");
	        Connection  con=null;
	        PreparedStatement ps=null;

	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				
               ps.setString(1, paymentInfo.getPaymentId());
               ps.setString(2, paymentInfo.getPaymentName());
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
	public List<PaymentInfo> getPaymentNameWithParticularId(PaymentInfo paymentInfo) throws Exception{
		
		List<PaymentInfo> pi = new ArrayList<PaymentInfo>();
        String query = "select payment_id, payment_name from paymentmethod where payment_id=? and isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
        	
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, paymentInfo.getPaymentId());
			ps.setBoolean(2, true);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				PaymentInfo data=new PaymentInfo();
				
				data.setPaymentId(rs.getString("payment_id"));
				data.setPaymentName(PasswordEncrypterUtil.getInstance().decript(rs.getString("payment_name")));
	
				pi.add(data);
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
        
          return pi;
	}
	
	
	@Override
	public boolean editPaymentMethod(PaymentInfo paymentInfo) throws Exception {
		 StringBuffer sb = new StringBuffer();
		 
		 String pattern = "dd-MM-yyyy";
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 String date = simpleDateFormat.format(new Date());

	      String strDateFormat = "hh:mm:ss a";
	      SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
	      String time = sdf.format(new Date());	
	      
	      
		  sb.append(" UPDATE paymentmethod ")
			.append("SET payment_name = ?, payment_date = ?, payment_time = ? WHERE payment_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;

	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setString(1, paymentInfo.getPaymentName());
				ps.setString(2, date);
				ps.setString(3, time);
				ps.setString(4, paymentInfo.getPaymentId());

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
	public boolean deletePaymentMethod(PaymentInfo paymentInfo) throws PredsUtilException {
		
		 StringBuffer sb = new StringBuffer();	      
		  sb.append(" UPDATE paymentmethod ")
			.append("SET isActive = ? WHERE payment_id = ?");

	        Connection  con=null;
	        PreparedStatement ps=null;

	        try {
				con=DataBaseConnectionManager.getConnection();
				ps = con.prepareStatement(sb.toString());
				 
				ps.setBoolean(1, false);
				ps.setString(2, paymentInfo.getPaymentId());

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
	
	
	
	
	@Override
	public List<PaymentInfo> getCODPayment() throws Exception {
		

		List<PaymentInfo> pi1 = new ArrayList<PaymentInfo>();
        String query = "select payment_id from paymentmethod where isActive = ? and payment_name = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setString(2, PasswordEncrypterUtil.getInstance().encrypt("COD"));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				PaymentInfo data1=new PaymentInfo();
				
				data1.setPaymentId(rs.getString(1));

				
				pi1.add(data1);
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
          return pi1;
	}
	


}
