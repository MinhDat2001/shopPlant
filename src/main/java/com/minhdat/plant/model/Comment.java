package com.minhdat.plant.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Comment implements Serializable {
	private long commentId;
	private long custommerId;
	private long productId;
	private String content;
	public Comment(long commentId, long custommerId, long productId, String content) {
		this.commentId = commentId;
		this.custommerId = custommerId;
		this.productId = productId;
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
	public long getCustommerId() {
		return custommerId;
	}
	public void setCustommerId(long custommerId) {
		this.custommerId = custommerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
