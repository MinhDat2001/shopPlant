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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long customerId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String firstName;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String lastName;
	@Column(length = 100, nullable = false)
	private String password;
	@Column(length = 20)
	private String phoneNumber;
	@Column(length = 200)
	private String address;
	@Column(length = 200)
	private String image;
	@Temporal(TemporalType.DATE)
	private Date registerDate;

	@OneToMany(mappedBy = "comment_customer", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "history_customer", cascade = CascadeType.ALL)
	private Set<History> histories;
	
	@OneToMany(mappedBy = "cart_customer", cascade = CascadeType.ALL)
	private Set<Cart> carts;

	public Customer( String email, String password) {
		this.customerId = (long) 10;
		this.email = email;
		this.firstName = "User";
		this.password = password;
		this.lastName="New";
	}
	public Customer(long customerId, String email, String firstName, String lastName, String password,
			String phoneNumber, String address, String image, Date registerDate) {
		this.customerId = customerId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.image = image;
		this.registerDate = registerDate;
	}
	

	public Customer(Long customerId, String email, String firstName, String lastName, String password,
			String phoneNumber, String address, String image, Date registerDate, Set<Comment> comments,
			Set<History> histories, Set<Cart> carts) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.image = image;
		this.registerDate = registerDate;
		this.comments = comments;
		this.histories = histories;
		this.carts = carts;
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

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Customer() {
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	
}
