package com.assignment.domain;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.assignment.util.Status;

@Document(collection = "orderDetail")
public class OrderDetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4723486311736835662L;

	@Id
	private ObjectId _id;

	@Indexed(unique = true)
	private String orderNumber;

	private Date orderDate;

	private Integer orderTotal;

	private Status status;

	private boolean isOrderComplete;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Status getStatus() {
		return status;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Status getOrderStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isOrderComplete() {
		return isOrderComplete;
	}

	public void setOrderComplete(boolean isOrderComplete) {
		this.isOrderComplete = isOrderComplete;
	}

}
