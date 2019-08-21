<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<jsp:include page="Template_Header.html"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
<!-- <link rel = "stylesheet" type="text/css" href = "css/jquery-ui.min.css"> -->
<style>
.tableborder{
 border-collapse:separate;
  border-spacing : 3px 3px;
 }
​.captiontop
{
caption-side:top;
color:black;
}
</style>
<link rel = "stylesheet" type="text/css" href = "https://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.4/themes/redmond/jquery-ui.css">
<script type="text/javascript" src= "js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src= "js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
</head>
<script>
$(function(){
$("#datepicker").datepicker(
		{dateFormat:'yy-mm-dd',
			changeMonth:true,
			changeYear:true,
			beforeShowDay:$.datepicker.noWeekends,
			minDate:0
		});
		
//$("#datepicker").datepicker('show'); show() to automatically show the date picker
//$("#datepicker").datepicker();
});
</script>
<body>
<br/>
<div class="container ml-5">

	<h3>Welcome Associate!!</h3>
	<br/>
	<h6>Please fill in the following details:</h6>
</div>


	<div class="container ml-5">	
		<form name="welcomeForm" method="post" action="SearchForRoom" onSubmit="return validate(this)">
		
		<table class = "tableborder" style="background-color:skyblue">
					<tr>
					<td>Associate-id</td>
					<td><input type="text" name="Aid" id="Aid" autocomplete="off" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Email-id</td>
					<td><input type="email" name="eid" id="eid"
						placeholder="sv@cerner.com" autocomplete="off" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Date</td>
					<td><input type="text" name="date" id="datepicker" placeholder="yy-mm-dd" autocomplete="off" /></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Location</td>
					<td><select name="loc" id="loc">
							<option value="">Select Location</option>
							<option value="H2 Floor-6">H2 Block</option>
							<option value="C2 Floor-8">C2 Block</option>

					</select></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Min. Capacity</td>
					<td><select name="capacity" id="cap">
							<option value="">--Select Capacity--</option>
							<option value="20">20</option>
							<option value="30">30</option>
							<option value="40">40</option>
							<option value="50">50</option>

					</select></td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>Slot</td>
					<td><select name="slot" id="slot">
							<option value="">--Select slot--</option>
							<option value="First Half">First Half (9:00 A:M- 1:00
								P:M)</option>
							<option value="Second Half">Second Half (2:00 p:M- 6:00
								P:M)</option>
							<option value="Full Day">Full Day (9:00 A:M- 6:00 P:M)</option>

					</select></td>
				</tr>
			
			
				<tr>
					<td></td>
					<td style="padding-right:25px"><input type="submit" value="Submit"><input type="reset" value="Cancel"></td>
					
					<td>
				</tr>
			
		</table>
	</form>
</div>

</body>
</html>