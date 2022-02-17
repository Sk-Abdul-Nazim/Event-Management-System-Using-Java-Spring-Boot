package com.ems.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ems.conn.PredsUtilException;
import com.ems.model.CovidModel;
import com.ems.model.DropDownBox;
import com.ems.model.HallInfo;



public interface HallService {

	List<HallInfo> getAllActiveHall() throws Exception;
	
	List<HallInfo> getHallNameWithParticularId(HallInfo hallInfo) throws Exception;
	
	List<HallInfo> showBookedHall() throws Exception;
	
	List<HallInfo> getAllEventsHall() throws Exception;

	List<HallInfo> getParticularEventsHall( HallInfo hallInfo) throws Exception;

	List<DropDownBox> getDropDownCategory() throws Exception;
	
	List<DropDownBox> getDropDownCity() throws Exception;
	
    void addActiveHall(HallInfo hallInfo) throws Exception,FileNotFoundException;

	void editActiveHall(HallInfo hallInfo)  throws Exception;

	void deleteActiveHall(HallInfo hallInfo)  throws Exception;

    public String  uploadFile(MultipartFile file);

	void activatedHall(HallInfo hallInfo)throws Exception;

	List<HallInfo> searchHall(HallInfo hallInfo) throws Exception;

	int getDoes(String appdate,String vaccine) throws Exception;

//	void doesDeduct(int noOfDoes,CovidModel covidModel)throws Exception;



}
