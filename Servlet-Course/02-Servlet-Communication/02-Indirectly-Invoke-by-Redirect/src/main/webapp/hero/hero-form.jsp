<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero Form</title>
</head>
<body>

	<h2>Hero Form</h2>
	<form action="<%= request.getContextPath().concat("/hero-save") %>" method="post">
		<table>
			<tr>
				<td><label for="name">Hero Name</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td><label for="type">Hero Type</label></td>
				<td>
					<select id="type" name="type">
						<option value="">Select Type</option>
						<option value="Strength">Strength</option>
						<option value="Agility">Agility</option>
						<option value="Intelligent">Intelligent</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>

	</form>

</body>
</html>