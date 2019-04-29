<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Attrazioni</title>
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
	List<PlacesDTO> allPlaces = (List<PlacesDTO>) request.getAttribute("allPlaces");
%>
</head>
<body>

	<div class="titolo">

		<p>Gestione Attrazioni</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<tr>
			<th>ID</th>
			<th>Nome Attrazione</th>
			<th>Città Attrazione</th>
			<th>Latitudine</th>
			<th>Longitudine</th>
		</tr>
		<%
			for (PlacesDTO places : allPlaces) {
		%>
		<tr>
			<td><%=places.getIdPlaces()%></td>
			<td><%=places.getNomePlaces()%></td>
			<td><%=places.getCityPlaces()%></td>
			<td><%=places.getLatitude()%></td>
			<td><%=places.getLongitude()%></td>
			<td class="center"><a href="/JspApp/PlacesServlet?richiesta=updateRedirect&id=<%=places.getIdPlaces()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/PlacesServlet?richiesta=delete&id=<%=places.getIdPlaces()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/PlacesServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuova Attrazione </i></a>

	<br>
	<br>
	<a href="/JspApp/PlacesServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>