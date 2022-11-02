package com.deloitte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.entity.Trainee;
import com.deloitte.util.DBUtil;

public class TraineeDAO {

	public int insertTrainee(Trainee trainee) throws Exception {
		String insertQuery = "insert into trainees (name,email,mobile) values (?,?,?)";
		PreparedStatement pstmt = DBUtil.createConnection().prepareStatement(insertQuery);
		pstmt.setString(1, "test");
		pstmt.setString(2, "test@gmail.com");
		pstmt.setLong(3, 9090909090l);
		return pstmt.executeUpdate();
	}

	public int updateTrainee(int id, Trainee updatedTrainee) throws Exception {
		String updateQuery = "update trainees set name=?, email=?, mobile=? where id=?";
		PreparedStatement pstmt = DBUtil.createConnection().prepareStatement(updateQuery);
		pstmt.setString(1, updatedTrainee.getName());
		pstmt.setString(2, updatedTrainee.getEmail());
		pstmt.setLong(3, updatedTrainee.getMobile());
		pstmt.setInt(4, id);
		return pstmt.executeUpdate();
	}

	public int deleteTrainee(int id) throws Exception {
		String deleteQuery = "delete from trainees where id=" + id;
		Statement stmt = DBUtil.createConnection().createStatement();
		return stmt.executeUpdate(deleteQuery);
	}

	public Trainee readById(int id) throws Exception {
		String readAllQuery = "select * from trainees where id=" + id;
		Statement stmt = DBUtil.createConnection().createStatement();
		ResultSet rs = stmt.executeQuery(readAllQuery);
		Trainee t = new Trainee();
		if (rs.next()) {
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setEmail(rs.getString("email"));
			t.setMobile(rs.getLong("mobile"));
		}
		return t;
	}

	public List<Trainee> readAll() throws Exception {
		String readAllQuery = "select * from trainees";
		Statement stmt = DBUtil.createConnection().createStatement();
		ResultSet rs = stmt.executeQuery(readAllQuery);
		List<Trainee> traineeList = new ArrayList<Trainee>();
		while (rs.next()) {
			Trainee t = new Trainee();
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setEmail(rs.getString("email"));
			t.setMobile(rs.getLong("mobile"));
			traineeList.add(t);
		}
		return traineeList;
	}

}
