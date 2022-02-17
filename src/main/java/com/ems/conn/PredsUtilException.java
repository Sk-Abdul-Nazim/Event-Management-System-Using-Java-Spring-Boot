package com.ems.conn;

import java.io.Serializable;

import org.apache.log4j.Logger;


public  class PredsUtilException extends Exception implements Serializable{
	private static final Logger logger = Logger.getLogger(PredsUtilException.class);
	private static final long serialVersionUID = 1L;
	
	
	public PredsUtilException(String arg0)
	{
		super(arg0);
		logger.info(arg0);

	}

	public PredsUtilException(Throwable arg0)
	{
		super(arg0);
		logger.info("IsplException class -------->>>>>>>>>"+arg0);
		

	}
	public PredsUtilException(String message, Throwable cause)
	{
		super(message, cause);
		logger.error(message, cause);

	}

	

	

}
