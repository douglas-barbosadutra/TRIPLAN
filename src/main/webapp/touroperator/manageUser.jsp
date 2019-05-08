<%@ page import="java.util.*"%>
<%@ page import="it.contrader.dto.UserDTO"%>

<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUserDTO");
%>
<%!private String convertUserType(String userType) {
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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">
<title>Gestione Utenti</title>
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
</head>
<body>

	<div class="titolo">

		<p>Gestione Utenti</p>

	</div>
	<br>



	<br />
	<table style="margin:20px auto;" >
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>User Type</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (UserDTO user : allUser) {
		%>
		<tr>
			<td><%=user.getIdUser()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=convertUserType(user.getUserType())%></td>
			<td class="center"><a href="/JspApp/TourOperatorServlet?richiesta=updateRedirect&id=<%=user.getIdUser()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/TourOperatorServlet?richiesta=delete&id=<%=user.getIdUser()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/TourOperatorServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Utente </i></a>

	<br>
	<br>
	<a href="/JspApp/TourOperatorServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>