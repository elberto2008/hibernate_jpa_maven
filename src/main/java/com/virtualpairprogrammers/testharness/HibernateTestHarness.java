package com.virtualpairprogrammers.testharness;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.virtualpairprogrammers.domain.Address;
import com.virtualpairprogrammers.domain.Student;

public class HibernateTestHarness 
{
	public static void main(String[] args)
	{		
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction tx = em.getTransaction();
	 
	 tx.begin();
	 

	 
	 
	 Student st = em.find(Student.class, 1);
	 
	 st.setAddress(new Address("400 S Lafayette St Apt 702","Denver,CO","80210"));
	 
	 System.out.println(st);
	 
	 tx.commit();
	 em.close();


	}

}
