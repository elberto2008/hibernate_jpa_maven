package com.virtualpairprogrammers.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.services.StudentManagement;

public class AddNewStudentServlet extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void doPost (HttpServletRequest request, 
		     HttpServletResponse response) 
		    		 				throws ServletException,IOException
	{
		
		StudentManagement service = StudentManagement.getService();
		
		String name = request.getParameter("name");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		
		
		String enrollementID = service.addNewStudent(name, street, city, zip);
		request.setAttribute("enrollementID", enrollementID);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/studentAdded.jsp");
		dispatch.forward(request,response);			
	}

}
