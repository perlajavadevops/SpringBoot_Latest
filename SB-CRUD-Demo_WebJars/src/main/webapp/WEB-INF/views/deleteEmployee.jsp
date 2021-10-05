<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<h2 align="center" style="color: green;" class="alert alert-info">Delete
		Employee</h2>
	<h3>
		<div id="msgDiv" style="display: none; color: green;" align="center"></div>
	</h3>
	<br>
	<c:choose>
		<c:when test="${empList != null}">
			<table border="1" align="center" class="table table-hover"
				style="width: 35%;">
				<tr>
					<td>Select Employee ID:<span style="color: red;"> *</span></td>
					<td><select id="SelectedEmpId">
							<option value="NONE">--Select Emp No--</option>
							<c:forEach items="${empList}" var="emp">
								<option value="${emp.firstName}&${emp.lastName}&${emp.deptName}"
									id="${emp.empNo}">${emp.empNo}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr id="EmpFirstNameTr" style="display: none;">
					<td>First Name:</td>
					<td><input type="text" name="updFirstName"
						id="EmpUptFirstName" disabled="disabled"></td>
				</tr>
				<tr id="EmpLastNameTr" style="display: none;">
					<td>Last Name:</td>
					<td><input type="text" name="updLastName" id="EmpUptLastName"
						disabled="disabled"></td>
				</tr>
				<tr id="EmpDeptNameTr" style="display: none;">
					<td>Dept Name:</td>
					<td><input type="text" name="updDeptName" id="EmpUptDeptName"
						disabled="disabled"></td>
				</tr>
				<tr id="EmpBtn" style="display: none;">
					<td align="center"><input type="button" id="CancelBtn"
						value="Cancel" class="btn btn-primary" /></td>
					<td align="center"><input type="button" id="DeleteBtn"
						value="Delete Employee" class="btn btn-primary" /></td>
				</tr>
			</table>
		</c:when>
	</c:choose>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#SelectedEmpId").change(function() {
					$("#msgDiv").hide();
					var empId = $("#SelectedEmpId :selected").text();
					var empTemp = $("#SelectedEmpId :selected").val();
					var id = $("#SelectedEmpId :selected").val();
					empTemp = empTemp.split("&");//int[] ar = new int[];

					if (empTemp != "NONE") {
						var firstName = empTemp[0];
						var lastName = empTemp[1];
						var deptName = empTemp[2];
						$("#EmpUptFirstName").val(firstName);
						$("#EmpUptLastName").val(lastName);
						$("#EmpUptDeptName").val(deptName);
						$("#EmpFirstNameTr").show();
						$("#EmpLastNameTr").show();
						$("#EmpDeptNameTr").show();
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

				$("#DeleteBtn").click(
						function() {
							var empNo = $("#SelectedEmpId :selected").text();
							$.ajax({
								url : "${pageContext.request.contextPath}/deleteEmployee",
								data : {
									empNo : empNo
								},
								type : "POST",
								success : function(data) {
									$("#msgDiv").text(data);
									$("#msgDiv").show();
									clearEmployeeData();
									$(
											"#SelectedEmpId option:contains("
													+ empNo + ")").remove();
								}
							});
						});

			});
</script>
</html>