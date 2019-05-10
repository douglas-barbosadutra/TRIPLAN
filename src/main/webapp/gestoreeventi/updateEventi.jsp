<%@ include file="../header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.EventiDTO"%>

<html>
<head>
<title>Modifica Evento</title>
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
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>


.titolo {
color: black;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
.body{
	text-align: center;



}
</style>

<%
	EventiDTO updateEventi = (EventiDTO) request.getAttribute("eventiUpdate");
%>
</head>

<body>

		<div class="titolo">

			<p>Modifica Evento</p>

		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/GestoreEventi/update">
			<br>
			<input type="hidden" name="idevento" value="<%=updateEventi.getIdevento()%>" />
			<br>
			Nome Evento: <input type="text" size="40" maxlength="40" name="nameevento" value="<%=updateEventi.getNameevento()%>" />
			<br>
			<br>
			Città Evento: <input type="text" size="40" maxlength="40" name="cityevento" value="<%=updateEventi.getCityevento()%>" />
			<br>
			<br>
			Gestore Evento: <input type="text" size="40" maxlength="40" name="gestoreevento" value="<%=updateEventi.getGestoreevento()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/GestoreEventi/indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>
		
	</div>
</body>
</html>