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
 * Servlet implementation class UserBranchView
 */
@WebServlet("/UserBranchView")
public class UserBranchView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBranchView() {
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
	ses.setAttribute("SUID", request.getParameter("uid"));
	ses.setAttribute("SUNAME", request.getParameter("uname"));
	ses.setAttribute("SULOGO", request.getParameter("ulogo"));
	ses.setAttribute("SUCITY", request.getParameter("ucity"));
	ses.setAttribute("SUSTATE", request.getParameter("ustate"));
	out.println("<script src=asset/jquery-2.2.1.min.js></script>");
    out.println("<script src=asset/branchview.js></script>");
	out.println("<html><center>");
	out.println("<input type='hidden' value='"+request.getParameter("uid")+"' id='uid'>");
	out.println("<table cellspacing='3' width='80%'>");
	out.println("<tr><td><table cellspacing=5><tr><td><img src=images/uni/"+request.getParameter("ulogo")+" width=50 height=50></td><td valign=middle>"+request.getParameter("uname")+"<br>");
	out.println(request.getParameter("ustate")+","+request.getParameter("ucity")+"</td></tr></table></td>");
	out.println("<td><input type='text' id='btxt' size=80 placeholder='Search Branch Here...'></td></tr></table>");
	out.println("<br><br><div id='branchresult'></div>");
	out.println("</center></html>");
	}

}
