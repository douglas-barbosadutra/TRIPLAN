<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.services.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home TuorOperator</title>
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
	<a href="/Touroperator/userManagement"><span class="fs"> Gestione Utenti </span></a>
	<br>
	<br>
	<a href=""><span class="fs"> Gestione Città </span></a>
	<br>
	<br>
	<a href="PlacesServlet?richiesta=PlacesManager"><span class="fs"> Gestione Attrazioni </span></a>
	<br>
	<br>
	<a href="TagsServlet?richiesta=TagsManager"><span class="fs"> Gestione Tag </span></a>
	<br>
	<br>
	
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>
	</div>
</body>
</html>