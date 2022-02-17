package com.ems.dao;

import java.util.List;

import com.ems.model.CityInfo;

public interface CityDao {

	List<CityInfo> getAllCity() throws Exception;

	boolean addCity(CityInfo cityInfo) throws Exception;

	List<CityInfo> getCityNameWithParticularId(CityInfo cityInfo) throws Exception;

	boolean editCity(CityInfo cityInfo)throws Exception;

	boolean deleteCity(CityInfo cityInfo) throws Exception;


}
