package com.happy.dao;

import java.util.List;

import com.happy.bean.Course;

public interface CourseDao {
	public void addCourse(Course course);

	public List<Course> listCourses();

	public Course getCourse(int id);

	public void deleteCourse(Course course);
}
