package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.ReservationDao;
import com.ems.model.ReservationInfo;
import com.ems.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao reservationDao;
	
	@Override
	public List<ReservationInfo> getAllReservationHall() throws Exception{
	
		List<ReservationInfo> reservationInfo = reservationDao. getAllReservationHall();
		
		return reservationInfo;
	}
	
	@Override
	public List<ReservationInfo> getAllReservationHallOfParticulatId(String logedUserId) throws Exception{
	
		List<ReservationInfo> reservationInfo = reservationDao. getAllReservationHallOfParticulatId(logedUserId);
		
		return reservationInfo;
	}
	
	@Override
	public void deleteReservationHall(ReservationInfo reservationInfo) throws Exception{
		
		boolean f = reservationDao.deleteReservationHall(reservationInfo);
	}
	
	@Override
	public void cancelReservedHall(ReservationInfo reservationInfo) throws Exception{
		
		boolean f = reservationDao.cancelReservedHall(reservationInfo);
	}
	
	@Override
     public void bookedReservationHall(ReservationInfo reservationInfo) throws Exception{
		
		boolean f = reservationDao.bookedReservationHall(reservationInfo);
	}
	
	@Override
    public void updateReservationHall(ReservationInfo reservationInfo) throws Exception{
		
		boolean f = reservationDao.updateReservationHall(reservationInfo);
	}
}
