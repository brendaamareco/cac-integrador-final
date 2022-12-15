<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.User" %> 
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>¡Bienvenido!</title>
	</head>
	<body>
	    <%! User user; %>
		<% 
		    user = (User) request.getSession().getAttribute("user"); 
		%>
		<h1><%= user.getNombre() %></h1>
	</body>
</html>