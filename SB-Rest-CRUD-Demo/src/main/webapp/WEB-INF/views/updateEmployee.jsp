<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2 align="center" style="color: green;" class="alert alert-info">Update
		Employee</h2>
	<br>
	<h3>
		<div id="msgDiv" style="display: none; color: green;" align="center"></div>
	</h3>
	<br>
	<c:choose>
		<c:when test="${empList != null}">
			<table border="1" align="center" class="table table-hover"
				style="width: 28%;">
				<tr>
					<td>Select Employee ID:<span style="color: red;"> *</span></td>
					<td><select id="SelectedEmpId">
							<option value="NONE">--Select Emp No--</option>
							<c:forEach items="${empList}" var="emp">
								<option
									value="${emp.firstName}&${emp.lastName}&${emp.deptName}&${emp.designation}&${emp.salary}&${emp.branch}&${emp.country}&${emp.gender}&${emp.password}&${emp.email}&${emp.phone}&${emp.dop}&${emp.id}"
									id="${emp.empNo}">${emp.empNo}</option>
							</c:forEach>
					</select></td>
				</tr>
				
				<tr id="EmpFirstNameTr" style="display: none;">
					<td>First Name:</td>
					<input type="hidden" name="id"
						id="EMPID">
					<td><input type="text" name="updFirstName"
						id="EmpUptFirstName"></td>
				</tr>
				<tr id="EmpLastNameTr" style="display: none;">
					<td>Last Name:</td>
					<td><input type="text" name="updLastName" id="EmpUptLastName"></td>
				</tr>
				<tr id="EmpDeptNameTr" style="display: none;">
					<td>Dept Name:</td>
					<td><input type="text" name="updDeptName" id="EmpUptDeptName"></td>
				</tr>
				<tr id="DesignationTr" style="display: none;">
					<td>Designation:</td>
					<td><input type="text" name="designation" id="Designation"></td>
				</tr>
				<tr id="SalaryTr" style="display: none;">
					<td>Salary:</td>
					<td><input type="text" name="salary" id="Salary"></td>
				</tr>
				<tr id="BranchTr" style="display: none;">
					<td>Branch:</td>
					<td><input type="text" name="branch" id="Branch"></td>
				</tr>
				<tr id="CountryTr" style="display: none;">
					<td>Country:</td>
					<td><input type="text" name="country" id="Country"></td>
				</tr>
				<tr id="GenderTr" style="display: none;">
					<td>Gender:</td>
					<td><input type="text" name="gender" id="Gender"></td>
				</tr>
				<tr id="PhoneTr" style="display: none;">
					<td>Phone:</td>
					<td><input type="number" name="phone" id="Phone"></td>
				</tr>
				<tr id="DOPTr" style="display: none;">
					<td>DOP:</td>
					<td><input type="date" name="dop" id="DOP"></td>
				</tr>
				<tr id="PasswordTr" style="display: none;">
					<td>Password:</td>
					<td><input type="password" name="password" id="Password"></td>
				</tr>
				<tr id="EmailTr" style="display: none;">
					<td>Email:</td>
					<td><input type="email" name="email" id="Email"></td>
				</tr>
				<tr id="EmpBtn" style="display: none;">
					<td align="center"><input type="button" id="CancelBtn"
						value="Cancel" class="btn btn-primary" /></td>
					<td align="center"><input type="button" id="UpdateBtn"
						value="Update Employee" class="btn btn-primary" /></td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#SelectedEmpId").change(function() {
			$("#msgDiv").hide();
			var empId = $("#SelectedEmpId :selected").text();
			var empTemp = $("#SelectedEmpId :selected").val();
			var id = $("#SelectedEmpId :selected").val();

			empTemp = empTemp.split("&");

			if (empTemp != "NONE") {
				var firstName = empTemp[0];
				var lastName = empTemp[1];
				var deptName = empTemp[2];
				var salary = empTemp[4];
				var designation = empTemp[3];
				
				var branch = empTemp[5];
				var country = empTemp[6];
				var gender = empTemp[7];
				var password = empTemp[8];
				var email = empTemp[9];
				var phone = empTemp[10];
				var dop = empTemp[11];
				var id = empTemp[12];
				
				$("#EMPID").val(id);
				$("#EmpUptFirstName").val(firstName);
				$("#EmpUptLastName").val(lastName);
				$("#EmpUptDeptName").val(deptName);
				$("#Designation").val(designation);
				$("#Branch").val(branch);
				$("#Gender").val(gender);
				$("#Salary").val(salary);
				$("#Country").val(country);
				$("#Password").val(password);
				$("#Email").val(email);
				$("#Phone").val(phone);
				$("#DOP").val(dop);
				
				$("#EmpFirstNameTr").show();
				$("#EmpLastNameTr").show();
				$("#EmpDeptNameTr").show();
				$("#DesignationTr").show();
				$("#BranchTr").show();
				$("#GenderTr").show();
				$("#SalaryTr").show();
				$("#CountryTr").show();
				$("#PasswordTr").show();
				$("#EmailTr").show();
				$("#PhoneTr").show();
				$("#DOPTr").show();
				$("#EmpBtn").show();
				$("#SelectedEmpId").prop('disabled', false);
			} else {
				clearEmployeeData();
			}
		});

		$("#CancelBtn").click(function() {
			clearEmployeeData();
		});

		function clearEmployeeData() {
			$("#EmpFirstNameTr").hide();
			$("#EmpLastNameTr").hide();
			$("#EmpDeptNameTr").hide();
			$("#EmpBtn").hide();
			$("#SelectedEmpId").prop('selectedIndex', 0);
		}

		$("#UpdateBtn").click(function() {
			var empNo = $("#SelectedEmpId :selected").text();
			var firstName = $("#EmpUptFirstName").val();
			var lastName = $("#EmpUptLastName").val();
			var deptName = $("#EmpUptDeptName").val();
			var salary = $("#Salary").val();
			var designation = $("#Designation").val();
			var branch = 	$("#Branch").val();
			var country = $("#Country").val();
			var gender = $("#Gender").val();
			var password = $("#Password").val();
			var email = $("#Email").val();
			var phone = $("#Phone").val();
			var dop = $("#DOP").val();
			var id = $("#EMPID").val();
			
			$.ajax({
				url : "./updateEmployee",
				data : {
					id : id,
					empNo : empNo,
					firstName : firstName,
					lastName : lastName,
					deptName : deptName,
					designation: designation,
					salary : salary,
					branch : branch,
					country : country,
					gender : gender,
					password : password,
					email : email,
					phone : phone,
					dop : dop
					
				},
				type : "POST",
				success : function(data) {
					$("#msgDiv").text(data);
					$("#msgDiv").show();
					clearEmployeeData();
				}
			});
		});

	});
</script>
</html>