<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo hotel</title>
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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
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
</head>
<body>
	<div class="titolo">

		<p>Nuovo Hotel</p>

	</div>
	<div class="body">
	<br>
	<br>
	<form method="POST" action="/JspApp/HotelServlet?richiesta=insert">

		
		<br>
		<br>
		Nome Hotel: <input type="text" size="40" maxlength="40" name="name_hotel" />
		<br>
		<br>
		Città Hotel: <input type="text" size="40" maxlength="40" name="city_hotel" />
		<br>
		<br>
		Numero Stelle: <input type="number" size="40" maxlength="40" name="numero_stelle" />
		<br>
		<br>
		Latitudine: <input type="number" name="latitude" step="0.001" min="0" max="9999"/>
		<br>
		<br>
		Longitudine: <input type="number" name="longitude" step="0.001" min="0" max="9999"/>
		<br>
		<br>
		Gestore Hotel: <input type="text" size="40" maxlength="40" name="gestore_hotel" />
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/HotelServlet?richiesta=HotelManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>
	</div>
</body>
</html>