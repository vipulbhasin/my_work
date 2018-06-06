package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserView
 */
@WebServlet("/UserView")
public class UserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserView() {
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
        out.println("<script src=asset/userview.js></script>");
        out.println("<script src='asset/jquery-ui.js'></script>");
    	out.println("<link href='asset/jquery-ui.css' rel='stylesheet'></link>");	
        out.println("<html>");
		out.println("<center>");
		out.println("<input type='text' id='txt' placeholder='Enter Your University Name or City ....' size='80'><br><br>");
		out.println("<div id='result'></div>");
		
		out.println("</center>");
		out.println("<div id='udialog'></div>");
		out.println("</html>");
		out.flush();
		 
	}

}
