
import mydbconnection.dbconnect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInCheck
 */
@WebServlet("/LogInCheck")
public class LogInCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * String uname = request.getParameter("uname"); String pswd =
		 * request.getParameter("pswd"); if (uname.equals("SV071356") &&
		 * pswd.equals("hello")) { response.sendRedirect("WelcomePage.jsp"); }
		 * if(uname.equals("") || pswd.equals("")) {
		 * response.sendRedirect("ErrorPage.jsp"); }
		 */
		boolean flag=false;
		String uname = request.getParameter("uname"); 
		String pswd = request.getParameter("pswd");
		dbconnect mycon = new dbconnect();
		//	Statement smt = mycon.createStatement();

		Connection con = mycon.getConnection();
		System.out.println("successful connection!" + con);
		ResultSet rs = null;
		Statement smt = null;
		try {
			smt = con.createStatement();
			rs =smt.executeQuery("select * from logindetails");
			if (rs!=null) {	System.out.println("fetched Result set");}
			while(rs.next())
			{
				if (uname.equals(rs.getObject("usreid")) && pswd.equals(rs.getObject("password")))
				{
					System.out.println("Match found!!");
					//response.sendRedirect("WelcomePage.jsp");
					flag =  true;
					break;
				}
			}
				if (flag==true)
				{
					RequestDispatcher rd = request.getRequestDispatcher("WelcomePage.jsp");
					rd.forward(request, response);

				}
				
				  else { //response.sendRedirect("ErrorPage.jsp");
				  
				  RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
				  rd.include(request, response);
				  
				  }
				 
			
		}
		catch(SQLException e)
		{ e.printStackTrace();

		}
		finally{
			try {
				rs.close();
				smt.close();
			} catch (SQLException e) {
				System.out.println("SQLException in closing PreparedStatement or ResultSet");
				e.printStackTrace();
			}
			
		}

		//doGet(request, response);
	}

}
