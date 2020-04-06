package com.assignment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.assignment.domain.OrderDetail;
import com.assignment.util.ApplicationUtil;
import com.assignment.util.Status;

@Repository
public class OrderRepositoryImpl implements OrderDetailStatusRepository , OrderDetailDateWiseRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<OrderDetail> getOrderDetailByStatus() {
		Query orQuery = new Query();
		
		orQuery.addCriteria(
				Criteria.where("status").is(Status.CANCELLED)
				.orOperator(
					Criteria.where("status").is(Status.DELIVERED)));
		List<OrderDetail> orderDetailResult = mongoTemplate.find(orQuery, OrderDetail.class);
		return orderDetailResult;
	}

	@Override
	public List<OrderDetail> getOrderDetailByDate(Date date) {
		Query query = new Query();
		Date now = new Date();
		Date retentionDate = ApplicationUtil.daysAgo(90);
		query.addCriteria(Criteria.where("orderDate").gte(retentionDate)
		                            .lte(now));
		List<OrderDetail> orderDetailResult = mongoTemplate.find(query, OrderDetail.class);
		return orderDetailResult;
	}
	
	public void saveOrderdetails(OrderDetail orderDetail) {
		mongoTemplate.save(orderDetail, "orderDetail");
	}

}
