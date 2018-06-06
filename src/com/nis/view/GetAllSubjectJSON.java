package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

 
import com.nis.controller.DBHelper;
import com.nis.controller.SubjectController;

/**
 * Servlet implementation class GetAllSubjectJSON
 */
@WebServlet("/GetAllSubjectJSON")
public class GetAllSubjectJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllSubjectJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println(request.getParameter("subjectsemester"));
		ResultSet rs=SubjectController.getAllSubject(request.getParameter("subjectsemester"),Integer.parseInt(request.getParameter("branchid")));
		ArrayList<JSONObject>obj=DBHelper.JsonEngine(rs);
		out.println(obj);
	}

}
