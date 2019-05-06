<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
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
<<<<<<< HEAD
	<a href="UserServlet?richiesta=UserManager"><span class="fs"> Gestione Utenti </span></a>
=======
	<a href="TourOperatorServlet?richiesta=UserManager"><span class="fs"> Gestione Utenti </span></a>
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
	<br>
	<br>
	<a href="CityServlet?richiesta=CityManager"><span class="fs"> Gestione Città </span></a>
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