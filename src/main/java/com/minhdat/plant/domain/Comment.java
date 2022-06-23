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
@Table(name = "comments")
public class Comment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	@ManyToOne
	@JoinColumn(name = "custommerId")
	private Customer comment_customer;
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product comment_product;
	@Column(columnDefinition = "nvarchar(300) not null")
	private String content;
	

	
	public Comment(Long commentId, Customer comment_customer, Product comment_product, String content) {
		super();
		this.commentId = commentId;
		this.comment_customer = comment_customer;
		this.comment_product = comment_product;
		this.content = content;
	}
	public Comment() {
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Customer getComment_customer() {
		return comment_customer;
	}
	public void setComment_customer(Customer comment_customer) {
		this.comment_customer = comment_customer;
	}
	public Product getComment_product() {
		return comment_product;
	}
	public void setComment_product(Product comment_product) {
		this.comment_product = comment_product;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	
}
