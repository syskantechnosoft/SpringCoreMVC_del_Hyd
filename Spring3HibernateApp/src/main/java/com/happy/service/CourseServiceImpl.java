package com.happy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.happy.bean.Course;
import com.happy.dao.CourseDao;

@Service("courseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	public List<Course> listCourses() {
		return courseDao.listCourses();
	}

	public Course getCourse(int id) {
		return courseDao.getCourse(id);
	}

	public void deleteCourse(Course course) {
		courseDao.deleteCourse(course);
	}

}
