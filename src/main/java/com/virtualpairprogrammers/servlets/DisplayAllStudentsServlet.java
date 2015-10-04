package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Student;
import com.virtualpairprogrammers.services.StudentManagement;

public class DisplayAllStudentsServlet extends HttpServlet
{
	
	public void doGet (HttpServletRequest request, 
		     HttpServletResponse response) 
			throws ServletException,IOException
			{
					StudentManagement service = StudentManagement.getService();
					
					List<Student> allStudents = service.getAllStudents();
					Long  totalStudent = service.countStudents();
					
					request.setAttribute("allStudents", allStudents);
					request.setAttribute("totalStudent", totalStudent);
					
					ServletContext context = getServletContext();
					RequestDispatcher dispatch = context.getRequestDispatcher("/displayAllStudents.jsp");
					dispatch.forward(request,response);
			}

}
