package com.jpa.hibernate.jpademo;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class StudentRepository {
	
	public void someOperationToUnderstandPersistanceContext() {

		//Operation-1 to retrieve student
		KunalStudent student = em.find(KunalStudent.class,20001L);   //P.C(KunalStudent)
	
		//Operation-2 to retrieve passport
		KunalPassport passport = student.getPassport();		//P.C(KunalStudent & KunalPassport)
		
		//Operation-3 to update passport
		passport.setNumber("e123457");						//P.C(KunalStudent & KunalPassport++)
		
		//Operation-4 to update student
		student.setName("ranga-updated");					//P.C(KunalStudent++ & KunalPassport++)

	}
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	public KunalStudent findById(Long id) {
		return em.find(KunalStudent.class, id);
		}
	
	public KunalStudent save(KunalStudent student) {
		if(student.getId()==null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
	
	public void SaveStudentWithPassport() {
		KunalPassport passport = new KunalPassport("Z123456");
		em.persist(passport);
		
	    KunalStudent student1 = new KunalStudent("Mike"); //insert first and then update it
	   
	    student1.setPassport(passport);
	    em.persist(student1);
	}
	
//	public void deleteById(Long id) {
//		Kunal_Student student = findById(1003L);
//		em.remove(student);
//		}
}















/*
package com.jpa.hibernate.jpademo;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//private static final String Long = null;
	@Autowired
	EntityManager em;
	
	public Kunal_Student findById(Long id) {
		return em.find(Kunal_Student.class, id);
	}
	
	/*public void deletebyId(Long id) {
		Kunal_Student student = findById(id);
		em.remove(student);

	}*/
	
	/*
	 * public Kunal_Student save(Kunal_Student student){
	 
		
		if(student.getId()==null) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
		
	}
	
	public void saveStudentWithPassport() {	
		//System.out.println("play with Entity Manager - start");
		Kunal_Passport passport = new Kunal_Passport("Z123456");
		em.persist(passport);
		
		Kunal_Student student1 = new Kunal_Student("mike");
		
		student1.setPassport(passport);
		em.persist(student1);
		//em.flush();
		
		//Kunal_Student student2 = findById(10001L);
		//student2.setName=("kunal");
		//Kunal_Student student2 = new Kunal_Student("chetan");
		//em.persist(student2);
		
		//em.flush();
		 
		//em.clear();
		//em.detach(student1);
		//em.detach(student2);
		
		//student1.setName("arjun - updated");
		//em.flush();
		
		//System.out.println("playWithEntityManager - start");
		//logger.info("playWithEntityManager - start");
		
		//Kunal_Student student2 = new Kunal_Student("chetan");
		//em.persist(student2);
		//em.flush();					/* changes which have done they will be sent out of the database.*/

		//em.detach(student2);        // changes to student2 are no longer tracked by em i.e. student2.setname
									  //will not be executed
		
		//student2.setName("chetan - updated");
		
		//em.refresh(student1);
		
		//em.flush();
		
//		}
//}

