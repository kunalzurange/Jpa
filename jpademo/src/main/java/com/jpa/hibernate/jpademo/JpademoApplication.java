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
	

		List<KunalReview> reviews=new ArrayList<>();
		reviews.add(new KunalReview("5" , "Great Hands-on Stuff."));	//add 2 reviews to it
		reviews.add(new KunalReview("5" , "Hatsoff."));				
		courseRepository.addReviewsForCourse(10003L,reviews);
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
		
		
	}

}
