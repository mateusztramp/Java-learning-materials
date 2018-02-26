package com.tramp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();

		employee.setFirstName("Janek");
		employee.setLastName("Nowak");
		employee.setSalary(3333.3);
		
		Employee employee2 = new Employee();

		employee2.setFirstName("Arek");
		employee2.setLastName("Janik");
		employee2.setSalary(3333.3);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
