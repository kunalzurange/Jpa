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
}	