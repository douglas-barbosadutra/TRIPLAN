<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
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
	<a href="UserServlet?richiesta=UserManager"><span class="fs"> Viaggia </span></a>
	<br>
	<br>
	<a href="LogoutServlet" ><span class="fs">
			Logout </span></a>
	</div>
</body>
</html>