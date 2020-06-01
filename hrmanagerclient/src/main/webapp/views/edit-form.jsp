<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Edit Details</title>
<style type="text/css">

body {
	font-family: sans-serif;
}

table, td, tr, th {
	padding: 30px;
	border-collapse: collapse;
	letter-spacing: 1px;
}
</style>
</head>
<body>

	<div>
					<c:if test = "${mode == 'edit'}">
					
      				<c:set var = "varMode" scope = "session" value = "${emp.getEcode()}"/>
      				<c:set var = "action" scope = "session" value = "update"/>
      
      				</c:if>
      				
      				<c:if test = "${mode == 'add'}">
					
      				<c:set var = "varMode" scope = "session" value = "AUTO GENERATED"/>
      				<c:set var = "action" scope = "session" value = "addemp"/>
      
      				</c:if>
		
		<form action="${action}" method="post">

			<h2>Edit Details</h2>
			<table>
				<tr>
					<th>Employee Code:</th>
					
					<td><input type="text" name="ecode" size="45"
						value="${varMode}" readonly /></td>
      				
      				
					
				</tr>

				<tr>
					<th>Employee Name:</th>
					<td><input type="text" name="name" size="45"
						value="${emp.getName()}" /></td>
				</tr>

				<tr>
					<th>Location:</th>
					<td><textarea name="loc" cols="40" rows="5">${emp.getLoc()}</textarea>

						<%-- <input type="text" name="loc" size="45"
                       value="${emp.getLoc()}"/> --%></td>
				</tr>

				<tr>
					<th>Email:</th>
					<td><input type="text" name="email" size="45"
						value="${emp.getEmail()}" /></td>
				</tr>

				<tr>
					
					<th><label for="start">Date of Birth:</label></th>
					
					<td>                       
                       <input type="date" id="start" name="dob" value="${emp.getDob()}">
					</td>
					
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="Save" />
					</td>
				</tr>
			</table>
		</form>
	</div>



</body>
</html>