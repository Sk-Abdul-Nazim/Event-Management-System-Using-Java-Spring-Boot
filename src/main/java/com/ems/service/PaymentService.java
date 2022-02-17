package com.ems.service;

import java.util.List;

import com.ems.model.PaymentInfo;

public interface PaymentService {

	List<PaymentInfo> getAllPayment() throws Exception;

	void addPaymentMethod(PaymentInfo paymentInfo) throws Exception;

	List<PaymentInfo> getPaymentNameWithParticularId(PaymentInfo paymentInfo) throws Exception;

	void editPaymentMethod(PaymentInfo paymentInfo)  throws Exception;

	void deletePaymentMethod(PaymentInfo paymentInfo)  throws Exception;

	List<PaymentInfo> getCODPayment() throws Exception;
}
