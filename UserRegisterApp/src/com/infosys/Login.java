package com.infosys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello" +request+  "---");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		
		RegisterBean registerbean = new RegisterBean();
		
	    registerbean.setUsername(uname);
	    registerbean.setPassword(password);
	    
	    RegisterDao registerdao= new RegisterDao();
	    String userresult = registerdao.Authentic(registerbean);
	    
	     if(userresult.equals("LOGIN"))
	       {
	    	 System.out.println("Fetching yours records and sucessfully logged in");
	    	 /*RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
	   	     rd.forward(request, response);*/
	    	 response.sendRedirect("sucess.jsp");
	       }	    
	      
	       else
	       {
	   	
	    	System.out.println("Login has been failed. Please try again.");
	    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
	       }
	}

}
