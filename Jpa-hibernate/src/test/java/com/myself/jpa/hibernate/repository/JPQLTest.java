package com.myself.jpa.hibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class JPQLTest {

	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		//query is a local variable not a library
	Query query = em.createQuery("select c from Course c");
	List resultList =	query.getResultList();
	logger.info("select c from Course c --> []", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("select c from Course c",Course.class);
		List<Course> resultList =	query.getResultList();
		logger.info("select c from Course c --> []", resultList);
		}
	
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = 
					em.createQuery("Select  c  From Course c where name like '%100 Steps'", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}",resultList);
		//[Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

	
}