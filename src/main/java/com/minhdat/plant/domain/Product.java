package com.minhdat.plant.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long productId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int quantity;
	@Column(length = 100)
	private String image_1;
	@Column(length = 100)
	private String image_2;
	@Column(length = 100)
	private String image_3;
	@Column(length = 100)
	private String image_4;
	@Column(columnDefinition = "nvarchar(500)")
	private String description;
	@Temporal(TemporalType.DATE)
	private Date uploadDate;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToMany(mappedBy = "comment_product", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "history_product", cascade = CascadeType.ALL)
	private Set<History> histories;
	@OneToMany(mappedBy = "cart_product", cascade = CascadeType.ALL)
	private Set<Cart> carts;
	
	
	public Product(Long productId, String name, double price, int quantity, String image_1, String image_2,
			String image_3, String image_4, String description, Date uploadDate, int categoryId, Category category,
			Set<Comment> comments, Set<History> histories, Set<Cart> carts) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.description = description;
		this.uploadDate = uploadDate;
		this.category = category;
		this.comments = comments;
		this.histories = histories;
		this.carts = carts;
	}
	public Product(Long productId, String name, double price, int quantity, String image_1, String image_2,
			String image_3, String image_4, String description, Date uploadDate, int categoryId, Category category) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image_1 = image_1;
		this.image_2 = image_2;
		this.image_3 = image_3;
		this.image_4 = image_4;
		this.description = description;
		this.uploadDate = uploadDate;
		this.category = category;
	}
	public Product() {
	}
	
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<History> getHistories() {
		return histories;
	}
	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
