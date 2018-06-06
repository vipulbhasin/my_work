package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserPaperView
 */
@WebServlet("/UserPaperView")
public class UserPaperView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPaperView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
	    out.println("<script src=asset/paperview.js></script>");
		out.println("<html><center>");
		
		out.println("<input type='hidden' value='"+request.getParameter("bid")+"' id='branchid'>");
		out.println("<table cellspacing='3' width='80%'>");
		out.println("<tr><td><table cellspacing=5><tr><td><img src=images/uni/"+ses.getAttribute("SULOGO").toString()+" width=50 height=50></td><td valign=middle>"+ses.getAttribute("SUNAME").toString()+"<br>");
		out.println(ses.getAttribute("SUCITY").toString()+","+ses.getAttribute("SUSTATE").toString()+"</td></tr></table></td>");
		out.println("<td><img src=images/branch/"+request.getParameter("bicon")+" width=50 height=50><br>"+request.getParameter("bname")+"</td></tr></table><br><br>");
		out.println("<select id='subjectsemester'><option>-Semester-</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id='subjectid'><option>-Subjects-</option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<select id=year><option>-Year-</option>");
		for(int i=2018;i>=2000;i--)
		{out.println("<option>"+i+"</option>");
 		}
		out.println("</select><br><br>");
		out.println("<div id='questionresult'></div>");
	 
		out.println("</center></html>");
		 
	}

}
