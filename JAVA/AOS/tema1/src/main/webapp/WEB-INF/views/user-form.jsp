<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add/Update an User</title>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>User manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add/Update an User</h3>
	
		<form:form action="saveUser" modelAttribute="user" method="POST">
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /><form:errors path="name"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /><form:errors path="email"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










