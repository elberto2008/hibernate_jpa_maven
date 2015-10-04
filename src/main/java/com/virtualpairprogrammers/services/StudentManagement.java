package com.virtualpairprogrammers.services;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Subject;
import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.hibernate.HibernateUtil;

public class StudentManagement
{
	
	private static StudentManagement reference;

	  
    public static StudentManagement getService()
    {
    	if (reference == null)
    		reference = new StudentManagement();
    	return reference;
    }

    public List<Student> getAllStudents()
    {
    	EntityManager em  = HibernateUtil.getEntityManager();
    
    	List<Student> allStudents = em.createNamedQuery("allStudents").getResultList();

    	
    	return allStudents;
    }

	public Student lazyFindStudentByIdWithSupervisionGroup(int id) throws NoResultsFoundException
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
    	return (Student) em.createNamedQuery("studentByIdWithLazyFetchOfStudents").setParameter("id", id).getSingleResult();
		
	}
	
	public String addNewStudent(String name,String street,String city,String zip)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

    	String enrollmentID = UUID.randomUUID().toString();
    	
    	Student student = new Student(enrollmentID, name, street, city, zip);

    	em.persist(student);
    	
    	return enrollmentID;
    	

	}

	public List<Student> getAllStudentsWithNoTutors()
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
    	
    	return em.createNamedQuery("studentsWithNoTutor").getResultList();
	}

	public Long countStudents()
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

		return em.createNamedQuery("countStudents",Long.class).getSingleResult();
		
		
	}

	public Student getStudentById(int id)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
		return em.find(Student.class, id);
	}

	public void deleteStudent(int id)
	{
		
    	EntityManager em  = HibernateUtil.getEntityManager();
    	em.createNamedQuery("deleteStudentById").setParameter("id", id).executeUpdate();
		
	}


}
