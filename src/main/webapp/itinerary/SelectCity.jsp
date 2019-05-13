<%@ page import="it.contrader.dto.CityDTO"%>
<%@ include file="../header.jsp"%>
<%
   List<CityDTO> allCity = (List<CityDTO>) request.getAttribute("allCityDTO");
   %>
<!DOCTYPE html>
<html>
<head>
<title>Seleziona Citta</title>
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
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
.tabella {
font-color:black;
}


.titolo {
	color: balck;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
</style>
</head>
<%
	
%>
</head>
<body>

	<div class="titolo">

		<p>Seleziona citta</p>

	</div>
	<br>



	<br />
	<form method="POST" action="/Places/SelectPlaces">
		<%
			for (CityDTO city : allCity) {
		%>
		
		<input type="radio" name="idCity" value="<%=city.getIdCity()%>" />
		<input type="hidden" name="namecity" value="<%=city.getNamecity()%>" />
		<input type="hidden" name="state" value="<%=city.getState()%>" />
		
				<td><%=city.getIdCity()%></td>
				<td><%=city.getNamecity()%></td>
			<br>
		<%
			}
		%>
		<br>
		<br>
		<input type="submit" value="OK">	

	<br>
	<br>
	<a href="/GestoreEventi/viaggia"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>

</body>
</html>