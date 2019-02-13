package com.myself.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.myself.jpa.hibernate.JpaHibernateApplication;
import com.myself.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateApplication.class)
public class CourseRepositoryTest {

	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void findById_basic() {
		
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		
		
	}

	@Test
	public void findById_firstLevelCacheDemo() {
		
		Course course = courseRepository.findById(10001L);
		logger.info("First Course Retrieved {}", course);

		Course course1 = courseRepository.findById(10001L);
		logger.info("First Course Retrieved again {}", course1);

		assertEquals("JPA in 50 Steps", course.getName());
		
		assertEquals("JPA in 50 Steps", course1.getName());
	}

	
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		
		courseRepository.deleteById(10002L);
		assertNull(courseRepository.findById(10002L));
		
		
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
				Course course = courseRepository.findById(10001L);
				assertEquals("JPA in 50 Steps", course.getName());

				// update details
				course.setName("JPA in 50 Steps - Updated");

				courseRepository.save(course);

				// check the value
				Course course1 = courseRepository.findById(10001L);
				assertEquals("JPA in 50 Steps - Updated", course1.getName());
		
	}
	
	
	
	
}

