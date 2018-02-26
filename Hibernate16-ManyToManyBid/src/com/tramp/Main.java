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
		
		Project project1 = new Project();
		project1.setName("proj1");
		Project project2 = new Project();
		project1.setName("proj2");
		
		Employee employee = new Employee("Jan","Nowak",22224.0);
		Employee employee2 = new Employee("Janok","Nowal",22224.0);
		Employee employee3 = new Employee("Jasiek","Nowik",22224.0);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(employee);
		empList.add(employee2);
		empList.add(employee3);
		List<Employee> empList2 = new ArrayList<>();
		empList2.add(employee2);
		empList2.add(employee3);
		
		project1.setEmployees(empList1);
		project2.setEmployees(empList2);
		
		
		
		
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(phone1);	
		entityManager.persist(phone2);		
		entityManager.getTransaction().commit();

		
		entityManager.close();
		entityManagerFactory.close();
	}

}