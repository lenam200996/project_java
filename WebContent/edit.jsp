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
%>
	<h1>EDIT PROFILE</h1>
	<form action="Edit">
	<input name="fullname" value="<%= u.getFullname().trim()%>">
	<input type="submit" value="EDIT">
	</form>
<% } %>
</body>
</html>