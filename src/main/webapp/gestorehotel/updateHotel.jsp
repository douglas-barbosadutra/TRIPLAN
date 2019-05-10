<%@ include file="../header.jsp"%>
<%@ page import="it.contrader.dto.HotelDTO"%>
<html>
<head>
<title>Modifica Hotel</title>
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
	HotelDTO updateHotel = (HotelDTO) request.getAttribute("hotelUpdate");
%>
</head>

<body>

		<div class="titolo">

			<p>Modifica Hotel</p>

		
		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/GestoreHotel/update">
			<br>
			<input type="hidden" name="idhotel" value="<%=updateHotel.getIdhotel()%>" />
			<br>
			Nome Hotel: <input type="text" size="40" maxlength="40" name="nomehotel" value="<%=updateHotel.getNomehotel()%>" />
			<br>
			<br>
			Città Hotel: <input type="text" size="40" maxlength="40" name="cityhotel" value="<%=updateHotel.getCityhotel()%>" />
			<br>
			<br>
			Numero Stelle: <input type="number" size="40" maxlength="40" name="numerostelle"value="<%=updateHotel.getNumerostelle()%>"  />
			<br>
			<br>
			Latitudine: <input type="number" name="latitude" step="0.001" min="0" max="9999"value="<%=updateHotel.getLatitude()%>" />
			<br>
			<br>
			Longitudine: <input type="number" name="longitude" step="0.001" min="0" max="9999"value="<%=updateHotel.getLongitude()%>" />
			<br>
			<br>
			Gestore Hotel: <input type="text" size="40" maxlength="40" name="gestorehotel" value="<%=updateHotel.getGestorehotel()%>" />
			
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/GestoreHotel/indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</
		form>
		
	</div>
</body>
</html>