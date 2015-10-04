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

public class DisplayAllSubjectsServlet extends HttpServlet
{
	public void doGet (HttpServletRequest request, 
		     HttpServletResponse response) 
			throws ServletException,IOException
			{
					SubjectManagement service = SubjectManagement.getService();
					
					List<Subject> allSubjects = service.getAllSubject();
					request.setAttribute("allSubjects", allSubjects);
					ServletContext context = getServletContext();
					RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllSubjects.jsp");
					dispatch.forward(request,response);
			}

}
