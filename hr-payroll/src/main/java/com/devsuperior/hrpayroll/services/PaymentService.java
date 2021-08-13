package com.devsuperior.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	private WorkerFeignClient workerFeignClient;

	@Autowired
	public PaymentService(WorkerFeignClient workerFeignClient) {
		super();
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(long workerId, int days) {
		Worker worker = this.workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
