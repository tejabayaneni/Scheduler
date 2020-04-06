package com.assignment.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assignment.service.OrderDetailService;

@Component
public class Scheduler {
	
	@Autowired
	OrderDetailService orderDetailService;

	@Scheduled(fixedDelay = 300000, initialDelay = 3000)
	public void fixedDelaySch() {
		orderDetailService.updateOrderDetail();
		
	}
}
