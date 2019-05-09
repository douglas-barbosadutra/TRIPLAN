<%@ include file="../header.jsp"%>
<%@ page import="it.contrader.dto.HotelDTO"%>
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
color: balck;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
.body{
	text-align: center;



}
</style>

<%
	EventiDTO updateEvento = (EventiDTO) request.getAttribute("eventoUpdate");
%>
</head>

<body>

		<div class="titolo">

			<p>Modifica Evento</p>

		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/JspApp/EventiServlet?richiesta=update">
			<br>
			<input type="hidden" name="idhotel" value="<%=updateEvento.getIdEvento()%>" />
			<br>
			Nome Evento: <input type="text" size="40" maxlength="40" name="name_evento" value="<%=updateEvento.getName_evento()%>" />
			<br>
			<br>
			Città Evento: <input type="text" size="40" maxlength="40" name="city_evento" value="<%=updateEvento.getCity_evento()%>" />
			<br>
		    <br>
			Gestore Evento: <input type="text" size="40" maxlength="40" name="gestore_evento" value="<%=updateEvento.getGestore_evento()%>" />
			
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/EventiServlet?richiesta=EventiManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</
		form>
		
	</div>
</body>
</html>