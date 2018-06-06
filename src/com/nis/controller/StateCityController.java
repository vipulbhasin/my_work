package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class StateCityController {
static public ResultSet getAllStates()
{ try{
	Connection cn=DBHelper.openConnection();
String query="Select * from states";
ResultSet rs=DBHelper.executeQuery(cn, query);
return(rs);
	
}catch(Exception e)
{System.out.println("StateCity Controller "+e);}
	return(null);
}
static public ResultSet getAllCities(String stateid)
{ try{
	Connection cn=DBHelper.openConnection();
String query="Select * from city where stateid='"+stateid+"'";
ResultSet rs=DBHelper.executeQuery(cn, query);
return(rs);
	
}catch(Exception e)
{System.out.println("StateCity Controller "+e);}
	return(null);
}



}
