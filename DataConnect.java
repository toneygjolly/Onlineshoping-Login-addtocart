package com.training.connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
private static Connection con;
private DataConnect()
{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinestore","root","Toney@123");
	System.out.println("connection established");
	
} catch(Exception ex)
	{
		ex.getMessage();
	}
	}
public static Connection getConnection() {
	DataConnect D=new DataConnect();
	return con;
}
public static void main(String args []) {
	DataConnect d=new DataConnect();
	System.out.println("connection established");
}
}

