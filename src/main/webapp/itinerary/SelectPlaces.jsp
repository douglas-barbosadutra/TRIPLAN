<%@ include file="../header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<title>Selezione Attrazione</title>
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
	List<PlacesDTO> CityPlaces = (List<PlacesDTO>) request.getAttribute("CityPlaces");
%>
</head>
<body>

	<div class="titolo">

		<p>Seleziona le attrazioni</p>

	</div>
	<br>



	<br />
	<form method="POST" action="/JspApp/UserServlet?richiesta=Itinerary">
		<%
			for (PlacesDTO places : CityPlaces) {
		%>
		
		<input type="checkbox" name="idcityplaces" value="<%=places.getIdPlaces()%>" />
		<input type="hidden" name="name_places" value="<%=places.getNomePlaces()%>" />
		<input type="hidden" name="latitude" value="<%=places.getLatitude()%>" />
		<input type="hidden" name="longitude" value="<%=places.getLongitude()%>" />
				<td><%=places.getIdPlaces()%></td>
				<td><%=places.getNomePlaces()%></td>
			<br>
		<%
			}
		%>
		<br>
		<br>
		<input type="submit" value="OK">	

	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=indietroP"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>

</body>
</html>