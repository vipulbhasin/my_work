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
import com.nis.controller.PaperController;
import com.nis.controller.SubjectController;

/**
 * Servlet implementation class GetQuestionPaperJSON
 */
@WebServlet("/GetQuestionPaperJSON")
public class GetQuestionPaperJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionPaperJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
 
		ResultSet rs=PaperController.GetQuestions(Integer.parseInt(request.getParameter("subjectid")),Integer.parseInt(request.getParameter("year")));
		ArrayList<JSONObject>obj=DBHelper.JsonEngine(rs);
		out.println(obj);
	}

}
