package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentResource {

	private PaymentService service;

	@Autowired
	public PaymentResource(PaymentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, 
			@PathVariable("days") Integer days) {
		Payment payment = this.service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}
