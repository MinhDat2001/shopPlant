package com.minhdat.plant.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class HistoryDto implements Serializable {
	private long historyId;
	private long customerId;
	private long productId;
	private int quantity;
	private double price;
	private int status;
	public HistoryDto() {
	}
	public HistoryDto(long historyId, long customerId, long productId, int quantity, double price, int status) {
		this.historyId = historyId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	public long getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
