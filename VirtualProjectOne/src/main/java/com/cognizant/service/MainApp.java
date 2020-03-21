package com.cognizant.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.dao.AppConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = (StudentDao) context.getBean("dao");
		dao.insert(new Student(101,"Mr. Das",78));
		dao.insert(new Student(102,"Mr. Sen",84));
		dao.insert(new Student(103,"Mr. Roy",75));
			
		
		List<Student> studentList=dao.getAll();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

}
