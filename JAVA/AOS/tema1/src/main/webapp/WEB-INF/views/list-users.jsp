<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Users</title>


</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>User manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">


			<input type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempUser" items="${users}">
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>

					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>

					<tr>
						<td>${tempUser.name}</td>
						<td>${tempUser.email}</td>

						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









