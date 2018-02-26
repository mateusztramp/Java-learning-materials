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
		
		TypedQuery<Employee> typedQuery = entityManager.createQuery("select e form Employee e where e.lastName = 'Paj¹k'", Employee.class);
		typedQuery.getSingleResult();
		
		Query query = entityManager.createQuery("select concat(e.firstName,' ', e.lastName), e.salary * 0,2 from Employee e");
		Iterator<?>iterator = query.getResultList().iterator();
		while(iterator.hasNext()) {
			Object[]item = (Object[])iterator.next();
			String name = (String)item[0];
			double tax = (double) item[1];
			System.out.println(name + " has to pay " + tax);
		}
		
		
		
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
