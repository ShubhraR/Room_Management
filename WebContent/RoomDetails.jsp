

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="Template_Header.html"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rooms Availabilty</title>
<style>
.tableborder1{
 border-collapse:collapse;
  border-spacing : 5px 5px;
  
}
table, th, td {
  border: 1px solid black;
}
td{
	text-align:center;
	padding:5px;}
.captiontop
{
caption-side:top;
color:black;
}
input:read-only {
	background-color:yellow;
}
</style>
</head>
<body>
<div class="container ml-5">
	<br/>
	<h3>Welcome <c:out value="${personobj.associateId}"/></h3>
	</div>
	<!--<h3>Room Availability Details on <c:out value="${personobj.bookingDate}"/></h3>-->
	
<div class="container ml-5">
	<form method="post" action="SendConfirmation">
		<table class="tableborder1" style="background-color: skyblue">
			<caption class = "captiontop">Room Availability Details on <c:out value="${personobj.bookingDate}"/></caption>
			<tr>
				<th>Room Name</th>
				<th>Location</th>
				<th>Capacity</th>
				<th>Monitor</th>
				<th>Projector</th>
				<th>White board</th>
				<th>Select Room</th>
			</tr>
			
			<c:forEach items="${roomobjects}" var="rmobj">
				<tr>
				
					<td><input  style="border:none; background-color:skyblue;" readonly name="room_name" value= "<c:out value="${rmobj.room_name}"/>"></td>
					<td><input  style="border:none ; background-color:skyblue;" readonly name="location" value= "<c:out value="${rmobj.location}"/>"></td>
					<td><c:out value="${rmobj.capacity}" /></td>
					<td><c:out value="${rmobj.monitor}" /></td>
					<td><c:out value="${rmobj.projector}" /></td>
					<td><c:out value="${rmobj.whiteboard}" /></td>
					<td><input type="checkbox" name="chkbox"></td>

				</tr>
			</c:forEach>

		</table>
	
		<input type = hidden name="associateId" value= "<c:out value="${personobj.associateId}"/>">
		<input type = hidden name="bookingDate" value= "<c:out value="${personobj.bookingDate}"/>">
		<input type="hidden" name="roomSlot" value= "<c:out value="${personobj.roomSlot}"/>">
		<input type="hidden" name="emailId" value= "<c:out value="${personobj.emailId}"/>">
		<br/><br/>
		<input type="submit" value="Submit"/>
	
	</form>
	</div>
</body>
</html>