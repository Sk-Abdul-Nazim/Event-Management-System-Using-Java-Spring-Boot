package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.CityDao;
import com.ems.model.CityInfo;
import com.ems.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao citydao;
	
	@Override
	public List<CityInfo> getAllCity() throws Exception {
		
		List<CityInfo> cityInfo = citydao.getAllCity();
		
		return cityInfo;
	}
	
	@Override
	public void addCity(CityInfo cityInfo) throws Exception{
		
		boolean c = citydao.addCity(cityInfo);
	}
	
	@Override
	public void editCity(CityInfo cityInfo) throws Exception{
		
		boolean c = citydao.editCity(cityInfo);
	}
	
	@Override
	public List<CityInfo> getCityNameWithParticularId(CityInfo cityInfo) throws Exception{
	
		List<CityInfo> particularCityInfo = citydao.getCityNameWithParticularId(cityInfo);
		
		return particularCityInfo;
	}
	
	@Override
	public void deleteCity(CityInfo cityInfo) throws Exception{
		
		boolean c = citydao.deleteCity(cityInfo);
	}
	
}
