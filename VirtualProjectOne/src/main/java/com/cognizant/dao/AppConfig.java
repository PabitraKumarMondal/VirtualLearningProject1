package com.cognizant.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.model.Student;
@Configuration
@ComponentScan(basePackages = "com.cognizant")
@PropertySource(value = { "classpath:db.properties" })
public class AppConfig {
	@Autowired
	private Environment env;
	
		
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUsername(env.getRequiredProperty("USERNAME"));
		ds.setPassword(env.getRequiredProperty("PASSWORD"));
		ds.setDriverClassName(env.getRequiredProperty("DRIVER_CLASS"));
		ds.setUrl(env.getRequiredProperty("URL"));
		return ds;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);		
		return jdbcTemplate;
	}
	@Bean
	public StudentDao dao() {
		return new StudentDaoImpl();
	}
}
