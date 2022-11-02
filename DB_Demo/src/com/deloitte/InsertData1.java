package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertData1 {

	public static void main(String[] args) throws Exception {
		// Step 1 : Loading & Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 : Establishing the Connection
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/delo";

		Connection conn = DriverManager.getConnection(url, username, password);

		// Step 3 : Create & Execute Query
		String query = "insert into trainees (name,email,mobile) values (?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "Sample");
		pstmt.setString(2, "sample@gmail.com");
		pstmt.setLong(3, 9089098978l);

		// Step 4 : Storing & Processing the Result
		int rows = 0;
		rows = pstmt.executeUpdate();

		if (rows != 0)
			System.out.println("1 Record insertted!!");
		// Step 5 :close all resources
//				rs.close();
		pstmt.close();
		conn.close();

	}

}
