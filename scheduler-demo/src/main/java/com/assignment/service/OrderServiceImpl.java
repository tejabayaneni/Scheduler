package com.assignment.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.domain.OrderDetail;
import com.assignment.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderDetailService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void updateOrderDetail() {
		List<OrderDetail> orderDetailDateWise = orderRepository.getOrderDetailByDate(new Date());

		for (OrderDetail item : orderDetailDateWise) {
			if(!item.isOrderComplete()) {
			item.setOrderComplete(true);
			List<OrderDetail> orderDetailstatusWise = orderRepository.getOrderDetailByStatus();
			for (OrderDetail items : orderDetailstatusWise) {
				items.setOrderComplete(true);
				orderRepository.saveOrderdetails(items);
			}
			}
			orderRepository.saveOrderdetails(item);
		}

		
		
	}
}
