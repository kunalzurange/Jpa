package com.jpa.hibernate.jpademo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
	
		@NamedQuery(name="qurey_get_all_courses",
				query="Select c from KunalCourse c")
		@NamedQuery(name="qurey_get_100_step_courses",
				query="Select c from KunalCourse c where name like'%ajit'")

@Cacheable
@SQLDelete(sql="update KunalCourse set is_deleted=true where id=?")
@Where(clause="is_deleted = false")

public class KunalCourse {

	private static Logger logger = LoggerFactory.getLogger(KunalCourse.class);
	
	@Id
	@GeneratedValue
	private Long id; 

	//@Column(nullable=false)
	private String name;

	@OneToMany(mappedBy="course")
	private List<KunalReview> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<KunalStudent> students = new ArrayList<>();

	
	@UpdateTimestamp 
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

	private boolean isDeleted;
	
	@PreRemove
	private void preRemove() {
		this.isDeleted = true;
	}
	//public String setName;
	
	protected KunalCourse() {
		
	}
	
	public KunalCourse(String name) {
		logger.info("Setting is Deleted to True");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<KunalReview> getReviews() {
		return reviews;
	}

	public void addReviews(KunalReview review) {
		this.reviews.add(review);
	}


	public void removeReviews(KunalReview review) {
		this.reviews.remove(review);
	}
	
	
	public List<KunalStudent> getStudents() {
		return students;
	}

	public void addStudent(KunalStudent student) {
		this.students.add(student);
	}

	public Long getId() {
		return id;
	
	}
		@Override
		public String toString() {
			return String.format("KunalCourse[%s]", name);
	}

	
}
