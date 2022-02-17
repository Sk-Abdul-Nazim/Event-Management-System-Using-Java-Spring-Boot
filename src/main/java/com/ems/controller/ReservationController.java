package com.ems.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ems.model.ReservationInfo;
import com.ems.service.ReservationService;
import com.ems.util.PasswordEncrypterUtil;

@Controller
@SessionAttributes("reservation")

public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/reservationHall", method = RequestMethod.GET)
	public String getAllReservationHall(ModelMap model) throws Exception {

			model.put("allReservationHall", reservationService.getAllReservationHall());

		return "./admin/reservation";
	}
	
	
	@RequestMapping(value = "/myBooking", method = RequestMethod.GET)
	public String getAllReservationHallOfParticulatId(HttpSession session, ModelMap model) throws Exception {

		String logedUserId = (String)session.getAttribute("logedUserId");
			model.put("allReservationHallOfParticular", reservationService.getAllReservationHallOfParticulatId(logedUserId));

		return "userMyBooking";
	}
	
	@RequestMapping(value = "/deleteReservationHall", method = RequestMethod.GET)
	public String deleteActiveHall(HttpSession session, ModelMap model , @ModelAttribute("ReservationInfo") ReservationInfo reservationInfo, @RequestParam String id) throws Exception {
		
		reservationInfo.setReservId(id);
		reservationService.deleteReservationHall(reservationInfo); 

		return "redirect:/reservationHall";
	}
	
	@RequestMapping(value = "/cancelReservedHall", method = RequestMethod.GET)
	public String cancelReservedHall(HttpSession session, ModelMap model , @ModelAttribute("ReservationInfo") ReservationInfo reservationInfo, @RequestParam String id) throws Exception {
		
		reservationInfo.setReservId(id);
		reservationService.cancelReservedHall(reservationInfo); 

		return "redirect:/myBooking";
	}
	
	
	@RequestMapping(value = "/hallBooked", method = RequestMethod.GET)
	public String errorBookedReservationHall( ModelMap model) throws Exception {

		return "redirect:/";
	}
	
	@RequestMapping(value = "/hallBooked", method = RequestMethod.POST)
	public String bookedReservationHall(HttpSession session, @ModelAttribute("ReservationInfo") ReservationInfo reservationInfo, ModelMap model, @RequestParam String hallId, @RequestParam String catId, @RequestParam String citId, @RequestParam String arr_date, @RequestParam String dep_date,  @RequestParam String paymentId) throws Exception {

		
		reservationInfo.setReservId(UUID.randomUUID().toString());
		reservationInfo.setOrderNo(PasswordEncrypterUtil.getInstance().encrypt(PasswordEncrypterUtil.gen()));
		reservationInfo.setUserId((String)session.getAttribute("logedUserId"));
		reservationInfo.setHallId(hallId);
		reservationInfo.setCategoryId(catId);
		reservationInfo.setCityId(citId);
		reservationInfo.setArrivalDate(arr_date);
		reservationInfo.setDepartureDate(dep_date);
		reservationInfo.setPaymentId(paymentId);
		
			reservationService.bookedReservationHall(reservationInfo);
			reservationService.updateReservationHall(reservationInfo);

		return "redirect:/";
	}
}
