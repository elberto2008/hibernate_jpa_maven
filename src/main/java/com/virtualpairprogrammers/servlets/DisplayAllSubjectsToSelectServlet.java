package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Subject;

import com.virtualpairprogrammers.services.SubjectManagement;
import com.virtualpairprogrammers.services.TutorManagement;

public class DisplayAllSubjectsToSelectServlet extends HttpServlet
{
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		
		int id = new Integer(request.getParameter("id"));
		
		SubjectManagement serviceSubject = SubjectManagement.getService();
		TutorManagement service = TutorManagement.getService();	

		List<Subject> allSubjects = serviceSubject.getAllSubject();
		
		
		
		
		request.setAttribute("tutorID", id);
		request.setAttribute("allSubjects", allSubjects);

		
		// forward to the displayAllBooks.jsp page to display the results
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllSubjectsToSelectFrom.jsp");
		dispatch.forward(request,response);
	}

}
