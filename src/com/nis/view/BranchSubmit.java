package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.BranchController;
import com.nis.model.BranchModel;

/**
 * Servlet implementation class BranchSubmit
 */
@WebServlet("/BranchSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class BranchSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	BranchModel B=new BranchModel();
	B.setUniversityid(request.getParameter("uid"));
	B.setBranchname(request.getParameter("branchname"));
	B.setSemester(request.getParameter("semester"));
	//B.setBranchicon(request.getParameter("bicon"));
	Part P=request.getPart("branchicon");
	FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/IndianUniversity/WebContent/images/branch");
	B.setBranchicon(F.filename);
	boolean st=BranchController.addNewRecord(B);
	
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
