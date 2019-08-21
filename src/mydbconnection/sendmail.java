package mydbconnection;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userName = "shubhragarg@gmail.com";
		String password="mohshu275";
		  Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	 
	        // creates a new session with an authenticator
	        Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	       
	        Session session = Session.getInstance(properties, auth);
	        // creates a new e-mail message
	       
	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("shubhragarg@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shubhragarg@gmail.com"));
	            message.setSubject("Testing Gmail SSL");
	            message.setText("Dear Mail Crawler,"
	                    + "\n\n Please do not spam my email!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	        	throw new RuntimeException(e);
	        }
	    }

	}


