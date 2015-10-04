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

public class DisplayStudentsWithNoTutorsServlet extends HttpServlet
{

	public void doGet (HttpServletRequest request, 
		     HttpServletResponse response) 
			throws ServletException,IOException
			{
					StudentManagement service = StudentManagement.getService();
					
					List<Student> studentsWithNoTutors = service.getAllStudentsWithNoTutors();
					request.setAttribute("allStudents", studentsWithNoTutors);
					request.setAttribute("totalStudent",studentsWithNoTutors.size() );
					ServletContext context = getServletContext();
					RequestDispatcher dispatch = context.getRequestDispatcher("/displayStudentWithNoTutor.jsp");
					dispatch.forward(request,response);
			}

}
