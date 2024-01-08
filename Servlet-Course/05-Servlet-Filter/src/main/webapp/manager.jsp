<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Home</title>

<style>
	body{
		min-height: 100vh;
		display: flex;
		flex-direction: column;
		align-content: center;
		align-items: center;
	}
</style>
</head>
<body>

	<h2>Manager Home</h2>

	<p><%= session.getAttribute("user") %> : <%= session.getAttribute("role") %></p>
	
	<div><a href="../logout">Logout</a></div>
</body>
</html>