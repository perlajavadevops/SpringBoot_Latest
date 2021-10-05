<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2 align="center" style="color: green;" class="alert alert-info">Register
		Employee</h2>
	<h4 align="center" style="color: red;" id="msgDiv">${msg}</h4>
	<br>
	<form action="./addEmployee" method="POST">
		<table align="center" style="width: 35%;"
			class="table table-hover table-bordered">
			<tr>
				<td>Emp No:</td>
				<td><input type="text" id="empNo" name="empNo" required /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" id="firstName" name="firstName" required /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" id="lastName" name="lastName" required /></td>
			</tr>
			<tr>
				<td>Dept Name:</td>
				<td><input type="text" id="deptName" name="deptName" required /></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><input type="text" id="designation" name="designation" required /></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" id="salary" name="salary" required /></td>
			</tr>
			<tr>
				<td>Branch:</td>
				<td><input type="text" id="branch" name="branch" required /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="country" style="width: 155px">
						<option>India</option>
						<option>USA</option>
						<option>France</option>
						<option>China</option>
						<option>UK</option>
						<option>Canada</option>
						<option>Other</option>
				</select></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male" />Male <input
					type="radio" name="gender" value="female" />Female <input
					type="radio" name="gender" value="other" />Other</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="number" name="phone" size="10"/></td>
			</tr>
			<tr>
				<td>DOP:</td>
				<td><input type="date" name="dop" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><center>
						<input type="submit" class="btn btn-primary"
							value="Register Employee" align="middle" />
					</center></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#firstName, #lastName, #deptName").click(function() {
			$("#msgDiv").hide();
		});
	});
</script>
</html>