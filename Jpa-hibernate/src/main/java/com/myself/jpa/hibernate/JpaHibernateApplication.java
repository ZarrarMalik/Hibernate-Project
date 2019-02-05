package com.myself.jpa.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myself.jpa.hibernate.entity.Course;
import com.myself.jpa.hibernate.repository.CourseRepository;
import com.myself.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner{

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;


	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		studentRepository.saveStudentWithPassport();
		//repository.playWithEntityManager();
	}	
}
