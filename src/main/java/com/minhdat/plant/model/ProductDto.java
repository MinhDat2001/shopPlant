package com.minhdat.plant.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductDto implements Serializable {
	private Long productId;
	private String name;
	private double price;
	private int categoryId;
	private int quantity;
	private String image_1;
	private String image_2;
	private String image_3;
	private String image_4;
	private String description;
	private Date uploadDate;
	private ProductDto(Long productId, String name, double price, int categoryId, int quantity, String image_1,
			String image_2, String image_3, String image_4, String description, Date uploadDate) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.description = description;
		this.uploadDate = uploadDate;
	}
	public ProductDto() {
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage_1() {
		return image_1;
	}
	public void setImage_1(String image_1) {
		this.image_1 = image_1;
	}
	public String getImage_2() {
		return image_2;
	}
	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}
	public String getImage_3() {
		return image_3;
	}
	public void setImage_3(String image_3) {
		this.image_3 = image_3;
	}
	public String getImage_4() {
		return image_4;
	}
	public void setImage_4(String image_4) {
		this.image_4 = image_4;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
}
