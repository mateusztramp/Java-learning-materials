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
		
		Student student = new Student();
		student.setFirstName("Jan");
		student.setLastName("Nowak");
		student.setAverageGrade(4.4);
		
		Professor professor = new Professor();
		professor.setFirstName("Marcin");
		professor.setLastName("Nawalka");
		professor.setSalary(3445.32);
	
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.persist(student);	
		entityManager.getTransaction().commit();

		
		entityManager.close();
		entityManagerFactory.close();
	}

}