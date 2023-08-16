package com.beautician.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beautician.entity.Customer;
import com.beautician.utility.DBUtil;

public class CustomerDAOImpl implements ICustomerDAO {

	@Override
	public int insert(Customer customer) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO customer VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, customer.getCustId());
			pstStudent.setString(2, customer.getName());
			pstStudent.setString(3, customer.getAddress());
			pstStudent.setString(4, customer.getContactNo());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with customer ID " + customer.getCustId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public int update(Customer customer) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE customer SET name=?, address=?, contactno=?"
				+ " WHERE custid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, customer.getName());
			pstStudent.setString(2, customer.getAddress());
			pstStudent.setString(3, customer.getContactNo());
			pstStudent.setInt(4, customer.getCustId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with customer ID " + customer.getCustId());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public int delete(int custId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM customer WHERE custid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with customer ID " + custId);
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		return status;
	}

	@Override
	public Customer viewOne(int custId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer WHERE custid=?");

		Customer customer = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, custId);
			

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer();
				customer.setCustId(rsCustomer.getInt("custId"));
				customer.setName(rsCustomer.getString("name"));
				customer.setAddress(rsCustomer.getString("address"));
				customer.setContactNo(rsCustomer.getString("contactno"));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return customer;
	}

	@Override
	public List<Customer> viewAll() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsCustomer = null;
		String sql = new String("SELECT * FROM customer");

		Customer customer = null;
		List<Customer>customers = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsCustomer = pstStudent.executeQuery();

			while(rsCustomer.next()) {
				customer = new Customer();
				customer.setCustId(rsCustomer.getInt("custId"));
				customer.setName(rsCustomer.getString("name"));
				customer.setAddress(rsCustomer.getString("address"));
				customer.setContactNo(rsCustomer.getString("contactno"));
				
				customers.add(customer);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				DBUtil.closeConnection();
			} catch (SQLException se) {
				System.out.println("Problems in closing connection");
			}
		}
		
		return customers;
	}

}