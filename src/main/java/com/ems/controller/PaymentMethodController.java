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

import com.ems.conn.PredsUtilException;
import com.ems.model.PaymentInfo;
import com.ems.service.PaymentService;
import com.ems.util.PasswordEncrypterUtil;

@Controller
@SessionAttributes("paymentMethod")
public class PaymentMethodController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "/paymentMethod", method = RequestMethod.GET)
	public String getAllPayment(ModelMap model) throws Exception {
		try {
			model.put("allPayment", paymentService.getAllPayment());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "./admin/payment";
	}
	
	
	
	@RequestMapping(value = "/userPaymentMethod", method = RequestMethod.GET)
	public String errorPaymentMethodUser(ModelMap model) throws Exception {
		

		  return "redirect:/";
	}
	
	
	@RequestMapping(value = "/userPaymentMethod", method = RequestMethod.POST)
	public String getAllPaymentMethodUser(ModelMap model, @RequestParam String hallId, @RequestParam String catId, @RequestParam String citId, @RequestParam String arr_date, @RequestParam String dep_date) throws Exception {
		try {

			model.put("pHallId",hallId);
			model.put("pCatId",catId);
			model.put("pCitId",citId);
			model.put("pArrDate",arr_date);
			model.put("pDepDate",dep_date);
			//System.out.println(paymentService.getCODPayment());
			model.put("codPaymentId", paymentService.getCODPayment());
			model.put("allPaymentMethod", paymentService.getAllPayment());
			
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "paymentMethod";
	}
	
	
	@RequestMapping(value = "/addPaymentMethod", method = RequestMethod.GET)
	public String ShowAddPaymentMethodPage(ModelMap model) throws Exception {
		return "./admin/addPayment";
	}
	
	
	@RequestMapping(value = "/addPaymentMethod", method = RequestMethod.POST) 
	public String addPaymentMethod(HttpSession session,@ModelAttribute("PaymentInfo") PaymentInfo paymentInfo, ModelMap model, @RequestParam String paymentname) throws Exception {
		try {
			paymentInfo.setPaymentId(UUID.randomUUID().toString());
			paymentInfo.setPaymentName(PasswordEncrypterUtil.getInstance().encrypt(paymentname));
			
			paymentService.addPaymentMethod(paymentInfo);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/paymentMethod";
	}
	
	
	@RequestMapping(value = "/editPaymentMethod", method = RequestMethod.GET)
	public String ShowEditPaymentMethodPage(HttpSession session, @ModelAttribute("PaymentInfo") PaymentInfo paymentInfo, ModelMap model , @RequestParam String id) throws Exception {
		
		paymentInfo.setPaymentId(id);
		model.put("getPaymentNameWithParticularId", paymentService.getPaymentNameWithParticularId(paymentInfo));
		
		return "./admin/editPaymentMethod";
	}
	
	
	@RequestMapping(value = "/editPaymentMethod", method = RequestMethod.POST) 
	public String editPaymentMethod(HttpSession session,@ModelAttribute("PaymentInfo") PaymentInfo paymentInfo, ModelMap model, @RequestParam String editPaymentId, @RequestParam String paymentname) throws Exception {
		try {
			paymentInfo.setPaymentId(editPaymentId);
			paymentInfo.setPaymentName(PasswordEncrypterUtil.getInstance().encrypt(paymentname));
			
			paymentService.editPaymentMethod(paymentInfo);
		} catch (PredsUtilException e) {
			e.printStackTrace();
		} 
		return "redirect:/paymentMethod";
	}
	
	@RequestMapping(value = "/deletePaymentMethod", method = RequestMethod.GET)
	public String deletePaymentMethod(HttpSession session, ModelMap model , @ModelAttribute("PaymentInfo") PaymentInfo paymentInfo, @RequestParam String id) throws Exception {
		
		paymentInfo.setPaymentId(id);
		paymentService.deletePaymentMethod(paymentInfo); 

		return "redirect:/paymentMethod";
	}
}
