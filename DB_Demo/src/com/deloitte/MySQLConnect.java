package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// Step 1 : Loading & Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 : Establishing the Connection
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/delo";

		Connection conn = DriverManager.getConnection(url, username, password);

		// Step 3 : Create & Execute Query
		String query = "select * from trainees";

		Statement stmt = conn.createStatement();

		// Step 4 : Storing & Processing the Result
		ResultSet rs = stmt.executeQuery(query);

		System.out.println("ID \t Name \t Email \t Mobile ");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getLong(4));
		}
		
		//Step 5 :close all resources
		rs.close();
		stmt.close();
		conn.close();
	}

}
