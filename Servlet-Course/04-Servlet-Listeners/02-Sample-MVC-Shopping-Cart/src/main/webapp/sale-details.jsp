<%@page import="com.jdc.shop.model.entity.SaleItem"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jdc.shop.model.entity.Voucher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sale Voucher Details</title>
</head>
<body>

	<%
		Voucher voucher = (Voucher) request.getAttribute("data");
	%>
	
	<%!
	String formatDateTime(LocalDateTime date){
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
	%>

	<!-- Title -->
	<h2>Sale Details</h2>
	
	<!-- Sale Summary -->
	<table>
		<tr>
			<td style="width:30%">Voucher Id : <%= voucher.getId() %> </td>
			<td style="width:40%">Customer Name : <%= voucher.getCustomer() %></td>
			<td style="width:30%">Sale DateTime : <%= formatDateTime(voucher.getSaleDateTime()) %></td>
		</tr>
	</table>
	
	<hr />
	<!-- Sale Detail -->
	
	<table style="width: 50%; border: 1px; padding: 10px;">
		<thead>
			<tr>
				<td>ProductId</td>
				<td>Name</td>
				<td style="text-align : right;">Unit-Price</td>
				<td style="text-align : center;">Count</td>
				<td style="text-align : right;">Total</td>
			</tr>
		</thead>
		<tbody>
			<% 
				for(SaleItem item : voucher.getSales()){
			%>
		
			<tr>
				<td><%= item.getProduct().getId() %></td>
				<td><%= item.getProduct().getName() %></td>
				<td style="text-align : right;"><%= item.getUnitPrice() %></td>
				<td style="text-align : center;"><%= item.getCount() %></td>
				<td style="text-align : right;"><%= item.getTotal() %></td>
			</tr>
			
			<%
			}
			%>
			<tr>
				<td colspan="3"></td>
				<td style="text-align : center;">Total</td>
				<td style="text-align : right;"><%= voucher.getTotal() %></td>
			</tr>
		</tbody>
	</table>
	
	<hr />
	
	<div>
		<a href="index.jsp" style="margin-right : 20px">Home</a>
		<a href="sale-list">Back</a>
	</div>
	
</body>
</html>