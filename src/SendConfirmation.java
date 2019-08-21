

import java.io.IOException;

//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SendConfirmation
 */
@WebServlet("/SendConfirmation")
public class SendConfirmation extends HttpServlet 
{
	  private static final long serialVersionUID = 1L;

	
	/*
	 * private String host; private String port; private String user; private String
	 * pass;
	 * 
	 * public void init() { // reads SMTP server setting from web.xml file
	 * ServletContext context = getServletContext(); host =
	 * context.getInitParameter("host"); port = context.getInitParameter("port");
	 * user = context.getInitParameter("user"); pass =
	 * context.getInitParameter("pass"); }
	 */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendConfirmation() {
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
		
		   String associate_Id = request.getParameter("associateId"); 
		  String email_Id =  request.getParameter("emailId");
		  String roomName =  request.getParameter("room_name");
		  String roomLocation =  request.getParameter("location");
		  String roomSlot =  request.getParameter("roomSlot");
		  String roomDate =  request.getParameter("bookingDate");
		 
		 
		String[] availRooms = request.getParameterValues("chkbox");
		if (availRooms != null && availRooms.length != 0) {
			
				System.out.println("Rooms Booked : "+ availRooms.length); 
				for(int i=0;i<=availRooms.length;i++)
					System.out.println(	associate_Id + "\n" + email_Id + "\n" + roomName + "\n" +roomLocation + "\n"+roomSlot +"\n"+ roomDate+"\n");
		}
		//doGet(request, response);
		/*
		 * String recipient = request.getParameter("recipient"); String subject =
		 * request.getParameter("subject"); String content =
		 * request.getParameter("content");
		 */
	        String resultMessage = "";
	 
	        try {
	  // EmailUtility.sendEmail(host, port, user, pass, user, "room allotted Information","Details are:" +associate_Id + "\n" + email_Id + "\n" + roomName + "\n" +roomLocation + "\n"+roomSlot +"\n"+ roomDate+"\n");
	        	 EmailUtility.sendEmail("smtp.gmail.com", "587", "shubhragarg@gmail.com", "mohshu275", "shubhragar@gmail.com", "Training Room allocation Information", "Dear Associate " + associate_Id + "\n" + "Following are the details of the training room booked by you: "+"\n" + "Room Name: "+ roomName + "\n" +"Location: "+ roomLocation + "\n"+"Room Slot: "+roomSlot +"\n"+ "Date: "+ roomDate+"\n");    
	            resultMessage = "Success!" +"\n"+ "The Training room allotment details are sent to your email account!";
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            resultMessage = "OOPS! There was an error in sending the email: " + ex.getMessage();
	        } finally {
	            request.setAttribute("Message", resultMessage);
	            getServletContext().getRequestDispatcher("/Result.jsp").forward(
	                    request, response);
	        }
	    }
	}
	


