<%@page import="com.jdc.shop.model.entity.SaleItem"%>
<%@page import="com.jdc.shop.model.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Listing</title>
</head>
<body>

	<div>
		<h2>My Cart</h2>
		
		<hr />
		<p><a href="index.jsp">Home</a></p>
		<hr />
		
		<h4>Item details in Shopping Cart</h4>
		<section>
			<table style="width:50%; margin:15px;">
				<tr>
					<td>Name</td>
					<td>Category</td>
					<td>Unit Price</td>
					<td style="text-align : center;">Count</td>
					<td style="text-align : right;">Total</td>
				</tr>
				
				<%
				ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
				
				for (SaleItem item : cart.items()) {
				%>
				
				<tr>
					<td><%=item.getProduct().getName() %></td>
					<td><%=item.getProduct().getCategory() %></td>
					<td><%=item.getUnitPrice() %></td>
					
					<td style="text-align : center;">
					<a href="cart-minus?product=<%= item.getProduct().getId() %>">
						-
					</a>
					
					<%=item.getCount() %>
					
					<a href="cart-plus?product=<%= item.getProduct().getId() %>">
						+
					</a>
					</td>
					
					<td style="text-align : right;"><%=item.getTotal() %></td>
				</tr>
				
				<%
				}
				%>
				
				<tr>
					<td colspan="4" >Total</td>
					<td style="text-align : right;"><%=cart.total() %></td>
				</tr>
				
			</table>
		</section>
		<hr />
			
		<div>
			<h4>Check-out</h4>
			
			<form action="check-out" method="post">
				<label for="customer">Customer Name :</label>
				<input type="text" name="customer" />
				<button type="submit" >Check Out</button>
			</form>
		</div>
	</div>

	

</body>
</html>