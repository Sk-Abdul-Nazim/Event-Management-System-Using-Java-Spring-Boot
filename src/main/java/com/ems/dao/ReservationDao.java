package com.ems.dao;

import java.util.List;

import com.ems.model.ReservationInfo;

public interface ReservationDao {

	List<ReservationInfo> getAllReservationHall() throws Exception;

	boolean deleteReservationHall(ReservationInfo reservationInfo) throws Exception;

	boolean bookedReservationHall(ReservationInfo reservationInfo) throws Exception;

	boolean updateReservationHall(ReservationInfo reservationInfo) throws Exception;

	List<ReservationInfo> getAllReservationHallOfParticulatId(String logedUserId) throws Exception;

	boolean cancelReservedHall(ReservationInfo reservationInfo)throws Exception;
}
