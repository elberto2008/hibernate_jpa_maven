package com.virtualpairprogrammers.servlets;

import java.io.IOException;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Subject;
import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.SubjectManagement;
import com.virtualpairprogrammers.services.TutorManagement;

public class AddSubjectToTutorServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void doPost (HttpServletRequest request, 
		     HttpServletResponse response) 
		    		 				throws ServletException,IOException
	{
		int subjectId = new Integer(request.getParameter("subjectId"));
		int tutorId = new Integer(request.getParameter("tutorId"));
		
		System.out.println("Subject ID is "+subjectId);
		System.out.println("Tutor ID is "+tutorId);
		
		TutorManagement serviceTutor = TutorManagement.getService();
		SubjectManagement serviceSubject = SubjectManagement.getService();
		
		Tutor tutor = serviceTutor.getTutorById(tutorId);
		Subject subjectToAdd = serviceSubject.getSubjectById(subjectId);
		
		
		tutor.addSubjectToQualifications(subjectToAdd);
		
		
		@SuppressWarnings("unused")
		ServletContext context = getServletContext();
		response.sendRedirect("/myhibernatebasicwebapp/displayTutorDetail.html?id="+tutorId);	
		
	}

}
