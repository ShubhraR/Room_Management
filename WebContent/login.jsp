<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="Template_Header.html"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
.tableborder{
 border-collapse:separate;
  border-spacing : 3px 3px;
 }
.captiontop
{
caption-side:top;
color:black;
}
</style>
</head>
  <body>
  <div class = "container ml-5">
   	<form name="loginForm" method="post" action="LogInCheck">
		<br />
		<br />
		<!--  <h5 style="color: purple">Fill in the credentials to log in!!</h5>-->
		<br />
		<table class="tableborder"  style="background-color: skyblue">
		<caption class="captiontop">Fill in the credentials to log in!!</caption>
			<tr></tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pswd"></td>
			</tr>
		
			<tr>
				<td></td>
				
				<td><input type="submit" value="Sign-In"></td>
			</tr>
			<tr></tr>
		</table>
	</form>
</div>
</body>
</html>