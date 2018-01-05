package com.accolite.au.hibernate.model;

import javax.persistence.Entity;

@Entity
public class User {

	private UserPk userPk;
	private String location;
	private String city;
	private String state;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public UserPk getUserPk() {
		return userPk;
	}

	public void setUserPk(UserPk userPk) {
		this.userPk = userPk;
	}

}
