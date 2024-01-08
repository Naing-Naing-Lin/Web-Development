<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Filter</title>

<style>
	body{
		padding: 2rem;
	}
	
	.card{
		padding: 1rem;
		font-size: 1 rem;
		background-color: aqua;
		box-shadow: 1px 1px 2px gray;
		border-radius: 0.4rem;
	}
	.demo{
		display: flex;
	}
	
	.demo form{
		width: 360px;
		margin-right: 1rem;
	}
	
	form div{
		display: flex;
		flex-direction: column;
		margin-bottom: 0.6rem;
	}
	
	form label{
		margin-bottom: 0.2rem;
	}
	
	input, select, button {
		padding: 0.4rem;
		border: 1px solid gray;
		border-radius: 0.4rem;
		outline: none;
	}
	
	button{
		background-color: transparent;
		color: black;
	}
	
	button:hover{
		background-color: maroon;
		color: white;
	}
	
</style>

</head>
<body>
	<h2>Servlet Filter</h2>
	
	<div>
		<a href="hello">Hello Servlet</a>
	</div>
	
	<% if(request.getAttribute("message") != null) { %>
	
	<section>
		<p class="card">
			<%= request.getAttribute("message") %>
		</p>
	</section>
	
	<%
	}
	%>
	
	<div>
		<h2>Log In Form Using Filter</h2>
		
		<div class="demo">
			<form class="card" action="login" method="post">
				<h3>Employee Form</h3>
				<input type="hidden" name="home" value="employee" />
				<div>
					<label for="name">Name : </label>
					<input type="text" name="name" />
				</div>
				<div>
					<label for="role">Role : </label>
					<select name="role">
						<option value=""> Select One </option>
						<option value="Manager"> Manager </option>
						<option value=" Employee "> Employee </option>
					</select>
				</div>
				<div>
					<button type="submit">Login</button>
				</div>
			</form>
			
			<form class="card" action="login" method="post">
				<h3>Manager Form</h3>
				<input type="hidden" name="home" value="manager" />
				<div>
					<label for="name">Name : </label>
					<input type="text" name="name" />
				</div>
				<div>
					<label for="role">Role : </label>
					<select name="role">
						<option value=""> Select One </option>
						<option value="Manager"> Manager </option>
						<option value=" Employee "> Employee </option>
					</select>
				</div>
				<div>
					<button type="submit">Login</button>
				</div>
			</form>
			
		</div>
		
	</div>
</body>
</html>