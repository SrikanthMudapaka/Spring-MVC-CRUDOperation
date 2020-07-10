<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function confirmDelete() {
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>

	<h2>View Contacts</h2>

	<a href="loadForm">+Add New Contact</a>

	<font color='green'>${succMsg}</font>

	<table border="1">
		<thead>
			<tr>
				<td>Contact ID</td>
				<td>Contact Name</td>
				<td>Contact Number</td>
				<td>Contact Email</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c">
				<tr>
					<td>${c.contactId}</td>
					<td>${c.contactName}</td>
					<td>${c.contactNum}</td>
					<td>${c.contactEmail}</td>
					<td><a href="editContact?cid=${c.contactId}">Edit</a> &nbsp; <a
						href="deleteContact?cid=${c.contactId}"
						onclick="return confirmDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>