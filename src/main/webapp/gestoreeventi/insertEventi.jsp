<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Nuovo Evento</title>
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
color: black;
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

		<p>Inserisci Nuovo Evento</p>

	</div>
	<div class="body">
	<br>
	<br>
	<form method="POST" action="/GestoreEventi/insert">

	
		<br>
		Nome Evento: <input type="text" size="40" maxlength="40" name="nameevento"/>
		<br>
		<br>
		Città Evento: <input type="text" size="40" maxlength="40" name="cityevento"/>
		<br>
		<br>
		Gestore Evento: <input type="text" size="40" maxlength="40" name="gestoreevento"/>
		<br>
		<br>
		<br>
		Mese Evento:<input type="text" size="40" maxlength="40" name="meseevento"/>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/GestoreEventi/indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</div>
	</form>
</body>
</html>