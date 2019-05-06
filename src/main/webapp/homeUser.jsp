<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<<<<<<< HEAD
<% 
int idU =  (Integer) request.getAttribute("idU");
%>
</head>
<body>


	<p>Benvenuto!</p>
	<p> Cosa vuoi fare? </p>


	<a href=""=<%=idU%>"><span class="fs">
			Viaggia </span></a>
	<br>
=======
<style>
body {
	background-image:
		url("http://1.bp.blogspot.com/-FLsi6FOuXJ8/UHHBwqDTLNI/AAAAAAAAEG0/KTBA9VtfDl0/s1600/viaggio-a-Paris.gif");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: black;
}
</style>
</head>
<body>
<style>
.body{
text-aling:center;

}
.titolo {
	color: balck;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	}
	
.body{
	text-align: center;
	}

</style>
	<div class="titolo">
		<p>Benvenuto!</p>
	</div>

	<div class="body">
	<a href="UserServlet?richiesta=City"><span class="fs"> Viaggia </span></a>
<<<<<<< HEAD
=======
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
>>>>>>> 824db453a5990ab9392d5e94cf15068e80f7125d
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>
	</div>
</body>
</html>