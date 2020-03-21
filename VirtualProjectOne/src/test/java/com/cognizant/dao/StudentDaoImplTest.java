package com.cognizant.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.model.Student;

public class StudentDaoImplTest {
	
	private StudentDao dao;
	private Student student;
	@Before
	public void setup() {
    	@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	this.dao = (StudentDao)context.getBean("dao");
		this.student = new Student(106, "Mr. Dubey", 55);
	}
	
	
	@Test
	public void testInsert() {
		assertEquals("SUCCESS", dao.insert(student));
	}

	@Test
	public void testGetAll() {
		assertEquals(1, dao.getAll().size());
	}

}
