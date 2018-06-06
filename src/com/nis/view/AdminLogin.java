package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
          
		out.println("<html>");
        out.println("<form action='CheckAdminLogin' method='post'>");
        out.println("<table>");
        out.println("<caption><b><i>Adminstrative Login</i></b></caption>");
       
        out.println("<tr>");
        out.println("<td><b><i>Admin Id:</i></b></td>");
        out.println("<td><input type='text' name='aid'></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td><b><i>Password:</i></b></td>");
        out.println("<td><input type='password' name='pwd'></td>");
        out.println("</tr></table><br><br>");
        out.println("<input type='Submit' value='Sign in'></form></html>");
        
        
        
        
        
	}

}
