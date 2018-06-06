package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.PaperController;
import com.nis.model.PaperModel;

/**
 * Servlet implementation class PaperSubmit
 */
@WebServlet("/PaperSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class PaperSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	PaperModel P=new PaperModel();
	P.setUniversityid(request.getParameter("uid"));
	P.setBranchid(request.getParameter("branchid"));
	P.setSemester(request.getParameter("semester"));
	P.setSubjectid(request.getParameter("subjectid"));
	P.setYear(request.getParameter("year"));
	P.setPaperheading(request.getParameter("paperheading"));
	P.setQuestionno(request.getParameter("questionno"));
	P.setQ1(request.getParameter("q1"));
	P.setQ2(request.getParameter("q2"));
	P.setQ3(request.getParameter("q3"));
	boolean st=PaperController.addNewRecord(P);
	out.println("<html>");
	if(st)
	{
		out.println("Record Submitted...");
		
	}
	else
	{
		out.println("Fail to Submit Record...");
	}
	out.println("</html>");
	out.flush();
	}

}
