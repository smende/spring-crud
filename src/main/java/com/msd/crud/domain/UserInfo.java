package com.msd.crud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private long id;
	private String email;
	private String cell;
	private String fullAddress;
	
	@OneToOne
	private User user;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserInfo(long id, String email, String cell, String fullAddress) {
		
		this.id = id;
		this.email = email;
		this.cell = cell;
		this.fullAddress = fullAddress;
	}
	public UserInfo() {
	}

	
	
	
}
