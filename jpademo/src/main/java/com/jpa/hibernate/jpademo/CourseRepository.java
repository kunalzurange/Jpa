package com.jpa.hibernate.jpademo;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//private static final String Long = null;
	@Autowired
	EntityManager em;
	
	public KunalCourse findById(Long id) {
		return em.find(KunalCourse.class, id);
	}
	
	/*public void deletebyId(Long id) {
		Kunal_Course course = findById(id);
		em.remove(course);

	}*/
	
	public KunalCourse save(KunalCourse course){
		
		if(course.getId()==null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
		
	}
	
	public void playWithEntityManager() {
		//System.out.println("play with Entity Manager - start");
		
		//KunalCourse course1 = new KunalCourse("kunal - updated");
		//em.persist(course1);
		//em.flush();
		
		//KunalCourse course2 = findById(10001L);
		//course2.setName=("kunal");
		//Kunal_Course course2 = new Kunal_Course("chetan");
		//em.persist(course2);
		
		//em.flush();
		 
		//em.clear();
		//em.detach(course1);
		//em.detach(course2);
		
		//course1.setName("arjun - updated");
		//em.flush();
		
		//System.out.println("playWithEntityManager - start");
		//logger.info("playWithEntityManager - start");
		
		//Kunal_Course course2 = new Kunal_Course("chetan");
		//em.persist(course2);
		//em.flush();					/* changes which have done they will be sent out of the database.*/

		//em.detach(course2);        // changes to course2 are no longer tracked by em i.e. course2.setname
									  //will not be executed
		
		//course2.setName("chetan - updated");
		
		//em.refresh(course1);
		
		//em.flush();
		
		}

	public void addHardcodedReviewsForCourse(Long courseId, List<KunalReview> reviews) {
		
		//KunalCourse course = findById(10003L);
		//System.out.println("course.getReviews() -> {}" + course.getReviews());   // get course 10003
		
	/*	KunalReview review1 = new KunalReview("5" , "Great Hands-on Stuff.");	//add 2 reviews to it
		KunalReview review2 = new KunalReview("5" , "Hatsoff.");				
	
		course.addReviews(review1);
		review1.setCourse(course);
		
		course.addReviews(review2);
		review2.setCourse(course);												 // setting relationship
		
		em.persist(review1);
		em.persist(review2);													// save it to database
		*/
	} 
	
	public void addReviewsForCourse(Long courseId, List<KunalReview> reviews) {
		
		/*KunalCourse course = findById(courseId);
		System.out.println("course.getReviews() -> {}" + course.getReviews());   
		
		for(KunalReview review:reviews)
		{
			course.addReviews(review);
			review.setCourse(course);
			em.persist(review);
		}*/
	}
}
