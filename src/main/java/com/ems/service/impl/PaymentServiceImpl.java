package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.PaymentDao;
import com.ems.model.PaymentInfo;
import com.ems.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	
	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public List<PaymentInfo> getAllPayment() throws Exception {
		
		List<PaymentInfo> paymentInfo = paymentDao.getAllPayment();
		
		return paymentInfo;
	}
	
	@Override
	public void addPaymentMethod(PaymentInfo paymentInfo) throws Exception{
		
		boolean c = paymentDao.addPaymentMethod(paymentInfo);
	}
	
	@Override
	public void editPaymentMethod(PaymentInfo paymentInfo) throws Exception{
		
		boolean c = paymentDao.editPaymentMethod(paymentInfo);
	}
	
	@Override
	public List<PaymentInfo> getPaymentNameWithParticularId(PaymentInfo paymentInfo) throws Exception{
	
		List<PaymentInfo> particularPaymentInfo = paymentDao.getPaymentNameWithParticularId(paymentInfo);
		
		return particularPaymentInfo;
	}
	
	@Override
	public void deletePaymentMethod(PaymentInfo paymentInfo) throws Exception{
		
		boolean c = paymentDao.deletePaymentMethod(paymentInfo);
	}
	
	@Override
	public List<PaymentInfo> getCODPayment() throws Exception {
		
		List<PaymentInfo> paymentInfo = paymentDao.getCODPayment();
		
		return paymentInfo;
	}
}
