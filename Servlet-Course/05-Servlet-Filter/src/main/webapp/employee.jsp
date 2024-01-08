<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>

<style>
	body{
		min-height: 100vh;
		display: flex;
		flex-direction: column;
		align-content: center;
		align-items: center;
	}
	
	p{
		height: 100px;
	}
</style>
</head>
<body>

	<h2>Employee Home</h2>

	<p><%= session.getAttribute("user") %> : <%= session.getAttribute("role") %></p>
	
	<div><a href="../logout">Logout</a></div>
</body>
</html>