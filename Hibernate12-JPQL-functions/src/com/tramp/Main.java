package com.tramp;

import javax.persistence.Query;

import java.util.ArrayList;
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

		Query query = entityManager.createQuery(
				"select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Employee e");

		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Average: " + result[0]);
		System.out.println("Minimal value: " + result[1]);
		System.out.println("Maximum value: " + result[2]);
		System.out.println("Sum of all: " + result[3]);
		System.out.println("All Counted: " + result[4]);

		Query query2 = entityManager.createQuery(
				"select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.lastName), length(e.firstName) from Employee e");

		Object [] result2 = (Object []) query.getSingleResult();
		//sout sout sout
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
		addEmployee("Monika", "Uci�ska", 4263);
		addEmployee("Ernest", "Paj�k", 2634);
		addEmployee("Kamil", "St�pie�", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "Wo�niak", 3324);
		addEmployee("Agnieszka", "Nowak", 2000);
		addEmployee("Angelika", "Bednarska", 1000);
	}

}
