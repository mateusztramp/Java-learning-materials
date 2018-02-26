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
		
		Owner owner = new Owner();
		Cat cat = new Cat();
		owner.setFirstName("Jan");
		owner.setLastName("Nowak");
		owner.setCat(cat);
		cat.setName("Bonifacy");
		
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);		
		entityManager.getTransaction().commit();

		
		entityManager.close();
		entityManagerFactory.close();
	}

}