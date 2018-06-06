package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.BranchModel;

public class BranchController {
	
	public static boolean addNewRecord(BranchModel B)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="insert into branch(universityid,branchname,semester,branchicon)values('"+B.getUniversityid()+"','"+B.getBranchname()+"','"+B.getSemester()+"','"+B.getBranchicon()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
			
		}
		catch(Exception e)
		{
			System.out.println("Error:[UC-addNewRecord]:"+e);
			return(false);
		}		
	}
	public static ResultSet displayAll()
	{
	try	{
		Connection cn=DBHelper.openConnection();
		String query="Select b.universityid,(select u.universityname from university u where u.universityid=b.universityid) as universityid,b.branchid,b.branchname,b.semester,b.branchicon from branch b";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return(rs);
	}
		catch(Exception e)
		{System.out.println("Error:[BC-displayAll]:"+e);
		return(null);
		}
	}
		public static BranchModel displayById(int branchid)
		{try
		{Connection cn=DBHelper.openConnection();
		String query="Select b.universityid,(select u.universityname from university u where u.universityid=b.universityid) as universityid,b.branchid,b.branchname,b.semester,b.branchicon from branch b where b.branchid="+branchid;
		ResultSet rs=DBHelper.executeQuery(cn, query);
		if(rs.next())
		{
			BranchModel B=new BranchModel();
			B.setUniversityid(rs.getString(1)+","+rs.getString(2));
			B.setBranchid(Integer.parseInt(rs.getString(3)));
			B.setBranchname(rs.getString(4));
			B.setSemester(rs.getString(5));
			B.setBranchicon(rs.getString(6));
			return(B);
			
		}
		return(null);
		}
		catch(Exception e)
		{
			System.out.println("Error:[BC-display]:"+e);
			return(null);
		}
			
		}
		public static boolean editRecord(BranchModel B)
		{
			try{
				Connection cn=DBHelper.openConnection();
				String query="update branch set universityid='"+B.getUniversityid()+"',branchname='"+B.getBranchname()+"',semester='"+B.getSemester()+"' where branchid="+B.getBranchid();
				System.out.println(query);
				boolean st=DBHelper.executeUpdate(cn, query);
				return(st);
			
			}catch(Exception e)
			{System.out.println("Error[BC-editRecord]:"+e);}
			return(false);
		}
		public static boolean deleteRecord(int branchid)
		{try{
			Connection cn=DBHelper.openConnection();
			String query="delete from branch where branchid="+branchid;
			
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{System.out.println("Error:[BC-deleteRecord]:"+e);
		return(false);
		}
		}
		
		public static boolean updateIcon(int branchid,String file)
		{try{
			Connection cn=DBHelper.openConnection();
			String query="update branch set branchicon='"+file+"' where branchid="+branchid;
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}
		
		catch(Exception e)
		{System.out.println("Error:[BC-update ICON]:"+e);
		return(false);
		}
		
		}
		
		static public ResultSet getAllBranch(int universityid)
		{try{
			Connection cn=DBHelper.openConnection();
			String query="Select * from branch where universityid="+universityid;
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			
		}catch(Exception e)
		{System.out.println("BranchSuject Controller"+e);}
		return(null);
			
		}
		
		public static ResultSet getSemesterById(int branchid)
		{try
		{Connection cn=DBHelper.openConnection();
		String query="Select b.universityid,(select u.universityname from university u where u.universityid=b.universityid) as universityid,b.branchid,b.branchname,b.semester,b.branchicon from branch b where b.branchid="+branchid;
		ResultSet rs=DBHelper.executeQuery(cn, query);
		 
		return(rs);
		}
		catch(Exception e)
		{
			System.out.println("Error:[BC-display]:"+e);
			return(null);
		}
			
		}		
		
}
		
	
