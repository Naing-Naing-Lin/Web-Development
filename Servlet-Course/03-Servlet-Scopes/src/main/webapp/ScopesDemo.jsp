<%@page import="com.jdc.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Scopes</title>

</head>
<body>

	<h2>Servlet Scopes</h2>

	<table>
		<tr>
			<td>Request Scope </td>
			<td> : </td>
			<td> <%= ((Counter) request.getAttribute("reqCounter")).getCount() %> </td>
		</tr>

		<tr>
			<td>Session Scope</td>
			<td> : </td>
			<td><%= ((Counter) session.getAttribute("sessionCounter")).getCount() %> </td>
		</tr>

		<tr>
			<td>Application Scope</td>
			<td> : </td>
			<td><%= ((Counter) application.getAttribute("applicationCounter")).getCount() %></td>
		</tr>
		<tr>
			<td>
				<!-- action="<%= request.getContextPath().concat("/session-stop") %>"  -->
				<form action="session-stop" method="post">
					<input type="submit" value="Stop Session" />
				</form>
			</td>
		
			<td>
				<a href="counter">Count Up</a>
				<%-- <a href="<%= request.getContextPath().concat("/counter") %>"></a> --%>
			</td>
		</tr>
	</table>

</body>
</html>