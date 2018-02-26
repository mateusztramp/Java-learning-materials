package com.tramp;

import javax.persistence.Query;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		addEmployees();
		
		TypedQuery<Employee> tQuery = entityManager.createQuery("select e from Employee e where e.salary > :minSalary", Employee.class);
		tQuery.setParameter("minSalary", 3000.0); //it can be list!
		tQuery.getResultList().forEach(e -> System.out.println(e.getFirstName() + e.getLastName() + e.getSalary()));
		
		TypedQuery<Employee> tQuery2 = entityManager.createQuery("select e from Employee e where e.salary > ?1 and e.salary < ?2", Employee.class);
		tQuery2.setParameter(1, 2000);
		tQuery2.setParameter(2, 2000);
	
				
		
		
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
	private static void addEmployees() {
		addEmployee("Karol", "Mateusiak", 2633);
		addEmployee("Marika", "Bednarek", 2345);
		addEmployee("Jan", "Mateusiak", 7346);
		addEmployee("Daria", "Kowalska", 2352);
		addEmployee("Monika", "Uciñska", 4263);
		addEmployee("Ernest", "Paj¹k", 2634);
		addEmployee("Kamil", "Stêpieñ", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "WoŸniak", 3324);
		addEmployee("Agnieszka", "Nowak", 2000);
		addEmployee("Angelika", "Bednarska", 1000);
	}
	
}
