package com.Payment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pay")
public class TestPayment {
	
	@GetMapping("/payment")
	public String getPayment() {
		return "Hello from GetPayment";
	}

}
