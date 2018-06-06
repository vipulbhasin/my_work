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
import com.nis.controller.UniversityController;
import com.nis.model.BranchModel;

/**
 * Servlet implementation class BranchEditDelete
 */
@WebServlet("/BranchEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class BranchEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			String btn=request.getParameter("btn");
			if(btn.equals("Edit"))
			{
				BranchModel B=new BranchModel();
				if(request.getParameter("uid").equals("-University-"))
				{
					B.setUniversityid(request.getParameter("puniversity"));
				}
				else{
				B.setUniversityid(request.getParameter("uid"));
				}
				B.setBranchid(Integer.parseInt(request.getParameter("branchid")));
				B.setBranchname(request.getParameter("branchname"));
				B.setSemester(request.getParameter("semester"));
				boolean st=BranchController.editRecord(B);
				response.sendRedirect("DisplayAllBranch");
			}
			else if(btn.equals("Delete"))
			{
				boolean st=BranchController.deleteRecord(Integer.parseInt(request.getParameter("branchid")));
				response.sendRedirect("DisplayAllBranch");
			}
			
		
		else if(btn.equals("Edit Icon"))
		{
			Part P=request.getPart("branchicon");
			FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/IndianUniversity/WebContent/images/branch");
			boolean st=BranchController.updateIcon(Integer.parseInt(request.getParameter("branchid")),F.filename);
			response.sendRedirect("DisplayAllBranch");
		}	
		}catch(Exception e){
			out.println(e);
		}
	}	
	}

