package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.StudentManagement;
import com.virtualpairprogrammers.services.TutorManagement;

public class AddStudentToTutorServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1L;

	
	public void doPost (HttpServletRequest request, 
		     HttpServletResponse response) 
		    		 				throws ServletException,IOException
	{
		int studentId = new Integer(request.getParameter("studentId"));
		int tutorId = new Integer(request.getParameter("tutorId"));

		
		TutorManagement serviceTutor = TutorManagement.getService();
		StudentManagement serviceStudent = StudentManagement.getService();
		
		Tutor tutor = serviceTutor.getTutorById(tutorId);
		Student studentToAdd = serviceStudent.getStudentById(studentId);
		tutor.addStudentToSupervisionGroup(studentToAdd);
		
		request.setAttribute("id", studentId);
		
		@SuppressWarnings("unused")
		ServletContext context = getServletContext();
		response.sendRedirect("/myhibernatebasicwebapp/displayStudentDetail.html?id="+studentId);	
		
	}

}
