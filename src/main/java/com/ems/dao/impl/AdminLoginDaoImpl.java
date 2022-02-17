package com.ems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.ems.conn.DataBaseConnectionManager;
import com.ems.conn.PredsUtilException;
import com.ems.dao.AdminLoginDao;
import com.ems.model.AdminLoginInfo;
import com.ems.model.HallInfo;
import com.ems.util.PasswordEncrypterUtil;


@Component("AdminLoginDao")
public class AdminLoginDaoImpl implements AdminLoginDao{

	
	@Override
	public int loginAdmin(HttpSession session, AdminLoginInfo adminLoginInfo) throws Exception {
		// in28minutes, dummy
		 int c = 0;

		String query = "select a_id, a_username, a_password from admin_login where isActive = ? " ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				if(adminLoginInfo.getAdminUsername().equalsIgnoreCase(rs.getString(2)) && adminLoginInfo.getAdminPassword().equals(rs.getString(3)))
						{
					
					          c++;
					          session.setAttribute("logedAdminId", rs.getString(1));
					          //session.setAttribute("logedAdmin", rs.getString("a_id"));
					          //session.setAttribute("logedin_search", rs.getString(1));
					      
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
	public List<AdminLoginInfo> getAdminProfile(String logedAdminId) throws Exception {
		
		List<AdminLoginInfo> ali = new ArrayList<AdminLoginInfo>();
        String query = "select a_id, a_username, a_password from admin_login where isActive = ? and a_id = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, true);
			ps.setString(2, logedAdminId);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				AdminLoginInfo data=new AdminLoginInfo();
				
				data.setAdminId(rs.getString("a_id"));
				data.setAdminUsername(rs.getString("a_username"));
				data.setAdminPassword(rs.getString("a_password"));
				ali.add(data);
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
        
        
          return ali;
	}
	
	
	
	@Override
	public boolean editAdminProfile(AdminLoginInfo adminLoginInfo, String logedAdminId) throws Exception {
		
		
        String query = "update admin_login set a_username = ?, a_password = ? where a_id = ?" ;
        Connection  con=null;
        PreparedStatement ps=null;
    	ResultSet rs=null;
        try {
			con=DataBaseConnectionManager.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, adminLoginInfo.getAdminUsername());
			ps.setString(2, adminLoginInfo.getAdminPassword());
			ps.setString(3, logedAdminId);
			
			int i = ps.executeUpdate();
			System.out.println(i+" records Updated");  
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
