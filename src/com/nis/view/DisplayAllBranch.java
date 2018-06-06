package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;

/**
 * Servlet implementation class DisplayAllBranch
 */
@WebServlet("/DisplayAllBranch")
public class DisplayAllBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllBranch() {
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
			ResultSet rs=BranchController.displayAll();
			if(rs.next())
			{
				out.println("<html><center><table border=1>");
				out.println("<caption><b>List of Branch</b></caption>");
				out.println("<tr><th>Sn</th><th>Icon</th><th>University<br>Name</th><th>Branch<br>Name</th><th>Semester</th><th>Update</th></tr>");
				int sn=1;
				do{
					out.println("<tr><td>"+sn+"</td><td><img src=images/branch/"+rs.getString(6)+" width=40 height=40></td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td><a href=DisplayBranchById?branchid="+rs.getString(3)+">Edit/Delete</a></td></tr>");
				sn++;
				}while(rs.next());
				out.println("</table></center></html>");
					
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
		
		
	}

}
