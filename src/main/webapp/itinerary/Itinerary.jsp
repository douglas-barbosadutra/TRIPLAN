<%@ page import="it.contrader.dto.PlacesDTO"%>
<%@ include file="../header.jsp"%>
<%
	List<PlacesDTO> Itinerary = (List<PlacesDTO>)(request.getAttribute("listaPlacesScelto"));
%>
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

		<p>Itinerario</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<%
			for (PlacesDTO places:Itinerary) {
		%>
		<tr>
			<td><%=places.getIdPlaces()%></td>
			<td><%=places.getNameplaces()%></td>
		</tr>
		<%
			}
		%>	
	</table>
	<br>
	<br>
	<a href="/Places/homeU"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>

</body>
</html>