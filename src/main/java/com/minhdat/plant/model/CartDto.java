package com.minhdat.plant.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CartDto implements Serializable{
	private long cartId;
	private long customerId;
	private long productId;
	private int quantity;
	public CartDto(long cartId, long customerId, long productId, int quantity) {
		this.cartId = cartId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public CartDto() {
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
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
	
}
