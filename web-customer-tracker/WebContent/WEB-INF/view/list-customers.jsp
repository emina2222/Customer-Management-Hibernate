<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<h1>Hello customers!</h1>

<div id="wrapper">
	<div id="header">
		<h2>Customer Relationship Manager</h2>
	</div>
</div>

<div class="container">
	<div id="content">
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="temp" items="${customers}">
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${temp.id}"/>
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${temp.id}"/>
				</c:url>
				
				<tr>
					<td>${temp.firstName}</td>
					<td>${temp.lastName}</td>
					<td>${temp.email}</td>
					<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</div>


</body>
</html>