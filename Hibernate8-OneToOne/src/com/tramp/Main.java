package com.tramp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		Address address = new Address();
		employee.setFirstName("Janek");
		employee.setLastName("Nowak");
		employee.setSalary(1111.22);
		employee.setAddress(address);
		address.setLocality("Warszawa");
		address.setZipCode("11-333");
		address.setStreet("Koszykowa");
		address.setStreetNr(33);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(address);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
