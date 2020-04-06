package com.assignment.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment.domain.OrderDetail;

@Repository
public interface OrderDetailStatusRepository {

	List<OrderDetail> getOrderDetailByStatus();
	public void saveOrderdetails(OrderDetail orderDetail);
}
