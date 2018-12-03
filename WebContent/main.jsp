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
		out.print("Welcom, please <a href='Login.jsp' >Login</a> first");
	}else{
%>
<h1>hello,<%= u.getFullname() %></h1>
<a href="edit.jsp">Edit Profile</a>
<a href="View">View result</a>
<a href="Logout">Logout</a>

<% } %>
</body>
</html>