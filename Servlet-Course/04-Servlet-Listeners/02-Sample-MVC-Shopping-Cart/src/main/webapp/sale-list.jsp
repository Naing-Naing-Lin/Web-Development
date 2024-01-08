<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jdc.shop.model.entity.Voucher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale History</title>
</head>
<body>
	<h2>Sale List</h2>
	
	<%!
	String formatDateTime(LocalDateTime date){
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
	%>
	
	<%
		@SuppressWarnings("unchecked")
		List<Voucher> list = (List<Voucher>) request.getAttribute("data");
	%>
	
	<table>
		<thead>
			<tr>
				<td>Voucher Id</td>
				<td>Sale Date</td>
				<td>Customer</td>
				<td>Count</td>
				<td>Total</td>
			</tr>
		</thead>
		
		<tbody>
			<% 
				for(Voucher v : list){
			%>
			
			<tr>
				<td>
					<a href="sale-details?voucherId=<%= v.getId() %>"> <%= v.getId() %> </a>
				</td>
				<td><%= formatDateTime(v.getSaleDateTime()) %></td>
				<td><%= v.getCustomer() %></td>
				<td><%= v.getCount() %></td>
				<td><%= v.getTotal() %></td>
			</tr>
			
			<%
				}
			%>
		</tbody>
	</table>
	
	<a href="index.jsp">Back</a>
</body>
</html>