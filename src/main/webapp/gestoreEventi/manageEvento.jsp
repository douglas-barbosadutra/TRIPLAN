<%@ include file="../header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.HotelDTO"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
			return "SuperUser";
		if (userType.equals("touroperator"))
			return "TourOperator";
		if (userType.equals("gestorehotel"))
			return "GestoreHotel";
		if (userType.equals("gestore_evento"))
		    return "Gestore_Evento";
		else
			return "User";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Eventi</title>
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
	List<EventiDTO> allEventi = (List<EventiDTO>) request.getAttribute("allEventi");
%>
</head>
<body>

	<div class="titolo">

		<p>Gestione Eventi</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<tr>
			<th>ID</th>
			<th>Nome Evento</th>
			<th>Città</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (EventiDTO evento : allEventi) {
		%>
		<tr>
			<td><%=evento.getIdEvento()%></td>
			<td><%=evento.getName_evento()%></td>
			<td><%=evento.getCity_evento()%></td>
			<td><%=evento.getGestore_evento()%></td>
			<td class="center"><a href="/JspApp/EventoServlet?richiesta=updateRedirect&id=<%=evento.getIdEvento()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/EventoServlet?richiesta=delete&id=<%=evento.getIdEvento()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/EventiServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo evento </i></a>

	<br>
	<br>
	<a href="/JspApp/EventiServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>