package com.happy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.happy.bean.Course;
import com.happy.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("command") Course courseBean, BindingResult result) {
		Course course = prepareModel(courseBean);
		courseService.addCourse(course);
		return new ModelAndView("redirect:/addCourse.html");
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView listCourses() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courses", prepareListofBean(courseService.listCourses()));
		return new ModelAndView("coursesList", model);
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView addCourse(@ModelAttribute("command") Course courseBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courses", prepareListofBean(courseService.listCourses()));
		return new ModelAndView("addCourse", model);
	}

	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public ModelAndView editCourse(@ModelAttribute("command") Course courseBean, BindingResult result) {
		courseService.deleteCourse(prepareModel(courseBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("course", null);
		model.put("courses", prepareListofBean(courseService.listCourses()));
		return new ModelAndView("addCourse", model);
	}

	@RequestMapping(value = "/editCourse", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@ModelAttribute("command") Course courseBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("course", prepareCourseBean(courseService.getCourse(courseBean.getId())));
		model.put("courses", prepareListofBean(courseService.listCourses()));
		return new ModelAndView("addCourse", model);
	}

	private Course prepareModel(Course courseBean) {
		Course course = new Course();
		course.setUrl(courseBean.getUrl());
		course.setDuration(courseBean.getDuration());
		course.setName(courseBean.getName());
		course.setDescription(courseBean.getDescription());
		course.setId(courseBean.getId());
		courseBean.setId(0);
		return course;
	}

	private List<Course> prepareListofBean(List<Course> courses) {
		List<Course> beans = null;
		if (courses != null && !courses.isEmpty()) {
			beans = new ArrayList<Course>();
			Course bean = null;
			for (Course course : courses) {
				bean = new Course();
				bean.setName(course.getName());
				bean.setId(course.getId());
				bean.setUrl(course.getUrl());
				bean.setDescription(course.getDescription());
				bean.setDuration(course.getDuration());
				beans.add(bean);
			}
		}
		return beans;
	}

	private Course prepareCourseBean(Course course) {
		Course bean = new Course();
		bean.setName(course.getName());
		bean.setId(course.getId());
		bean.setUrl(course.getUrl());
		bean.setDescription(course.getDescription());
		bean.setDuration(course.getDuration());
		return bean;
	}
}
