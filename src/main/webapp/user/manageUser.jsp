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
			<td class="center"><a href="/JspApp/UserServlet?richiesta=updateRedirect&id=<%=user.getUserId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/JspApp/UserServlet?richiesta=delete&id=<%=user.getUserId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New User</i></a>

	<br>
	<br>
	<a href="/JspApp/UserServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>