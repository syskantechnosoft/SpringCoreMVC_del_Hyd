package com.happy.service;

import java.util.List;

import com.happy.bean.Course;

public interface CourseService {
	public void addCourse(Course course);

	public List<Course> listCourses();

	public Course getCourse(int id);

	public void deleteCourse(Course course);
}
