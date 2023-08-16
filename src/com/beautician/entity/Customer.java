package com.beautician.entity;

import java.util.Objects;

public class Customer {
	private int custId;
	private String name;
	private String address;
	private String contactNo;
	
	public Customer() {
	}

	public Customer(int custId, String name, String address, String contactNo) {
		this.custId = custId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public int hashCode() {
		return custId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNo, other.contactNo)
				&& custId == other.custId && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + ", contactNo=" + contactNo
				+ "]";
	}
}