package com.infosys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out= response.getWriter();
		String fname=request.getParameter("firstname");
		String uname=request.getParameter("username");
		String email=request.getParameter("emailid");
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", fname);
		
		
	    RegisterBean registerbean = new RegisterBean();
	    registerbean.setFirstname(fname);
	    registerbean.setEmailid(email);
	    registerbean.setUsername(uname);
	    registerbean.setPassword(password);
	    
	    RegisterDao registerdao= new RegisterDao();
	    String result= registerdao.registeruser(registerbean);
	    
	   if(result.equals("SUCCESS"))
	    {
		   System.out.println("It's done.");
		   RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
		   rd.forward(request, response);
	    }
	    
	    else
	    {
	    	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
	    	System.out.println("Oops something went wrong, please try again. Check the console");
	    }
	  		
	}	
}


