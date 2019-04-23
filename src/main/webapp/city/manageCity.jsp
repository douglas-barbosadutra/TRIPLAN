<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("superuser"))
		return "TourOperator";
		else
			return "User";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Città</title>
<style>
body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="/JspApp/css/style.css">
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

	<div class=titolo>

		<p>Gestione Città</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID Città</th>
			<th>Nome Città</th>	
		</tr>
		<%
			for (CityDTO city : allCity) {
		%>
		<tr>
			<td><%=city.getIdCity()%></td>
			<td><%=city.getName_City()%></td>
			<td class="center"><a href="/JspApp/UserServlet?richiesta=updateRedirect&id=<%=city.getIdCity()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/UserServlet?richiesta=delete&id=<%=city.getIdCity()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
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