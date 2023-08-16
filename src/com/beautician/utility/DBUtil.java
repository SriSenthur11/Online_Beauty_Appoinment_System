package com.beautician.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static Connection connNursery;
	
	public static Connection createConnection() throws SQLException{
		ResourceBundle resOracle = ResourceBundle.getBundle("oracle");
		
		String url = resOracle.getString("url");
		String username = resOracle.getString("username");
		String password = resOracle.getString("password");
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		connNursery = DriverManager.getConnection(url, username, password);
		return connNursery;
	}
	
	public static void closeConnection()throws SQLException{
		if(connNursery != null){
			connNursery.close();
		}
	}

}
