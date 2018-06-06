package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.controller.SubjectController;
import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

/**
 * Servlet implementation class DisplaySubjectById
 */
@WebServlet("/DisplaySubjectById")
public class DisplaySubjectById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySubjectById() {
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
			SubjectModel S=SubjectController.displayById(Integer.parseInt(request.getParameter("subjectid")));
			
			out.println("<script src=asset/jquery-2.2.1.min.js></script>");
			out.println("<script src=asset/universitybranch.js></script>");
			
			out.println("<html>");
			out.println("<form action='SubjectEditDelete' method='post' enctype='multipart/form-data' >");
			out.println("<table>");
	       	out.println("<caption><b><i>Subject Register</i></b></caption>");
	       	
	        
	       	out.println("<tr>");
			out.println("<td><b><i>University Name:</i></b></td>");
			out.println("<td><select name='uid' id='uid'><option>-University-</option></select></td>");
			out.println("</tr>");
			
			 String arrayBranch[]=S.getBranchid().split(",");
			out.println("<tr>");
			out.println("<td><b><i>Branch Name:</i></b></td>");
			out.println("<td><select name='branchid' id='branchid'><option>-Branch-</option></select><b>"+arrayBranch[1]+"</b><input type='hidden' value="+arrayBranch[0]+" name=pbranch></td>");
			out.println("</tr>");
			
			out.println("<input type=hidden name=subjectid  value="+S.getSubjectid()+">");
			out.println("<tr>");
			out.println("<td><b><i>Subject Name:</i></b></td>");
			out.println("<td><input type='type' name='subjectname' value='"+S.getSubjectname()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b><i>Semester:</i></b></td>");
			out.println("<td><input type='text' name='semester' value='"+S.getSemester()+"'></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td><b><i>Remark:</i></b></td>");
			out.println("<td><input type='text' name='remark' value='"+S.getRemark()+"'></td>");
			out.println("</tr>");
			
			
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
