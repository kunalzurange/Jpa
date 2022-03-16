package com.jpa.hibernate.jpademo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private CourseRepository courseRepository;

	@Autowired 
	private StudentRepository studentRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception{
		//studentRepository.SaveStudentWithPassport();
		//repository.playWithEntityManager();
		//Kunal_Course course = repository.findById(10004L);
		
		//logger.info("Kunal_Course 10004 -> {}", course);		
		//repository.deletebyId(10002L);
		//repository.save(new Kunal_Course("hrushi"));
	

		//List<KunalReview> reviews=new ArrayList<>();
		//reviews.add(new KunalReview("5" , "Great Hands-on Stuff."));	//add 2 reviews to it
		//reviews.add(new KunalReview("5" , "Hatsoff."));				
		//courseRepository.addReviewsForCourse(10003L,reviews);
		//courseRepository.addHardcodedReviewsForCourse(10003L,reviews);

/*course.getReviews() -> {}[KunalReview[5 awesome course], KunalReview[5 Great Hands-on Stuff.], KunalReview[5 Hatsoff.]]
	Hibernate: 
				    insert 
				    into
				        KunalReview
				        (course_id, description, rating) 
				    values
				        (?, ?, ?)
2022-03-15 15:30:26.679 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 15:30:26.681 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [VARCHAR] - [Great Hands-on Stuff.]
2022-03-15 15:30:26.681 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [5]
	Hibernate: 
				    insert 
				    into
				        KunalReview
				        (course_id, description, rating) 
				    values
				        (?, ?, ?)
2022-03-15 15:30:27.004 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-15 15:30:27.004 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [VARCHAR] - [Hatsoff.]
2022-03-15 15:30:27.004 TRACE 9408 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [5]
*/
		
		//studentRepository.insertHardcodedStudentAndCourse();		
/*		
Hibernate: 
		    insert 
		    into
		        KunalStudent
		        (name, passport_id) 
		    values
		        (?, ?)
2022-03-16 18:14:24.772 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [Jack]
2022-03-16 18:14:24.774 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [null]
		
Hibernate: 
		    insert 
		    into
		        KunalCourse
		        (createdDate, lastUpdatedDate, name) 
		    values
		        (?, ?, ?)
2022-03-16 18:14:25.124 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [TIMESTAMP] - [2022-03-16T18:14:25.121952900]
2022-03-16 18:14:25.141 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [TIMESTAMP] - [2022-03-16T18:14:25.121952900]
2022-03-16 18:14:25.142 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [Microservices in 100 Steps]
		
Hibernate: 
		    insert 
		    into
		        KunalStudent_KunalCourse
		        (student_id, course_id) 
		    values
		        (?, ?)
2022-03-16 18:14:25.504 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [20016]
2022-03-16 18:14:25.505 TRACE 7620 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [10004]		
*/	
	
	studentRepository.insertStudentAndCourse(new KunalStudent("ravi"),new KunalCourse("jpa"));
	
/*
Hibernate: 
    insert 
    into
        KunalStudent
        (name, passport_id) 
    values
        (?, ?)
2022-03-16 18:57:38.540 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [ravi]
2022-03-16 18:57:38.542 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [null]

Hibernate: 
    insert 
    into
        KunalCourse
        (createdDate, lastUpdatedDate, name) 
    values
        (?, ?, ?)
2022-03-16 18:57:38.877 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [TIMESTAMP] - [2022-03-16T18:57:38.874818400]
2022-03-16 18:57:38.888 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [TIMESTAMP] - [2022-03-16T18:57:38.874818400]
2022-03-16 18:57:38.889 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [VARCHAR] - [jpa]
Hibernate: 
    insert 
    into
        KunalStudent_KunalCourse
        (student_id, course_id) 
    values
        (?, ?)
2022-03-16 18:57:39.250 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [20017]
2022-03-16 18:57:39.251 TRACE 8792 --- [  restartedMain] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [10005]

*/
	}
	
}
