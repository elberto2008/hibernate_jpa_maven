package com.virtualpairprogrammers.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Subject;

import com.virtualpairprogrammers.services.SubjectManagement;

public class DisplaySubjectDetailsServlet extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		
	SubjectManagement service = SubjectManagement.getService();	
		
		int id = new Integer(request.getParameter("id"));
		
		System.out.println("I RECEIVED SUBJECT ID : "+id);
				
		String resultsPage;
		

	
			
			Subject subject = service.getSubjectById(id);
			
			
			request.setAttribute("subject", subject);
			resultsPage = "/displaySubjectDetails.jsp";
	
		
		// forward to the displayAllBooks.jsp page to display the results
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher(resultsPage);
		dispatch.forward(request,response);
	}

}
