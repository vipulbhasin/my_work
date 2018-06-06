package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.model.BranchModel;

/**
 * Servlet implementation class DisplayBranchById
 */
@WebServlet("/DisplayBranchById")
public class DisplayBranchById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBranchById() {
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
			BranchModel B=BranchController.displayById(Integer.parseInt(request.getParameter("branchid")));
			
			out.println("<script src=asset/jquery-2.2.1.min.js></script>");
			out.println("<script src=asset/universitybranch.js></script>");
			
			out.println("<html>");
			out.println("<form action='BranchEditDelete' method='post' enctype='multipart/form-data' >");
			out.println("<table>");
	        out.println("<tr><td valign='top'>");
	        out.println("<table>");
			out.println("<caption><b><i>Branch Register</i></b></caption>");
			
			 String arrayUniversity[]=B.getUniversityid().split(",");
			out.println("<tr>");
			out.println("<td><b><i>University Name:</i></b></td>");
			out.println("<td><select name='uid' id='uid'><option>-University-</option></select><b>"+arrayUniversity[1]+"</b><input type='hidden' value="+arrayUniversity[0]+" name=puniversity></td>");
			out.println("</tr>");
			
			out.println("<input type=hidden name=branchid  value="+B.getBranchid()+">");
			out.println("<tr>");
			out.println("<td><b><i>Branch Name:</i></b></td>");
			out.println("<td><input type='type' name='branchname' value='"+B.getBranchname()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b><i>Semester:</i></b></td>");
			out.println("<td><input type='text' name='semester' value='"+B.getSemester()+"'></td>");
			out.println("</tr>");
			

	        out.println("</table>");
	        out.println("</td>");
	        
			out.println("<td valign='top'><img src=images/branch/"+B.getBranchicon()+" width='200' height='200'><br><br>");
			out.println("Edit Icon:<input type='file' name='branchicon'><br><br>");
			out.println("<input type='submit' name='btn' value='Edit Icon'></td>");
			out.println("</td></tr></table>");
		
			
			out.println("</table>");
			out.println("<br><br><input type='Submit' value='Edit' name='btn'>&nbsp;&nbsp;&nbsp;<input type='submit' name='btn' value='Delete'>");
			out.println("</form>");
			out.println("</html>");
			out.flush();
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
