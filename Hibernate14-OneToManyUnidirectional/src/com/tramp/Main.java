package com.tramp;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(2344.3);
		phone1.setType("mobile");
		phone2.setType("home");
		phone1.setNumber("345345345");
		phone2.setNumber("456456456");
		List<Phone>phones = new ArrayList<>();
		phones.add(phone1);
		phones.add(phone2);
		employee.setPhones(phones);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(phone1);	
		entityManager.persist(phone2);		
		entityManager.getTransaction().commit();

		
		entityManager.close();
		entityManagerFactory.close();
	}

}