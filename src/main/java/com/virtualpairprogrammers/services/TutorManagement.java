package com.virtualpairprogrammers.services;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Subject;
import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.hibernate.HibernateUtil;


/*
 * This is a starting point : it is far from perfect and will be improved
 * on the course videos. See the final code folder for the finished version.
 */
public class TutorManagement
{
	private static TutorManagement reference;

    /**
     * Use this method if you want to share the service across many servlets.
     *
     * This is simulating what a true container such as Spring would provide
     */
    public static TutorManagement getService()
    {
    	if (reference == null)
    		reference = new TutorManagement();
    	return reference;
    }

    public List<Tutor> getAllTutors()
    {
    	EntityManager em  = HibernateUtil.getEntityManager();
    
    	List<Tutor> allTutors = em.createNamedQuery("allTutors").getResultList();

    	
    	return allTutors;
    }

    public long getTotalSalaryBill()
    {
    	// gets the salary bill for the whole college
    	EntityManager em  = HibernateUtil.getEntityManager();

    	
    	Long result = (Long)em.createNamedQuery("totalSalary").getSingleResult();

    	if (result == null) result = 0L;

    	return result;
    }

    public Tutor findTutorByIdWithSupervisionGroup(int id) throws NoResultsFoundException
    {
       	// gets the salary bill for the whole college
    	EntityManager em  = HibernateUtil.getEntityManager();

    	Tutor tutor;
		try
    	{
        	tutor = (Tutor)em.createNamedQuery("tutorByIdWithEagerFetchOfStudents").setParameter("id", id).getSingleResult();
    	}
    	catch (javax.persistence.NoResultException e)
    	{
    		throw new NoResultsFoundException();
    	}


    	return tutor;
    }

    public Tutor lazyFindTutorByIdWithSupervisionGroup(int id) throws NoResultsFoundException
    {
       	// gets the salary bill for the whole college
    	EntityManager em  = HibernateUtil.getEntityManager();

    	Tutor tutor;
		try
    	{
        	tutor = (Tutor)em.createNamedQuery("tutorByIdWithLazyFetchOfStudents").setParameter("id", id).getSingleResult();
    	}
    	catch (javax.persistence.NoResultException e)
    	{
    		throw new NoResultsFoundException();
    	}


    	return tutor;
    }

	public String createNewTutor(String name, int salary)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

    	// generate a Staff Id. This is a very cheap way of doing it but it is a very
    	// long id!
    	String staffId = UUID.randomUUID().toString();

    	Tutor newTutor = new Tutor(staffId, name, salary);
    	em.persist(newTutor);

    	return staffId;
	}

	public Tutor  getTutorById(int tutorId)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();

		return em.find(Tutor.class, tutorId);
	}


	public List<Tutor> getAllTutorsWithNoSubject()
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
    	System.out.println("BEFORE SELECT");
    	List<Tutor> findTutorWithoutSubjects = em.createNamedQuery("findTutorWithoutSubjects").getResultList();
    	System.out.println("AFTER SELECT");

		return findTutorWithoutSubjects;
	}

	public void deleteTutor(int id)
	{
    	EntityManager em  = HibernateUtil.getEntityManager();
    	Tutor tutorToDelete = em.find(Tutor.class, id);
    	
    	for(Subject subject : tutorToDelete.getSubjects())
    	{
    		subject.removeTutor(tutorToDelete);
    	}
    	
    	
    	for(Student student : tutorToDelete.getModifiableSupervisionGroup())
    	{
    		student.setSupervisor(null);
    	}
    	
    	em.remove(tutorToDelete);

	}


}
