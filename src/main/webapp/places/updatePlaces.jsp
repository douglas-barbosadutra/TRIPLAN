<%@ include file="../header.jsp"%>
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
		<form method="POST" action="/JspApp/PlacesServlet?richiesta=update">
			<input type="hidden" name="idplaces" value="<%=updatePlaces.getIdPlaces()%>" />
<<<<<<< HEAD
			<br>
			Nome Città: <input type="text" size="40" maxlength="40" name="name_places" value="<%=updatePlaces.getNomePlaces()%>" />
=======
			<br>
			Nome Attrazione: <input type="text" size="40" maxlength="40" name="name_places" value="<%=updatePlaces.getNomePlaces()%>" />
			<br>
			<br>
			Città Attrazione: <input type="text" size="40" maxlength="40" name="city_places" value="<%=updatePlaces.getCityPlaces()%>" />
			<br>
			<br>
			Latitudine <input type="number" name="latitude" step="0.001" min="0" max="9999" value="<%=updatePlaces.getLatitude()%>" />
			<br>
			<br>
			Logitudine: <input type="number" name="longitude" step="0.001" min="0" max="9999" value="<%=updatePlaces.getLongitude()%>" />
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="/JspApp/PlacesServlet?richiesta=PlacesManager&"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>
		
	</div>
</body>
</html>