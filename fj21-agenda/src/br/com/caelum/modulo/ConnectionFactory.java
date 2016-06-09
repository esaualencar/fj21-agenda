package br.com.caelum.modulo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionFactory {

	
	public java.sql.Connection getConnection() {
		java.sql.Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "testando123");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return (java.sql.Connection) new RuntimeException(e);
		}  
		
		
		
	}
	
	
	

}
