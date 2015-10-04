package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.services.SubjectManagement;

public class DeleteSubjectServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void doPost (HttpServletRequest request, 
		     HttpServletResponse response) 
		    		 				throws ServletException,IOException
	{
		
		SubjectManagement service = SubjectManagement.getService();
		
		int  id = new Integer(request.getParameter("id"));
		
		service.deleteSubject(id);
		
		@SuppressWarnings("unused")
		ServletContext context = getServletContext();
		response.sendRedirect("/myhibernatebasicwebapp/displayAllSubjects.html");
	}
}