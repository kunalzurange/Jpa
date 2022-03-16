package com.jpa.hibernate.jpademo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
	public class KunalReview {
	@Id
	@GeneratedValue

	private Long id;

	private String rating;

	private String description;

	@ManyToOne

	private KunalCourse course;

	protected KunalReview() {
	}

	public KunalReview(String rating,String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	
	public KunalCourse getCourse() {
		return course;
	}

	public void setCourse(KunalCourse course) {
		this.course = course;
	}

	public Long getId() {
	return id;
	}

	public String getRating() {
	return rating;
	}

	public void setRating(String rating) {
	this.rating = rating;
	}

	@Override
	public String toString() {
	return String.format("KunalReview[%s %s]", rating, description);
	}
}










/*package com.jpa.hibernate.jpademo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="KunalReview")

public class KunalReview {

	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	
	private String description;
	
	@ManyToOne
	private KunalCourse course;
	
	protected KunalReview() {
		
	}
	
	public KunalReview(String rating , String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public KunalCourse getCourse() {
		return course;
	}

	public void setCourse(KunalCourse course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("KunalReview[%s %s]",rating,description);
	}
	
}
*/