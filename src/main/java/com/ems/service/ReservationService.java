package com.ems.service;

import java.util.List;


import com.ems.model.ReservationInfo;


public interface ReservationService {

	List<ReservationInfo> getAllReservationHall() throws Exception;

	void deleteReservationHall(ReservationInfo reservationInfo) throws Exception;

	void bookedReservationHall(ReservationInfo reservationInfo)throws Exception;

	void updateReservationHall(ReservationInfo reservationInfo) throws Exception;

	List<ReservationInfo> getAllReservationHallOfParticulatId(String logedUserId) throws Exception;

	void cancelReservedHall(ReservationInfo reservationInfo)throws Exception;
}
