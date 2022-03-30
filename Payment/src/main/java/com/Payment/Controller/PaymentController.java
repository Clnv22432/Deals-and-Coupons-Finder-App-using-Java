package com.Payment.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Payment.Model.PaymentPOJO;
import com.Payment.Repository.PaymentRepository;
import com.Payment.Service.PaymentService;

import ch.qos.logback.core.joran.spi.ActionException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	public PaymentService paymentService;
	
	
	@Autowired
	public PaymentRepository paymentRepository;
	
	
	@GetMapping("/orders/{id}")
	public Optional<PaymentPOJO> getCustomerById(@PathVariable int id) throws ActionException {
		return Optional.of(paymentRepository.findById(id)
				.orElseThrow(() -> new ActionException()));
	}
	
	
	
	@PostMapping("/payment")
	public PaymentPOJO doPayment(@RequestBody PaymentPOJO payment) {
		return paymentService.doPay(payment);
		
	}

}
