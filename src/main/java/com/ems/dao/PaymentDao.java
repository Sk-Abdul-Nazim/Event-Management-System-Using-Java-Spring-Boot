package com.ems.dao;

import java.util.List;

import com.ems.model.PaymentInfo;

public interface PaymentDao {

	List<PaymentInfo> getAllPayment() throws Exception;

	boolean addPaymentMethod(PaymentInfo paymentInfo) throws Exception;

	List<PaymentInfo> getPaymentNameWithParticularId(PaymentInfo paymentInfo) throws Exception;

	boolean editPaymentMethod(PaymentInfo paymentInfo) throws Exception;

	boolean deletePaymentMethod(PaymentInfo paymentInfo) throws Exception;

	List<PaymentInfo> getCODPayment() throws Exception;


}
