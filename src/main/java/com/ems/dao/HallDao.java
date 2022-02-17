package com.ems.dao;

import java.io.FileNotFoundException;
import java.util.List;

import com.ems.model.CovidModel;
import com.ems.model.DropDownBox;
import com.ems.model.HallInfo;


public interface HallDao {

	List<HallInfo> getAllActiveHall() throws Exception;
	
	List<HallInfo> getAllEventsHall() throws Exception;

	List<HallInfo> getParticularEventsHall( HallInfo hallInfo) throws Exception;
	
	List<HallInfo> getHallNameWithParticularId(HallInfo hallInfo) throws Exception;
	
	List<HallInfo> showBookedHall() throws Exception;
	
    List<DropDownBox> getDropDownCategory() throws Exception; 
	
	List<DropDownBox> getDropDownCity() throws Exception;
	
    boolean addActiveHall(HallInfo hallInfo) throws Exception,FileNotFoundException;

	boolean editActiveHall(HallInfo hallInfo)throws Exception;

	boolean deleteActiveHall(HallInfo hallInfo) throws Exception;

	boolean activatedHall(HallInfo hallInfo) throws Exception;
	
	List<HallInfo> searchHall(HallInfo hallInfo) throws Exception;

int getDoes(String appdate, String vaccine) throws Exception;

void doesDeduct(int noOfDoes, CovidModel covidModel) throws Exception;




	
}
