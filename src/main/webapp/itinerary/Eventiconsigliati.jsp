<%@ page import="it.contrader.dto.EventiDTO"%>
<%@ include file="../header.jsp"%>
<%
List<EventiDTO> allEventi = (List<EventiDTO>) request.getAttribute("allEventiDTO");
   %>
<!DOCTYPE html>
<html>
<head>
<title>Eventi principali</title>
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

		<p>Eventi principali</p>
      
      </div>
      <br>
	

    <form method="POST" action="/City/selectCity">
    	<table style="margin:20px auto;" >
    	<tr>
			<th>ID</th>
			<th>Nome Evento</th>
			<th>Città Evento</th>
			<th>Mese Evento</th>
		</tr>
		<%
			for (EventiDTO eventi : allEventi) {
		%>
		<tr>
			<td><%=eventi.getIdevento()%></td>
			<td><%=eventi.getNameevento()%></td>
			<td><%=eventi.getCityevento()%></td>
			<td><%=eventi.getMeseevento()%></td>
		</tr>
		<%
			}
		%>
		</table>
		<br>
		<br>
		<input type="submit" value="OK">	

	<br>
	<br>
	<a href="/GestoreEventi/viaggia"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>

</body>
</html>