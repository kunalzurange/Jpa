package com.jpa.hibernate.jpademo;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	EntityManager em;
	
	public void insert (KunalEmployee employee) {
		em.persist(employee);										//insert employee
	}
	
	
	public List<KunalPartTimeEmployee> retrieveAllPartTimeEmployees() {
		return em.createQuery("select e from KunalPartTimeEmployee e", KunalPartTimeEmployee.class)
					.getResultList();                                //retrieve all employees
	}
	

	public List<KunalFullTimeEmployee> retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from KunalFullTimeEmployee e", KunalFullTimeEmployee.class)
					.getResultList();                                //retrieve all employees
	}
}
