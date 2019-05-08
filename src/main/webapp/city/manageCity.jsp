<%@ include file="../header.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.CityDTO"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestione Città</title>
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
   List<CityDTO> allCity = (List<CityDTO>) request.getAttribute("allCityDTO");	
%>
</head>
<body>

	<div class="titolo">

		<p>Gestione Città</p>

	</div>

	<table style="margin:20px auto"; cellspacing=8;>
		<tr>
			<th>ID</th>
			<th>Nome Città</th>
		</tr>
		<%
			for (CityDTO city : allCity) {
		%>
		<tr>
			<td><%=city.getIdcity()%></td>
			<td><%=city.getName_city()%></td>
			<td class="center"><a href="/JspApp/CityServlet?richiesta=updateRedirect&id=<%=city.getIdcity()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/CityServlet?richiesta=delete&id=<%=city.getIdcity()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/CityServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuova Città </i></a>

	<br>
	<br>
	<a href="/JspApp/CityServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>