package com.jspiders.hibaernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibaernatemanytomany.dto.CustomerDTO;
import com.jspiders.hibaernatemanytomany.dto.ProductDTO;

public class CustomerProductDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("ManyToOne");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	public static void main(String[] args) {
		
		try {
			
			openConnection();
			
			transaction.begin();
			
			CustomerDTO customer1=new CustomerDTO();
			customer1.setId(1);
			customer1.setName("Shubham");
			customer1.setContact(9898989898l);
			customer1.setCity("Banglore");
			manager.persist(customer1);
			
			CustomerDTO customer2=new CustomerDTO();
			customer2.setId(2);
			customer2.setName("Mukesh");
			customer2.setContact(9191919191l);
			customer2.setCity("Pune");
			manager.persist(customer2);
			
			CustomerDTO customer3=new CustomerDTO();
			customer3.setId(3);
			customer3.setName("Mahesh");
			customer3.setContact(9292929292l);
			customer3.setCity("Pune");
			manager.persist(customer3);
			
			List<CustomerDTO> customers1 = Arrays.asList(customer1,customer3);
			
			ProductDTO product1=new ProductDTO();
			product1.setId(1);
			product1.setName("T-Shirt");
			product1.setCategory("Clothing");
			product1.setPrice(1500);
			product1.setCustomers(customers1);
			manager.persist(product1);
			
			List<CustomerDTO> customers2 = Arrays.asList(customer1,customer2);
			
			ProductDTO product2=new ProductDTO();
			product2.setId(2);
			product2.setName("Perfume");
			product2.setCategory("Grooming");
			product2.setPrice(2500);
			product2.setCustomers(customers2);
			manager.persist(product2);
			
			List<CustomerDTO> customers3 = Arrays.asList(customer2,customer3);
			
			ProductDTO product3=new ProductDTO();
			product3.setId(3);
			product3.setName("AC");
			product3.setCategory("Electronics");
			product3.setPrice(25000);
			product3.setCustomers(customers3);
			manager.persist(product3);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
