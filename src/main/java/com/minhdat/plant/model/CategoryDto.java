package com.minhdat.plant.model;

import java.io.Serializable;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CategoryDto implements Serializable {

	private Long categoryId;
	@Length(min=3)
	private String name;
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryDto(Long categoryId, @Length(min = 3) String name) {
		this.categoryId = categoryId;
		this.name = name;
	}
	public CategoryDto() {
	}
	
}
