package com.jpa.hibernate.jpademo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@MappedSuperclass
//@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="employee_type")

public abstract class KunalEmployee {
	
	@Id
	@GeneratedValue

	private int id;
	
	private String name;
	
	public KunalEmployee() {
		
	}
	
	public KunalEmployee(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "\nKunalEmployee [name=" + name + "]";
	}
	
	
}

