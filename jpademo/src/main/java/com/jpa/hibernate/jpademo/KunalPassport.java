package com.jpa.hibernate.jpademo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class KunalPassport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY , mappedBy="passport")
	private KunalStudent student ;
	
		protected KunalPassport() {
		
	}
	
	public KunalPassport(String number) {
		
		this.number = number; 
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public KunalStudent getStudent() {
		return student;
	}

	public void setStudent(KunalStudent student) {
		this.student = student;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("kunal_passport[%s]",number);
	}
	
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
	@Autowired
	EntityManager em;
	
	public tanjila_Student findById(Long id) {
		return em.find(tanjila_Student.class, id);
		}
	
	public tanjila_Student save(tanjila_Student student) {
		if(student.getId()==null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
	
	public void SaveStudentWithPassport() {
		tanjila_Passport passport = new tanjila_Passport("S876123");
		em.persist(passport);
		
	    tanjila_Student student1 = new tanjila_Student("Shreya"); //insert first and then update it
	   
	    student1.setPassport(passport);
	    em.persist(student1);
	}
	
//	public void deleteById(Long id) {
//		tanjila_Student student = findById(1003L);
//		em.remove(student);
//		}
}

*/




