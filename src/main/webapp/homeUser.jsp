<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<% 
int idu =  (Integer) request.getAttribute("idu");
%>
</head>
<body>


	<p>Benvenuto!</p>
	<p> Cosa vuoi fare? </p>


	<a href=""=<%=idu%>"><span class="fs">
			Viaggia </span></a>
	<br>
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>

</body>
</html>