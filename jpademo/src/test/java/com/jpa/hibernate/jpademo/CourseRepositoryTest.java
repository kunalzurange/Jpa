package com.jpa.hibernate.jpademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

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
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	public void findById_basic() {
		
		KunalCourse course = repository.findById(10013L);
		assertEquals("arjun", course.getName());
		//logger.info("Testing is Running");
		//System.out.println("Testing is Running");
	}
	
	/*@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));

}*/
	
	/*@Test
	@DirtiesContext
	public void save_basic() {
		 
		//get a course
		KunalCourse course = repository.findById(10013L);
		assertEquals("arjun", course.getName());
		
		//update details
		course.setName("arjun - Updated");

		 repository.save(course);
		
		//check the value
		KunalCourse course1 = repository.findById(10013L);
		assertEquals("arjun - Updated", course1.getName());
		//repository.save(10002L);
		//assertNull(repository.findById(10002L));
	}*/
	
	/*@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
		
	}*/
	
	/*@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		KunalCourse course = repository.findById(10001L);
		logger.info("{}",course.getReviews()); 
	}*/
	
	@Test
	@Transactional
	public void retrieveCourseForReviews() {
		KunalReview review = em.find(KunalReview.class,50001L);
		logger.info("{}",review.getCourse()); 
	
/*	
Hibernate: 
		    select
		        kunalcours0_.id as id1_0_0_,
		        kunalcours0_.createdDate as createdd2_0_0_,
		        kunalcours0_.lastUpdatedDate as lastupda3_0_0_,
		        kunalcours0_.name as name4_0_0_ 
		    from
		        KunalCourse kunalcours0_ 
		    where
		        kunalcours0_.id=?
2022-03-15 16:59:25.971 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 16:59:26.301 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([createdd2_0_0_] : [TIMESTAMP]) - [2022-03-15T12:42:14]
2022-03-15 16:59:26.302 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([lastupda3_0_0_] : [TIMESTAMP]) - [2022-03-15T12:42:14]
2022-03-15 16:59:26.303 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name4_0_0_] : [VARCHAR]) - [spring boot in 100 steps]
2022-03-15 16:59:26.330 TRACE 2340 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalCourse.reviews#10003]

Hibernate: 
		    select
		        reviews0_.course_id as course_i4_2_0_,
		        reviews0_.id as id1_2_0_,
		        reviews0_.id as id1_2_1_,
		        reviews0_.course_id as course_i4_2_1_,
		        reviews0_.description as descript2_2_1_,
		        reviews0_.rating as rating3_2_1_ 
		    from
		        KunalReview reviews0_ 
		    where
		        reviews0_.course_id=?
2022-03-15 16:59:26.340 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 16:59:26.647 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50003]
2022-03-15 16:59:26.648 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.649 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [awesome course]
2022-03-15 16:59:26.649 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.649 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.650 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50003]
2022-03-15 16:59:26.650 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50004]
2022-03-15 16:59:26.651 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.651 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Great Hands-on Stuff.]
2022-03-15 16:59:26.651 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.651 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.652 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50004]
2022-03-15 16:59:26.652 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50005]
2022-03-15 16:59:26.652 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.653 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Hatsoff.]
2022-03-15 16:59:26.653 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.653 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.653 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50005]
2022-03-15 16:59:26.654 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50006]
2022-03-15 16:59:26.654 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.654 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Great Hands-on Stuff.]
2022-03-15 16:59:26.654 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.654 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.655 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50006]
2022-03-15 16:59:26.655 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50007]
2022-03-15 16:59:26.655 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.655 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Hatsoff.]
2022-03-15 16:59:26.655 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.656 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.656 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50007]
2022-03-15 16:59:26.656 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50008]
2022-03-15 16:59:26.656 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.656 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Great Hands-on Stuff.]
2022-03-15 16:59:26.657 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.657 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.657 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50008]
2022-03-15 16:59:26.657 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_1_] : [BIGINT]) - [50009]
2022-03-15 16:59:26.658 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_1_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.658 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_1_] : [VARCHAR]) - [Hatsoff.]
2022-03-15 16:59:26.658 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_1_] : [VARCHAR]) - [5]
2022-03-15 16:59:26.658 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10003]
2022-03-15 16:59:26.658 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [50009]
		course.getReviews() -> {}[KunalReview[5 awesome course], KunalReview[5 Great Hands-on Stuff.], KunalReview[5 Hatsoff.], KunalReview[5 Great Hands-on Stuff.], KunalReview[5 Hatsoff.], KunalReview[5 Great Hands-on Stuff.], KunalReview[5 Hatsoff.]]

Hibernate: 
		    insert 
		    into
		        KunalReview
		        (course_id, description, rating) 
		    values
		        (?, ?, ?)
2022-03-15 16:59:26.695 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 16:59:26.697 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [VARCHAR] - [Great Hands-on Stuff.]
2022-03-15 16:59:26.697 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [5]

Hibernate: 
		    insert 
		    into
		        KunalReview
		        (course_id, description, rating) 
		    values
		        (?, ?, ?)
2022-03-15 16:59:27.010 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 16:59:27.010 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [VARCHAR] - [Hatsoff.]
2022-03-15 16:59:27.010 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [5]

Hibernate: 
		    select
		        kunalrevie0_.id as id1_2_0_,
		        kunalrevie0_.course_id as course_i4_2_0_,
		        kunalrevie0_.description as descript2_2_0_,
		        kunalrevie0_.rating as rating3_2_0_,
		        kunalcours1_.id as id1_0_1_,
		        kunalcours1_.createdDate as createdd2_0_1_,
		        kunalcours1_.lastUpdatedDate as lastupda3_0_1_,
		        kunalcours1_.name as name4_0_1_ 
		    from
		        KunalReview kunalrevie0_ 
		    left outer join
		        KunalCourse kunalcours1_ 
		            on kunalrevie0_.course_id=kunalcours1_.id 
		    where
		        kunalrevie0_.id=?
2022-03-15 16:59:29.663 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [50001]
2022-03-15 16:59:29.966 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_0_1_] : [BIGINT]) - [10001]
2022-03-15 16:59:29.967 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i4_2_0_] : [BIGINT]) - [10001]
2022-03-15 16:59:29.968 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([descript2_2_0_] : [VARCHAR]) - [great course]
2022-03-15 16:59:29.968 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([rating3_2_0_] : [VARCHAR]) - [5]
2022-03-15 16:59:29.969 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([createdd2_0_1_] : [TIMESTAMP]) - [2022-03-15T12:40:47]
2022-03-15 16:59:29.969 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([lastupda3_0_1_] : [TIMESTAMP]) - [2022-03-15T12:40:47]
2022-03-15 16:59:29.969 TRACE 2340 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name4_0_1_] : [VARCHAR]) - [jpa in 50 steps]
2022-03-15 16:59:29.970 TRACE 2340 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalCourse.reviews#10001]
2022-03-15 16:59:30.658 TRACE 2340 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Handling #sessionFactoryClosed from [org.hibernate.internal.SessionFactoryImpl@7a3643e3] for TypeConfiguration
2022-03-15 16:59:30.659 DEBUG 2340 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Un-scoping TypeConfiguration [org.hibernate.type.spi.TypeConfiguration$Scope@6fab9cf] from SessionFactory [org.hibernate.internal.SessionFactoryImpl@7a3643e3]
*/
		
	}
}