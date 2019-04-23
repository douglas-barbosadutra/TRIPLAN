<%@ include file="/header.jsp"%>
<%!
private String convertUsertype(String userType) {
		if (userType.equals("admin"))
			return "Admin";
		else
			return "Business Owner";
	}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
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

.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<%
	List<PlacesDTO> allPlaces = (List<PlacesDTO>) request.getAttribute("allPlaces");
	final int idU= (Integer) request.getAttribute("idU");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Gestione Attrazioni</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID Attraziob</th>
			<th>Nome Attrzioni</th>	
		</tr>
		<%
			for (PlacesDTO places : allPlaces) {
		%>
		<tr>
			<td><%=places.getIdPlaces()%></td>
			<td><%=places.getNomePlaces()%></td>
			
			<td class="center"><a href="/JspApp/PlacesServlet?richiesta=updateRedirect&updateId=<%=places.getIdPlaces()%>&idU=<%=idU%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/PlacesServlet?richiesta=delete&deleteId=<%=places.getIdPlaces()%>&idU=<%=idU%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<br>
	<a href="/JspApp/UsersServlet?richiesta=UserManager&idU=<%=idU%>"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>