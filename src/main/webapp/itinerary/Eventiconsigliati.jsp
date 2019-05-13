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



	<br />
	<form method="POST" action="/City/selectCity">
		<%
			for (EventiDTO eventi : allEventi) {
		%>
		
		<input type="hidden" name="idevento" value="<%=eventi.getIdevento()%>" />
		<input type="hidden" name="nameevento" value="<%=eventi.getNameevento()%>" />
		<input type="hidden" name="cityevento" value="<%=eventi.getCityevento()%>" />
		<input type="hidden" name="gestoreevento" value="<%=eventi.getGestoreevento()%>" />
				<td><%=eventi.getIdevento()%></td>
				<td><%=eventi.getNameevento()%></td>
			  
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