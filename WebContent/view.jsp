<%@page import="model.bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	User u = new User();
	u = (User)request.getSession().getAttribute("user");
	if(u == null){
		out.print("Please <a href='Login.jsp' >Login</a> first");
	}else{
		
		ArrayList<Book> arr = new ArrayList<>();
		
		arr = (ArrayList<Book>) request.getSession().getAttribute("list");
%>
	<table>
		<tr>
			<th>Ten Sach</th>
			<th>Nam SX</th>
			<th>Nha xb </th>
			<th>So Luong</th>
		</tr>
		<%
			for(Book b : arr){
		%>
		<tr>
			<td><%= b.getTensach() %></td>
			<td><%= b.getNamsx() %></td>
			<td><%= b.getNhaxb() %></td>
			<td><%= b.getSoluong() %></td>
		</tr>
			
		<% } %>
	</table>
<% } %>
</body>
</html>