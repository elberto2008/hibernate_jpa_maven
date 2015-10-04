package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.StudentManagement;
import com.virtualpairprogrammers.services.TutorManagement;

public class DisplayAllTutorsToSelectServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		
		int id = new Integer(request.getParameter("id"));
		
		@SuppressWarnings("unused")
		StudentManagement serviceStudent = StudentManagement.getService();
		TutorManagement service = TutorManagement.getService();	

		List<Tutor> allTutors = service.getAllTutors();
		
		
		
		
		request.setAttribute("studentID", id);
		request.setAttribute("allTutors", allTutors);

		
		// forward to the displayAllBooks.jsp page to display the results
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllTutorsToSelectFrom.jsp");
		dispatch.forward(request,response);
	}

}
