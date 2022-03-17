package com.jpa.hibernate.jpademo;

import java.math.BigDecimal;

import javax.persistence.Entity;



@Entity

public class KunalPartTimeEmployee extends KunalEmployee{
	protected KunalPartTimeEmployee() {}
	
	public KunalPartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	
	private BigDecimal hourlyWage;
}
