<%@ include file="../header.jsp"%>
<%!
private String convertUsertype(String userType) {
<<<<<<< HEAD:src/main/webapp/user/manageUser.jsp
=======
		if (userType.equals("superuser"))
			return "SuperUser";
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5:src/main/webapp/touroperator/manageUser.jsp
		if (userType.equals("touroperator"))
			return "TourOperator";
		else
			return "User";
	}%>

<!DOCTYPE html>
<html>
<head>
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
<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUser");
%>
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
			<td><%=user.getUserId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=convertUsertype(user.getUsertype())%></td>
<<<<<<< HEAD:src/main/webapp/user/manageUser.jsp
			<td class="center"><a href="/JspApp/UserServlet?richiesta=updateRedirect&id=<%=user.getUserId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/UserServlet?richiesta=delete&id=<%=user.getUserId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
=======
			<td class="center"><a href="/JspApp/TourOperatorServlet?richiesta=updateRedirect&id=<%=user.getUserId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/TourOperatorServlet?richiesta=delete&id=<%=user.getUserId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5:src/main/webapp/touroperator/manageUser.jsp
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
<<<<<<< HEAD:src/main/webapp/user/manageUser.jsp
	<a href="/JspApp/UserServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Utente </i></a>
=======
	<a href="/JspApp/TourOperatorServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> Nuovo Utente </i></a>
>>>>>>> f75a4ea3df5167a161313cd1f27983d32a2009b5:src/main/webapp/touroperator/manageUser.jsp

	<br>
	<br>
	<a href="/JspApp/TourOperatorServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>