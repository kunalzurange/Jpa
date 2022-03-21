package com.jpa.hibernate.jpademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
public class CriteriaQueryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void all_courses() {
		
//1
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KunalCourse> cq = cb.createQuery(KunalCourse.class);
		
		
//2
		Root<KunalCourse> courseRoot = cq.from(KunalCourse.class);
		
//3
		
//4		
		
//5
		TypedQuery<KunalCourse> query = 
				em.createQuery(cq.select(courseRoot));
		 
		List<KunalCourse> resultList = query.getResultList();
		logger.info("Typed Query ->{}",resultList);
	}

	
	
	@Test
	public void all_courses_having_100Steps() {
		
//1
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KunalCourse> cq = cb.createQuery(KunalCourse.class);
		
		
//2
		Root<KunalCourse> courseRoot = cq.from(KunalCourse.class);
		
//3
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps"); 
        cq.where(like100Steps);         
		
//4		
		cq.where(like100Steps);
        
        
//5
		TypedQuery<KunalCourse> query = 
				em.createQuery(cq.select(courseRoot));
		 
		List<KunalCourse> resultList = query.getResultList();
		logger.info("Typed Query ->{}",resultList);
	}

	
	
	@Test
	public void all_courses_without_students() {
		
//1
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KunalCourse> cq = cb.createQuery(KunalCourse.class);
		
		
//2
		Root<KunalCourse> courseRoot = cq.from(KunalCourse.class);
		
//3
		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("KunalStudent")); 
         
		
//4		
		cq.where(studentsIsEmpty);
        
        
//5
		TypedQuery<KunalCourse> query = 
				em.createQuery(cq.select(courseRoot));
		 
		List<KunalCourse> resultList = query.getResultList();
		logger.info("Typed Query ->{}",resultList);
	}
	

	@Test
	public void join() {
		
//1
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KunalCourse> cq = cb.createQuery(KunalCourse.class);
		
		
//2
		Root<KunalCourse> courseRoot = cq.from(KunalCourse.class);
		
//3
		Join<Object, Object> join = courseRoot.join("KunalStudent"); 
         
		
//4		
		
        
        
//5
		TypedQuery<KunalCourse> query = 
				em.createQuery(cq.select(courseRoot));
		 
		List<KunalCourse> resultList = query.getResultList();
		logger.info("Typed Query ->{}",resultList);
	}
	

	
	@Test
	public void left_join() {
		
//1
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<KunalCourse> cq = cb.createQuery(KunalCourse.class);
		
		
//2
		Root<KunalCourse> courseRoot = cq.from(KunalCourse.class);
		
//3
		Join<Object, Object> join = courseRoot.join("KunalStudent", JoinType.LEFT); 
         
		
//4		
		
        
        
//5
		TypedQuery<KunalCourse> query = 
				em.createQuery(cq.select(courseRoot));
		 
		List<KunalCourse> resultList = query.getResultList();
		logger.info("Typed Query ->{}",resultList);
	}

	
	
}