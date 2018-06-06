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

import com.nis.controller.BranchController;
import com.nis.controller.DBHelper;
import com.nis.controller.StateCityController;

/**
 * Servlet implementation class GetSemesterJSON
 */
@WebServlet("/GetSemesterJSON")
public class GetSemesterJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSemesterJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        ResultSet rs=BranchController.getSemesterById(Integer.parseInt(request.getParameter("bid")));
        ArrayList<JSONObject>obj=DBHelper.JsonEngine(rs);
	     out.println(obj);
	}

}
