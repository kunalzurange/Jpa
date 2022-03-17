package com.jpa.hibernate.jpademo;

import java.math.BigDecimal;

import javax.persistence.Entity;



@Entity

public class KunalFullTimeEmployee extends KunalEmployee{
	protected KunalFullTimeEmployee() {}
	
	public KunalFullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
	
	private BigDecimal salary;
}
