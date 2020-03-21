package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;
@Repository
@Qualifier("dao")
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String insert(Student s) {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?,?,?)";
		int row = jdbcTemplate.update(sql,s.getId(),s.getName(),s.getMarks());
		if(row>0)
			return "SUCCESS";
		return "FAIL";
		//System.out.println("Insertion successfull");
		//return 0;
	}

	public List<Student> getAll() {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM student";
		List<Student> stList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
		return stList;
	}

}
