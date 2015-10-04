package com.virtualpairprogrammers.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.services.SubjectManagement;

public class AddNewSubjectServlet extends HttpServlet
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
				
				String name = request.getParameter("name");
				int numberOfSemesters = new Integer(request.getParameter("numberOfSemesters"));
			
				service.addNewSubject(name, numberOfSemesters);
				request.setAttribute("name", name);
				// Forward to a JSP page to inform the user all is well
				
				ServletContext context = getServletContext();
				RequestDispatcher dispatch = context.getRequestDispatcher("/subjectAdded.jsp");
				dispatch.forward(request,response);			
			}

}
