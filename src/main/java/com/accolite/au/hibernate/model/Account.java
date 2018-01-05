package com.accolite.au.hibernate.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {

	
	private Long acctNo;
	
	private String acctName;
	
	private String acctType;
	
	private Customer customer;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String acctName, String acctType) {
		super();
		this.acctName = acctName;
		this.acctType = acctType;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getAcctNo() {
		return this.acctNo;
	}

	public void setAcctNo(Long acctNo) {
		this.acctNo = acctNo;
	}

	public String getAcctName() {
		return this.acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}

	public String getAcctType() {
		return this.acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTID", nullable=false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	@Override
	public String toString() {
		return "Account [acctNo=" + acctNo + ", acctName=" + acctName + ", acctType=" + acctType + ", customer="
				+ customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctName == null) ? 0 : acctName.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		Account other = (Account) obj;
		if (acctName == null) {
			if (other.acctName != null)
				return false;
		} else if (!acctName.equals(other.acctName))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	
	
}
