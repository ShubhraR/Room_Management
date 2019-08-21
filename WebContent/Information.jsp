<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Template_Header.html"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Request Information</title>
</head>
<!-- java code -->
<%
String id = request.getParameter("Aid");
String email = request.getParameter("eid");
String date = request.getParameter("date");
String location = request.getParameter("loc");
String capacity = request.getParameter("capacity");
String slot = request.getParameter("slot");
%>
<body>
<form name = "Request info" action="SearchForRoom"  method = "post">
	
	<table>
	
		<tbody>
		<tr><td><h2>Request Information</h2></td></tr>
			<tr>
				<td>Associate Id : </td>
				<td><%=id %></td>
			</tr>
			<tr>
				<td>email : </td>
				<td><%=email %></td>
			</tr>
			<tr>
				<td>Date : </td>
				<td><%=date %></td>
			</tr>
			<tr>
				<td>Min. Capacity : </td>
				<td><%=capacity %></td>
			</tr>
			<tr>
				<td>Slot : </td>
				<td><%=slot %></td>
			</tr>
			<tr>
				<td>Location : </td>
				<td><%=location %></td>
			</tr>
		
	<tr></tr>
	<tr></tr>
	<tr>
	<td><input type="submit" value="Submit"></td>
	</tr>
	
	<tr></tr>
	<tr></tr>
	</tbody>
	</table>
	
</form>
</body>
</html>