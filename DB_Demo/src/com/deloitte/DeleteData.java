package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// Step 1 : Loading & Registering the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2 : Establishing the Connection
		String username = "root";
		String password = "root";
		String url = "jdbc:mysql://127.0.0.1:3306/delo";

		Connection conn = DriverManager.getConnection(url, username, password);

		// Step 3 : Create & Execute Query
		String query = "delete from trainees where id=4";

		Statement stmt = conn.createStatement();

		// Step 4 : Storing & Processing the Result
		int rows = 0;
		rows = stmt.executeUpdate(query);

		if (rows != 0)
			System.out.println("1 Record deletted!!");
		// Step 5 :close all resources
//				rs.close();
		stmt.close();
		conn.close();
	}

}
