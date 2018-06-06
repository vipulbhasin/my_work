package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaperView
 */
@WebServlet("/PaperView")
public class PaperView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperView() {
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
		out.println("<form action='PaperSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><i>Paper Register</i></b></caption>");
		
		out.println("<tr>");
		out.println("<td><b><i>University Name:</i></b></td>");
		out.println("<td><select name='uid' id='uid'><option>-University-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branch Name:</i></b></td>");
		out.println("<td><select name='branchid' id='branchid'><option>-Branch-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semester:</i></b></td>");
		out.println("<td><select name='subjectsemester' id='subjectsemester'><option>-Sem-</option></select></td>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Subject Name:</i></b></td>");
		out.println("<td><select name='subjectid' id='subjectid'><option>-Subject-</option></select></td>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Year:</i></b></td>");
		out.println("<td><input type='text' name='year'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Paper Heading:</i></b></td>");
		out.println("<td><textarea rows='3' cols='30' name='paperheading'></textarea></td>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Question No:</i></b></td>");
		out.println("<td><input type='text' name='questionno'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Q1:</i></b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q1'></textarea></td>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Q2:</i></b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q2'></textarea></td>");
		out.println("<tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Q3:</i></b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q3'></textarea></td>");
		out.println("<tr>");
		
		out.println("</table>");
		out.println("<br><br><input type='submit'>&nbsp&nbsp&nbsp<input type='reset'>");
		out.println("</form></html>");
		out.flush();
		
	}

}
