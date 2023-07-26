package com.minhdat.plant.domain;

import java.io.Serializable;

public class Order implements Serializable {
	private int quantity;
	private Product product;
	public Order(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
