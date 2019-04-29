<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Nuova Città</title>
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

		<p>Inserisci Nuova Città</p>

	</div>
	<div class="body">
	<br>
	<br>
	<form method="POST" action="/JspApp/CityServlet?richiesta=insert">

	
		<br>
		Nome Città: <input type="text" size="40" maxlength="40" name="name_city"/>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input type="SUBMIT" value="Add">
		<br>
		<br>
		<a href="/JspApp/CityServlet?richiesta=CityManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</div>
	</form>
</body>
</html>