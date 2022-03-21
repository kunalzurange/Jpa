package com.jpa.hibernate.jpademo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity

	public class KunalStudent {
	@Id
	@GeneratedValue

	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
	private KunalAddress address; 
	
	@OneToOne(fetch=FetchType.LAZY)
	private KunalPassport passport ;

	@ManyToMany
	@JoinTable(name="KunalStudent_KunalCourse",
	joinColumns	= @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id"))
	
	private List<KunalCourse> courses = new ArrayList<>();

	
	protected KunalStudent() {

	}

	public KunalStudent(String name) {

		this.name = name;

	}

	public String getName() {
	return name;

	}

	public void setName(String name) {
	this.name = name;

	}

	public KunalAddress getAddress() {
		return address;
	}

	public void setAddress(KunalAddress address) {
		this.address = address;
	}

	public KunalPassport getPassport() {
	return passport;

	}

	public void setPassport(KunalPassport passport) {
	this.passport = passport;

	}
	

	public List<KunalCourse> getCourses() {
		return courses;
	}

	public void addCourses(KunalCourse course) {
		this.courses.add(course);
	}

	public Long getId() {
	return id;

	}
	

	@Override

	public String toString() {
	return String.format("kunal_student[%s]", name);

	}
}





/*
package com.jpa.hibernate.jpademo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class Kunal_Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@OneToOne
	private Kunal_Passport passport;
	
	protected Kunal_Student() {
		
	}
	
	public Kunal_Student(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Kunal_Passport getPassport() {
		return passport;
	}

	public void setPassport(Kunal_Passport passport) {
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Kunal_Student[%s]",name);
	}
	
}
*/