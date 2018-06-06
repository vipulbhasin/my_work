package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

public class SubjectController {
	public static boolean addNewRecord(SubjectModel S)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into subject(branchid,subjectname,semester,remark)values('"+S.getBranchid()+"','"+S.getSubjectname()+"','"+S.getSemester()+"','"+S.getRemark()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
			
		}catch(Exception e)
		{System.out.println("Error:[SC-addNewRecord]:"+e);
		return(false);
		}
		
	}
	public static ResultSet displayAll()
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="Select s.branchid,(select b.branchname from branch b where b.branchid=s.branchid) as branchid,s.subjectid,s.subjectname,s.semester,s.remark from subject s";
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("Error:[SC-displayAll]:"+e);
			return(null);
		}
	}
	public static SubjectModel displayById(int subjectid)
	{try
	{Connection cn=DBHelper.openConnection();
	String query="Select s.branchid,(select b.branchname from branch b where b.branchid=s.branchid) as branchid,s.subjectid,s.subjectname,s.semester,s.remark from subject s where s.subjectid="+subjectid;
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{
		SubjectModel S=new SubjectModel();
		S.setBranchid(rs.getString(1)+","+rs.getString(2));
		S.setSubjectid(Integer.parseInt(rs.getString(3)));
		S.setSubjectname(rs.getString(4));
		S.setSemester(rs.getString(5));
		S.setRemark(rs.getString(6));
		return(S);
		
		
	}
	return(null);
	}
	catch(Exception e)
	{
		System.out.println("Error:[SC-display]:"+e);
		return(null);
	}
		
	}
	public static boolean editRecord(SubjectModel S)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update subject set branchid='"+S.getBranchid()+"',subjectname='"+S.getSubjectname()+"',semester='"+S.getSemester()+"',remark='"+S.getRemark()+"' where subjectid="+S.getSubjectid();
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}
		catch(Exception e)
		{
			System.out.println("Error[SC-editRecord]:"+e);
			return(false);
		}
	}
		public static boolean deleteRecord(int subjectid)
		{
			try{
				Connection cn=DBHelper.openConnection();
				String query="delete from subject where subjectid="+subjectid;
				boolean st=DBHelper.executeUpdate(cn, query);
				return(st);
				
			}
			catch(Exception e)
			{
				System.out.println("Error[SC-deleteRecord]:"+e);
				return(false);
			}
		
	}
	
		static public ResultSet getAllSubject(String semester,int branchid)
		{try{
			Connection cn=DBHelper.openConnection();
			String query="Select * from subject where semester='"+semester+"' and branchid="+branchid;
			System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			
		}catch(Exception e)
		{System.out.println("Subject Controller"+e);}
		return(null);
			
		}
}
