<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home Page</title>
</head>
<body>
	<h1>Main page</h1>
	
	<%! String username; %> 
	<% username = (String)request.getSession().getAttribute("user").toString(); %>
	<h2>hell0, <%= username %></h2>
	<a>Sua thong tin</a>
	<a>xem thong tin</a>
	<a>dang xuat</a>
</body>
</html>