package com.Payment.Service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Payment.Model.PaymentPOJO;
import com.Payment.Repository.PaymentRepository;



@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public PaymentPOJO doPay(PaymentPOJO payment) {
		payment.setPaymentStatus(paymentStatus());
		payment.setTxId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
		
	}

	private String paymentStatus() {
		// TODO Auto-generated method stub
		return new Random().nextBoolean()?"success":"failure";
	}
	
}
