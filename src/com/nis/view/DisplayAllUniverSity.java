package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.UniversityController;

/**
 * Servlet implementation class DisplayAllUniverSity
 */
@WebServlet("/DisplayAllUniverSity")
public class DisplayAllUniverSity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllUniverSity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
		ResultSet rs=UniversityController.displayAll();	
		if(rs.next())
		{out.println("<html><center><table border=1>");
		 out.println("<caption>List of University</caption>");
		 out.println("<tr><th>Sn</th><th>Logo</th><th>University<br>Name</th><th>Establishment<br>Year</th><th>Address</th><th>Contact<br>Information</th><th>Description</th><th>Update</th></tr>");
		 int sn=1;
		  do{
		 out.println("<tr><td>"+sn+"</td><td><img src=images/uni/"+rs.getString(13)+" width=40 height=40></td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(8)+","+rs.getString(6)+"</td><td>"+rs.getString(10)+"<br>Email:"+rs.getString(9)+"<br>Mob:"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td><a href=DisplayUniversityById?uid="+rs.getString(1)+">Edit/Delete</a></td>");	  
		  sn++;
		  }while(rs.next());	
			out.println("</table></center></html>");
		}
		else
		{
		out.println("Record Not Found..."); 	
		}
		
		}catch(Exception e)
		{out.println(e);} 
	}

}
