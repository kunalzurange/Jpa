package com.jpa.hibernate.jpademo;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpademoApplication.class) 
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("qurey_get_all_courses");
		List resultList = query.getResultList();
		logger.info("Select c from Kunal_Course c ->{}",resultList);
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<KunalCourse> query = 
							em.createNamedQuery("qurey_get_all_courses", KunalCourse.class);
		
		List<KunalCourse> resultList = query.getResultList();
		
		logger.info("Select c from Kunal_Course c ->{}",resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<KunalCourse> query = 
							em.createNamedQuery("qurey_get_100_step_courses", KunalCourse.class);
		
		List<KunalCourse> resultList = query.getResultList();
		
		logger.info("Select c from Kunal_Course c where name like'%ajit' ->{}",resultList);
	}

}