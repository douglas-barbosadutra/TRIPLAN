<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
			return "SuperUser";
		if (userType.equals("touroperator"))
			return "TourOperator";
		if (userType.equals("gestorehotel"))
			return "GestoreHotel";
		else
			return "User";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Hotel</title>
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
	List<HotelDTO> allHotel = (List<HotelDTO>) request.getAttribute("allHotel");
%>
</head>
<body>

	<div class="titolo">

		<p>Gestione Hotel</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<tr>
			<th>ID</th>
			<th>Nome Hotel</th>
			<th>Città</th>
			<th>Numero Stelle</th>
			<th>Latitudine</th>
			<th>Longitudine</th>
			<th>Gestore Hotel</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (HotelDTO hotel : allHotel) {
		%>
		<tr>
			<td><%=hotel.getIdHotel()%></td>
			<td><%=hotel.getNomeHotel()%></td>
			<td><%=hotel.getCityHotel()%></td>
			<td><%=hotel.getNumeroStelle()%></td>
			<td><%=hotel.getLatitude()%></td>
			<td><%=hotel.getLongitude()%></td>
			<td><%=hotel.getGestoreHotel()%></td>
			<td class="center"><a href="/JspApp/HotelServlet?richiesta=updateRedirect&id=<%=hotel.getIdHotel()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/HotelServlet?richiesta=delete&id=<%=hotel.getIdHotel()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/HotelServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Hotel </i></a>

	<br>
	<br>
	<a href="/JspApp/HotelServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>