package com.happy.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happy.bean.Course;

@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addCourse(Course course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);
	}

	@SuppressWarnings("unchecked")
	public List<Course> listCourses() {
		return (List<Course>) sessionFactory.getCurrentSession().createCriteria(Course.class).list();
	}

	public Course getCourse(int id) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
	}

	public void deleteCourse(Course course) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Course WHERE id = " + course.getId())
				.executeUpdate();
	}
}
