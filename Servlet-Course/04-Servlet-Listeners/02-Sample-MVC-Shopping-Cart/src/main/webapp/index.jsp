<%@page import="com.jdc.shop.model.ShoppingCart"%>
<%@page import="com.jdc.shop.model.entity.Product"%>
<%@page import="com.jdc.shop.model.ProductModel"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listener Demo</title>
</head>
<body>

	<h1>Product List</h1>
	
	<p>
	Shopping Cart : 
		<a href="showCart"> 
			<% ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");%>
			<%= cart == null ? 0 : cart.itemCount() %>
		</a>
	</p>
	
	<p>
		<% if(cart != null && cart.itemCount() > 0) { %>
		
		<a href="clearCart">Clear</a>
		
		<% } %>
	</p>
	
	<%
	ProductModel model = (ProductModel) application.getAttribute("products");
	%>

	<table style="width: 30%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
			<th></th>
		</tr>

		<%
		for (int i = 0; i < model.getList().size(); i++) {
			Product product = model.getList().get(i);
		%>

		<tr style="text-align: center;">
			<td><%=product.getId()%></td>
			<td><%=product.getName()%></td>
			<td><%=product.getCategory()%></td>
			<td><%=product.getPrice()%></td>
			<td>
				<a href="addToCart?productID=<%=product.getId()%>">
					Add to Cart
				</a>
			</td>
		</tr>

		<%
		}
		%>

	</table>
	
	<p><a href="sale-list">Sale History List</a></p>

</body>
</html>