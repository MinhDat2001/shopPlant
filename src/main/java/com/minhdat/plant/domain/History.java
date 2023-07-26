package com.minhdat.plant.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "histories")
public class History implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	@ManyToOne
	@JoinColumn(name = "custommerId")
	private Customer history_customer;
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product history_product;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int status;


	
	public History(Customer history_customer, Product history_product, int quantity, double price,
			int status) {
		this.historyId = (long) 100;
		this.history_customer = history_customer;
		this.history_product = history_product;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	public History() {
	}
	public long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}
	

	
	public Customer getHistory_customer() {
		return history_customer;
	}
	public void setHistory_customer(Customer history_customer) {
		this.history_customer = history_customer;
	}
	public Product getHistory_product() {
		return history_product;
	}
	public void setHistory_product(Product history_product) {
		this.history_product = history_product;
	}
	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
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
