<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" />

<!-- jQuery library file -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js">
	
</script>

<!-- Datatable plugin JS library file -->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
	
</script>
</head>
<body>
	<%@include file="menu.jsp"%>

	<h2 align="center" style="color: green;" class="alert alert-info">Employee
		List</h2>
	<br>
	<table align="center" class="table table-hover table-bordered"
		style="width: 90%;" id="empListId">
		<c:if test="${empList != null}">

			<tr style="background-color: silver;">
				<th>SNo</th>
				<th>Emp ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Dept</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Branch</th>
				<th>Country</th>
				<th>Gender</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>DOP</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td align="center"><c:out value="${emp.id}"></c:out></td>
					<td><c:out value="${emp.empNo}"></c:out></td>
					<td><c:out value="${emp.firstName}"></c:out></td>
					<td><c:out value="${emp.lastName}"></c:out></td>
					<td><c:out value="${emp.deptName}"></c:out></td>
					<td><c:out value="${emp.designation}"></c:out></td>
					<td><c:out value="${emp.salary}"></c:out></td>
					<td><c:out value="${emp.branch}"></c:out></td>
					<td><c:out value="${emp.country}"></c:out></td>
					<td><c:out value="${emp.gender}"></c:out></td>
					<td><c:out value="${emp.email}"></c:out></td>
					<td><c:out value="${emp.password}"></c:out></td>
					<td><c:out value="${emp.phone}"></c:out></td>
					<td><c:out value="${emp.dop}"></c:out></td>
				</tr>
			</c:forEach>

	</c:if>
	</table>
	<script>
		$(document).ready(function() {
			$('#empListId').DataTable({
				"pagingType" : "full_numbers"
			});
		});
	</script>

</body>
</html>
