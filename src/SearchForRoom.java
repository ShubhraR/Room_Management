

import java.io.IOException;

import mydbconnection.dbconnect;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SearchForRoom
 */
@WebServlet("/SearchForRoom")
public class SearchForRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForRoom() {
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
		// TODO Auto-generated method stub
		dbconnect mycon = new dbconnect();
		Connection con = mycon.getConnection();
		
		String id = request.getParameter("Aid");
		String email = request.getParameter("eid");
		String bookingDate = request.getParameter("date");
		String location = request.getParameter("loc");
		String capacity = request.getParameter("capacity");
		String slot = request.getParameter("slot");
		
	
		Associatepojo personobj =  new Associatepojo();
		personobj.setAssociateId(id);
		personobj.setEmailId(email);
		personobj.setRoomSlot(slot);
		personobj.setBookingDate(bookingDate);
		
		List<roompojo> roomobjects = new ArrayList<roompojo>();
				
		ResultSet rs = null;
		Statement smt = null;
		
		try {
			smt = con.createStatement();
			String Query = "select * from room_info where location = '"+location+"' and capacity=' "+capacity+"'";
			rs =smt.executeQuery(Query);
			//System.out.println("location: !" + location);
			
				
	
		if (rs.next()==false)
		{
			 System.out.println("NO match found!!");
			 RequestDispatcher rd = request.getRequestDispatcher("NoRooms.jsp");
		     rd.include(request, response);
		}
		else
		{
			//while(rs.next())
			do
			{
					//System.out.println("Room id: "+ rs.getObject("room_id") + "  Room name: "+ rs.getObject("room_name"));
					
					roompojo roomobj = new roompojo(rs);
					//roomobj.setRoom_id(rs.getInt("room_id"));
					roomobj.setRoom_name(rs.getString("room_name"));
					roomobj.setLocation(rs.getString("location"));
			        roomobj.setCapacity(rs.getInt("capacity"));
			        roomobj.setMonitor(rs.getString("monitor"));
			        roomobj.setWhiteboard(rs.getString("whiteboard"));
			        roomobj.setProjector(rs.getString("projector"));
			        roomobjects.add(roomobj);
			}while(rs.next());

			       request.setAttribute("roomobjects", roomobjects);
			       request.setAttribute("personobj", personobj);
			       // request.setAttribute("roomobj", roomobj);
			        RequestDispatcher rd = request.getRequestDispatcher("RoomDetails.jsp");
			        rd.forward(request, response);
			
		}	
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				smt.close();
				con.close();
			} catch (SQLException e) 
			{
				System.out.println("SQLException in closing PreparedStatement or ResultSet");
				e.printStackTrace();
			}
			
		}
		
		//doGet(request, response);
	}

}
