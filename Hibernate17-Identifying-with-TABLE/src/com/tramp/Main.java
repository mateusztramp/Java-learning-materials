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
		
		
		Employee employee = new Employee("Jan","Nowak",22224.0);
		Employee employee2 = new Employee("Janok","Nowal",22224.0);
		Employee employee3 = new Employee("Jasiek","Nowik",22224.0);
	
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);	
		entityManager.persist(employee3);		
		entityManager.getTransaction().commit();

		
		entityManager.close();
		entityManagerFactory.close();
	}

}