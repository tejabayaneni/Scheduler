package com.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.domain.OrderDetail;

@Repository
public interface OrderRepository
		extends MongoRepository<OrderDetail, Long>, OrderDetailDateWiseRepository, OrderDetailStatusRepository {

}
