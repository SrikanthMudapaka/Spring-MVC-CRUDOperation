<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(event) {
		$("#contactEmail").blur(function() {
			$("#dupEmailMsg").text('');
			var emailId = $("#contactEmail").val();
			$.ajax({
				type : "GET",
				url : "validateEmail?email=" + emailId,
				success : function(data) {
					if (data == 'DUPLICATE') {
						$("#dupEmailMsg").text('Duplicate Email ID');
						$("#contactEmail").focus();
					}
				}
			});
		});
	});
</script>

</head>
<body>
	<h2>Save Contact</h2>
	<font color='green'>${succMsg}</font>
	<font color='red'>${errMsg}</font>
	<form:form action="saveContact?contactId=${contact.contactId}"
		method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name:</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Contact Email:</td>
				<td><form:input path="contactEmail" /></td>
				<td><font color='red'><span id="dupEmailMsg"></span></font>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td><form:input path="contactNum" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Submit" id="submitBtn" /></td>
			</tr>
		</table>
	</form:form>
	<a href="viewAllContacts">View All Contacts</a>
</body>
</html>