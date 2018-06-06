package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BranchView
 */
@WebServlet("/BranchView")
public class BranchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/universitybranch.js></script>");
		
		out.println("<html>");
		out.println("<form action='BranchSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><i>Branch Register</i></b></caption>");
		
		out.println("<tr>");
		out.println("<td><b><i>University Name:</i></b></td>");
		out.println("<td><select name='uid' id='uid'><option>-University-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branch Name:</i></b></td>");
		out.println("<td><input type='text' name='branchname'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semester:</i></b></td>");
		out.println("<td><input type='text' name='semester'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branch Icon:</i></b></td>");
		out.println("<td><input type='file' name='branchicon'></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<br><br><input type='Submit'>&nbsp;&nbsp;&nbsp;<input type='reset'>");
		out.println("</form>");
		out.println("<html>");
		out.flush();
		
	}

}
