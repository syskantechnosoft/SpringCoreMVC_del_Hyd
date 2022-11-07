package com.deloitte;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Traditional Way
		Course course1 = new Course();
		System.out.println(course1);

		Course course2 = new Course(100, "Testing", 20, "Manual Testing", "https://corejava.com/testing");
		System.out.println(course2);

		// Using Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Course course3 = (Course) context.getBean("course3");
		System.out.println(course3);
		System.out.println(course3.hashCode());

		Course course4 = (Course) context.getBean("course4");
		System.out.println(course4);
		System.out.println(course4.hashCode());

		Course course5 = (Course) context.getBean("course3");
		Course course6 = (Course) context.getBean("course4");
		System.out.println(course5);
		System.out.println(course5.hashCode());
		System.out.println(course6);
		System.out.println(course6.hashCode());

		B b = new B();
		A a = new A(b);
		b.print();
		a.print();
		//a.display();

		// using spring ci
		B b1 = (B) context.getBean("b");
		A a1 = (A) context.getBean("a");
		
		b1.print();
		a1.print();
		//a1.display();
		
		//Using spring SI
		B b2 = (B)context.getBean("b");
		A a2 = (A)context.getBean("a1");
		b2.print();
		a2.print();
		//a2.display();

		System.out.println("*******");
		//Using Spring Autowire
		A a3 = context.getBean("a2",A.class);
		a3.display();
	}

}
