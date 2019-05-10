<%@ include file="../header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<title>Itinerario</title>
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
	color: black;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
}
</style>
</head>
<%
	List<PlacesDTO> Itinerary = (List<PlacesDTO>)(request.getAttribute("listaPlacesScelto"));
%>
</head>
<body>

	<div class="titolo">

		<p>Itinerario</p>

	</div>
	<br>



	<br />
		<form name = "myform" method="POST" action="/JspApp/UserServlet?richiesta=Itinerary">
		<%
			for (PlacesDTO places:Itinerary) {
		%>
		<input type="hidden" name="idcityplaces" value="<%=places.getIdPlaces()%>" />
		<input type="hidden" name="name_places" value="<%=places.getNomePlaces()%>" />
		
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