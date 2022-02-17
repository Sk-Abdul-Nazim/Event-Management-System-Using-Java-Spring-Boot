package com.ems.service;

import java.util.List;
import com.ems.conn.PredsUtilException;
import com.ems.model.CityInfo;


public interface CityService {

	List<CityInfo> getAllCity() throws Exception;

	void addCity(CityInfo cityInfo) throws Exception;

	List<CityInfo> getCityNameWithParticularId(CityInfo cityInfo) throws Exception;

	void editCity(CityInfo cityInfo)  throws Exception;

	void deleteCity(CityInfo cityInfo)  throws Exception;



}
