package mydbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","root@123"); 
		System.out.println("Connected Successfully to db !!!");
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from logindetails");
		while(rs.next())
		{
		System.out.println("  ID: " + rs.getObject("usreid")+ "  Password:  "+rs.getObject("password"));
		}
		
		
		
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println("Driver not found!!");
			e.printStackTrace(); 
				}
		catch(SQLException e)
		{ e.printStackTrace();
		
		}

	}

}
