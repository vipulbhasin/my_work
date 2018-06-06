package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.UniversityModel;

public class UniversityController {
public static boolean addNewRecord(UniversityModel U)
{try{Connection cn=DBHelper.openConnection();
	String query="insert into university(universityname,estyear,address,state,city,email,contactperson,mobile,description,logo)values('"+U.getUniversityname()+"','"+U.getEstyear()+"','"+U.getAddress()+"','"+U.getState()+"','"+U.getCity()+"','"+U.getEmail()+"','"+U.getContactperson()+"','"+U.getMobile()+"','"+U.getDescription()+"','"+U.getLogo()+"')";
    boolean st=DBHelper.executeUpdate(cn, query);
    return(st);
}catch(Exception e){
	System.out.println("Error:[UC-addNewRecord]:"+e);
  return(false);  
}
	}

public static ResultSet displayAll()
{try{Connection cn=DBHelper.openConnection();
	String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state) as ustate,u.city,(select c.cityname from city c where c.cityid=u.city) as ucity,u.email,u.contactperson,u.mobile,u.description,u.logo from university u";
    ResultSet rs=DBHelper.executeQuery(cn, query);
    return(rs);
}catch(Exception e){
	System.out.println("Error:[UC-displayAll]:"+e);
  return(null);  
}}
public static ResultSet displayByPattern(String pat)
{try{Connection cn=DBHelper.openConnection();
	String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state) as ustate,u.city,(select c.cityname from city c where c.cityid=u.city) as ucity,u.email,u.contactperson,u.mobile,u.description,u.logo from university u where u.universityname like '%"+pat+"%'";
    ResultSet rs=DBHelper.executeQuery(cn, query);
    return(rs);
}catch(Exception e){
	System.out.println("Error:[UC-displayAll]:"+e);
  return(null);  
}}

public static UniversityModel displayById(int uid)
{try{Connection cn=DBHelper.openConnection();
	String query="select u.universityid,u.universityname,u.estyear,u.address,u.state,(select s.statename from states s where s.stateid=u.state) as ustate,u.city,(select c.cityname from city c where c.cityid=u.city) as ucity,u.email,u.contactperson,u.mobile,u.description,u.logo from university u where u.universityid="+uid;
    ResultSet rs=DBHelper.executeQuery(cn, query);
    if(rs.next())
    {UniversityModel U=new UniversityModel();
     U.setUniversityid(Integer.parseInt(rs.getString(1)));	
     U.setUniversityname(rs.getString(2));
     U.setEstyear(rs.getString(3));
     U.setAddress(rs.getString(4));
     U.setState(rs.getString(5)+","+rs.getString(6));
     U.setCity(rs.getString(7)+","+rs.getString(8));
     U.setEmail(rs.getString(9));
     U.setContactperson(rs.getString(10));
     U.setMobile(rs.getString(11));
     U.setDescription(rs.getString(12));
     U.setLogo(rs.getString(13));
     return(U);
    }
    return(null);
     
}catch(Exception e){
	System.out.println("Error:[UC-displayAll]:"+e);
  return(null);  
}}
public static boolean editRecord(UniversityModel U)
{try{Connection cn=DBHelper.openConnection();
	String query="update university set universityname='"+U.getUniversityname()+"',estyear='"+U.getEstyear()+"',address='"+U.getAddress()+"',state='"+U.getState()+"',city='"+U.getCity()+"',email='"+U.getEmail()+"',contactperson='"+U.getContactperson()+"',mobile='"+U.getMobile()+"',description='"+U.getDescription()+"' where universityid="+U.getUniversityid();
	 
    boolean st=DBHelper.executeUpdate(cn, query);
    return(st);
}catch(Exception e){
	System.out.println("Error:[UC-editRecord]:"+e);
  return(false);  
}
	}
public static boolean deleteRecord(int uid)
{try{Connection cn=DBHelper.openConnection();
	String query="delete from university where universityid="+uid;
	 
    boolean st=DBHelper.executeUpdate(cn, query);
    return(st);
}catch(Exception e){
	System.out.println("Error:[UC-deleteRecord]:"+e);
  return(false);  
}}
public static boolean updateLogo(int uid,String file)
{try{Connection cn=DBHelper.openConnection();
	String query="update university set logo='"+file+"' where universityid="+uid;
	 
    boolean st=DBHelper.executeUpdate(cn, query);
    return(st);
}catch(Exception e){
	System.out.println("Error:[UC-update LOGO]:"+e);
  return(false);  
}
	}

}
