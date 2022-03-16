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
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	//@Transactional
	
	public void someTest() {
		repository.someOperationToUnderstandPersistanceContext();
	
/*Hibernate: 
		    insert 
		    into
		        KunalPassport
		        (number) 
		    values
		        (?)
2022-03-14 12:53:29.932 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [Z123456]
		
Hibernate: 
		    insert 
		    into
		        KunalStudent
		        (name, passport_id) 
		    values
		        (?, ?)
2022-03-14 12:53:30.132 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [Mike]
2022-03-14 12:53:30.134 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [40006]

Hibernate: 
		    select
		        kunalstude0_.id as id1_2_0_,
		        kunalstude0_.name as name2_2_0_,
		        kunalstude0_.passport_id as passport3_2_0_ 
		    from
		        KunalStudent kunalstude0_ 
		    where
		        kunalstude0_.id=?
2022-03-14 12:53:32.006 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [20001]
2022-03-14 12:53:32.206 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name2_2_0_] : [VARCHAR]) - [ranga]
2022-03-14 12:53:32.207 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([passport3_2_0_] : [BIGINT]) - [40001]

Hibernate: 
		    select
		        kunalpassp0_.id as id1_1_0_,
		        kunalpassp0_.number as number2_1_0_ 
		    from
		        KunalPassport kunalpassp0_ 
		    where
		        kunalpassp0_.id=?
		2022-03-14 12:53:32.231 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [40001]
		2022-03-14 12:53:32.411 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([number2_1_0_] : [VARCHAR]) - [e123456]

Hibernate: 
		    update
		        KunalStudent 
		    set
		        name=?,
		        passport_id=? 
		    where
		        id=?
2022-03-14 12:53:32.454 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [ranga-updated]
2022-03-14 12:53:32.454 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [40001]
2022-03-14 12:53:32.455 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [3] as [BIGINT] - [20001]

Hibernate: 
		    update
		        KunalPassport 
		    set
		        number=? 
		    where
		        id=?
2022-03-14 12:53:32.639 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [e123457]
2022-03-14 12:53:32.640 TRACE 5936 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [40001]
2022-03-14 12:53:33.241 TRACE 5936 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Handling #sessionFactoryClosed from [org.hibernate.internal.SessionFactoryImpl@410382cb] for TypeConfiguration
2022-03-14 12:53:33.243 DEBUG 5936 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Un-scoping TypeConfiguration [org.hibernate.type.spi.TypeConfiguration$Scope@1a84a3c] from SessionFactory [org.hibernate.internal.SessionFactoryImpl@410382cb]
*/
	
	}

		
	
	@Test
	@Transactional
	
	public void retriveStudentAndPassportDetails() {
		KunalStudent student = em.find(KunalStudent.class,20001L);
		logger.info("KunalStudent -> {}", student);
		logger.info("KunalPassport -> {}", student.getPassport());
		
/*Hibernate: 
    insert 
    into
        KunalPassport
        (number) 
    values
        (?)
2022-03-11 18:37:22.308 TRACE 12340 --- [main] o.h.type.descriptor.sql.BasicBinder: binding parameter [1] as [VARCHAR] - [Z123456]
Hibernate: 
    insert 
    into
        KunalStudent
        (name, passport_id) 
    values
        (?, ?)
2022-03-11 18:37:22.500 TRACE 12340 --- [main] o.h.type.descriptor.sql.BasicBinder: binding parameter [1] as [VARCHAR] - [Mike]
2022-03-11 18:37:22.503 TRACE 12340 --- [main] o.h.type.descriptor.sql.BasicBinder: binding parameter [2] as [BIGINT] - [40004]
Hibernate: 
    select
        kunalstude0_.id as id1_2_0_,
        kunalstude0_.name as name2_2_0_,
        kunalstude0_.passport_id as passport3_2_0_,
        kunalpassp1_.id as id1_1_1_,
        kunalpassp1_.number as number2_1_1_ 
    from
        KunalStudent kunalstude0_ 
    left outer join
        KunalPassport kunalpassp1_ 
            on kunalstude0_.passport_id=kunalpassp1_.id 
    where
        kunalstude0_.id=?
2022-03-11 18:37:23.977 TRACE 12340 --- [main] o.h.type.descriptor.sql.BasicBinder: binding parameter [1] as [BIGINT] - [20001]*/
	}
	
	@Test
	@Transactional
	
	public void retrivePassportAndAssociatedStudent() {
		KunalPassport passport = em.find(KunalPassport.class,40001L);
		logger.info("KunalPassport -> {}", passport);
		logger.info("KunalStudent -> {}", passport.getStudent());
	
/*		
Hibernate: 
		    select
		        kunalpassp0_.id as id1_1_0_,
		        kunalpassp0_.number as number2_1_0_ 
		    from
		        KunalPassport kunalpassp0_ 
		    where
		        kunalpassp0_.id=?
2022-03-14 16:00:50.020 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [40001]
2022-03-14 16:00:50.354 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([number2_1_0_] : [VARCHAR]) - [e123457]
Hibernate: 
		    select
		        kunalstude0_.id as id1_2_0_,
		        kunalstude0_.name as name2_2_0_,
		        kunalstude0_.passport_id as passport3_2_0_ 
		    from
		        KunalStudent kunalstude0_ 
		    where
		        kunalstude0_.passport_id=?
2022-03-14 16:00:50.371 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [40001]
2022-03-14 16:00:50.688 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_2_0_] : [BIGINT]) - [20001]
2022-03-14 16:00:50.689 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name2_2_0_] : [VARCHAR]) - [ranga-updated]
2022-03-14 16:00:50.689 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([passport3_2_0_] : [BIGINT]) - [40001]
2022-03-14 16:00:50.689 TRACE 12280 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([passport4_2_0_] : [BIGINT]) - [e123457]
2022-03-14 16:00:51.398 TRACE 12280 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Handling #sessionFactoryClosed from [org.hibernate.internal.SessionFactoryImpl@14590fe2] for TypeConfiguration
2022-03-14 16:00:51.400 DEBUG 12280 --- [ionShutdownHook] o.h.type.spi.TypeConfiguration$Scope     : Un-scoping TypeConfiguration [org.hibernate.type.spi.TypeConfiguration$Scope@68dae5df] from SessionFactory [org.hibernate.internal.SessionFactoryImpl@14590fe2]
*/
	
	}
	
	@Test
	@Transactional
	public void retriveStudentAndCourses() {
		KunalStudent student = em.find(KunalStudent.class,20001L);
		//System.out.printf("student -> {}" + student);
		//System.out.printf("courses -> {}" + student.getCourses());
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
/*
  Hibernate: 

		   select
		        kunalstude0_.id as id1_3_0_,
		        kunalstude0_.name as name2_3_0_,
		        kunalstude0_.passport_id as passport3_3_0_ 
		    from
		        KunalStudent kunalstude0_ 
		    where
		        kunalstude0_.id=?
2022-03-16 16:45:06.350 TRACE 424 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [20001]
2022-03-16 16:45:06.676 TRACE 424 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name2_3_0_] : [VARCHAR]) - [ranga-updated]
2022-03-16 16:45:06.677 TRACE 424 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([passport3_3_0_] : [BIGINT]) - [40001]
2022-03-16 16:45:06.716 TRACE 424 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalStudent.courses#20001]		
*/	
	}
	
	@Test
	@Transactional
	public void retriveCourseAndStudents() {
		KunalCourse course = em.find(KunalCourse.class,10003L);
		System.out.printf("course -> {}" + course);
		System.out.printf("students -> {}" + course.getStudents());
		//logger.info("course -> {}", course);
		//logger.info("students -> {}", course.getStudents());

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
2022-03-16 17:33:59.074 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-16 17:33:59.402 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([createdd2_0_0_] : [TIMESTAMP]) - [2022-03-15T12:42:14]
2022-03-16 17:33:59.403 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([lastupda3_0_0_] : [TIMESTAMP]) - [2022-03-15T12:42:14]
2022-03-16 17:33:59.405 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name4_0_0_] : [VARCHAR]) - [spring boot in 100 steps]
2022-03-16 17:33:59.433 TRACE 6016 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalCourse.reviews#10003]
2022-03-16 17:33:59.433 TRACE 6016 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalCourse.students#10003]
		course -> {}KunalCourse[spring boot in 100 steps]Hibernate: 
		    select
		        students0_.course_id as course_i2_4_0_,
		        students0_.student_id as student_1_4_0_,
		        kunalstude1_.id as id1_3_1_,
		        kunalstude1_.name as name2_3_1_,
		        kunalstude1_.passport_id as passport3_3_1_ 
		    from
		        KunalStudent_KunalCourse students0_ 
		    inner join
		        KunalStudent kunalstude1_ 
		            on students0_.student_id=kunalstude1_.id 
		    where
		        students0_.course_id=?
2022-03-16 17:33:59.444 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [10003]
2022-03-16 17:33:59.754 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([id1_3_1_] : [BIGINT]) - [20001]
2022-03-16 17:33:59.755 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([name2_3_1_] : [VARCHAR]) - [ranga-updated]
2022-03-16 17:33:59.755 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([passport3_3_1_] : [BIGINT]) - [40001]
2022-03-16 17:33:59.755 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([course_i2_4_0_] : [BIGINT]) - [10003]
2022-03-16 17:33:59.756 TRACE 6016 --- [           main] o.h.type.descriptor.sql.BasicExtractor   : extracted value ([student_1_4_0_] : [BIGINT]) - [20001]
2022-03-16 17:33:59.756 TRACE 6016 --- [           main] org.hibernate.type.CollectionType        : Created collection wrapper: [com.jpa.hibernate.jpademo.KunalStudent.courses#20001]
*/	
	}	
}	