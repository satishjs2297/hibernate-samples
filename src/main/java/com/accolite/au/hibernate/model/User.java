package com.accolite.au.hibernate.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {

	private UserPk userPk;
	private String location;
	private String city;
	private String state;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@EmbeddedId
	public UserPk getUserPk() {
		return userPk;
	}

	public void setUserPk(UserPk userPk) {
		this.userPk = userPk;
	}
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((userPk == null) ? 0 : userPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (userPk == null) {
			if (other.userPk != null)
				return false;
		} else if (!userPk.equals(other.userPk))
			return false;
		return true;
	}

	public User(String name, String mobileNumber, String location, String city, String state) {
		this.userPk = new UserPk(name, mobileNumber);
		this.location = location;
		this.city = city;
		this.state = state;
	}

}
