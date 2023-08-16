package com.beautician.service;

import java.util.List;

import com.beautician.entity.Customer;

public interface CustomerService {
	public int insertCustomer(Customer customer);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(int custId);
	public Customer viewCustomer(int custId);
	public List<Customer>viewCustomers();
}
