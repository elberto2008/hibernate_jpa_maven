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
import com.virtualpairprogrammers.services.TutorManagement;

public class DisplayTutorsWithNoSubjectsServlet extends HttpServlet
{

	private static final long	serialVersionUID	= 1L;

	public void doGet (HttpServletRequest request, 
		     HttpServletResponse response) 
			throws ServletException,IOException
			{
					TutorManagement service = TutorManagement.getService();
					
					List<Tutor> tutorsWithNoSubject = service.getAllTutorsWithNoSubject();
					request.setAttribute("allTutors", tutorsWithNoSubject);
					request.setAttribute("totalTutors",tutorsWithNoSubject.size() );
					ServletContext context = getServletContext();
					RequestDispatcher dispatch = context.getRequestDispatcher("/displayTutorWithNoSubject.jsp");
					dispatch.forward(request,response);
			}

}
