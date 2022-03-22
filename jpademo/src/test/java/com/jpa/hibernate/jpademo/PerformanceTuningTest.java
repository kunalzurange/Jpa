package com.jpa.hibernate.jpademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;

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
public class PerformanceTuningTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional 
	
	public void creatingNPlusOneProblem() {
		
		List<KunalCourse> courses = em.createNamedQuery("query_get_all_courses",KunalCourse.class)
								.getResultList();
	
		for(KunalCourse course:courses) {
			logger.info("Course -> {} Students -> {}",course,course.getStudents());
		}
	}
	
	
	public void solvingNPlusOneProblem_EntityGraph() {
		EntityGraph<KunalCourse> entityGraph = em.createEntityGraph(KunalCourse.class);
	    Subgraph<Object> subgraph = entityGraph.addSubgraph("students");
		List<KunalCourse> courses = em.createNamedQuery("query_get_all_courses",KunalCourse.class)
						.setHint("javax.persistence.loadgraph", entityGraph)		
						.getResultList();
	
		for(KunalCourse course:courses) {
			logger.info("Course -> {} Students -> {}",course,course.getStudents());
		}
	}
	

	public void solvingNPlusOneProblem_JoinFetch() {
		
		List<KunalCourse> courses = em.createNamedQuery("query_get_all_courses",KunalCourse.class)
								.getResultList();
	
		for(KunalCourse course:courses) {
			logger.info("Course -> {} Students -> {}",course,course.getStudents());
		}
	}
	
	
	
	/*public void findById_basic() {
		
		KunalCourse course = repository.findById(10013L);
		assertEquals("arjun", course.getName());
		//logger.info("Testing is Running");
		//System.out.println("Testing is Running");
	}*/
		
}