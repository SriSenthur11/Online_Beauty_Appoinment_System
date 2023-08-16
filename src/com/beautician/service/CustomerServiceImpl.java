package com.beautician.service;

import java.util.List;

import com.beautician.dao.ICustomerDAO;
import com.beautician.entity.Customer;
import com.beautician.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	private ICustomerDAO customerDAO;
	
	public CustomerServiceImpl() {
		customerDAO = new CustomerDAOImpl();
	}
	
	@Override
	public int insertCustomer(Customer customer) {
		return customerDAO.insert(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerDAO.update(customer);
	}

	@Override
	public int deleteCustomer(int custId) {
		return customerDAO.delete(custId);
	}

	@Override
	public Customer viewCustomer(int custId) {
		return customerDAO.viewOne(custId);
	}

	@Override
	public List<Customer> viewCustomers() {
		return customerDAO.viewAll();
	}

}
