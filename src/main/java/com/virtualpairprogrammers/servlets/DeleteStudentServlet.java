package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.services.StudentManagement;

public class DeleteStudentServlet extends HttpServlet
{
	public void doPost (HttpServletRequest request, 
		     HttpServletResponse response) 
		    		 				throws ServletException,IOException
	{
		
		StudentManagement service = StudentManagement.getService();
		
		int  id = new Integer(request.getParameter("id"));
		
		service.deleteStudent(id);
		
		ServletContext context = getServletContext();
		response.sendRedirect("/myhibernatebasicwebapp/displayAllStudents.html");
		
	}

}
