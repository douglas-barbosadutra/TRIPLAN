<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
			return "SuperUser";
		if (userType.equals("touroperator"))
			return "TourOperator";
		else
			return "User";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Selezione Città</title>
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
	List<CityDTO> allCity = (List<CityDTO>) request.getAttribute("allCity");
%>
</head>
<body>

	<div class="titolo">

		<p>Seleziona la città</p>

	</div>
	<br>



	<br />
	<form method="POST" action="/JspApp/UserServlet?richiesta=Places">
		<%
			for (CityDTO city : allCity) {
		%>
		
		<input type="radio" name="idcity" value="<%=city.getIdCity()%>" />
		<input type="hidden" name="name_city" value="<%=city.getName_City()%>" />
		
				<td><%=city.getIdCity()%></td>
				<td><%=city.getName_City()%></td>
			<br>
		<%
			}
		%>
		<br>
		<br>
		<input type="SUBMIT" value="OK">
	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
	</form>

</body>
</html>