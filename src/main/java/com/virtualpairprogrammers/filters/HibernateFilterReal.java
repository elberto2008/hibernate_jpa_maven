package com.virtualpairprogrammers.filters;

import java.io.IOException;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.virtualpairprogrammers.hibernate.HibernateUtil;

public class HibernateFilterReal implements Filter
{


	public void destroy()
	{
		HibernateUtil.getEntityManagerFactory().close();
	}

	
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain) throws IOException, ServletException
	{
		EntityManager em = null;
		EntityTransaction tx=null;
		try
		{
		System.out.println("Filter started");

		em = HibernateUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("I have my entity");

		HibernateUtil.setEmtityManager(em);
		

		tx = em.getTransaction();
		tx.begin();
			chain.doFilter(request, reponse);
			
		tx.commit();

		}
		catch(Exception e)
		{
		
			if (tx !=null)
				tx.rollback();
			System.out.println("Caught exception! "+e);
			System.out.println(e.getCause().toString());
			System.out.println(e.getStackTrace());


			
		}
		finally
		{
			if (em != null)
				em.close();
//			HibernateUtil.setEmtityManager(null);

		}
		
		
		System.out.println("Filter stopped");


	}

	public void init(FilterConfig arg0) throws ServletException
	{

	}

}
