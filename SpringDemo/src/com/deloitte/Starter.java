package com.deloitte;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = null; // Creating object refernce (Obj is not created yet)

		Employee emp1 = new Employee();
		// creating another reference variable and instantiating it using new keyword
		// Employee obj is created

		System.out.println(emp);
		System.out.println(emp1);
		System.out.println(emp1.hashCode());

		Employee emp2 = new Employee(100, "test");
		System.out.println(emp2);
		System.out.println(emp2.hashCode());

		emp1.setId(50);
		emp1.setName("sample");
		System.out.println(emp1);

		// Spring handling/managing the beans
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Employee employee = (Employee) factory.getBean("employeeBean");
		System.out.println(employee);
		System.out.println(employee.hashCode());

		Employee employee1 = (Employee) factory.getBean("employeeBean1");
		System.out.println(employee1);
		System.out.println(employee1.hashCode());

		Employee employee2 = (Employee) factory.getBean("employeeBean");
		System.out.println(employee2);
		System.out.println(employee2.hashCode());
		// employee2 = employee;
		
		ApplicationContext context =   
			    new ClassPathXmlApplicationContext("applicationContext.xml");  

		Student stu = (Student) context.getBean("student");
		System.out.println(stu);
	}

}
