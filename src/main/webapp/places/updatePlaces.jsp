<%@ include file="../header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.PlacesDTO"%>

<html>
<head>
<title>Modifica Attrazione</title>
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
	PlacesDTO updatePlaces = (PlacesDTO) request.getAttribute("placesUpdate");
%>
</head>

<body>

		<div class="titolo">

			<p>Modifica Attrazione</p>

		</div>
			<div class="body">
		<br>
		<br>
		<form method="POST" action="/Places/update">
			<br>
			<input type="hidden" name="idplaces" value="<%=updatePlaces.getIdPlaces()%>" />
			<br>
			<br>
		Nome Attrazione: <input type="text" size="40" maxlength="40" name="name_places" value="<%=updatePlaces.getNameplaces()%>"/>
		<br>
		<br>
		Città: <input type="text" size="40" maxlength="40" name="city_places"value="<%=updatePlaces.getCityplaces()%>"/>
		<br>
		<br>
		Latitudine: <input type="number" name="latitude" step="0.001" min="0" max="9999"value="<%=updatePlaces.getLatitude()%>"/>
		<br>
		<br>
		Longitudine <input type="number" name="longitude" step="0.001" min="0" max="9999"value="<%=updatePlaces.getLongitude()%>"/>
		<br>
		<br>
		ID Città <input type="number" name="city_idcity" value="<%=updatePlaces.getCityidcity()%>"/>
		<br>
		<br>
		<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/Places/placesManagement"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>
		
	</div>
</body>
</html>