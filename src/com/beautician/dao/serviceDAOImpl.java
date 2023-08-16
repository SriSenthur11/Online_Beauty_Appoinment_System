package com.beautician.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beautician.entity.Services;
import com.beautician.utility.DBUtil;

public class serviceDAOImpl implements IserviceDAO {

	@Override
	public int insertService(Services service) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO Services VALUES(?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, service.getSerId());
			pstStudent.setString(2, service.getSername());
		
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with service ID " + service.getSerId());
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
	public int updateService(Services service) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE Services SET Sername=? " + " WHERE Serid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, service.getSername());
			pstStudent.setInt(2, service.getSerId());

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with service ID " + service.getSerId());
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
	public int deleteService(int SerId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM Services WHERE Serid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, SerId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with service ID " + SerId);
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
	public Services viewOneService(int SerId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM Services WHERE Serid=?");

		Services service = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, SerId);
			

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				service = new Services();
				service.setSerId(rsService.getInt("SerId"));
				service.setSername(rsService.getString("Sername"));
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
		
		return service;
	}

	@Override
	public List<Services> viewAllServices() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM Services");

		Services service = null;
		List<Services>services = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				service = new Services();
				service.setSerId(rsService.getInt("SerId"));
				service.setSername(rsService.getString("Sername"));
				
				services.add(service);
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
		
		return services;
	}

}