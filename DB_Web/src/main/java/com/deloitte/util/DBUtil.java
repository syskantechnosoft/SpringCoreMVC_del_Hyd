package com.deloitte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	private static Connection conn;
	private static ResultSet rs;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static String username = "root";
	private static String password = "root";
	private static String url = "jdbc:mysql://localhost:3306/delo";

	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeResource() throws Exception {
		if (pstmt != null)
			pstmt.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
		if (conn != null)
			conn.close();
	}

}
