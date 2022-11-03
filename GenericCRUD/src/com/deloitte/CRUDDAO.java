package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private ResultSetMetaData rsmd = null;
	private Scanner input = new Scanner(System.in);
	private int status = 0;

	public void connect() throws Exception {
		if (conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/delo", "root", "root");
		}
	}

	public List<String> getTableNames() throws Exception {
		if (conn == null)
			connect();
		List<String> tables = new ArrayList<String>();
		String query = "show tables";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);

		while (rs.next()) {
			tables.add(rs.getString(1));
		}
		return tables;
	}

	public void displayTableData(String table) throws Exception {
		if (conn == null)
			connect();
		String query = "select * from " + table;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		for (int i = 1; i <= colCount; i++) {
			System.out.print(rsmd.getColumnName(i) + "\t");
		}
		System.out.println(" ");
		while (rs.next()) {
			for (int i = 1; i <= colCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println(" ");
		}
		System.out.println("***** Table Contents Ends here *****");
	}

	public void addRecord(String table) throws Exception {
		if (conn == null)
			connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from " + table);
		rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		List<String> colNames = new ArrayList<String>();
		String query = "insert into " + table + " (";
		for (int i = 1; i <= colCount; i++) {
			String col = rsmd.getColumnName(i);
			colNames.add(col);
			if (i != colCount)
				query += col + ",";
			else
				query += col;
		}
		query = query + ") values (";
		for (int j = 1; j <= colCount; j++) {
			if (j != colCount)
				query += "?,";
			else
				query += "?)";
		}
		System.out.println("insert query :" + query);

		pstmt = conn.prepareStatement(query);
		for (int k = 1; k <= colCount; k++) {
			System.out.print("Enter value for " + colNames.get(k - 1) + " :");
			String data = null;
			data = input.next();
			pstmt.setString(k, data);
		}

		status = pstmt.executeUpdate();
		if (status != 0)
			System.out.println("One Record Insertted to " + table + " table.");
	}

	public void updateRecord(String table, int id) throws Exception {
		if (conn == null)
			connect();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select * from " + table + " where id=" + id);
		rs.next();
		rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		List<String> colNames = new ArrayList<String>();
		String query = "update " + table + " set ";
		for (int i = 2; i <= colCount; i++) {
			String col = rsmd.getColumnName(i);
			colNames.add(col);
			if (i != colCount)
				query += col + "= ?,";
			else
				query += col + "=? ";
		}
		query = query + " where " + rsmd.getColumnName(1) + " = " + rs.getString(1);

		System.out.println("update query :" + query);

		pstmt = conn.prepareStatement(query);
		for (int k = 1; k < colCount; k++) {
			System.out.print("Enter value for " + colNames.get(k - 1) + " :");
			String data = null;
			data = input.next();
			pstmt.setString(k, data);
		}

		status = pstmt.executeUpdate();
		if (status != 0)
			System.out.println("One Record Updated in " + table + " table.");

	}

	public void deleteRecord(String table, int id) throws Exception {
		if (conn == null)
			connect();
		String query = "delete from " + table + " where id=" + id;
		stmt = conn.createStatement();
		status = stmt.executeUpdate(query);
		if (status != 0)
			System.out.println("One Record Deleted in " + table + " table.");

	}
}
