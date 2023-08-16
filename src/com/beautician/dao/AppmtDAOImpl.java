package com.beautician.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beautician.entity.Appmt;
import com.beautician.entity.Beautician;
import com.beautician.entity.Services;
import com.beautician.utility.DBUtil;

public class AppmtDAOImpl implements IAppmtDAO {

	@Override
	public int insertAppService(Appmt appmt) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO Appmt VALUES(?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appmt.getAppId());
			pstStudent.setInt(2, appmt.getCustId());
			pstStudent.setInt(3, appmt.getSerId());
		

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with Appoinment ID " + appmt.getAppId());
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
	public int deleteAppService(int appId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM Appmt WHERE Appid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with Appointment ID " + appId);
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
	public Appmt viewOneAppService(int appId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM Appmt WHERE Appid=?");

		Appmt appmt = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, appId);
			

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				appmt = new Appmt();
				appmt.setappId(rsService.getInt("AppId"));
				appmt.setCustId(rsService.getInt("CustId"));
				appmt.setSerId(rsService.getInt("SerId"));
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
		
		return appmt;
	}

	@Override
	public List<Appmt> viewAllAppServices() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsService = null;
		String sql = new String("SELECT * FROM Appmt");

		Appmt appmt = null;
		List<Appmt>appmts = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsService = pstStudent.executeQuery();

			while(rsService.next()) {
				appmt = new Appmt();
				appmt.setappId(rsService.getInt("AppId"));
				appmt.setCustId(rsService.getInt("CustId"));
				appmt.setSerId(rsService.getInt("SerId"));
				
				appmts.add(appmt);
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
		
		return appmts;
	}

}