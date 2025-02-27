package com.employee.management;
import java.sql.*;

public class ConnectionDB {

	private static String dpath = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/employeedata";
	private static String username = "root";
	private static String pass = "system";
	
	
	
	
	public static Connection getConnection() throws Exception {
		Class.forName(dpath);
//		System.out.println("Driver Load");
		return  DriverManager.getConnection(url,username,pass);
	}
	
	}
		
	
