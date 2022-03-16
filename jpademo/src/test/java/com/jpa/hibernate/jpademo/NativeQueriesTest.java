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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpademoApplication.class) 
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	/*@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("SELECT * FROM Kunal_Course", Kunal_Course.class);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Kunal_Course ->{}",resultList);
	}*/
	/*
	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM Kunal_Course where id = ?", Kunal_Course.class);
		query.setParameter(1, 10020L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Kunal_Course where id = ? ->{}",resultList);
		//: binding parameter [1] as [BIGINT] - [10020]
		//: extracted value ([id] : [BIGINT]) - [10020]
		//: extracted value ([createdDate] : [TIMESTAMP]) - [2022-03-10T18:09:05.402266]
		//: extracted value ([lastUpdatedDate] : [TIMESTAMP]) - [2022-03-10T18:09:05.403269]
		//: extracted value ([name] : [VARCHAR]) - [kunal - updated]
	}*/
	
	/*@Test
	public void native_queries_with_named_parameter() {
		Query query = em.createNativeQuery("SELECT * FROM Kunal_Course where id = :id", Kunal_Course.class);
		query.setParameter("id", 10023L);
		List resultList = query.getResultList();
		logger.info("SELECT * FROM Kunal_Course where id = :id ->{}",resultList);
		
	}*/
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("Update Kunal_Course set lastUpdatedDate=sysdate()", KunalCourse.class);
		int noOfRowsupDated = query.executeUpdate();
		logger.info("noOfRowsupDated  ->{}", noOfRowsupDated);
		//System.out.printf("noOfRowsupDated  ->{}",noOfRowsupDated);
		
	}
}