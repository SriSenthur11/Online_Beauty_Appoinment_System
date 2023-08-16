package com.beautician.controller;

import java.util.List;

import com.beautician.entity.Customer;
import com.beautician.service.CustomerService;
import com.beautician.service.CustomerServiceImpl;

public class NurseryController {

	private CustomerService customerService;

	public NurseryController() {
		customerService = new CustomerServiceImpl();
	}
	
	public void insertCustomer(Customer customer) {
		int status = customerService.insertCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record inserted successfully.");
		}else {
			System.out.println("Record couldn't be inserted");
		}
	}
	
	public void updateCustomer(Customer customer) {
		int status = customerService.updateCustomer(customer);
		
		if(status > 0) {
			System.out.println("Record updated successfully.");
		}else {
			System.out.println("Record couldn't be updated");
		}
	}
	
	public void deleteCustomer(int custId) {
		int status = customerService.deleteCustomer(custId);
		
		if(status > 0) {
			System.out.println("Record deleted successfully.");
		}else {
			System.out.println("Record couldn't be deleted");
		}
	}
	
	public Customer viewCustomer(int custId) {
		Customer customer = customerService.viewCustomer(custId);
		return customer;
	}
	
	public List<Customer> viewAllCustomers(){
		return customerService.viewCustomers();
	}
}
