package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UniversityEditDeleteById
 */
@WebServlet("/UniversityEditDeleteById")
public class UniversityEditDeleteById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversityEditDeleteById() {
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
        out.println("<form action='DisplayUniversityById'>");
        out.println("<table>");
        out.println("<caption><b><i>Search University</i></b></caption>");
       
        out.println("<tr>");
        out.println("<td><b><i>University Id:</i></b></td>");
        out.println("<td><input type='text' name='uid'></td>");
        out.println("<td><input type='Submit' value='Search'></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form></html>");
        
	}

}
