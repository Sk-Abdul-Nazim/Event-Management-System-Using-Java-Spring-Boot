package com.ems.conn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseConnectionManager {
	/*private static final Logger logger = Logger.getLogger(PredsUtilException.class);*/
	
	/*private static String JDBC_DRIVER   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String JDBC_URL      = "jdbc:sqlserver://127.0.0.1:1433;databaseName=UjvSfb"; 
    private static String JDBC_USER     = "sa";
    private static String JDBC_PASSWORD = "server@123";*/
	
	private static String JDBC_DRIVER   = "com.mysql.jdbc.Driver";
	private static String JDBC_URL      = "jdbc:mysql://localhost:3306/ems"; 
    private static String JDBC_USER     = "root";
    private static String JDBC_PASSWORD = "root";
      

    private static Driver driver = null;
	
	
	public static Connection getConnection() throws PredsUtilException{
		Connection con = null;
		//if (driver == null) {

			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
				 con=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				 con.setAutoCommit(false);
			} catch (Exception e) {
				//logger.info("Failed to initialise JDBC driver");
				e.printStackTrace();
			}
	//	}

		return con;
	}
	
	


	/*
	 * close the Connection 
	 * 
	 */
	public static void close(Connection conn)throws PredsUtilException{	
		
		try {
			if (conn != null){
				conn.close();
			}

		} catch (SQLException e) {
			 throw new PredsUtilException(e);
		}
		
		
	}
	/*
	 * close the PreparedStatement 
	 * 
	 */
	public static void close(PreparedStatement stmt) throws PredsUtilException{
		try {

			if (stmt != null){
				stmt.close();
			}

		} catch (SQLException e) {
			 throw new PredsUtilException(e);
		}
		

	}
	/*
	 * close the ResultSet 
	 * 
	 */
	public static void close(ResultSet rs) throws PredsUtilException{		 
		
		try {

			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			 throw new PredsUtilException(e);
		}		 
	}
	/*
	 * close the Statement 
	 * 
	 */
	public static void close(Statement stmt) throws PredsUtilException{		 
		try {

			if (stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			 throw new PredsUtilException(e);
		}

	}
	/*
	 * used for rollback  
	 * 
	 */
	public static void rollBack(Connection conn) throws PredsUtilException  {		  
	
		try {if (conn != null){
			conn.rollback();
		}
		} catch (SQLException e) {
			 throw new PredsUtilException(e);
			
			
		}
	}
	/*
	 *  commit the connection
	 * 
	 */
	public static void commit(Connection conn) throws PredsUtilException {
		
		try {

			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			 throw new PredsUtilException(e);
		}


	}
}
