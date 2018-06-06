package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.PaperModel;

public class PaperController {
	
	public static boolean addNewRecord(PaperModel P)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into paper(subjectid,year,paperheading,questionno,q1,q2,q3)values('"+P.getSubjectid()+"','"+P.getYear()+"','"+P.getPaperheading()+"','"+P.getQuestionno()+"','"+P.getQ1()+"','"+P.getQ2()+"','"+P.getQ3()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
			
		}
		catch(Exception e)
		{
			System.out.println("Error:[PC-addNewRecord]:"+e);
			return(false);
		}		
	}

	public static ResultSet GetQuestions(int subjectid,int year)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="select * from paper where subjectid="+subjectid+" and year="+year;
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			
		}
		catch(Exception e)
		{
			System.out.println("Error:[PC-addNewRecord]:"+e);
			return(null);
		}		
	}
	
	
	
}
