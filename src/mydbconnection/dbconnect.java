package mydbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbconnect {
	private Connection connection;
	public dbconnect() 
	{
		
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "root@123";
	try 
	{		
	Class.forName("com.mysql.cj.jdbc.Driver"); 
	this.connection = DriverManager.getConnection(url,username,password); 
	}
	catch(ClassNotFoundException e) 
	{
		System.out.println("Driver not found!!");
		e.printStackTrace(); 
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
	public Connection getConnection() {
		return this.connection;}
	}

