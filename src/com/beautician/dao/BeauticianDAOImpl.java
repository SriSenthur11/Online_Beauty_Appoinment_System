package com.beautician.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beautician.entity.Beautician;
import com.beautician.utility.DBUtil;

public class BeauticianDAOImpl implements IBeauticianDAO {

	@Override
	public int insert(Beautician beautician) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("INSERT INTO beautician VALUES(?,?,?,?)");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, beautician.getbId());
			pstStudent.setString(2, beautician.getName());
			pstStudent.setString(3, beautician.getAddress());
			pstStudent.setString(4, beautician.getContactNo());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record inserted successfully with beautician ID " + beautician.getbId());
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
	public int update(Beautician beautician) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("UPDATE beautician SET bname=?, baddress=?, bcontactNo=?"
				+ " WHERE bId=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setString(1, beautician.getName());
			pstStudent.setString(2, beautician.getAddress());
			pstStudent.setString(3, beautician.getContactNo());
			pstStudent.setInt(4, beautician.getbId());
			

			status = pstStudent.executeUpdate();

			System.out.println("Record updated successfully with beautician ID " + beautician.getbId());
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
	public int delete(int bId) {
		int status = 0;

		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		String sql = new String("DELETE FROM beautician WHERE bid=?");

		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, bId);
			

			status = pstStudent.executeUpdate();

			System.out.println("Record deleted successfully with beautician ID " + bId);
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
	public Beautician viewOne(int bId) {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsBeautician = null;
		String sql = new String("SELECT * FROM beautician WHERE bid=?");

		Beautician beautician = null;
		
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);
			pstStudent.setInt(1, bId);
			

			rsBeautician = pstStudent.executeQuery();

			while(rsBeautician.next()) {
				beautician = new Beautician();
				beautician.setbId(rsBeautician.getInt("bId"));
				beautician.setName(rsBeautician.getString("bname"));
				beautician.setAddress(rsBeautician.getString("baddress"));
				beautician.setContactNo(rsBeautician.getString("bcontactno"));
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
		
		return beautician;
	}

	@Override
	public List<Beautician> viewAll() {
		Connection connStudent = null;
		PreparedStatement pstStudent = null;

		ResultSet rsBeautician = null;
		String sql = new String("SELECT * FROM beautician");

		Beautician beautician = null;
		List<Beautician>beauticians = new ArrayList<>();
		try {
			connStudent = DBUtil.createConnection();

			pstStudent = connStudent.prepareStatement(sql);

			rsBeautician = pstStudent.executeQuery();

			while(rsBeautician.next()) {
				beautician = new Beautician();
				beautician.setbId(rsBeautician.getInt("bId"));
				beautician.setName(rsBeautician.getString("bname"));
				beautician.setAddress(rsBeautician.getString("baddress"));
				beautician.setContactNo(rsBeautician.getString("bcontactno"));
				
				beauticians.add(beautician);
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
		
		return beauticians;
	}

}
