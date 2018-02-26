package com.tramp;

import java.math.BigDecimal;

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
		employee.setBonusSalary(new BigDecimal("23443.2"));
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}

}
