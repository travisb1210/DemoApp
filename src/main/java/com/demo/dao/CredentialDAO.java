package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.model.Credential;

public class CredentialDAO {

	public Credential getCredential(String userName, String password) throws Exception {
		

        String url = "jdbc:postgresql://localhost:5432/credentials";
		String dbUserName = "postgres";
		String dbPassword = "pass123";
		
		String sql = "SELECT * FROM CREDENTIALS WHERE username='" + userName + "' AND password='" + password + "'";
//		String sql = "SELECT * FROM credentials";
		
		System.out.println("Executing query: " + sql);	
		
		try {
			System.out.println("Verifiying credentials");	
			Class.forName("org.postgresql.Driver");
			
			Connection conn = DriverManager.getConnection(url, dbUserName, dbPassword);
			System.out.println("Successful DB connection established");
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			
			Credential credential = new Credential();
			
			if(rs.next()) {
				credential.setUsername(rs.getString("username"));
				credential.setPassword(rs.getString("password"));
			}

			conn.close();
			
			return credential;
		}catch (Exception e) {
			throw new Exception("FAILURE: " + e.getMessage());
		}
 	}
	
}
