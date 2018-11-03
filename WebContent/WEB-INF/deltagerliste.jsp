<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<c:choose>
				<c:when test="${username.mobilnr == user.mobilnr}">
					<tr bgcolor="#aaffaa">
						<td align="center">${user.icon}</td>
						<td>${user.first_name}${user.last_name}</td>
						<td>${user.mobilnr}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr bgcolor="#ffffff">
						<td align="center">${user.icon}</td>
						<td>${user.first_name}${user.last_name}</td>
						<td>${user.mobilnr}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<p>
		<a href="logout">Logg ut</a>
	</p>
</body>
</html>