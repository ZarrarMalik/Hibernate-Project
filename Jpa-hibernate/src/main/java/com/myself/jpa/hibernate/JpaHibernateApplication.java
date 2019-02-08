package com.myself.jpa.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myself.jpa.hibernate.entity.Course;
import com.myself.jpa.hibernate.entity.FullTimeEmployee;
import com.myself.jpa.hibernate.entity.PartTimeEmployee;
import com.myself.jpa.hibernate.entity.Review;
import com.myself.jpa.hibernate.entity.Student;
import com.myself.jpa.hibernate.repository.CourseRepository;
import com.myself.jpa.hibernate.repository.EmployeeRepository;
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
	
	@Autowired
	private EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		//studentRepository.saveStudentWithPassport();
				//repository.playWithEntityManager();
				//courseRepository.addHardcodedReviewsForCourse();
				//List<Review> reviews = new ArrayList<>();
				
				//reviews.add(new Review("5", "Great Hands-on Stuff."));	
				//reviews.add(new Review("5", "Hatsoff."));

				//courseRepository.addReviewsForCourse(10003L, reviews );
				//studentRepository.insertHardcodedStudentAndCourse();
				//studentRepository.insertStudentAndCourse(new Student("Jack"), 
					//	new Course("Microservices in 100 Steps"));
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
}
}
