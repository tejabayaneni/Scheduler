package com.assignment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.assignment.domain.OrderDetail;

@Repository
public interface OrderDetailDateWiseRepository {

	List<OrderDetail> getOrderDetailByDate(Date date);
}
