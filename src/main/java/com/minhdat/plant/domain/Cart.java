package com.minhdat.plant.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "carts")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	@ManyToOne
	@JoinColumn(name = "custommerId")
	private Customer cart_customer;
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product cart_product;
	@Column(length = 20)
	private int quantity;
	
	public Cart() {
	}
	

	public Cart(Customer cart_customer, Product cart_product, int quantity) {
		this.cartId=(long) 100;
		this.cart_customer = cart_customer;
		this.cart_product = cart_product;
		this.quantity = quantity;
	}


	public Customer getCart_customer() {
		return cart_customer;
	}


	public void setCart_customer(Customer cart_customer) {
		this.cart_customer = cart_customer;
	}


	public Product getCart_product() {
		return cart_product;
	}


	public void setCart_product(Product cart_product) {
		this.cart_product = cart_product;
	}


	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
