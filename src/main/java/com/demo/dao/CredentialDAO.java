package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.Credential;

public class CredentialDAO {

	public Credential getCredential(String userName, String password) throws SQLException {
		
		String url = "jbdc:postgresql://localhost:5432/students";
		String dbUserName = "postgres";
		String dbPassword = "pass123";
		
		String sql = "SELECT * FROM CREDENTIALS WHERE username='" + userName + "' AND password='" + password + "'";
		System.out.println("Executing query: " + sql);
		
		try {
			System.out.println("Verifiying credentials");
			Connection conn = DriverManager.getConnection(url, dbUserName, dbPassword);
			System.out.println("Successful DB connection established");
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			
			Credential credential = new Credential();
			credential.setUsername(rs.getString("username"));
			credential.setPassword(rs.getString("password"));
			
			conn.close();
			
			return credential;
		}catch (SQLException e) {
			throw new SQLException("Unrecognized credentials");
		}
 	}
	
}
