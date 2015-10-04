package com.virtualpairprogrammers.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.virtualpairprogrammers.domain.Subject;
import com.virtualpairprogrammers.hibernate.HibernateUtil;

public class SubjectManagement
{
	
	private static SubjectManagement reference;

  
    public static SubjectManagement getService()
    {
    	if (reference == null)
    		reference = new SubjectManagement();
    	return reference;
    }

    public List<Subject> getAllSubject()
    {
    	EntityManager em  = HibernateUtil.getEntityManager();
    
    	List<Subject> allSubjects = em.createNamedQuery("allSubjects").getResultList();

    	
    	return allSubjects;
    }
    
    public void addNewSubject(String name, int numberOfSemesters)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

    	Subject subject = new Subject(name,numberOfSemesters);
    	
    	em.persist(subject);
    	
	}

	public void deleteSubject(int id)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
    	Subject subjectToDelete= em.find(Subject.class, id);
    	em.remove(subjectToDelete);
    	
    	//em.createNamedQuery("deleteSubjectById").setParameter("id", id).executeUpdate();
	}

	public Subject getSubjectById(int id)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

		return em.find(Subject.class, id);
	}

   
   
   


}
