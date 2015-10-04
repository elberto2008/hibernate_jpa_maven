package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.domain.Tutor;
import com.virtualpairprogrammers.services.NoResultsFoundException;
import com.virtualpairprogrammers.services.StudentManagement;
import com.virtualpairprogrammers.services.TutorManagement;

public class DisplayStudentDetailsServlet extends HttpServlet
{
	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException,IOException
	{
		
		StudentManagement service = StudentManagement.getService();	
		
		int id = new Integer(request.getParameter("id"));
		
		System.out.println("I RECEIVED STUDENT ID : "+id);
				
		String resultsPage;
		

		try 
		{

			
			Student student = service.lazyFindStudentByIdWithSupervisionGroup(id);
			
			
			request.setAttribute("student", student);
			resultsPage = "/displayStudentDetail.jsp";
		} 
		catch (NoResultsFoundException e) 
		{
			resultsPage = "/noResultsFound.jsp";
		}
		
		// forward to the displayAllBooks.jsp page to display the results
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher(resultsPage);
		dispatch.forward(request,response);
	}

}
